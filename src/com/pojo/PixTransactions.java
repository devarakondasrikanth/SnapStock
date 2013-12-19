package com.pojo;

import java.io.Serializable;

/*This pojo class is used to bind the class with Transactions table in the database
 *This class contains
 *  Transaction_Id;
 	Total_Amount;
	Buyer_User_Id;
	Date_Of_Purchase;
 * 
 */
public class PixTransactions implements Serializable{
		
		/**
	 * 
	 */
		private static final long serialVersionUID = 1L;
		private int transactionId;
		private PixPhotoInfo photoInfo;
		private PixInvoice invoice;
		
		public int getTransactionId() {
			return transactionId;
		}
		public void setTransactionId(int transactionId) {
			this.transactionId = transactionId;
		}
		public PixPhotoInfo getPhotoInfo() {
			return photoInfo;
		}
		public void setPhotoInfo(PixPhotoInfo photoInfo) {
			this.photoInfo = photoInfo;
		}
		public PixInvoice getInvoice() {
			return invoice;
		}
		public void setInvoice(PixInvoice invoice) {
			this.invoice = invoice;
		}
		
		
}
