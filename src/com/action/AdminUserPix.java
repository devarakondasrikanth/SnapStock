package com.action;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.frm.AdminFrm;
import com.pojo.PixPhotoInfo;
import com.service.Service;
import com.service.ServiceI;

/**
 * this action class checks for valid user
 */

public class AdminUserPix extends Action{
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest req, HttpServletResponse resp)
			throws ServletException {
		System.out.println("AdminUserPix Action Called");
		AdminFrm user = (AdminFrm) form;
		String userid = user.getUserId(); 
		System.out.println(""+userid);
		String target="photos";
		
		try
		{
		
		String uid=userid;
		ServiceI ser = Service.getInstance();
		List<PixPhotoInfo> photos = ser.getUserPix(uid);
		
		req.setAttribute("userpix", photos);
		}catch(NullPointerException nullex){
			String err_msg="UnAuthorized User";
			req.setAttribute("nouserid",err_msg);
			}
		return mapping.findForward(target);
	}
}
