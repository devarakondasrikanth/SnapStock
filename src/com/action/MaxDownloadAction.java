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
 * 
 *  this action sets the most downloaded photos array of size 10 in the request attribute(arrphoto)
 */

public class MaxDownloadAction extends Action {

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest req, HttpServletResponse resp)
			throws ServletException {
		String target = "photos";

		ServiceI ser = Service.getInstance();
		List<PixPhotoInfo> photos = ser.getMaxDownloads();

		req.setAttribute("plist", photos);
		List<PixPhotoInfo> arrphotos = ser.getNewArrivals();

		req.setAttribute("arrphoto", arrphotos);
		return mapping.findForward(target);

	}
}
