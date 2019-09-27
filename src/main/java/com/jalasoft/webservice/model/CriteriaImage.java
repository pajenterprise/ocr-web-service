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
 * Criteria Image (file png/jgp/tif)
 *
 */
public class CriteriaImage extends Criteria{

	public CriteriaImage(String sourcePath) {
		super(sourcePath);

	}

	@Override
	public String getAttribute() {
		return null;
	}

}
