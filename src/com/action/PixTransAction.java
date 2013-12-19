package com.action;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.pojo.PixUserInfo;
import com.service.Service;
import com.service.ServiceI;
/**
 *  this action is to do the transactions and sets lists of attributes to the session and requests
*/ 
public class PixTransAction extends Action{
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest req, HttpServletResponse resp)
			throws ServletException {
		HttpSession sess = req.getSession();
		PixUserInfo userInfo = (PixUserInfo)sess.getAttribute("login");
		String[] photos =  req.getParameterValues("chkphoto");
		ServiceI ser = Service.getInstance();
		req.setAttribute("amt", ser.doBill(photos));
		int invid = ser.doTrans(photos, userInfo);
		req.setAttribute("inId", invid);
		req.setAttribute("nophotos",photos.length);
		sess.setAttribute("downlist", ser.doDown(photos));
		sess.setAttribute("list", ser.doDown(photos));
		sess.setAttribute("amount", ser.doBill(photos));
		sess.setAttribute("photos_owned",req.getParameterValues("chkphoto"));
		return mapping.findForward("buy");
		
		
	}
}
