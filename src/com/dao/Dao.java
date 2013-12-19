package com.dao;



import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.hql.ast.QuerySyntaxException;

import com.frm.LoginCheck;
import com.frm.NewUser;
import com.pixphotofrm.StrutsUploadFrm;
import com.pojo.PixAccount;
import com.pojo.PixInvoice;
import com.pojo.PixPhotoInfo;
import com.pojo.PixTransactions;
import com.pojo.PixUserInfo;


public class Dao implements DaoI{
	private static DaoI dao = null;

	public static synchronized DaoI getInstance(){
		if (dao == null) {
			dao = new Dao();
		}
		return dao;
	}
	Configuration cfg = new Configuration();
	SessionFactory sf = cfg.configure().buildSessionFactory();
	
	/* this method inserts the user information into pix_userinfo table */
	public void insertUser(NewUser user) {
		// TODO Auto-generated method stub
		
		Session sess = sf.getCurrentSession();
		Transaction tx = sess.beginTransaction();
		PixUserInfo userdet = new PixUserInfo();
		userdet.setUserId(user.getUserId());
		userdet.setUserName(user.getUserName());		
		userdet.setPassword(user.getPassword());
		userdet.setGender(user.getGender());
		userdet.setMobileNumber(user.getMobilenumber());
		userdet.setLocation(user.getLocation());
		userdet.setEmail(user.getEmail());
		userdet.setAccountNumber(user.getAccountnumber());
		sess.save(userdet);
		tx.commit();
}

	/* this method validates the user lodged in from pix_userinfo*/
	public PixUserInfo CheckUser(PixUserInfo userinfo) {
		// TODO Auto-generated method stub
		Session sess = sf.getCurrentSession();		
		Transaction tx = sess.beginTransaction();
		PixUserInfo user = null;
		tx.begin();
			String userId = userinfo.getUserId();
			String password = userinfo.getPassword();
			try
			{
				Query query = sess.createQuery(Queries.LoginCheck);
				query.setParameter(0,userId);
				query.setParameter(1,password);
				List<PixUserInfo> lst = query.list();	
			    if (lst.size()==1){
			    	user = lst.get(0);
			    }
						}catch(QuerySyntaxException se)
			{se.printStackTrace();}
			return user;
	}
	
	/* this method inserts the photo information in pix_photoinfo  */
	public void updatePhotoInfo(StrutsUploadFrm photoInfo, PixUserInfo userinfo) {
		// TODO Auto-generated method stub
		Session sess = sf.getCurrentSession();
		Transaction tx = sess.beginTransaction();
		PixPhotoInfo px = new PixPhotoInfo();
		Date date = new Date();
		px.setCategory(photoInfo.getCategory());
		px.setCost(photoInfo.getCost());
		px.setDateOfUpload(date);
		px.setImgsrc(photoInfo.getTheFile().getFileName());
		px.setUserInfo(userinfo);
		px.setFileSize(photoInfo.getTheFile().getFileSize());
		sess.save(px);
		tx.commit();
	}
	
	/* this method retrieves the list of photos by category */
	public List<PixPhotoInfo> getPhotoByCategory(String category){
		Session sess = sf.getCurrentSession();
		Transaction tx = sess.beginTransaction();
		Query query = sess.createQuery(Queries.viewPhotoQry);
		query.setParameter(0, category);
		List<PixPhotoInfo> lst = query.list();
		return lst;
		
	}

	/* this method gets the photo information to the corresponding photo id   */
	public PixPhotoInfo getPhotoInfo(int pid) {
		// TODO Auto-generated method stub
		Session sess = sf.getCurrentSession();
		Transaction tx = sess.beginTransaction();
		PixPhotoInfo info = (PixPhotoInfo)sess.get(PixPhotoInfo.class,pid);
		return info;
	}
		
	/* this method inserts the transaction details into invoice table of the user */
	public int saveInvoice(PixInvoice inv,List<PixTransactions> lst){
		Session sess = sf.getCurrentSession();
		Transaction tx = sess.beginTransaction();
		for(PixTransactions pix: lst){
			sess.save(pix);
		}		
		inv.setPhotoTx(lst);
		sess.save(inv);
		tx.commit();
		int invid =  inv.getInvoiceId();
		return invid;
	}
	
