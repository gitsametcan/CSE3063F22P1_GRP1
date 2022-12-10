package System;

import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

import Debt_LRA_Transcript.LectureRegistrationApplication;
import Enums.ApprovalState;
import lecture.LectureSession;
import person.Advisor;

//Kaan Camci 150119063
public class AdvisorRegistrationSystem {

	private Scanner scanner;
	private RegistrationSystem registrationSystem1;
	private ObjectCreator objects1;

	public AdvisorRegistrationSystem(ObjectCreator objects, RegistrationSystem registrationSystem)
			throws FileNotFoundException {
		scanner = new Scanner(System.in);
		objects1 = objects;
		registrationSystem1 = registrationSystem;
		AdvisorLogin();
	}

	private void AdvisorLogin() throws FileNotFoundException {
		Advisor currentUser = null;
		while (true) {
			System.out.println("Please provide your ID:");
			System.out.println("----\nSuggestion: Enter \"????\"");
			String providedID = scanner.nextLine();
			// currentUser = DataManager.getInstance().findStudent(FilterType.ID,
			// providedID);
			for (Advisor advisor : objects1.getAdvisors()) {
				if (providedID.equals(advisor.getId())) {
					currentUser = advisor;
					System.out.println("Welcome to Marmara BYS " + currentUser.getFullName());
				}
			}

			if (currentUser == null) {
				System.out.println("The user not found.");
				continue;
			}
			break;
		}

		advisorMenu(currentUser);
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
				case 3:
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
				String sessionName = me.getKey().getLecture().getName() + "." + me.getKey().getLecture().getID() + "."
						+ me.getKey().getSessionID();
				System.out.printf("%d. %-30s%s", count, sessionName, me.getValue());
			}
			System.out.println("0. Exit");
			System.out.print("Please Enter The Session Name(0 for exit): ");
			lectureChoice = scanner.nextLine();

			System.out.println("1. Approve");
			System.out.println("2. Reject");
			System.out.println("3. Go Back");

			int approveChoice = scanner.nextInt();

			switch (approveChoice) {
			case 1:
				currentUser.approveApplication(lectureRegistrationApplication, lectureChoice);
				break;
			case 2:
				currentUser.rejectApplication(lectureRegistrationApplication, lectureChoice);
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
