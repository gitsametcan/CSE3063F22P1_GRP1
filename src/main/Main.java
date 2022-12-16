package main;

import java.io.FileNotFoundException;

import System.RegistrationSystem;
import logger.Logger;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {

		Logger log = Logger.getLogger("logs");
		log.info("info deneme");
		log.error("error deneme");
		log.info("formatted info %s", "deneme");
		log.error("formatted error %s", "deneme");
		
		//DataManager.getInstance().writeExamples();
		
		new RegistrationSystem();

	}

}
