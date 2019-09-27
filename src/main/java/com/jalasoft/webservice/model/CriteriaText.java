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
package com.jalasoft.webservice.model;
/**
 * *
 * Criteria Text (file txt) language
 * fra - France
 * eng - English
 * spa - Spanish
 * por - Portuguese
 */
public class CriteriaText extends Criteria {
	String lang; 
	public CriteriaText(String sourcePath, String language) {
		super(sourcePath);
		lang = language;
	}
	@Override
	public String getAttribute() {
		return lang;
	}

}
