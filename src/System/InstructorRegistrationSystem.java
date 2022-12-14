package System;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import Enums.FilterType;
import data.DataManager;
import lecture.LectureSession;
import lecture.Schedule;
import person.Instructor;
import person.Student;

//Kaan Camci 150119063
public class InstructorRegistrationSystem {

	private Scanner scanner;
	private RegistrationSystem registrationSystem1;

	public InstructorRegistrationSystem(RegistrationSystem registrationSystem) throws FileNotFoundException {
		scanner = new Scanner(System.in);
		registrationSystem1 = registrationSystem;
		instructorLogin();
	}

	private void instructorLogin() throws FileNotFoundException {
		Instructor currentUser = null;

		System.out.println("Please provide your ID:");
		System.out.println("----\nSuggestion: Enter \"????\"");
		while (true) {
			String providedID = scanner.nextLine();
			Optional<Instructor> currentOptionalAdvisor = DataManager.getInstance().findInstructor(providedID,
					FilterType.ID);
			if (currentOptionalAdvisor.isPresent()) {
				currentUser = currentOptionalAdvisor.get();
				instructorMenu(currentUser);
				break;
			} else {
				System.out.print("Instructor not found, please try again: ");
			}
		}
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
		Schedule schedule = currentUser.getSchedule();
		List<LectureSession> listOfLectureSessions = schedule.getListOfLectureSessions();

		for (LectureSession lectureSession : listOfLectureSessions) {
			System.out.println(lectureSession.getLecture().getName() + "." + lectureSession.getSessionID());
			System.out.println("------------");
			System.out.println("Quota: " + lectureSession.getLecture().getQuota());
			System.out.println("Number Of Students: " + lectureSession.getListOfStudents().size());
		}

		schedule.showSchedule();
	}

	private void showStudents(Instructor currentUser) {
		int count = 0;
		for (LectureSession lectureSession : currentUser.getSchedule().getListOfLectureSessions()) {
			count++;
			System.out.println(
					count + ". " + lectureSession.getLecture().getName() + "." + lectureSession.getSessionID());
		}
		System.out.print("Choose A Session: ");
		int sessionChoice = scanner.nextInt();
		LectureSession lectureSession = currentUser.getSchedule().getListOfLectureSessions().get(sessionChoice - 1);
		for (Student student : lectureSession.getListOfStudents()) {
			System.out.println("ID: " + student.getID() + "Name: " + student.getFullName());
		}
	}

	private void signOut() throws FileNotFoundException {
		registrationSystem1.menu();
	}

}
