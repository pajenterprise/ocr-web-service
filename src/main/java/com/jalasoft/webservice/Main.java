package com.jalasoft.webservice;
import com.jalasoft.webservice.database.ConnectionDB;
import com.jalasoft.webservice.database.DBQuery;
import com.jalasoft.webservice.model.*;


public class Main {

	public static void main(String[] args) {
		Criteria image=new Criteria ("thirdParty/Tess4J/test/resources/test-data/eurotext.tif");
		ConvertImageToText test= new ConvertImageToText();
		System.out.println(test.Convert(image));
	}
}
