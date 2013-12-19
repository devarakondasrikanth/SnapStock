package com.frm;

import org.apache.struts.action.ActionForm;

public class NewUser extends ActionForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String userName;
	private String userId;
	private String password;	
	private long  mobilenumber;	
	private String  email;
	private String location;
	private String gender;
	private long accountnumber;
	
	
	public void setAccountnumber(long accountnumber) {
		this.accountnumber = accountnumber;
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


	public long getMobilenumber() {
		return mobilenumber;
	}


	public void setMobilenumber(long mobilenumber) {
		this.mobilenumber = mobilenumber;
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


		public static long getSerialversionuid() {
		return serialVersionUID;
	}


		public long getAccountnumber() {
			// TODO Auto-generated method stub
			return accountnumber;
		}
			
}
