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
import com.ilp03.entity.EmployeeSkills;
import com.ilp03.entity.Skills;

public class EmployeeDAO {

	public static ArrayList<Employee> getAllEmployee(Connection connection) {
		ArrayList<Employee> employeeList = new ArrayList<Employee>();

		Statement statement;
		try {
			statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("select * from employee");

			while (resultSet.next()) {
				int id = resultSet.getInt(1);
				String employeeName = resultSet.getString(2);
				int experience = resultSet.getInt(3);
				int departmentId = resultSet.getInt(4);
				Department department = DepartmentDAO.getDepartment(connection, departmentId);
				int createdBy = resultSet.getInt(5);
				Employee createdEmp = EmployeeDAO.getCreateEmployee(connection,createdBy);
				int updatedBy = resultSet.getInt(6);
				Employee updateEmp = EmployeeDAO.getCreateEmployee(connection,updatedBy);
				Date createdDate = resultSet.getDate(7);
				Date updatedDate = resultSet.getDate(8);

				Employee employee = new Employee(id, employeeName, experience, department, createdEmp, updateEmp, createdDate,
						updatedDate, null);
				employeeList.add(employee);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return employeeList;

	}

	public static Employee getCreateEmployee(Connection connection, int employeeId) {
		Statement statement;
		Employee employee = null;
		if(employeeId!=0) {
			try {
//				statement = connection.createStatement();
//				ResultSet resultSet = statement.executeQuery("select * from employee");
//				
				PreparedStatement preparedStatement= connection.prepareStatement("select * from employee where emp_id= ?;"); 
				preparedStatement.setInt(1,employeeId);
				ResultSet resultSet = preparedStatement.executeQuery();
				
				
				resultSet.next();
				int id = resultSet.getInt(1);
				String employeeName = resultSet.getString(2);
				int experience = resultSet.getInt(3);
//				int departmentId = resultSet.getInt(4);
//				int createdBy = resultSet.getInt(5);
//				int updatedBy = resultSet.getInt(6);
//				Date createdDate = resultSet.getDate(7);
//				Date updatedDate = resultSet.getDate(8);

				employee = new Employee(id, employeeName, experience, null, null, null, null, null,
						null);
				return employee;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
		
		return employee;
	}
	
	public static Employee getEmployeeAndSkillById(Connection connection, int employeeId) {
		Statement statement;
		Employee employee = null;
		try {
//			statement = connection.createStatement();
//			ResultSet resultSet = statement.executeQuery("select * from employee");
//			
			PreparedStatement preparedStatement= connection.prepareStatement("select emp_id,name ,employee.experience as total_experience ,department_id ,skills.skill_id ,employee_skills.experience, skill_name  from employee inner join employee_skills on employee.emp_id = employee_skills.employee_id inner join skills on employee_skills.skill_id = skills.skill_id where emp_id = ?;"); 
			preparedStatement.setInt(1,employeeId);
			ResultSet resultSet = preparedStatement.executeQuery();
			ArrayList<EmployeeSkills> skillList = new ArrayList<EmployeeSkills>();
			
//			resultSet.next();
			int id =0;
			String employeeName =null;
			int experience =0;
			int departmentId = 0;
			while(resultSet.next()) {
				int skillId = resultSet.getInt(5);
				int skillExperience = resultSet.getInt(6);
				String skillName = resultSet.getString(7);
				Skills skill = new Skills(skillId, skillName, null, null, null, null);
				EmployeeSkills employeeSkills = new EmployeeSkills(skill, skillExperience, null, null, null, null);
				skillList.add(employeeSkills);
				id = resultSet.getInt(1);
				employeeName = resultSet.getString(2);
				experience = resultSet.getInt(3);
				departmentId = resultSet.getInt(4);
			}
			if(id!=0) {
				Department department = DepartmentDAO.getDepartment(connection, departmentId);
				employee = new Employee(id, employeeName, experience, department, null, null, null, null,
						skillList);
			}
			return employee;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return employee;
	}
	
	public static ArrayList<Employee> getEmployeeBySkill(Connection connection, String searchSkillName){
		ArrayList<Employee> employeeList = new ArrayList<Employee>();
		Statement statement;
		PreparedStatement preparedStatement;
		try {
			preparedStatement = connection.prepareStatement("select emp_id,name ,employee.experience as total_experience ,department_id ,skills.skill_id ,employee_skills.experience, skill_name  from employee inner join employee_skills on employee.emp_id = employee_skills.employee_id inner join skills on employee_skills.skill_id = skills.skill_id where skill_name = ?;");
			preparedStatement.setString(1,searchSkillName);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				ArrayList<EmployeeSkills> skillList = new ArrayList<EmployeeSkills>();
				int id = resultSet.getInt(1);
				String employeeName = resultSet.getString(2);
				int experience = resultSet.getInt(3);
				int departmentId = resultSet.getInt(4);
				Department department = DepartmentDAO.getDepartment(connection, departmentId);

				int skillId = resultSet.getInt(5);
				int skillExperience = resultSet.getInt(6);
				String skillName = resultSet.getString(7);
				Skills skill = new Skills(skillId, skillName, null, null, null, null);
				EmployeeSkills employeeSkills = new EmployeeSkills(skill, skillExperience, null, null, null, null);
				skillList.add(employeeSkills);

				employeeList.add( new Employee(id, employeeName, experience, department, null, null, null, null,
						skillList));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		return employeeList;
		
	}
	public static ArrayList<Employee> getEmployeeBySkill(Connection connection, String searchSkillName,int searchExperience){
		ArrayList<Employee> employeeList = new ArrayList<Employee>();
		Statement statement;
		PreparedStatement preparedStatement;
		try {
			preparedStatement = connection.prepareStatement("select emp_id,name ,employee.experience as total_experience ,department_id ,skills.skill_id ,employee_skills.experience, skill_name  from employee inner join employee_skills on employee.emp_id = employee_skills.employee_id inner join skills on employee_skills.skill_id = skills.skill_id where skill_name = ? and employee_skills.experience >=?; ");
			preparedStatement.setString(1,searchSkillName);
			preparedStatement.setInt(2,searchExperience);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				ArrayList<EmployeeSkills> skillList = new ArrayList<EmployeeSkills>();
				int id = resultSet.getInt(1);
				String employeeName = resultSet.getString(2);
				int experience = resultSet.getInt(3);
				int departmentId = resultSet.getInt(4);
				int skillId = resultSet.getInt(5);
				int skillExperience = resultSet.getInt(6);
				String skillName = resultSet.getString(7);
				Skills skill = new Skills(skillId, skillName, null, null, null, null);
				EmployeeSkills employeeSkills = new EmployeeSkills(skill, skillExperience, null, null, null, null);
				skillList.add(employeeSkills);
				
				employeeList.add( new Employee(id, employeeName, experience, null, null, null, null, null,
						skillList));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		return employeeList;
		
	}
}
