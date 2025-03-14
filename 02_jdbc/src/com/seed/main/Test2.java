package com.seed.main;

import java.sql.ResultSet;
import java.sql.Statement;

import com.seed.util.ConnectionUtil;

public class Test2 {
	
	public static void main(String[] args) {
		selectExample();
	}
	
	
	public static void selectExample() {
		String sql ="select * from emp_11mar";
		
		try(Statement st = ConnectionUtil.getConnection().createStatement()){
			
			try(ResultSet rs = st.executeQuery(sql)){
				while(rs.next()) {
					int id = rs.getInt(1);  //rs.getInt("id");
					String name = rs.getString(2);
					double salary = rs.getDouble(3);
					System.out.println(id+"   "+name+"   "+salary);
				}
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
