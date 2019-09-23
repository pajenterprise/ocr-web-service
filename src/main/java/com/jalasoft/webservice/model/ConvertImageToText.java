package com.jalasoft.webservice.model;

import net.sourceforge.tess4j.*;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
public class ConvertImageToText implements IConvert{
	   
		@Override
		public String Convert(Criteria cri) {
			 ITesseract instance = new Tesseract();  // JNA Interface Mapping
		     //    ITesseract instance = new Tesseract1(); // JNA Direct Mapping
		        instance.setDatapath("thirdParty/Tess4J/tessdata"); // path to tessdata directory

		        try {
		            String result = instance.doOCR(cri.getFile());
		            PrintWriter writer = new PrintWriter("result.txt", "UTF-8");
		            writer.println(result);
		            writer.close();
		            
		        } catch (TesseractException e) {
		            return(e.getMessage());
		        } catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		        return ("result.txt");
		}
	

}
