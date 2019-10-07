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
package com.jalasoft.ocrwebservice.model;

import com.jalasoft.ocrwebservice.database.DBQuery;
/**
 * *
 * Manages all statements to the database
 *
 */
public class DBManager {
    DBQuery dbq;
    public DBManager() {
        dbq = new DBQuery();
    }
    public void addFile(String checksum, String path) {
        dbq.insert(checksum, path);
    }
    public String getPath(String checksum) {
        return dbq.getPath(checksum);
    }
    public void deleteFile(String checksum) {
        dbq.deleteFile(checksum);
    }
    public void updatePath(String checksum, String path) {
        dbq.updatePath(checksum,path);
    }
}
