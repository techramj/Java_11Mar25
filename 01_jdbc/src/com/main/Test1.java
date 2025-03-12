package com.main;

public class Test1 {
	
	public static void main(String[] args) {
		String driverClassName = "oracle.jdbc.driver.OracleDriver";
		
		System.out.println("create Connection Object");
		System.out.println("\tstep 1: Load the driver..");
		try {
			Class.forName(driverClassName); //load the driver
			System.out.println("\t\tdriver loaded!!!!");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}

}
