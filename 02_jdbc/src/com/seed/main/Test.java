package com.seed.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.seed.util.ConnectionUtil;

public class Test {
	
	
	public static void main(String[] args) {
		//addEmployeeExample();
		addEmployeeExample(2,"sam",9000);
		addEmployeeExample(3,"Jay",12000);
		
	}
	
public static void addEmployeeExample(int id, String name, double salary)  {
		
		Connection con = ConnectionUtil.getConnection();
		String sql = "insert into emp_11mar(id,name,salary) values ("+id+",'"+name+"',"+salary+")";
		
		try(Statement st = con.createStatement())
		{
			int row = st.executeUpdate(sql);
			System.out.println(row+" row inserted!");
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void addEmployeeExample()  {
		
		Connection con = ConnectionUtil.getConnection();
		String sql = "insert into emp_11mar(id,name,salary) values (1,'Jack',5000)";
		Statement st = null;
		
		try
		{
			st = con.createStatement();
			int row = st.executeUpdate(sql);
			System.out.println(row+" row inserted!");
			
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(st!=null) {
				try {
					st.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
