package com.pojo;
import java.io.Serializable;
import java.util.Date;
public class PixPhotoInfo implements Serializable {
		
		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

		private int photoId;	
		private double cost;	
		private Date dateOfUpload;
		private PixUserInfo userInfo;
		private String imgsrc;
		private String category;
		private int fileSize;
		
		
		public int getFileSize() {
			return fileSize;
		}
		public void setFileSize(int fileSize) {
			this.fileSize = fileSize;
		}
		public String getCategory() {
			return category;
		}
		public void setCategory(String category) {
			this.category = category;
		}
		public String getImgsrc() {
			return imgsrc;
		}
		public void setImgsrc(String imgsrc) {
			this.imgsrc = imgsrc;
		}
		
		public int getPhotoId() {
			return photoId;
		}
		public void setPhotoId(int photoId) {
			this.photoId = photoId;
		}
		public double getCost() {
			return cost;
		}
		public void setCost(double cost) {
			this.cost = cost;
		}
		public Date getDateOfUpload() {
			return dateOfUpload;
		}
		public void setDateOfUpload(Date dateOfUpload) {
			this.dateOfUpload = dateOfUpload;
		}
		public PixUserInfo getUserInfo() {
			return userInfo;
		}
		public void setUserInfo(PixUserInfo userInfo) {
			this.userInfo = userInfo;
		}
		
		
		
}

