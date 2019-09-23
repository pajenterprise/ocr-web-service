package com.jalasoft.webservice.model;
import java.io.File;

public class Criteria {
 File filePath;
 
 public Criteria(String sourcePath){
	 filePath = new File(sourcePath);
	 
 }
 
 public File getFile() {
	 
		 return filePath;
	 
	 
 }
}
