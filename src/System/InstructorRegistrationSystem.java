package System;

import java.io.FileNotFoundException;
import java.util.Optional;
import java.util.Scanner;

import Enums.FilterType;
import data.DataManager;
import person.Instructor;

//Kaan Camci 150119063
public class InstructorRegistrationSystem {

	private Scanner scanner;
	private RegistrationSystem registrationSystem1;

	public InstructorRegistrationSystem(RegistrationSystem registrationSystem) throws FileNotFoundException {
		scanner = new Scanner(System.in);
		registrationSystem1 = registrationSystem;
		instructorLogin();
	}

	private void instructorLogin() throws FileNotFoundException {
		Instructor currentUser = null;

		System.out.println("Please provide your ID:");
		System.out.println("----\nSuggestion: Enter \"????\"");
		while (true) {
			String providedID = scanner.nextLine();
			Optional<Instructor> currentOptionalAdvisor = DataManager.getInstance().findInstructor(providedID,
					FilterType.ID);
			if (currentOptionalAdvisor.isPresent()) {
				currentUser = currentOptionalAdvisor.get();
				instructorMenu(currentUser);
				break;
			} else {
				System.out.print("Instructor not found, please try again: ");
			}
		}
	}

	private void instructorMenu(Instructor currentUser) throws FileNotFoundException {

		boolean validInput = false;

		int menuChoice = 0;

		while (menuChoice != 3) {

			System.out.println("Please choose a menu: ");
			System.out.println("1-Show Lecture Sessions");
			System.out.println("2-Show Students Of A Lecture Session");
			System.out.println("3-Sign Out");

			validInput = false;

			while (!validInput) {

				menuChoice = scanner.nextInt();

				switch (menuChoice) {
				case 1:
					validInput = true;
					currentUser.showLectures();
					break;
				case 2:
					validInput = true;
					currentUser.showStudents();
					break;
				case 3:
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
