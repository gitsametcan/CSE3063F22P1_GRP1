package System;

import java.io.FileNotFoundException;
import java.util.Scanner;

import logger.Logger;
import simulation.Simulation;

public class RegistrationSystem {

	private Logger log;
	private Scanner scanner;

	public RegistrationSystem() throws FileNotFoundException {
		log = Logger.getLogger("logs");
		scanner = new Scanner(System.in);
		menu();
	}

	public void menu() throws FileNotFoundException {

		log.info("Log in as...");
		log.info("1-Student");
		log.info("2-Instructor");
		log.info("3-Advisor");
		log.info("4-Simulation");
		log.info("4-Exit");

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
				validInput = true;
				Simulation simulation = new Simulation();
			case 5:
				System.exit(0);
			default:
				log.info("The input is not valid, please provide a valid input.");
			}
		}

	}
}
