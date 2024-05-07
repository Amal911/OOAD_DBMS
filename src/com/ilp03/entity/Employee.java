package com.ilp03.entity;

import java.util.ArrayList;
import java.util.Date;

public class Employee {
	
	private int employee_id;
	private String employeeName;
	private int experience;
	private Department employeeDepartment;
	private Employee createdBy;
	private Employee updatedBy;
	private Date createdDate;
	private Date updatedDate;
	
	private ArrayList<EmployeeSkills> employeeSkillList;
	

	public Employee(int employee_id, String employeeName, int experience, Department employeeDepartment,
			Employee createdBy, Employee updatedBy, Date createdDate, Date updatedDate,
			ArrayList<EmployeeSkills> employeeSkillList) {
		super();
		this.employee_id = employee_id;
		this.employeeName = employeeName;
		this.experience = experience;
		this.employeeDepartment = employeeDepartment;
		this.createdBy = createdBy;
		this.updatedBy = updatedBy;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
		this.employeeSkillList = employeeSkillList;
	}
	public ArrayList<EmployeeSkills> getEmployeeSkillList() {
		return employeeSkillList;
	}
	public void setEmployeeSkillList(ArrayList<EmployeeSkills> employeeSkillList) {
		this.employeeSkillList = employeeSkillList;
	}
	public int getEmployee_id() {
		return employee_id;
	}
	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public int getExperience() {
		return experience;
	}
	public void setExperience(int experience) {
		this.experience = experience;
	}
	public Department getEmployeeDepartment() {
		return employeeDepartment;
	}
	public void setEmployeeDepartment(Department employeeDepartment) {
		this.employeeDepartment = employeeDepartment;
	}
	public Employee getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(Employee createdBy) {
		this.createdBy = createdBy;
	}
	public Employee getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(Employee updatedBy) {
		this.updatedBy = updatedBy;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public Date getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}
	
	
	
}
