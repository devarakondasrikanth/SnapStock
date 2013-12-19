package com.pojo;

import java.io.Serializable;

/*This class will give the information regarding the PixAccount Information 
 * from this class payment transactions are carried out
 */
public class PixAccount implements Serializable{

		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		private int accountNumber;
		private String accountName;
		private double balance;
		
		
		public int getAccountNumber() {
			return accountNumber;
		}
		
		public void setAccountNumber(int accountNumber) {
			this.accountNumber = accountNumber;
		}

		public String getAccountName() {
			return accountName;
		}
		public void setAccountName(String accountName) {
			this.accountName = accountName;
		}
		public double getBalance() {
			return balance;
		}
		public void setBalance(double balance) {
			this.balance = balance;
		}
		
}
