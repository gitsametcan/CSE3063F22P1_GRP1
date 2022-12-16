package System;

import java.io.FileNotFoundException;
import java.util.Optional;
import java.util.Scanner;

import Enums.FilterType;
import data.DataManager;
import person.Advisor;

//Kaan Camci 150119063
public class AdvisorRegistrationSystem {

	private Scanner scanner;
	private RegistrationSystem registrationSystem1;

	public AdvisorRegistrationSystem(RegistrationSystem registrationSystem) throws FileNotFoundException {
		scanner = new Scanner(System.in);
		registrationSystem1 = registrationSystem;
		AdvisorLogin();
	}

	private void AdvisorLogin() throws FileNotFoundException {
		Advisor currentUser = null;

		System.out.println("Please provide your ID:");
		System.out.println("----\nSuggestion: Enter \"????\"");
		while (true) {
			String providedID = scanner.nextLine();
			Optional<Advisor> currentOptionalAdvisor = DataManager.getInstance().findAdvisor(providedID, FilterType.ID);
			if (currentOptionalAdvisor.isPresent()) {
				currentUser = currentOptionalAdvisor.get();
				advisorMenu(currentUser);
				break;
			} else {
				System.out.print("Advisor not found, please try again: ");
			}
		}

	}

	private void advisorMenu(Advisor currentUser) throws FileNotFoundException {

		boolean validInput = false;

		int menuChoice = 0;

		while (menuChoice != 3) {

			System.out.println("Please choose a menu: ");
			System.out.println("1-Registration Applications");
			System.out.println("2-Sign Out");

			validInput = false;

			while (!validInput) {

				menuChoice = scanner.nextInt();

				switch (menuChoice) {
				case 1:
					validInput = true;
					showApplications(currentUser);
					break;
				case 2:
					validInput = true;
					signOut();
					break;
				default:
					System.out.print("The input is not valid, please provide a valid input.");
				}
			}
		}

	}

	private void showApplications(Advisor currentUser) {

		currentUser.showApplications();

	}

	private void signOut() throws FileNotFoundException {
		registrationSystem1.menu();
	}

}