	/* this method inserts the transaction details into invoice table of the user */
	public List<PixPhotoInfo> getMaxDownloads() {
		// TODO Auto-generated method stub
			List<PixPhotoInfo> photos= new ArrayList<PixPhotoInfo>();
			Session sess = sf.getCurrentSession();
			Transaction tx = sess.beginTransaction();
			Query query = sess.createQuery(Queries.getMaxDlQuery);
			int pid = 0;
			query.setMaxResults(6);
			List<Object[]> obj =(List<Object[]>) query.list();
			List<Integer> ids=new ArrayList<Integer>();
			for(Object[] a: obj)
			{
				
				pid = ((Integer)a[1]).intValue();
				PixPhotoInfo info = (PixPhotoInfo)sess.get(PixPhotoInfo.class, pid);
				photos.add(info);
			}
			return photos;			
		}

	/* this method gets the list of 5 photos based on the date of loaded   */
	
	public List<PixPhotoInfo> getNewArrivals() {
		// TODO Auto-generated method stub 
		Session sess = sf.getCurrentSession();
		Transaction tx = sess.beginTransaction();
		Query query = sess.createQuery(Queries.getNewArrivals);
		query.setMaxResults(5);
		List<PixPhotoInfo> lst =(List<PixPhotoInfo>) query.list();
		tx.commit();
		return lst;
	}

	/* this method gets the list of user uploaded photos */
	public List<PixPhotoInfo> getUserPix(String uid) {
		// TODO Auto-generated method stub
		Session sess = sf.getCurrentSession();
		Transaction tx = sess.beginTransaction();
		Query query = sess.createQuery(Queries.getUserPix);
		query.setParameter(0,uid);
		List<PixPhotoInfo> lst = (List<PixPhotoInfo>)query.list();
		return lst;
	}

	/* this method gets the list of user transacted details */
	public List<PixInvoice> getUserHistory(String uid) {
		// TODO Auto-generated method stub
		Session sess = sf.getCurrentSession();
		Transaction tx = sess.beginTransaction();
		Query query = sess.createQuery(Queries.getInvoiceById);
		query.setParameter(0,uid);
		List<PixInvoice> lst = (List<PixInvoice>)query.list();
		return lst;
	}

	/* this method debits the amount from user's account*/
	@SuppressWarnings("unchecked")
	@Override
	public double doDebit(PixUserInfo userinfo, double amount) {
		// TODO Auto-generated method stub
		Session sess = sf.getCurrentSession();		
		Transaction tx = sess.beginTransaction();
		long accountId =userinfo.getAccountNumber();  
		tx.begin();
		try
		{
			Query query = sess.createQuery(Queries.checkamount);
			query.setParameter(0,accountId);
			List<PixAccount> lst = query.list();			
			double balance = lst.get(0).getBalance();			
			
			if(balance>=amount)
			{
				balance = balance - amount;
				query = sess.createQuery(Queries.doDebit);
				query.setParameter(0, balance);
				query.setParameter(1, accountId);
				query.executeUpdate();
				tx.commit();
			}
			else
			{
				amount =-1;
			}
			
		}catch(QuerySyntaxException se)
		{se.printStackTrace();}		
		return amount;
	}

	@Override
	public void doCredit(long accountNumber, double cost) {
		// TODO Auto-generated method stub
		Configuration cfg = new Configuration();
		SessionFactory sf = cfg.configure().buildSessionFactory();
		Session sess = sf.getCurrentSession();		
		Transaction tx = sess.beginTransaction();
		tx.begin();
		try
		{
			Query query = sess.createQuery(Queries.checkamount);
			query.setParameter(0,accountNumber);
			List<PixAccount> lst = query.list();			
			double balance = lst.get(0).getBalance();
			
				balance = balance + (cost*0.8);
				
				query = sess.createQuery(Queries.doCredit);
				query.setParameter(0, balance);
				query.setParameter(1, accountNumber);
				query.executeUpdate();
				
				
				query = sess.createQuery(Queries.checkamount);
				query.setParameter(0,1111);
				List<PixAccount> lst2 = query.list();			
				double balance_admin = lst2.get(0).getBalance();
				
					balance_admin = balance_admin + (cost*0.2);
					
					query = sess.createQuery(Queries.doCredit);
					query.setParameter(0, balance_admin);
					query.setParameter(1, 1111);
					query.executeUpdate();
					
				tx.commit();
			
			
			
		}catch(QuerySyntaxException se)
		{se.printStackTrace();}		
	}
	
	

}
