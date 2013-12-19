package com.client;


import com.dao.Dao;
import com.pojo.PixUserInfo;

public class Client {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Dao dao = new Dao();
		PixUserInfo info = new PixUserInfo();
		info.setAccountNumber(123);
		double amount =100;
		dao.doDebit(info, amount);

	}

}
