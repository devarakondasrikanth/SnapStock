package com.service;

import java.util.List;

import com.frm.NewUser;
import com.pixphotofrm.StrutsUploadFrm;
import com.pojo.PixInvoice;
import com.pojo.PixPhotoInfo;
import com.pojo.PixUserInfo;


public interface ServiceI {

	public void insertUser(NewUser user);
	public PixUserInfo CheckUser(PixUserInfo userinfo);
	public void updatePhotoInfo(StrutsUploadFrm photoInfo,PixUserInfo userinfo);
	public List<PixPhotoInfo> getPhotoByCategory(String category);
	public int doTrans(String[] photos, PixUserInfo info);
	public double doBill(String[] photos);
	public List<PixPhotoInfo> getMaxDownloads();
	public List<PixPhotoInfo> getNewArrivals();
	public List<PixPhotoInfo> getUserPix(String uid);
	public List<PixInvoice> getUserHistory(String uid);
	public List<PixPhotoInfo> doDown(String[] photos);
	public double doDebit(PixUserInfo userinfo,double amount);
	public void doCredit(long accountNumber, double cost);
	
}
