package com.action;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.pojo.PixPhotoInfo;
import com.pojo.PixUserInfo;
import com.service.Service;
import com.service.ServiceI;

/**
 * This class is used to debit and credit the amount from the owners,buyer and site maintain account
 * @author trg
 *
 */
public class CheckBalanceAction extends Action{
	
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest req, HttpServletResponse resp)
			throws ServletException {
		String target="Sucess";
		HttpSession sess = req.getSession();
		PixUserInfo info=(PixUserInfo) req.getSession().getAttribute("login");
		Double amount=(Double) sess.getAttribute("amount");
		ServiceI ser = Service.getInstance();
		double debitedAmount = ser.doDebit(info, amount);
		String[] photos = (String[]) sess.getAttribute("photos_owned");
		List<PixPhotoInfo> photolists = ser.doDown(photos);
		for(PixPhotoInfo pinfo :photolists)
		{
			ser.doCredit(pinfo.getUserInfo().getAccountNumber(),pinfo.getCost());
		}		
		if(debitedAmount ==-1)
		{
			target = "Failure";
		}
		return mapping.findForward(target);
		
		
	}
}
