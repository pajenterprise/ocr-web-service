package com.jalasoft.webservice.database;

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
		}
		catch (ClassNotFoundException c ){
			System.out.println(c.getException());
		}
		catch (SQLException s){
			System.out.println(s.getErrorCode());
		}
	}
	public static Connection getConnection() {
		return conn;
	}
	


}
