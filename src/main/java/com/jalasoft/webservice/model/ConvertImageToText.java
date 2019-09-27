/*
 * ConvertImageToText 
 * 
 * Version 1
 *
 * Date 09/23/2019
 * 
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jalasoft.
 */
package com.jalasoft.webservice.model;

import net.sourceforge.tess4j.*;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

/**
 * The ConvertImageToText class provides make a new result.txt file in the project folder
 * given an Object Criteria that contains a path of a image file. 
 */
public class ConvertImageToText implements IConvert{

	@Override
	public String Convert(Criteria cri) {
		ITesseract instance = new Tesseract();  
		// path to tessdata directory
		instance.setDatapath("thirdParty/Tess4J/tessdata"); 
		instance.setLanguage(cri.getAttribute());

		try {
			String result = instance.doOCR(cri.getFile());
			PrintWriter writer = new PrintWriter("result.txt", "UTF-8");
			writer.println(result);
			writer.close();

		} catch (TesseractException e) {

			return(e.getMessage());

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {

			e.printStackTrace();
		}
		return ("result.txt");
	}


}
