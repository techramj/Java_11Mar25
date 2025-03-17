package com.seed.main;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

import com.seed.util.ConnectionUtil;

public class CallableTest {
	

	
	public static void main(String[] args) {
		
	}
	
	public static void add(int a, int b) {
		Connection con = ConnectionUtil.getConnection();
		String sql = "call add_num(?,?,?)";
		try(CallableStatement cs = con.prepareCall(sql)){
			cs.setInt(1, a);
			cs.setInt(2, b);
			cs.registerOutParameter(3, Types.INTEGER);
			cs.execute();
			
			int res = cs.getInt(3);
			System.out.println("sum is "+res);
		}catch(SQLException e) {
			
		}
	}

}
