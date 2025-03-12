package com.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestOracleConnection {
	
	public static void main(String[] args) {
		String driverClassName = "oracle.jdbc.driver.OracleDriver";
		String url ="jdbc:oracle:thin:@localhost:1521/PDB";
		String username ="system";
		String password = "sytem";
		
		System.out.println("create Connection Object");
		System.out.println("\tstep 1: Load the driver..");
		try {
			Class.forName(driverClassName); //load the driver
			System.out.println("\t\tOracle driver loaded!!!!");
			
			System.out.println("\t Step 2: create connection object using DriverManager");
			Connection connection = DriverManager.getConnection(url, username, password);
			System.out.println("\t\tconnectio object created: "+connection.getClass());
		
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
	}

}

//c://app/ .. /network/admin/tnsname.ora   
