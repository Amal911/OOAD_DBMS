package com.ilp03.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import com.ilp03.entity.Employee;
import com.ilp03.entity.Skills;

public class SkillsDAO {
	
	public static ArrayList<Skills> getAllSkills(Connection connection){
		ArrayList<Skills> skillList = new ArrayList<Skills>();
		Statement statement;
		try {
			statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("select * from skills");
			while(resultSet.next()) {
				int id = resultSet.getInt(1);
				String skillName = resultSet.getString(2);
				int createdBy= resultSet.getInt(3);
				Employee createdEmployee = EmployeeDAO.getCreateEmployee(connection, createdBy);
				int updatedBy= resultSet.getInt(4);
				Employee updatedEmployee = EmployeeDAO.getCreateEmployee(connection, updatedBy);
				Date createdDate = resultSet.getDate(5);
				Date updatedDate = resultSet.getDate(6);
				
				Skills skill = new Skills(id, skillName, createdEmployee, updatedEmployee, createdDate, updatedDate);
				skillList.add(skill);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return skillList;
	}
}
