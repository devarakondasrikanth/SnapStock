package com.action;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.frm.LoginCheck;
import com.pojo.PixUserInfo;
import com.service.Service;
import com.service.ServiceI;

/**
 *  this action class checks for user authentication 
 */

public class LoginAction extends Action{

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest req, HttpServletResponse resp)
			throws ServletException {
		HttpSession sess = req.getSession();
		LoginCheck user = (LoginCheck) form;
		ServiceI ser = Service.getInstance();
			
			PixUserInfo user1 = ser.CheckUser(user.getUserinfo());
			String target="";
			String msg = "User and Password Invalid";
			
			if (user1 != null && !((user1.getUserId()).equalsIgnoreCase("admin"))){
				sess.setAttribute("login",user1);
				target="success";
			}
			else{
				target="failure";
				req.setAttribute("failure",msg);
			}
			return mapping.findForward(target);
		
		
	}
}
