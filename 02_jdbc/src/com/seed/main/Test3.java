package com.seed.main;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import com.seed.util.ConnectionUtil;

public class Test3 {
	public static void main(String[] args) {
		
		try {
			dbMetaData();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//String sql1 = "update emp_11mar set salary = salary + 1000";
		//String sql2 = "delete from emp_11mar where salary<8000";
		String sql3 = "select * from emp_11mar";
		String sql4 = "select * from dept2";
		
		//executeMethodExample(sql1);
		executeMethodExample1(sql3);
		executeMethodExample1(sql4);
		executeMethodExample1("select * from emp2");
	}
	
	
	public static void executeMethodExample1(String sql) {
		Connection con = ConnectionUtil.getConnection();
		try(Statement st = con.createStatement()){
			if(st.execute(sql)) {
				try(ResultSet rs = st.getResultSet()){
					//no of column, type of column
					 ResultSetMetaData rsmd = rs.getMetaData();
					 int colCount = rsmd.getColumnCount();
					 for(int i=1;i<=colCount;i++) {
						 String colName = rsmd.getColumnName(i); 
						 System.out.print(colName+"\t\t\t");
					 }
					 System.out.println();
					 
					 while(rs.next()) {
						 for(int i=1;i<=colCount;i++) {
							 System.out.print(rs.getObject(i)+"\t\t\t");
						 } 
						 System.out.println();
					 }
				}
				
			}else {
				//insert, update, delete
				int count = st.getUpdateCount();
				System.out.println(count+" row(s) affected!!!");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("=========================================");
	}
	
	public static void executeMethodExample(String sql) {
		Connection con = ConnectionUtil.getConnection();
		try(Statement st = con.createStatement()){
			if(st.execute(sql)) {
				try(ResultSet rs = st.getResultSet()){
					while (rs.next()) {
						int id = rs.getInt(1); // rs.getInt("id");
						String name = rs.getString(2);
						double salary = rs.getDouble(3);
						System.out.println(id + "   " + name + "   " + salary);
					}
				}
				
			}else {
				//insert, update, delete
				int count = st.getUpdateCount();
				System.out.println(count+" row(s) affected!!!");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void dbMetaData() throws SQLException {
		Connection con = ConnectionUtil.getConnection();
		DatabaseMetaData md = con.getMetaData();
		
		System.out.println("Product name: " +md.getDatabaseProductName());
		
		System.out.println("max col in select: " +md.getMaxColumnsInSelect());
		System.out.println("max col in table: "+md.getMaxColumnsInTable());

	}
	

}
