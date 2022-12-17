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
	}

	public void menu() throws FileNotFoundException {
		while (true) {
			log.info("Log in as...");
			log.info("1-Student");
			log.info("2-Instructor");
			log.info("3-Advisor");
			log.info("4-Simulation");
			log.info("5-Exit");
			int loginType = scanner.nextInt();
			switch (loginType) {
				case 1:
					new StudentRegistrationSystem(this);
					break;
				case 2:
					new InstructorRegistrationSystem(this);
					break;
				case 3:
					new AdvisorRegistrationSystem(this);
					break;
				case 4:
					log.info("Initiating simulation...");
					Simulation simulation = new Simulation();
					simulation.run();
					log.info("Done.");
					break;
				case 5:
					log.info("Exiting...");
					System.exit(0);
				default:
					log.info("The input is not valid, please provide a valid input.");
			}
		}

	}
}
