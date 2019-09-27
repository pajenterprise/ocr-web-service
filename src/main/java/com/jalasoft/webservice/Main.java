/*
 * 
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jalasoft.
 */
package com.jalasoft.webservice;
import com.jalasoft.webservice.database.ConnectionDB;
import com.jalasoft.webservice.database.DBQuery;
import com.jalasoft.webservice.model.*;


public class Main {

	public static void main(String[] args) {
		Criteria image=new CriteriaText ("thirdParty/Tess4J/test/resources/test-data/eurotext.tif", "por");
		ConvertImageToText test= new ConvertImageToText();
		System.out.println(test.Convert(image));
	}
}
