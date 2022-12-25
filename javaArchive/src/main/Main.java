package main;

import java.io.FileNotFoundException;

import System.RegistrationSystem;
import data.DataManager;
import logger.Logger;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {

		DataManager.getInstance().loadFiles();
		Logger.getLogger("logs"); // To ensure logger is loaded here

		RegistrationSystem registrationSystem = new RegistrationSystem();
		registrationSystem.menu();
	}
}
