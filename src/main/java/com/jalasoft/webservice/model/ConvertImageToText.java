package com.jalasoft.webservice.model;

import net.sourceforge.tess4j.*;

public class ConvertImageToText implements IConvert{
	   
		@Override
		public String Convert(Criteria cri) {
			 ITesseract instance = new Tesseract();  // JNA Interface Mapping
		     //    ITesseract instance = new Tesseract1(); // JNA Direct Mapping
		        instance.setDatapath("thirdParty/Tess4J/tessdata"); // path to tessdata directory

		        try {
		            String result = instance.doOCR(cri.getFile());
		            return (result);
		        } catch (TesseractException e) {
		            return(e.getMessage());
		        }
		}
	

}
