package System;

import java.io.FileNotFoundException;
import java.util.Optional;
import java.util.Scanner;

import Enums.FilterType;
import data.DataManager;
import person.Instructor;
import logger.Logger;

//Kaan Camci 150119063
public class InstructorRegistrationSystem {

	private Logger log;
	private Scanner scanner;
	private RegistrationSystem registrationSystem1;

	public InstructorRegistrationSystem(RegistrationSystem registrationSystem) throws FileNotFoundException {
		log = Logger.getLogger("logs");
		scanner = new Scanner(System.in);
		registrationSystem1 = registrationSystem;
		instructorLogin();
	}

	private void instructorLogin() throws FileNotFoundException {
		Instructor currentUser = null;

		log.info("Please provide your ID:");
		log.info("----\nSuggestion: Enter \"150097\"");
		while (true) {
			String providedID = scanner.nextLine();
			Optional<Instructor> currentOptionalAdvisor = DataManager.getInstance().findInstructor(providedID,
					FilterType.ID);
			if (currentOptionalAdvisor.isPresent()) {
				currentUser = currentOptionalAdvisor.get();
				instructorMenu(currentUser);
				break;
			} else {
				log.info("Instructor not found, please try again: ");
			}
		}
	}

	private void instructorMenu(Instructor currentUser) throws FileNotFoundException {

		boolean validInput = false;

		int menuChoice = 0;

		while (menuChoice != 3) {

			log.info("Please choose a menu: ");
			log.info("1-Show Lecture Sessions");
			log.info("2-Show Students Of A Lecture Session");
			log.info("3-Sign Out");

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
					log.info("The input is not valid, please provide a valid input.");
				}
			}
		}

	}

	private void signOut() throws FileNotFoundException {
		registrationSystem1.menu();
	}

}
