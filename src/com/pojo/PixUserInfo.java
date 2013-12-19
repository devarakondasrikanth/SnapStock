package com.pojo;

import java.io.Serializable;
import java.util.List;


public class PixUserInfo implements Serializable{


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String userName;
	private String userId;
	private String password;	
	private long mobileNumber;	
	private String  email;
	private String location;
	private String gender;
	private long accountNumber;
	private List<PixPhotoInfo> photos;
	private List<PixInvoice> invlst;
	
	
	
	
	public List<PixInvoice> getInvlst() {
		return invlst;
	}
	public PixUserInfo(String userName, String userId, String password,
			long mobileNumber, String email, String location, String gender,
			long accountNumber, List<PixPhotoInfo> photos) {
		super();
		this.userName = userName;
		this.userId = userId;
		this.password = password;
		this.mobileNumber = mobileNumber;
		this.email = email;
		this.location = location;
		this.gender = gender;
		this.accountNumber = accountNumber;
		this.photos = photos;
	}
	public void setInvlst(List<PixInvoice> invlst) {
		this.invlst = invlst;
	}
	public List<PixPhotoInfo> getPhotos() {
		return photos;
	}
	public void setPhotos(List<PixPhotoInfo> photos) {
		this.photos = photos;
	}
	public PixUserInfo(String userName, String userId, String password,
			long mobileNumber, String email, String location, String gender,
			long accountNumber) {
		super();
		this.userName = userName;
		this.userId = userId;
		this.password = password;
		this.mobileNumber = mobileNumber;
		this.email = email;
		this.location = location;
		this.gender = gender;
		this.accountNumber = accountNumber;
	}
	public PixUserInfo() {
		// TODO Auto-generated constructor stub
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public long getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public long getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}
	
	
	
			
}
