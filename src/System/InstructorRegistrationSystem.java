package System;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

import Enums.LectureHour;
import lecture.LectureSession;
import person.Instructor;
import person.Student;

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

		while (menuChoice != 3) {

			System.out.println("Please choose a menu: ");
			System.out.println("1-Show Lecture Sessions");
			System.out.println("2-Show Students Of A Lecture Session");
			System.out.println("3-Sign Out");

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
					showStudents(currentUser);
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

	private void showLectures(Instructor currentUser) {
		List<LectureSession> listOfLectureSessions = currentUser.getListOfLectureSessions();

		for (LectureSession lectureSession : listOfLectureSessions) {
			System.out.println(lectureSession.getLecture().getName() + "." + lectureSession.getSessionID());
			System.out.println("------------");
			System.out.println("Quota: " + lectureSession.getLecture().getQuota());
			System.out.println("Number Of Students: " + lectureSession.getListOfStudents().size());
			if (currentUser.getListOfLectureSessions().size() == 0) {
				System.out.println("You dont have any lecture to be shown.");
			} else {
				List<LectureSession> lectureSessions = currentUser.getListOfLectureSessions();
				int lecturePlaceX = 0;
				int lecturePlaceY = 1;
				for (int y = 1; y < 42; y++) {
					for (int x = 1; x < 79; x++) {
						if (y == 1 || y == 41) {
							System.out.print("_");
							if ((x == 78 && y == 1)) {
								System.out.println();
							}
						} else if ((((x - 2) % 11) == 0) && (((y - 3) % 4) == 0)) {

							if (lecturePlaceX == 7) {
								lecturePlaceX = 1;
								lecturePlaceY++;
							} else {
								lecturePlaceX++;
							}

							boolean thereIsLecture = false;
							for (LectureSession ls : lectureSessions) {
								if (ls.getSessionHours()[lecturePlaceX - 1][lecturePlaceY - 1] == LectureHour.YES) {
									String lectureSessionName = ls.getLecture().getID() + "." + ls.getSessionID();
									System.out.print(lectureSessionName);
									x = x + (lectureSessionName.length()) - 1;
									thereIsLecture = true;
									break;
								}
							}

							if (thereIsLecture == false) {
								System.out.print(" ");
							}

						} else if (x == 1 || x == 78) {
							System.out.print("|");
							if (x == 78) {
								System.out.println();
							}
						} else if ((y - 1) % 4 == 0) {
							System.out.print("_");
						} else if ((x - 1) % 11 == 0) {
							System.out.print("|");
						} else {
							System.out.print(" ");
						}
					}
				}
			}
			System.out.println();
		}
	}

	private void showStudents(Instructor currentUser) {
		int count = 0;
		for(LectureSession lectureSession: currentUser.getListOfLectureSessions()) {
			count++;
			System.out.println(count + ". " + lectureSession.getLecture().getName() + "." + lectureSession.getSessionID());
		}
		System.out.print("Choose A Session: ");
		int sessionChoice = scanner.nextInt();
		LectureSession lectureSession = currentUser.getListOfLectureSessions().get(sessionChoice-1);
		for(Student student: lectureSession.getListOfStudents()) {
			System.out.println("ID: " + student.getId() + "Name: " + student.getFullName());
		}
	}
	private void signOut() throws FileNotFoundException {
		registrationSystem1.menu();
	}

}
