package com.pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class PixInvoice implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int invoiceId;
	private Date dateOfPurchase;
	private List<PixTransactions> photoTx;
	private PixUserInfo inf;
	private PixUserInfo userInfo;
	
	
	
	
	public PixUserInfo getUserInfo() {
		return userInfo;
	}
	public void setUserInfo(PixUserInfo userInfo) {
		this.userInfo = userInfo;
	}
	public int getInvoiceId() {
		return invoiceId;
	}
	public void setInvoiceId(int invoiceId) {
		this.invoiceId = invoiceId;
	}
	public Date getDateOfPurchase() {
		return dateOfPurchase;
	}
	public void setDateOfPurchase(Date dateOfPurchase) {
		this.dateOfPurchase = dateOfPurchase;
	}
	public List<PixTransactions> getPhotoTx() {
		return photoTx;
	}
	public void setPhotoTx(List<PixTransactions> photoTx) {
		this.photoTx = photoTx;
	}
	public PixUserInfo getInf() {
		return inf;
	}
	public void setInf(PixUserInfo inf) {
		this.inf = inf;
	}
}

