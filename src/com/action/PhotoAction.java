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
import com.service.Service;
import com.service.ServiceI;
/**
 *  this action is to set the request attribute(photolst ) according to category  
*/
public class PhotoAction extends Action{
	
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest req, HttpServletResponse resp)
			throws ServletException {
		String target="photos";
		String category =req.getParameter("cat");
		ServiceI ser = Service.getInstance();
		List<PixPhotoInfo> photos = ser.getPhotoByCategory(category);
		req.setAttribute("photolst", photos);
		return mapping.findForward(target);
		
		
	}

}
