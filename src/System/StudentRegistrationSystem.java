package System;

import java.io.FileNotFoundException;
import java.util.Optional;
import java.util.Scanner;

import Enums.FilterType;
import data.DataManager;
import person.Student;
import logger.Logger;

//Kaan Camci 150119063
public class StudentRegistrationSystem {
	Logger log = Logger.getLogger("logs");
	private Scanner scanner;
	private RegistrationSystem registrationSystem1;

	public StudentRegistrationSystem(RegistrationSystem registrationSystem) throws FileNotFoundException {
		scanner = new Scanner(System.in);
		registrationSystem1 = registrationSystem;
		studentLogin();
	}

	private void studentLogin() throws FileNotFoundException {
		Student currentUser = null;
		log.info("Please provide your ID:");
		log.info("----\nSuggestion: Enter \"150119063\"");
		while (true) {
			String providedID = scanner.nextLine();
			Optional<Student> currentOptionalStudent = DataManager.getInstance().findStudent(providedID, FilterType.ID);
			if (currentOptionalStudent.isPresent()) {
				currentUser = currentOptionalStudent.get();
				studentMenu(currentUser);
				break;
			} else {
				log.info("Student not found, please try again: ");
			}
		}

	}

	private void studentMenu(Student currentUser) throws FileNotFoundException {

		boolean validInput = false;

		int menuChoice = 0;
		while (menuChoice != 6) {

			log.info("Please choose a menu: ");
			log.info("1-Transcript");
			log.info("2-Make Lecture Registration");
			log.info("3-Schedule");
			log.info("4-Registration Status");
			log.info("5-Debt");
			log.info("6-Sign Out");
			log.info(
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
					log.info("The input is not valid, please provide a valid input.");
				}
			}
		}

	}

	private void signOut() throws FileNotFoundException {
		registrationSystem1.menu();
	}

}
