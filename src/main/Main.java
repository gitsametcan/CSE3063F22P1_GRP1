package main;

import java.io.FileNotFoundException;

import System.RegistrationSystem;
import data.DataManager;
import logger.Logger;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {

		DataManager.getInstance().loadFiles();
		Logger log = Logger.getLogger("logs");

		RegistrationSystem registrationSystem = new RegistrationSystem();
		registrationSystem.menu();
	}

}
