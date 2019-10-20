package com.jalasoft.ocrwebservice.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionDB  {
    private static ConnectionDB instance;
    private static Connection conn;
    private ConnectionDB()	{
        this.init();
    }
    public static ConnectionDB getInstance() {
        if (instance==null) {
            instance =new ConnectionDB();
        }
        return instance;
    }

    private void init() {
        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:webservice.db");
            Statement state = conn.createStatement();
            state.execute("create table if not exists fileST("
                    + "id integer primary key,"
                    + "checksum varchar(32),"
                    + "path varchar(250));");
            System.out.println("Table fileST created");
            state.execute("create table if not exists users("
                    + "id integer primary key,"
                    + "userId varchar(32),"
                    + "password varchar(50));");
            System.out.println("Table users created");
            state.execute("create table if not exists employee("
                    + "id integer primary key,"
                    + "employeeId varchar(32),"
                    + "name varchar(32),"
                    + "lastName varchar(32),"
                    + "jobTitle varchar(32),"
                    + "hiredDate varchar(32),"
                    + "photoPath varchar(250));");
            System.out.println("Table employee created");
        }
        catch (ClassNotFoundException c ){
            c.printStackTrace();
        }
        catch (SQLException s){
            s.printStackTrace();
        }
    }
    public static Connection getConnection() {
        return conn;
    }



}