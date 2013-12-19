package com.action;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.pojo.PixInvoice;
import com.pojo.PixUserInfo;
import com.service.Service;
import com.service.ServiceI;
/**
 *  this action sets the user history 
*/
public class UserHistory extends Action{
	
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest req, HttpServletResponse resp)
			throws ServletException {
		String target="invoice";
		try{
		PixUserInfo info=(PixUserInfo) req.getSession().getAttribute("login");
		String uid=info.getUserId();
		ServiceI ser = Service.getInstance();
		List<PixInvoice> invoices = ser.getUserHistory(uid);
		
		
		req.setAttribute("userhistory", invoices);
		}catch(NullPointerException nex)
		{
			nex.printStackTrace();
		}
		return mapping.findForward(target);
		
	}
}
