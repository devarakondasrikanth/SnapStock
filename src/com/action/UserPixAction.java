package com.action;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.pojo.PixPhotoInfo;
import com.pojo.PixUserInfo;
import com.service.Service;
import com.service.ServiceI;
/**
 * this action sets request attribute for gallery of a particular user
 */
public class UserPixAction extends Action{

	
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest req, HttpServletResponse resp)
			throws ServletException {
		String target="photos";
		
		try
		{
		PixUserInfo info=(PixUserInfo) req.getSession().getAttribute("login");
		String uid=info.getUserId();
		ServiceI ser = Service.getInstance();
		List<PixPhotoInfo> photos = ser.getUserPix(uid);
		int length=photos.size();
		req.setAttribute("userpix", photos);
		req.setAttribute("len", length);
		}catch(NullPointerException nullex){
			String err_msg="UnAuthorized User";
			req.setAttribute("nouserid",err_msg);
			}
		return mapping.findForward(target);
		
		
	}
	
	
}
