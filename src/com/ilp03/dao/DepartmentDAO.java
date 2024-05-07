package com.ilp03.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import com.ilp03.entity.Department;
import com.ilp03.entity.Employee;

public class DepartmentDAO {
	
	public static ArrayList<Department> getAllDepartments(Connection connection){
		ArrayList<Department> departmentList = new ArrayList<Department>();
		Statement statement;
		try {
			statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("select * from department");
			while(resultSet.next()) {
				int id = resultSet.getInt(1);
				String departmentName = resultSet.getString(2);
				int createdBy= resultSet.getInt(3);
				Employee createdEmployee = EmployeeDAO.getCreateEmployee(connection, createdBy);
				int updatedBy= resultSet.getInt(4);
				Employee updatedEmployee = EmployeeDAO.getCreateEmployee(connection, updatedBy);
				Date createdDate = resultSet.getDate(5);
				Date updatedDate = resultSet.getDate(6);
				
				Department department = new Department(id, departmentName, createdEmployee, updatedEmployee, createdDate, updatedDate);
				departmentList.add(department);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return departmentList;
	}
	
	
	public static Department getDepartment(Connection connection, int deptId){
		Statement statement;
		Department department  = null;
		try {
			statement = connection.createStatement();
			PreparedStatement preparedStatement= connection.prepareStatement("select * from departments where department_id= ?;"); 
			preparedStatement.setInt(1,deptId);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				int id = resultSet.getInt(1);
				String departmentName = resultSet.getString(2);
				int createdBy= resultSet.getInt(3);
				Employee createdEmployee = EmployeeDAO.getCreateEmployee(connection, createdBy);
				int updatedBy= resultSet.getInt(4);
				Employee updatedEmployee = EmployeeDAO.getCreateEmployee(connection, updatedBy);
				Date createdDate = resultSet.getDate(5);
				Date updatedDate = resultSet.getDate(6);
				
				department = new Department(id, departmentName, createdEmployee, updatedEmployee, createdDate, updatedDate);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return department;
	}
	
}
