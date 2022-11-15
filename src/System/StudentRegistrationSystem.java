package System;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import Enums.ApprovalState;
import Enums.LetterGrade;
import lecture.Lecture;
import lecture.LectureSession;
import person.Student;

public class StudentRegistrationSystem {
	
	private Scanner scanner;
	private RegistrationSystem registrationSystem;
	private ObjectCreator objects1;
	
	public StudentRegistrationSystem(ObjectCreator objects) throws FileNotFoundException {
		scanner = new Scanner(System.in);
		objects1 = objects;
		studentLogin();
	}
	
	private void studentLogin() throws FileNotFoundException {
		Student currentUser=null;
		while (true) {
			System.out.println("Please provide your ID:");
			String providedID = scanner.nextLine();
			//currentUser = DataManager.getInstance().findStudent(FilterType.ID, providedID);
			for(Student student: objects1.getStudents()) {
				if(providedID.equals(student.getId())){
					currentUser=student;
					System.out.println("Welcome to Marmara BYS " + currentUser.getFullName());
				}
			}
			
			if (currentUser == null) {
				System.out.println("The user not found.");
				continue;
			}
			break;
		}

		studentMenu(currentUser);
	}

	private void studentMenu(Student currentUser) throws FileNotFoundException {
		
		boolean validInput = false;

		System.out.println("Please choose a menu: ");
		System.out.println("1-Transcript");
		System.out.println("2-Make Lecture Registration");
		System.out.println("3-Schedule");
		System.out.println("4-Registration Status");
		System.out.println("5-Debt");
		System.out.println("6-Sign Out");

		while (!validInput) {

			int menuChoice = scanner.nextInt();

			switch (menuChoice) {
			case 1:
				validInput = true;
				transcriptMenu(currentUser);
				break;
			case 2:
				validInput = true;
				makeRegistrationMenu(currentUser);
				break;
			case 3:
				validInput = true;
				scheduleMenu(currentUser);
				break;
			case 4:
				validInput = true;
				registrationStatusMenu(currentUser);
				break;
			case 5:
				validInput = true;
				debtMenu(currentUser);
				break;
			case 6:
				validInput = true;
				signOut();
				break;
			default:
				System.out.print("The input is not valid, please provide a valid input.");
			}
		}

	}

	private void transcriptMenu(Student currentUser) throws FileNotFoundException {
		for (int i = 0; i < currentUser.getTranscript().getListOfSemester().size(); i++) {
			if (i == 0) {
				System.out.println("1st Semester");
			} else if (i == 1) {
				System.out.println("2nd Semester");
			} else {
				System.out.println((i + 1) + "th Semester");
			}

			System.out.printf("%-12s", "Lecture Code");
			System.out.printf("%-40s", "Lecture Name");
			System.out.printf("%-10s", "Credit");
			System.out.printf("%-15s%n", "Letter Grade");

			HashMap<Lecture, LetterGrade> tempTakenLectures = currentUser.getTranscript().getListOfSemester().get(i)
					.getListOfLecturesTaken();

			for (Lecture l : tempTakenLectures.keySet()) {

				System.out.printf("%-12s", l.getId());
				System.out.printf("%-40s", l.getName());
				System.out.printf("%-10s", l.getCredit());
				System.out.printf("%-15s%n", tempTakenLectures.get(l).toString());
			}

			System.out.printf("%-31s", "Credits taken in Semester:");
			System.out.println(currentUser.getTranscript().getListOfSemester().get(i).getCreditsTaken());
			System.out.printf("%-31s", "Credits completed in Semester:");
			System.out.println(currentUser.getTranscript().getListOfSemester().get(i).getCreditsCompleted());
		}
		
		studentMenu(currentUser);
	}

	private void scheduleMenu(Student currentUser) {

	}

	private void makeRegistrationMenu(Student currentUser) throws FileNotFoundException {

		List<Lecture> currentStudentAvailableLectures = objects1.getLectures();
		System.out.println("Lectures: ");

		for (int i = 0; i < currentStudentAvailableLectures.size(); i++) {
			System.out.printf("Lecture Code: %-15s", currentStudentAvailableLectures.get(i).getId());
			System.out.printf("Lecture Name: %-40s", currentStudentAvailableLectures.get(i).getName());
			System.out.printf("Lecture Type: %-10s",
					currentStudentAvailableLectures.get(i).getLectureType().toString());
			System.out.printf("Lecture Credit: %-4s%n", currentStudentAvailableLectures.get(i).getCredit());
		}
		
		studentMenu(currentUser);
	}

	private void registrationStatusMenu(Student currentUser) throws FileNotFoundException {
		Map<LectureSession, ApprovalState> sessions = currentUser.getRegistirationApplication()
				.getSessionsSentForApproval();

		for (LectureSession s : sessions.keySet()) {
			System.out.printf("%s.%s", s.getLecture(), s.getSessionID());
			System.out.printf("%-15s%n", sessions.get(s).toString());
		}
		studentMenu(currentUser);
	}
	
	private void debtMenu(Student currentUser) throws FileNotFoundException {
		if(currentUser.getDebt().getAmount() == 0) {
			System.out.println("You have no debt.");
		}
		else {
			System.out.println("Your debt is " + currentUser.getDebt().getAmount() + "TL.");
			System.out.println("1- Pay your debt");
			System.out.println("2- Go back");
		}
		
		studentMenu(currentUser);
	}

	private void signOut() throws FileNotFoundException{
		registrationSystem.menu();
	}

}
