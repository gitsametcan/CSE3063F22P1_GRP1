package System;

import java.io.FileNotFoundException;
import java.util.Scanner;
import logger.Logger;

public class RegistrationSystem {

	Logger log = Logger.getLogger("logs");
	private Scanner scanner;

	public RegistrationSystem() throws FileNotFoundException {
		scanner = new Scanner(System.in);
		menu();
	}

	public void menu() throws FileNotFoundException {

		log.info("Log in as...");
		log.info("1-Student");
		log.info("2-Instructor \"Not Finished!!!\"");
		log.info("3-Advisor \"Not Finished!!!\"");
		log.info("4-Exit");
		log.info("----\nSuggestion: Enter \"1\"");

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
				log.info("The input is not valid, please provide a valid input.");
			}
		}

	}
}
