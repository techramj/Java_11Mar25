package com.seed.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.seed.entity.Employee;
import com.seed.util.ConnectionUtil;

public class Test {

	public static void main(String[] args) {
		// addEmployeeExample();
		//addEmployeeExample(2,"sam",5000);
	    //addEmployeeExample(3,"Jay",12000);
		// updateSalary(5000);

		// System.out.println("1. add emp\n2. Delete emp\n3. Update emp\n4. Display
		// Record");
		// System.out.println("Enter your choice");

		List<Employee> empList = List.of(new Employee(101, "Abhijeet", 3000), new Employee(102, "Abhi", 30000),
				new Employee(103, "Laxmi", 40000));
		
		//addEmployeeExample(1003, "Shreya", 80000);
		//addEmployeeExampleV1(1002, "Shreyash", 90000);
		addEmployeeExample(empList);
		
		//List<Employee> bigList = getDummyEmployees(500000);
		
		//addEmployeesWithOutUsingBatchUpdate(bigList);
		
		//addEmployeesUsingBatchUpdate(bigList);
		
		//transferAmount(2,3,1000);
		

	}
	
	
	
	
	public static void transferAmount(int toEmpId, int fromEmpId, double balance) {
		Connection con = ConnectionUtil.getConnection();
		String sql = "update emp_11mar set salary = salary + ? where id =?";
		
		try {
			con.setAutoCommit(false);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try(PreparedStatement ps = con.prepareStatement(sql)){
			//deduct
			ps.setDouble(1, -balance);
			ps.setInt(2, fromEmpId);
			ps.executeUpdate();
			
			if(true) {
				throw new RuntimeException("forcing to  throw exception for testing...");
			}
			
			
			//add 
			ps.setDouble(1, balance);
			ps.setInt(2, toEmpId);
			ps.executeUpdate();
			
			con.commit();
			System.out.println("transaction completed");
			
		}catch(Exception e) {
			//e.printStackTrace();
			try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			System.out.println("transactiion failed, "+e.getMessage());
		}
		
	}
	
	public static void addEmployeesUsingBatchUpdate(List<Employee> empList) {
		Connection con = ConnectionUtil.getConnection();
		int batchSize = 100;
		long l1 = System.currentTimeMillis();
		try(Statement st = con.createStatement()){
			for(int i=0;i<empList.size();i++) {
				String sql = "insert into emp_11mar(id,name,salary) values (" 
						+ empList.get(i).getId() + ",'" + empList.get(i).getName() + "',"
					+ empList.get(i).getSalary() + ")";
				//st.executeUpdate(sql);
				st.addBatch(sql);
				if((i+1)%batchSize == 0) {
					int[] arr =st.executeBatch();
					//System.out.println(arr.length+" rows inserted");
				}

			}
			
		}catch (Exception ex) {
			ex.printStackTrace();
		}
		long l2 = System.currentTimeMillis();
		System.out.println("all rows updated. Time taken= "+(l2-l1)+" ms");

	}
	
	public static void addEmployeesWithOutUsingBatchUpdate(List<Employee> empList) {
		Connection con = ConnectionUtil.getConnection();
		long l1 = System.currentTimeMillis();
		try(Statement st = con.createStatement()){
			for(int i=0;i<empList.size();i++) {
				String sql = "insert into emp_11mar(id,name,salary) values (" 
						+ empList.get(i).getId() + ",'" + empList.get(i).getName() + "',"
					+ empList.get(i).getSalary() + ")";
				st.executeUpdate(sql);

			}
			
		}catch (Exception ex) {
			ex.printStackTrace();
		}
		long l2 = System.currentTimeMillis();
		System.out.println("all rows updated. Time taken= "+(l2-l1)+" ms");

	}
	
	
	public static void addEmployeeExample(List<Employee> empList) {

		Connection con = ConnectionUtil.getConnection();
		String sql = "insert into emp_11mar(id,name,salary) values (?,?,?)";
		
		try (PreparedStatement ps = con.prepareStatement(sql)) {
			for(Employee e : empList) {
				ps.setInt(1, e.getId());
				ps.setString(2, e.getName());
				ps.setDouble(3, e.getSalary());
				ps.executeUpdate();
				System.out.println("1row inserted.");
			}
		} catch (SQLException exp) {
			exp.printStackTrace();
		}
	}

	@Deprecated
	public static void addEmployeeExampleD(List<Employee> empList) {

		Connection con = ConnectionUtil.getConnection();

		for (Employee e : empList) {
			String sql = "insert into emp_11mar(id,name,salary) values (" 
						+ e.getId() + ",'" + e.getName() + "',"
					+ e.getSalary() + ")";

			try (Statement st = con.createStatement()) {
				int row = st.executeUpdate(sql);
				System.out.println(row + " row inserted!");

			} catch (SQLException exp) {
				exp.printStackTrace();
			}
		}

	}

	public static void updateSalary(double incrementSalaryBy) {
		String sql = "update emp_11mar set salary = salary +" + incrementSalaryBy;
		System.out.println(sql);
		Connection con = ConnectionUtil.getConnection();
		try (Statement st = con.createStatement()) {
			int row = st.executeUpdate(sql);
			System.out.println(row + " row updated!");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void addEmployeeExampleV1(int id, String name, double salary) {

		Connection con = ConnectionUtil.getConnection();
		String sql = "insert into emp_11mar(id,name,salary) values (?,?,?)";

		try (PreparedStatement ps = con.prepareStatement(sql)) {
			
			ps.setInt(1, id);
			ps.setString(2, name);
			ps.setDouble(3, salary);
			
			int row = ps.executeUpdate();
			System.out.println(row + " row inserted!");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Deprecated
	public static void addEmployeeExample(int id, String name, double salary) {

		Connection con = ConnectionUtil.getConnection();
		String sql = "insert into emp_11mar(id,name,salary) values (" + id + ",'" + name + "'," + salary + ")";

		try (Statement st = con.createStatement()) {
			int row = st.executeUpdate(sql);
			System.out.println(row + " row inserted!");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void addEmployeeExample() {

		Connection con = ConnectionUtil.getConnection();
		String sql = "insert into emp_11mar(id,name,salary) values (1,'Jack',5000)";
		Statement st = null;

		try {
			st = con.createStatement();
			int row = st.executeUpdate(sql);
			System.out.println(row + " row inserted!");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (st != null) {
				try {
					st.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	
	private static List<Employee> getDummyEmployees(int count){
		List<Employee> empList = new ArrayList<Employee>();
		for(int i=1; i<=count;i++) {
			Employee emp = new Employee(9999+i, "name-"+i,5000);
			empList.add(emp);
		}
		return empList;
	}
	

}
