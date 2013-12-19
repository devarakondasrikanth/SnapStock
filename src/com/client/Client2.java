package com.client;

import java.util.List;

import com.dao.Dao;
import com.pojo.PixPhotoInfo;

public class Client2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Dao dao = new Dao();
		List<PixPhotoInfo> lst = dao.getPhotoByCategory("babies");
		for (PixPhotoInfo p:lst){
			System.out.println(p.getImgsrc() + " " + p.getCategory()+ " " + p.getUserInfo().getUserId());
		}
	}

}
