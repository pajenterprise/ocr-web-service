package com.jalasoft.webservice.model;
import java.io.File;

public class Criteria {
 File filePath;
 
 public Criteria(String sourcePath){
	 File filePath = new File(sourcePath);
 }
 
 public File getFile() {
	 if (filePath!=null)
		 return filePath;
	 
	 return(new File("thirdParty/Tess4J/test/resources/test-data/eurotext.tif"));
 }
}
