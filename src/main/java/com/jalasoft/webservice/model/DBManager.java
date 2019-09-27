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

import com.jalasoft.webservice.database.DBQuery;
/**
 * *
 * Criteria Image (file png/jgp/tif)
 *
 */
public class DBManager {
	DBQuery dbq;
	public DBManager() {
		dbq = new DBQuery();
	}
	public void addfile(String checksum, String path) {
		dbq.insert(checksum, path);
	}
	public String getPath(String checksum) {
		return dbq.getPath(checksum);
	}
}
