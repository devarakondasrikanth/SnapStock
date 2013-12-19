package com.servlet; 

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.Dao;
import com.dao.DaoI;
import com.pojo.PixPhotoInfo;

/**
 * Servlet implementation class PhotoDownload
 */
public class PhotoDownload extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PhotoDownload() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("image/jpg");
		
		int pid = Integer.parseInt(request.getParameter("pid"));
		DaoI dao = Dao.getInstance();
		PixPhotoInfo info = dao.getPhotoInfo(pid);
		String img = info.getImgsrc();
		response.addHeader("content-disposition", "attachment;filename=" + img);
		byte[] bytes = new byte[info.getFileSize()];
		InputStream st = getServletContext().getResourceAsStream("/upload_original/" + info.getCategory()+ "/"+ img);
		st.read(bytes);
		response.getOutputStream().write(bytes);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
