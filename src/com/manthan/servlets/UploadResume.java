package com.manthan.servlets;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;


@WebServlet("/upload") 
public class UploadResume extends HttpServlet {


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(ServletFileUpload.isMultipartContent(request)) {
			try {
				List<FileItem>multiparts = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
				for (FileItem item : multiparts) {
					if(!item.isFormField()) {
						String name = new File(item.getName()).getName();
						item.write(new File("D:\\resume\\" + File.separator + name));
					}
				}
				//file uploaded successfully
				request.setAttribute("message", "File Uploaded Successfully");
			} catch (Exception e) {
				request.setAttribute("messgae", "File Upload Failed due to " + e);
			}
		}else {
			request.setAttribute("message", "no File Found");
		}

		request.getRequestDispatcher("/UploadForm.jsp").forward(request, response);

	}


}