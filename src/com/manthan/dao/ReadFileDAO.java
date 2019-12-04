package com.manthan.dao;

import java.io.File;

import com.manthan.bean.ResumeBean;

public interface ReadFileDAO {

	public ResumeBean readPdf(String search, File f);
	
	public ResumeBean readDoc(String search,File f );
}
