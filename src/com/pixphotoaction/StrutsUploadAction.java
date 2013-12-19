package com.pixphotoaction;
/* This class is used to upload a photo and store it in a upload_original folder and also watermarks the image*/
import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
	import java.io.FileOutputStream;

import javax.imageio.ImageIO;
	import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.ImageIcon;

	import org.apache.struts.action.Action;
	import org.apache.struts.action.ActionForm;
	import org.apache.struts.action.ActionForward;
	import org.apache.struts.action.ActionMapping;
import org.apache.struts.upload.FormFile;
import com.pixphotofrm.StrutsUploadFrm;
import com.pojo.PixUserInfo;
import com.service.Service;
import com.service.ServiceI;
	public class StrutsUploadAction extends Action
	{
	  public ActionForward execute(
	    ActionMapping mapping,
	    ActionForm form,
	    HttpServletRequest request,
	    HttpServletResponse response) throws Exception{
	    StrutsUploadFrm myForm = (StrutsUploadFrm)form;
	    HttpSession session = request.getSession(true);
	    PixUserInfo  userinfo =(PixUserInfo) session.getAttribute("login");
	    @SuppressWarnings("unused")
		String username = ((PixUserInfo) session.getAttribute("login")).getUserName();
	    ServiceI ser = Service.getInstance();
	    ser.updatePhotoInfo(myForm, userinfo);
	 	
	        // Process the FormFile
	        FormFile myFile = myForm.getTheFile();
	       
			String contentType = myFile.getContentType();
	        String fileName    = myFile.getFileName();
	        int fileSize       = myFile.getFileSize();
	        
			byte[] fileData    = myFile.getFileData();
	        String cate	=myForm.getCategory();
	       
			double cost=myForm.getCost();
	        String filePath = getServlet().getServletContext().getRealPath("/")+"upload_original\\"+cate;
	        
	        File folder = new File(filePath);
		       if (!folder.exists()){
		    	   folder.mkdir();
		       }
		      
		        if(!fileName.equals("")){  
		                   
		            File fileToCreate = new File(filePath, fileName);
		                          
		            if(!fileToCreate.exists()){
		              FileOutputStream fileOutStream = new FileOutputStream(fileToCreate);
		              fileOutStream.write(myFile.getFileData());
		              fileOutStream.flush();
		              fileOutStream.close();
		            }
		        }
	        File file = new File(filePath,fileName);
			if (!file.exists()) {
				System.out.println("File not Found");
			}
			ImageIcon icon = new ImageIcon(file.getPath());
			BufferedImage bufferedImage = new BufferedImage(
					icon.getIconWidth(), icon.getIconHeight(),
					BufferedImage.TYPE_INT_RGB);
			Graphics2D g2d = (Graphics2D) bufferedImage.getGraphics();
			g2d.drawImage(icon.getImage(), 0, 0, null);
			AlphaComposite alpha = AlphaComposite.getInstance(
					AlphaComposite.SRC_OVER, 0.5f);
			g2d.setComposite(alpha);
			g2d.setColor(Color.white);
			g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
					RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
			g2d.setFont(new Font("Arial", Font.BOLD, 60));
			String watermark = "SNAPSTOCK";
			FontMetrics fontMetrics = g2d.getFontMetrics();
			Rectangle2D rect = fontMetrics.getStringBounds(watermark, g2d);
			g2d.drawString(watermark, (icon.getIconWidth() - (int) rect
					.getWidth()) / 2, (icon.getIconHeight() - (int) rect
					.getHeight()) / 2);
			g2d.dispose();
			String waterFolderPath=getServlet().getServletContext().getRealPath("/")+"upload\\"+cate;
			 File waterFolder = new File(waterFolderPath);
		       if (!waterFolder.exists()){
		    	   waterFolder.mkdir();
		       }
			File fileout = new File(waterFolder,fileName);
			ImageIO.write(bufferedImage, "jpg", fileout);  
	        request.setAttribute("fileuploadstatus", fileName+ " successfully  uploaded");
	        request.setAttribute("cid", request.getParameter("cid"));
	        request.setAttribute("fsize", fileSize);
	        myForm.setCategory("");
	        myForm.setCost(0.0);
	        return mapping.findForward("success");
	  }
	
}
