package System;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class RegistrationSystem {

	private Scanner scanner;

	public RegistrationSystem() throws FileNotFoundException {
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
				StudentRegistrationSystem studentRegistrationSystem = new StudentRegistrationSystem(this);
				break;
			case 2:
				validInput = true;
				InstructorRegistrationSystem instructorRegistrationSystem = new InstructorRegistrationSystem(this);
				break;
			case 3:
				validInput = true;
				AdvisorRegistrationSystem advisorRegistrationSystem = new AdvisorRegistrationSystem(this);
				break;
			case 4:
				System.exit(0);
			default:
				System.out.print("The input is not valid, please provide a valid input.");
			}
		}

	}
}
