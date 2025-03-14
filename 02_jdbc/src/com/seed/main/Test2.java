package com.seed.main;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.seed.entity.Employee;
import com.seed.util.ConnectionUtil;

public class Test2 {

	public static void main(String[] args) {
		//selectExample();
		List<Employee> empList = getEmployeeSalaryGreaterThan(10000);
		empList.forEach(e->  System.out.println(e));
		
		System.out.println("-----------------");
		getEmployeeSalaryGreaterThan(5000).forEach(e->  System.out.println(e));
	}

	public static List<Employee> getEmployeeSalaryGreaterThan(double salary) {
		String sql = "select * from emp_11mar where salary > ?";
		List<Employee> empList = new ArrayList<>();

		try (PreparedStatement ps = ConnectionUtil.getConnection().prepareStatement(sql)) {
			ps.setDouble(1, salary);
			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					int id = rs.getInt(1); // rs.getInt("id");
					String name = rs.getString(2);
					double empSal = rs.getDouble(3);
					// System.out.println(id + " " + name + " " + salary);
					Employee emp = new Employee(id, name, empSal);
					empList.add(emp);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return empList;
	}

	public static void selectExample() {
		String sql = "select * from emp_11mar";

		try (Statement st = ConnectionUtil.getConnection().createStatement()) {

			try (ResultSet rs = st.executeQuery(sql)) {
				while (rs.next()) {
					int id = rs.getInt(1); // rs.getInt("id");
					String name = rs.getString(2);
					double salary = rs.getDouble(3);
					System.out.println(id + "   " + name + "   " + salary);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
