package System;

<<<<<<< Updated upstream
public class InstructorRegistrationSystem {

=======
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

import lecture.Lecture;
import lecture.LectureSession;
import person.Instructor;

//Kaan Camci 150119063
public class InstructorRegistrationSystem {

	private Scanner scanner;
	private RegistrationSystem registrationSystem1;
	private ObjectCreator objects1;

	public InstructorRegistrationSystem(ObjectCreator objects, RegistrationSystem registrationSystem)
			throws FileNotFoundException {
		scanner = new Scanner(System.in);
		objects1 = objects;
		registrationSystem1 = registrationSystem;
	}

	private void instructorLogin() throws FileNotFoundException {
		Instructor currentUser = null;
		while (true) {
			System.out.println("Please provide your ID:");
			System.out.println("----\nSuggestion: Enter \"????\"");
			String providedID = scanner.nextLine();
			// currentUser = DataManager.getInstance().findStudent(FilterType.ID,
			// providedID);
			for (Instructor instructor : objects1.getInstructors()) {
				if (providedID.equals(instructor.getId())) {
					currentUser = instructor;
					System.out.println("Welcome to Marmara BYS " + currentUser.getFullName());
				}
			}

			if (currentUser == null) {
				System.out.println("The user not found.");
				continue;
			}
			break;
		}

		instructorMenu(currentUser);
	}

	private void instructorMenu(Instructor currentUser) throws FileNotFoundException {

		boolean validInput = false;

		int menuChoice = 0;

		while (menuChoice != 4) {

			System.out.println("Please choose a menu: ");
			System.out.println("1-Show Lectures");
			System.out.println("2-Add Lecture");
			System.out.println("3-Remove Lecture");
			System.out.println("4-Sign Out");

			validInput = false;

			while (!validInput) {

				menuChoice = scanner.nextInt();

				switch (menuChoice) {
				case 1:
					validInput = true;
					showLectures(currentUser);
					break;
				case 2:
					validInput = true;
					addLecture(currentUser);
					break;
				case 3:
					validInput = true;
					removeLecture(currentUser);
					break;
				case 4:
					validInput = true;
					signOut();
					break;
				default:
					System.out.print("The input is not valid, please provide a valid input.");
				}
			}
		}

	}

	private void showLectures(Instructor currentUser) {
		List<LectureSession> listOfLectureSessions = currentUser.getListOfLectureSessions();

		for (LectureSession lectureSession : listOfLectureSessions) {
			System.out.println(lectureSession.getLecture().getName() + "." + lectureSession.getSessionID());
			System.out.println("------------");
			System.out.println("Quota: " + lectureSession.getLecture().getQuota());
			
		}
	}

	private void addLecture(Instructor currentUser) {

	}

	private void removeLecture(Instructor currentUser) {

	}

	private void signOut() throws FileNotFoundException {
		registrationSystem1.menu();
	}

>>>>>>> Stashed changes
}
