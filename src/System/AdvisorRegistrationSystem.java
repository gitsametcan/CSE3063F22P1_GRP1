package System;

import java.io.FileNotFoundException;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Scanner;

import Debt_LRA_Transcript.LectureRegistrationApplication;
import Enums.ApprovalState;
import Enums.FilterType;
import data.DataManager;
import lecture.LectureSession;
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

		int choice = -1;
		while (choice != 0) {
			int count = 0;
			for (LectureRegistrationApplication lectureRegistrationApplication : currentUser.getListOfApplications()) {
				count++;
				System.out.println("" + count + ". " + lectureRegistrationApplication.getStudent().getFullName());
			}
			System.out.println("0. Exit");

			System.out.print("Choose A Lecture Registration Application: ");
			choice = scanner.nextInt();
			if (choice != 0) {
				applicationOperations(choice - 1, currentUser);
			}
		}

	}

	private void applicationOperations(int choice, Advisor currentUser) {
		LectureRegistrationApplication lectureRegistrationApplication = currentUser.getListOfApplications().get(choice);
		String lectureChoice = "";
		while (!lectureChoice.equals("0")) {
			System.out.println("Name Of Student: " + lectureRegistrationApplication.getStudent().getFullName());
			int count = 0;

			System.out.println("Session Name                 Approval State");
			for (Entry<LectureSession, ApprovalState> me : lectureRegistrationApplication.getSessionsSentForApproval()
					.entrySet()) {
				count++;
				String sessionName = me.getKey().getLecture().getID() + "." + me.getKey().getSessionID();
				System.out.printf("%d. %-30s%s", count, sessionName, me.getValue());
			}
			System.out.println("0. Exit");
			System.out.print("Please Enter The Session Name(0 for exit): ");
			lectureChoice = scanner.nextLine();

			LectureSession lectureSession = null;

			for (Entry<LectureSession, ApprovalState> me : lectureRegistrationApplication.getSessionsSentForApproval()
					.entrySet()) {
				String sessionName = me.getKey().getLecture().getID() + "." + me.getKey().getSessionID();
				if (sessionName.equalsIgnoreCase(lectureChoice)) {
					lectureSession = me.getKey();
				}
			}

			System.out.println("1. Approve");
			System.out.println("2. Reject");
			System.out.println("3. Go Back");

			int approveChoice = scanner.nextInt();

			switch (approveChoice) {
			case 1:
				currentUser.approveApplication(lectureRegistrationApplication, lectureSession);
				break;
			case 2:
				currentUser.rejectApplication(lectureRegistrationApplication, lectureSession);
				break;
			default:
				break;
			}

		}

	}

	private void signOut() throws FileNotFoundException {
		registrationSystem1.menu();
	}

}
