package System;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class RegistrationSystem {

	ObjectCreator objects = null;

	private Scanner scanner;

	public RegistrationSystem() throws FileNotFoundException {
		objects = new ObjectCreator();
		objects.createStudents();
		objects.createAdvisors();
		objects.createLectures();
		scanner = new Scanner(System.in);
		menu();
	}

	public void menu() throws FileNotFoundException {

		System.out.println("Log in as...");
		System.out.println("1-Student");
		System.out.println("2-Instructor \"Not Finished!!!\"");
		System.out.println("3-Advisor \"Not Finished!!!\"");
		System.out.println("4-Exit");
		System.out.println("----\nSuggestion: Enter \"1\"");

		boolean validInput = false;

		while (!validInput) {
			int loginType = scanner.nextInt();
			switch (loginType) {
			case 1:
				validInput = true;
				StudentRegistrationSystem studentRegistrationSystem = new StudentRegistrationSystem(objects, this);
				break;
			case 2:
				validInput = true;
				instructorMenu();
				break;
			case 3:
				validInput = true;
				advisorMenu();
				break;
			case 4:
				System.exit(0);
			default:
				System.out.print("The input is not valid, please provide a valid input.");
			}
		}

	}

	private void instructorMenu() {

	}

	private void advisorMenu() {

	}
}
