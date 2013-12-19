package com.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.dao.Dao;
import com.dao.DaoI;
import com.frm.NewUser;
import com.pixphotofrm.StrutsUploadFrm;
import com.pojo.PixInvoice;
import com.pojo.PixPhotoInfo;
import com.pojo.PixTransactions;
import com.pojo.PixUserInfo;


public class Service implements ServiceI {
	private static ServiceI ser = null;

	public static ServiceI getInstance() {
		if (ser == null) {
			ser = new Service();
		}
		return ser;
	}
	
	/* this method calls insertUser() method in DAO*/
	public void insertUser(NewUser user) {
		// TODO Auto-generated method stub
		
		DaoI dao = Dao.getInstance();
		dao.insertUser(user);
		
	}
	
	/* this method calls CheckUser() method in DAO*/
	@Override
	public PixUserInfo CheckUser(PixUserInfo userinfo) {
		// TODO Auto-generated method stub
		DaoI dao = Dao.getInstance();
		return dao.CheckUser(userinfo);
	}

	/* this method calls UpdatePhotoInfo() method in DAO*/
	@Override
	public void updatePhotoInfo(StrutsUploadFrm photoInfo, PixUserInfo userinfo) {
		// TODO Auto-generated method stub
		DaoI dao = Dao.getInstance();
		dao.updatePhotoInfo(photoInfo, userinfo);
	}

	/* this method calls getPhotoByCategory() method in DAO*/
	@Override
	public List<PixPhotoInfo> getPhotoByCategory(String category) {
		// TODO Auto-generated method stub
		DaoI dao = Dao.getInstance();
		return dao.getPhotoByCategory(category);
	}
	
	/* this method calls getPhotoByCategory() method in DAO*/
	public List<PixPhotoInfo> getMaxDownloads(){
		// TODO Auto-generated method stub
		DaoI dao = Dao.getInstance();
		return dao.getMaxDownloads();
	}

	/* this method calls getPhotoByCategory() method in DAO*/
	public double doBill(String[] photos) {
		// TODO Auto-generated method stub
		double amt=0;
		int phid=0;
		PixPhotoInfo info= null;
		DaoI dao = Dao.getInstance();
		for (String strpid: photos){
			phid = Integer.parseInt(strpid);
			info = dao.getPhotoInfo(phid);
			amt += info.getCost();
		}
		return amt;
	}
	
	/* this method calls doDown() method in DAO*/
	public List<PixPhotoInfo> doDown(String[] photos){
		int phid=0;
		PixPhotoInfo info= null;
		List<PixPhotoInfo> phlist=new ArrayList<PixPhotoInfo>();
		DaoI dao = Dao.getInstance();
		for (String strpid: photos){
			phid = Integer.parseInt(strpid);
			info = dao.getPhotoInfo(phid);
			phlist.add(info);
		}
		
		return phlist;
		
	}

	/* this method calls doTrans() method in DAO*/
	public int doTrans(String[] photos, PixUserInfo info) {
		// TODO Auto-generated method stub
		PixInvoice inv = new PixInvoice();
		inv.setDateOfPurchase(new Date());
		inv.setUserInfo(info);
		int phid=0;
		PixPhotoInfo photoInfo = null;
		PixTransactions pixTrans = null;
		List<PixTransactions> lst = new ArrayList<PixTransactions>();
		for (String strpid: photos){
			phid = Integer.parseInt(strpid);
			photoInfo = new PixPhotoInfo();
			photoInfo.setPhotoId(phid);
			pixTrans = new PixTransactions();
			pixTrans.setPhotoInfo(photoInfo);
			lst.add(pixTrans);
		}
		//inv.setPhotoTx(lst);
		DaoI dao = Dao.getInstance();
		
		return dao.saveInvoice(inv,lst);
	}

	/* this method calls getNewArrivals() method in DAO*/
	public List<PixPhotoInfo> getNewArrivals() {
		// TODO Auto-generated method stub
		DaoI dao = Dao.getInstance();
		return dao.getNewArrivals();
		
	}
	
	/* this method calls getUserPix() method in DAO*/
	@Override
	public List<PixPhotoInfo> getUserPix(String uid) {
		// TODO Auto-generated method stub
		DaoI dao = Dao.getInstance();
		return dao.getUserPix(uid);
		
	}

	/* this method calls getUserHistory() method in DAO*/
	public List<PixInvoice> getUserHistory(String uid) {
		// TODO Auto-generated method stub
		DaoI dao = Dao.getInstance();
		return dao.getUserHistory(uid);
	}

	/* this method calls doDebit() method in DAO */
	public double doDebit(PixUserInfo userinfo, double amount) {
		// TODO Auto-generated method stub
		DaoI dao = Dao.getInstance();
		return dao.doDebit(userinfo,amount);
		
	}

	/* this method calls doCredit() method in DAO */
	public void doCredit(long accountNumber, double cost) {
		// TODO Auto-generated method stub
		DaoI dao = Dao.getInstance();
		dao.doCredit(accountNumber, cost);
	}

	
	

	
	

	
	

		
	
}
