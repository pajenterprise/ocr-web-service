/*
 * Criteria 
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
import java.io.File;
/**
 * *
 * This class is our source object we want to convert
 *
 */
public class Criteria {
	File filePath;

	public Criteria(String sourcePath){
		filePath = new File(sourcePath);

	}

	public File getFile() {
		return filePath;
	}
}
