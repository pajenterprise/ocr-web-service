package com.jalasoft.ocrwebservice.database;

import java.sql.*;

public class DBQueryUser {
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




    public boolean existUser(String name, String password) {
        return true;
    }
}
