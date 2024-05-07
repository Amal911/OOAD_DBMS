package com.ilp03.utility;

import java.util.Scanner;

import com.ilp03.service.EmployeeService;
import com.ilp03.service.SkillsService;

public class EmployeeUtility {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scanner = new Scanner(System.in);
		char exit = 'y';
		while (exit == 'y') {

			System.out.println("Search Employees \n1.By Id \n2.By Skill \n3.By Skill and Experience\n4.Display All Employees\n5.Display All Skills");
			System.out.println("Enter your choice");
			int choice = scanner.nextInt();
			switch (choice) {
			case 1:
				EmployeeService.searchEmployeeById();
				break;
			case 2:
				EmployeeService.searchEmployeeBySkills();
				break;
			case 3:
				EmployeeService.searchEmployeeBySkillAndExperience();
				break;
			case 4:
				EmployeeService.displayAllEmployees();
				break;
			case 5:
				SkillsService.displayAllSkills();
				break;
			default:
				System.out.println("Invalid choice");
			}
			System.out.println("Do you Want to continue? (y/n)");
			exit = scanner.next().charAt(0);
		}
	}

}
