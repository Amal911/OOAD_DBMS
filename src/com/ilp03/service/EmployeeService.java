package com.ilp03.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Scanner;

import com.ilp03.dao.ConnectionDAO;
import com.ilp03.dao.EmployeeDAO;
import com.ilp03.entity.Employee;
import com.ilp03.entity.EmployeeSkills;

public class EmployeeService {
	public static void searchEmployeeById() {
		Connection connection = ConnectionDAO.getConnection();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the Employee Id: ");
		int employeeId = scanner.nextInt();
		Employee employee = EmployeeDAO.getEmployeeAndSkillById(connection, employeeId);
		if (employee == null) {
			System.out.println("No Employee Found");
		} else {
			System.out.println("Employee ID: " + employee.getEmployee_id() + "\nName: " + employee.getEmployeeName()
					+ "\nTotal Experience: " + employee.getExperience()+"\nDepartment: "+employee.getEmployeeDepartment().getDepartmentName());
			System.out.println("\nEmployee Skill List:");
			System.out.println("SkillID\tSkill Name\tExperience in Skill");
			for (EmployeeSkills employeeSkills : employee.getEmployeeSkillList()) {
				System.out.println(employeeSkills.getSkill().getSkillID() + "\t"
						+ employeeSkills.getSkill().getSkillName() + "\t\t" + employeeSkills.getExperience());
			}
		}
		
		ConnectionDAO.closeConnection(connection);

	}
	
	public static void searchEmployeeBySkills() {
		Connection connection = ConnectionDAO.getConnection();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the Skill: ");
		String skill = scanner.nextLine();
		ArrayList<Employee> employeeList = EmployeeDAO.getEmployeeBySkill(connection, skill);
		System.out.println("Employees with Skill "+skill);
		System.out.println("Emp Id\tName\tTotal Experience\tDepartment\tSkill ID\tSkill Name\tExperience in Skill");
		for(Employee employee:employeeList) {
			System.out.print(employee.getEmployee_id()+"\t"+employee.getEmployeeName()+"\t"+employee.getExperience()+
					"\t\t"+employee.getEmployeeDepartment().getDepartmentName()+"\t");
			for(EmployeeSkills empSkill:employee.getEmployeeSkillList()) {
				System.out.println(empSkill.getSkill().getSkillID()+"\t\t"+empSkill.getSkill().getSkillName()+"\t\t\t"
						+empSkill.getExperience());
			}
		}
		ConnectionDAO.closeConnection(connection);
	}
	public static void searchEmployeeBySkillAndExperience() {
		Connection connection = ConnectionDAO.getConnection();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the Skill: ");
		String skill = scanner.nextLine();
		System.out.println("Enter the Minimum Experience: ");
		int experience= scanner.nextInt();
		ArrayList<Employee> employeeList = EmployeeDAO.getEmployeeBySkill(connection, skill, experience);
		System.out.println("Employees with Skill "+skill);
		System.out.println("Emp Id\tName\tTotal Experience\tSkill ID\tSkill Name\tExperience in Skill");
		for(Employee employee:employeeList) {
			System.out.print(employee.getEmployee_id()+"\t"+employee.getEmployeeName()+"\t"+employee.getExperience()+
					"\t\t");
			for(EmployeeSkills empSkill:employee.getEmployeeSkillList()) {
				System.out.println(empSkill.getSkill().getSkillID()+"\t\t"+empSkill.getSkill().getSkillName()+"\t\t\t"
						+empSkill.getExperience());
			}
		}
		ConnectionDAO.closeConnection(connection);
	}
	
	public static void displayAllEmployees() {
		Connection connection = ConnectionDAO.getConnection();
		ArrayList<Employee> employeeList = EmployeeDAO.getAllEmployee(connection);
		System.out.println("Emp Id\tName\t Total Experience\tDepartment\tCreatedBy\tUpdatedBy\tCreate Date\tUpdate Date");
		for(Employee employee:employeeList) {
			System.out.println(employee.getEmployee_id()+"\t"+employee.getEmployeeName()+"\t"+employee.getExperience()+"\t\t"+
					employee.getEmployeeDepartment().getDepartmentName()+"\t\t"+employee.getCreatedBy().getEmployeeName()+"\t"+(employee.getUpdatedBy()==null?"null":employee.getUpdatedBy().getEmployeeName())+"\t\t"+employee.getCreatedDate()+"\t"+employee.getUpdatedDate());
		}
		ConnectionDAO.closeConnection(connection);
	}
}
