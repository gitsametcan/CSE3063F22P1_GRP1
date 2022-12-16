package System;

import java.io.FileNotFoundException;
import java.util.Optional;
import java.util.Scanner;

import Enums.FilterType;
import data.DataManager;
import person.Advisor;
import logger.Logger;

//Kaan Camci 150119063
public class AdvisorRegistrationSystem {
	Logger log = Logger.getLogger("logs");
	private Scanner scanner;
	private RegistrationSystem registrationSystem1;

	public AdvisorRegistrationSystem(RegistrationSystem registrationSystem) throws FileNotFoundException {
		scanner = new Scanner(System.in);
		registrationSystem1 = registrationSystem;
		AdvisorLogin();
	}

	private void AdvisorLogin() throws FileNotFoundException {
		Advisor currentUser = null;

		log.info("Please provide your ID:");
		log.info("----\nSuggestion: Enter \"????\"");
		while (true) {
			String providedID = scanner.nextLine();
			Optional<Advisor> currentOptionalAdvisor = DataManager.getInstance().findAdvisor(providedID, FilterType.ID);
			if (currentOptionalAdvisor.isPresent()) {
				currentUser = currentOptionalAdvisor.get();
				advisorMenu(currentUser);
				break;
			} else {
				log.info("Advisor not found, please try again: ");
			}
		}

	}

	private void advisorMenu(Advisor currentUser) throws FileNotFoundException {

		boolean validInput = false;

		int menuChoice = 0;

		while (menuChoice != 3) {

			log.info("Please choose a menu: ");
			log.info("1-Registration Applications");
			log.info("2-Sign Out");

			validInput = false;

			while (!validInput) {

				menuChoice = scanner.nextInt();

				switch (menuChoice) {
				case 1:
					validInput = true;
					currentUser.showApplications();
					break;
				case 2:
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
