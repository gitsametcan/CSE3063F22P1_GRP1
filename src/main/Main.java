package main;

import java.io.FileNotFoundException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import System.RegistrationSystem;

public class Main {
	
	private static final Logger LOG = LogManager.getLogger(Main.class);

	public static void main(String[] args) throws FileNotFoundException {
		LOG.info("Appending string: {}.", "Hello, World");

		RegistrationSystem registrationSystem = new RegistrationSystem();

	}

}
