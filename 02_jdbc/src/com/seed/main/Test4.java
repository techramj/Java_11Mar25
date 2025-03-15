package com.seed.main;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.seed.util.ConnectionUtil;

public class Test4 {

	public static void main(String[] args) {
		//selectExample();
		//insertOperationUsingResultSet();
		//updateOperationUsingResultSet();
		deleteOperationUsingResultSet();
	}
	
	public static void deleteOperationUsingResultSet() {
		String sql = "select * from emp_11mar";
		Connection con = ConnectionUtil.getConnection();

		try (Statement st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE)) {

			try (ResultSet rs = st.executeQuery(sql)) {
				
				//delete 3rd, 6th, last row
				rs.relative(3);
				rs.deleteRow();
				
				rs.relative(3);
				rs.deleteRow();
				
				rs.last();
				rs.deleteRow();
				
				System.out.println("row deleted..");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	
	public static void updateOperationUsingResultSet() {
		String sql = "select * from emp_11mar";
		Connection con = ConnectionUtil.getConnection();

		try (Statement st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE)) {

			try (ResultSet rs = st.executeQuery(sql)) {
				
				//update last row
				rs.last();
				rs.updateString(2, "Jayesh Agarwal");
				rs.updateDouble(3, 29999);
				rs.updateRow();
				System.out.println("row updated");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void insertOperationUsingResultSet() {
		String sql = "select * from emp_11mar";
		Connection con = ConnectionUtil.getConnection();

		try (Statement st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE)) {

			try (ResultSet rs = st.executeQuery(sql)) {
				
				//add one row => 1000, Jayesh , 99999
				rs.moveToInsertRow();
				rs.updateInt(1, 1000);
				rs.updateString(2, "Jayesh");
				rs.updateDouble(3, 99999);
				rs.insertRow();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void selectExample() {
		String sql = "select * from emp_11mar";
		Connection con = ConnectionUtil.getConnection();

		try (Statement st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)) {

			try (ResultSet rs = st.executeQuery(sql)) {
				rs.next(); // first row
				displayEmpDetails(rs);

				rs.next(); // second row
				displayEmpDetails(rs);

				rs.last(); // last row
				displayEmpDetails(rs);

				rs.previous();
				displayEmpDetails(rs);

				rs.first();
				displayEmpDetails(rs);

				System.out.println("----------");

				rs.absolute(3);
				displayEmpDetails(rs, "Absolute of 3 means 3rd row");

				rs.relative(3);
				displayEmpDetails(rs, "relattive of 3  means from curresnt position next 3");

				rs.absolute(3);
				displayEmpDetails(rs, "Absolute of 3");

				rs.absolute(-2);
				displayEmpDetails(rs, "Absolute of -2 means 2nd last");

				rs.next(); // second row
				displayEmpDetails(rs);

				int x = rs.getRow();

				System.out.println("index = " + x);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static void displayEmpDetails(ResultSet rs, String msg) throws SQLException {
		System.out.println("========" + msg + "==========");
		displayEmpDetails(rs);
		System.out.println();
	}

	private static void displayEmpDetails(ResultSet rs) throws SQLException {
		int id = rs.getInt(1); // rs.getInt("id");
		String name = rs.getString(2);
		double salary = rs.getDouble(3);
		System.out.println(id + "   " + name + "   " + salary);
	}

}
