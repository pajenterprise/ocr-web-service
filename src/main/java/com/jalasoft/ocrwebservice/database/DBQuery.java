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
package com.jalasoft.ocrwebservice.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 * *
 * DB Query contains tra
 *
 */
public class DBQuery {
    public void insert (String checksum, String path) {
        String sql="INSERT INTO filest(checksum,path) VALUES (?,?)";
        Connection conn = ConnectionDB.getInstance().getConnection();
        PreparedStatement state;
        try {
            state = conn.prepareStatement(sql);
            state.setString (1,checksum);
            state.setString (2,path);
            state.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String getPath(String checksum) {
        String path = null;
        String sql ="SELECT path from filest where checksum = '"+checksum+"'";
        Connection conn = ConnectionDB.getInstance().getConnection();
        Statement state;
        try {
            state = conn.createStatement();

            ResultSet result = state.executeQuery(sql);

            while (result.next()) {
                path=result.getString("path");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return path;

    }

    public void deleteFile(String checksum) {
        String sql ="DELETE FROM filest WHERE checksum = ?";
        Connection conn = ConnectionDB.getInstance().getConnection();
        PreparedStatement state;
        try {
            state = conn.prepareStatement(sql);
            state.setString (1,checksum);
            state.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void updatePath (String checksum, String path) {
        String sql="UPDATE filest SET path = ? WHERE checksum = ?";
        Connection conn = ConnectionDB.getInstance().getConnection();
        PreparedStatement state;
        try {
            state = conn.prepareStatement(sql);
            state.setString (1,path);
            state.setString (2,checksum);
            state.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
