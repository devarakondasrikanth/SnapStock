package com.frm;

import org.apache.struts.action.ActionForm;

import com.pojo.PixUserInfo;


public class LoginCheck extends ActionForm {


		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		private PixUserInfo userinfo= new PixUserInfo();

		public PixUserInfo getUserinfo() {
			return userinfo;
		}

		public void setUserinfo(PixUserInfo userinfo) {
			this.userinfo = userinfo;
		}
		
		
		
		
		
}
