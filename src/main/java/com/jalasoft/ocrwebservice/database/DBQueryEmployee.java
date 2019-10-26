package com.jalasoft.ocrwebservice.database;

import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBQueryEmployee {
    public void insert (Employee emp) {
        String sql="INSERT INTO employee(employeeId, name, lastName,jobTitle,hiredDate,photoPath ) VALUES (?,?,?,?,?,?)";
        Connection conn = ConnectionDB.getInstance().getConnection();
        PreparedStatement state;
        try {
            state = conn.prepareStatement(sql);
            state.setString (1,emp.getEmployeeID());
            state.setString (2,emp.getName());
            state.setString (3,emp.getLastName());
            state.setString (4,emp.getJobTitle());
            state.setString (5,emp.getHiredDate());
            state.setString (6,emp.getPhotoPath());
            state.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String getPath(String id) {
        String path = null;
        String sql ="SELECT photoPath from employee where employeeId = '"+id+"'";
        Connection conn = ConnectionDB.getInstance().getConnection();
        Statement state;
        try {
            state = conn.createStatement();

            ResultSet result = state.executeQuery(sql);

            while (result.next()) {
                path=result.getString("photoPath");
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
    public void updatePath (String id, String path) {
        String sql="UPDATE employee SET photoPath=? WHERE employeeId=?";
        Connection conn = ConnectionDB.getInstance().getConnection();
        PreparedStatement state;
        try {
            state = conn.prepareStatement(sql);
            state.setString (1,path);
            state.setString (2,id);

            state.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean existEmployee(String id) {
        String name = null;
        String sql ="SELECT name from employee where employeeId = '"+id+"'";
        Connection conn = ConnectionDB.getInstance().getConnection();
        Statement state;
        try {
            state = conn.createStatement();

            ResultSet result = state.executeQuery(sql);

            while (result.next()) {
                name = result.getString("name");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (name != null);
    }

    public List<Employee> getAllEmployees() {
        List<Employee> employees= new ArrayList<>();
        Employee emp;
        String sql ="SELECT employeeId,name,lastName,jobTitle,hiredDate,photoPath from employee";
        Connection conn = ConnectionDB.getInstance().getConnection();
        Statement state;
        try {
            state = conn.createStatement();
            ResultSet result = state.executeQuery(sql);
            while (result.next()) {
                emp = new Employee();
                emp.setEmployeeID(result.getString("employeeId"));
                emp.setName(result.getString("name"));
                emp.setLastName(result.getString("lastName"));
                emp.setJobTitle(result.getString("jobTitle"));
                emp.setHiredDate(result.getString("hiredDate"));
                emp.setPhotoPath(result.getString("photoPath"));
                employees.add(emp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employees;
    }

    public void deleteEmployee(String id) {
        String sql ="DELETE FROM employee WHERE employeeId = ?";
        Connection conn = ConnectionDB.getInstance().getConnection();
        PreparedStatement state;
        try {
            state = conn.prepareStatement(sql);
            state.setString (1,id);
            state.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
