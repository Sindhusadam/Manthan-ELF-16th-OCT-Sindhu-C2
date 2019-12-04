package com.manthan.servlets;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.util.PDFTextStripper;

@WebServlet("/search2")
public class SearchResume extends HttpServlet {


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		ArrayList<File> al = new ArrayList<File>();
		
		File file = new File("D:\\resume");
		
		String string = req.getParameter("search");
		
		if(file.exists() && file.isDirectory()) {
			File array[] = file.listFiles();
			
			for (File f : array) {
				if(file.isFile()) {
					try {
						PDDocument pddocument = PDDocument.load(file);
						
						PDFTextStripper pdftextstripper = new PDFTextStripper();
						
						String string1 = pdftextstripper.getText(pddocument);
						
						String string2 = string1.replace("\n", " ").replace("\r", " ");
						
						if(string2.contains(string)) {
							System.out.println(file);
							al.add(file);
						}
				
					} catch (Exception e) {
                        e.printStackTrace();
					}
			}
		}
		}
					
		req.setAttribute("files", al);
		req.getRequestDispatcher("./search1").forward(req, resp);
	}

}
