package com.ilp03.entity;

import java.util.Date;

public class EmployeeSkills {

	private Skills skill;
	private int experience;
	private Employee createdBy;
	private Employee updatedBy;
	private Date createdDate;
	private Date updatedDate;
	
	
	
	public EmployeeSkills( Skills skill, int experience, Employee createdBy, Employee updatedBy,
			Date createdDate, Date updatedDate) {
		super();
		this.skill = skill;
		this.experience = experience;
		this.createdBy = createdBy;
		this.updatedBy = updatedBy;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
	}

	public Skills getSkill() {
		return skill;
	}
	public void setSkill(Skills skill) {
		this.skill = skill;
	}
	public int getExperience() {
		return experience;
	}
	public void setExperience(int experience) {
		this.experience = experience;
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
