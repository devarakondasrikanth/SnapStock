package com.dao;

import java.util.List;

import com.frm.NewUser;
import com.pixphotofrm.StrutsUploadFrm;
import com.pojo.PixInvoice;
import com.pojo.PixPhotoInfo;
import com.pojo.PixTransactions;
import com.pojo.PixUserInfo;

public interface DaoI {

	public void insertUser(NewUser user);
	public PixUserInfo CheckUser(PixUserInfo userinfo);
	public void updatePhotoInfo(StrutsUploadFrm photoInfo,PixUserInfo userinfo);
	public List<PixPhotoInfo> getPhotoByCategory(String category);
	public PixPhotoInfo getPhotoInfo(int pid);
	public int saveInvoice(PixInvoice inv,List<PixTransactions> lst);
	
	public List<PixPhotoInfo> getMaxDownloads();
	public List<PixPhotoInfo> getNewArrivals();
	public List<PixPhotoInfo> getUserPix(String uid);
	public List<PixInvoice> getUserHistory(String uid);
	public double doDebit(PixUserInfo userinfo, double amount);
	public void doCredit(long accountNumber, double cost);
	

}
