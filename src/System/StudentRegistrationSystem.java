package System;

import java.io.FileNotFoundException;
import java.util.Optional;
import java.util.Scanner;

import Enums.FilterType;
import data.DataManager;
import person.Student;

//Kaan Camci 150119063
public class StudentRegistrationSystem {

	private Scanner scanner;
	private RegistrationSystem registrationSystem1;

	public StudentRegistrationSystem(RegistrationSystem registrationSystem) throws FileNotFoundException {
		scanner = new Scanner(System.in);
		registrationSystem1 = registrationSystem;
		studentLogin();
	}

	private void studentLogin() throws FileNotFoundException {
		Student currentUser = null;
		System.out.println("Please provide your ID:");
		System.out.println("----\nSuggestion: Enter \"150119063\"");
		while (true) {
			String providedID = scanner.nextLine();
			Optional<Student> currentOptionalStudent = DataManager.getInstance().findStudent(providedID, FilterType.ID);
			if (currentOptionalStudent.isPresent()) {
				currentUser = currentOptionalStudent.get();
				studentMenu(currentUser);
				break;
			} else {
				System.out.print("Student not found, please try again: ");
			}
		}

	}

	private void studentMenu(Student currentUser) throws FileNotFoundException {

		boolean validInput = false;

		int menuChoice = 0;
		while (menuChoice != 6) {

			System.out.println("Please choose a menu: ");
			System.out.println("1-Transcript");
			System.out.println("2-Make Lecture Registration");
			System.out.println("3-Schedule");
			System.out.println("4-Registration Status");
			System.out.println("5-Debt");
			System.out.println("6-Sign Out");
			System.out.println(
					"----\nSuggestion: Enter \"2\" to go to he registartion menu, then check by entering \"4\" to go to the status menu");

			validInput = false;

			while (!validInput) {

				menuChoice = scanner.nextInt();

				switch (menuChoice) {
				case 1:
					validInput = true;
					currentUser.showTranscript();
					break;
				case 2:
					validInput = true;
					currentUser.makeRegistrationMenu();
					break;
				case 3:
					validInput = true;
					currentUser.showSchedule();
					break;
				case 4:
					validInput = true;
					currentUser.registrationStatusMenu();
					break;
				case 5:
					validInput = true;
					currentUser.debtMenu();
					break;
				case 6:
					validInput = true;
					signOut();
					break;
				default:
					System.out.print("The input is not valid, please provide a valid input.");
				}
			}
		}

	}

	private void signOut() throws FileNotFoundException {
		registrationSystem1.menu();
	}

}
