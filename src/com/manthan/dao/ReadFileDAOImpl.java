package com.manthan.dao;

import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.FileInputStream;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

import com.manthan.bean.ResumeBean;



public class ReadFileDAOImpl implements ReadFileDAO {

	@Override
	public ResumeBean readPdf(String search, File f) {
      
		ResumeBean resumebean = new ResumeBean();
		//Loading an existing document
		File file = new File("D:\\resume");
		PDDocument document;
		try {
			document = PDDocument.load(file);
			//Instantiate PDFTextStripper class
			PDFTextStripper pdfStripper = new PDFTextStripper();

			//Retrieving text from PDF document
			String text = pdfStripper.getText(document);
			System.out.println(text);

			//Closing the document
			document.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resumebean; 
	}


	@Override
	public ResumeBean readDoc(String search,File f) {

		ResumeBean resumebean = new ResumeBean();
		
		XWPFDocument docx;
		try {
			docx = new XWPFDocument(new FileInputStream("D:\\resume"));

			//using XWPFWordExtractor Class
			XWPFWordExtractor extract = new XWPFWordExtractor(docx);
			System.out.println(extract.getText());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return resumebean;

	}
}		







