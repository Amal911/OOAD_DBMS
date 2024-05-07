package com.ilp03.entity;

import java.util.Date;

public class Department {
	
	private int departmentId;
	private String departmentName;
	private Employee createdBy;
	private Employee updatedBy;
	private Date createdDate;
	private Date updatedDate;
	
	
	public Department(int departmentId, String departmentName, Employee createdBy, Employee updatedBy,
			Date createdDate, Date updatedDate) {
		super();
		this.departmentId = departmentId;
		this.departmentName = departmentName;
		this.createdBy = createdBy;
		this.updatedBy = updatedBy;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
	}
	public int getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
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
