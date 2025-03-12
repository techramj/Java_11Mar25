package com.main;

public class TestMySqlConnection {

	public static void main(String[] args) {
		String driverClassName = "com.mysql.cj.jdbc.Driver";

		System.out.println("create Connection Object");
		System.out.println("\tstep 1: Load the driver..");
		try {
			Class.forName(driverClassName); // load the driver
			System.out.println("\t\tmysql driver loaded!!!!");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
