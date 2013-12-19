package com.pojo;

import java.io.Serializable;



public class PixLoginInfo implements Serializable {
	
		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		private String user_Id;
		private String password;
		
		
		public PixLoginInfo(String userId, String password) {
			super();
			user_Id = userId;
			this.password = password;
		}
		public String getUser_Id() {
			return user_Id;
		}
		public void setUser_Id(String userId) {
			user_Id = userId;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		
}
