package com.dao;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

import com.frm.NewUser;
import com.pojo.PixUserInfo;

public class RegistrationDao extends Dao implements DaoI {
	
	
	Configuration cfg = new Configuration();
	SessionFactory sf = cfg.configure().buildSessionFactory();
	Session sess = sf.openSession();
	Transaction tx = sess.beginTransaction();
	
	public void insertUser(NewUser user) {
		// TODO Auto-generated method stub
		

		PixUserInfo userdet = new PixUserInfo();
		//userdet.setUserId(user.getUserId());
		
		userdet.setUserId(user.getUserId());
		userdet.setUserName(user.getUserName());		
		userdet.setPassword(user.getPassword());
		userdet.setGender(user.getGender());
		userdet.setMobileNumber(user.getMobilenumber());
		userdet.setLocation(user.getLocation());
		userdet.setEmail(user.getEmail());
		//userdet.setAccountNumber(user.getAccountnumber());
		
		sess.save(userdet);

		tx.commit();
		
		sess.close();

	}
		
	
		public NewUser getLogin(String uname, String password) {
		
		Session sess = sf.getCurrentSession();
		Transaction tx = sess.beginTransaction();
		@SuppressWarnings("unused")
		Query qry = sess.createQuery(Queries.viewPhotoQry);
		tx.commit();
		return null;
	}
	
	
	
}
