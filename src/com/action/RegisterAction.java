package com.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.hibernate.exception.ConstraintViolationException;

import com.frm.NewUser;
import com.service.Service;
import com.service.ServiceI;
/**
 *  this action is to verify a users' account number with a predefined set of accountnumbers
 */ 
public class RegisterAction extends Action {

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest req, HttpServletResponse resp)
			throws ServletException,IOException{
	
	
			
		@SuppressWarnings("unused")
		boolean flag =false;
		NewUser user = (NewUser) form;
		ServiceI ser = Service.getInstance();
		String str="You don't have account in the Bank first create an account with Bank or user-id already exists";
		try{	
			ser.insertUser(user);
			flag = true;			
		}catch(ConstraintViolationException ex){
			ex.printStackTrace();
			req.setAttribute("error", str);
			return mapping.findForward("failure");		
		}
			
			return mapping.findForward("ok");
		
		
	}
}
 