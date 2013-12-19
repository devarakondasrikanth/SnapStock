package com.dao;
public interface Queries {
	public String LoginCheck = "from PixUserInfo UI where UI.userId = ? and UI.password = ?";
	public String viewPhotoQry="from PixPhotoInfo photo where photo.category=?";
	public String getMaxDlQuery ="select count(*),pix.photoInfo.photoId  from PixTransactions pix  group by photo_id order by col_0_0_ desc";
	public String getNewArrivals="from PixPhotoInfo where dateOfUpload >= sysdate-1 order by dateOfUpload desc";
	public String getUserPix="from PixPhotoInfo info where info.userInfo.userId=?";
	public String getHistory="from PixTransactions trans where trans.invoice.invoiceId in (select invoiceId from PixInvoice info where info.userInfo.userId=?)";
	public String getInvoiceById="from PixInvoice inv where user_id=?";
	public String checkamount ="from PixAccount acc where account_number=?";
	public String doDebit ="update PixAccount set balance = ? where account_number=?";
	public String doCredit ="update PixAccount set balance= ? where account_number =?";
}
