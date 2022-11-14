package main;

import java.io.FileNotFoundException;
import java.util.Scanner;

import Enums.FilterType;
import data.DataManager;
import person.Student;

public class RegistrationSystem {
	
	
	
	private Scanner scanner;
	
	public RegistrationSystem() {
		scanner = new Scanner(System.in);
	}
	
	public void menu() throws FileNotFoundException {
		System.out.println("Log in as...");
		System.out.println("1-Student");
		System.out.println("2-Instructor");
		System.out.println("3-Advisor");
		
		boolean validInput = false;
		
		while (!validInput) {
			int loginType = scanner.nextInt();
			switch(loginType) {
				case 1:
					validInput = true;
					studentMenu();
					break;
				case 2:
					validInput = true;
					instructorMenu();
					break;
				case 3:
					validInput = true;
					advisorMenu();
					break;
				default:
					System.out.print("The input is not valid, please provide a valid input.");	
			}
		}
		
		
	}

	private void studentMenu() throws FileNotFoundException {
		Student currentUser;
		while (true) {
			System.out.println("Please provide your ID:");
			String providedID = scanner.nextLine();
			currentUser = DataManager.getInstance().findStudent(FilterType.ID, providedID);
			if (currentUser == null) {
				System.out.println("The user not found.");
				continue;
			}
			break;
		}
		
		while (true) {
			System.out.println("Please choose a menu: ");
			System.out.println("1-Transcript");
			System.out.println("2-Lecture Registiration");
			System.out.println("3-Schedule");
			System.out.println("4-RegistrationStatus");
			System.out.println("5-Debt");
		}
		
	}
	
	private void instructorMenu() {
		
	}
	
	private void advisorMenu() {
		
	}
}
