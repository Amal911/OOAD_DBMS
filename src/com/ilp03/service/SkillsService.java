package com.ilp03.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.ilp03.dao.ConnectionDAO;
import com.ilp03.dao.SkillsDAO;
import com.ilp03.entity.Skills;

public class SkillsService {
	public static void displayAllSkills() {
		Connection connection = ConnectionDAO.getConnection();
		ArrayList<Skills> skillList = SkillsDAO.getAllSkills(connection);
		System.out.println("Skill ID\tSkill Name");
		for(Skills skill:skillList) {
			System.out.println(skill.getSkillID()+"\t\t"+skill.getSkillName());
		}
		ConnectionDAO.closeConnection(connection);
	}
}
