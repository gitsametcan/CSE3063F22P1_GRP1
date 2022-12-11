package System;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import Enums.ApprovalState;
import Enums.LectureHour;
import Enums.LetterGrade;
import lecture.Lecture;
import lecture.LectureSession;
import lecture.Schedule;
import person.Student;

//Kaan Camci 150119063
public class StudentRegistrationSystem {

	private Scanner scanner;
	private RegistrationSystem registrationSystem1;
	private ObjectCreator objects1;

	public StudentRegistrationSystem(ObjectCreator objects, RegistrationSystem registrationSystem)
			throws FileNotFoundException {
		scanner = new Scanner(System.in);
		objects1 = objects;
		registrationSystem1 = registrationSystem;
		studentLogin();
	}

	private void studentLogin() throws FileNotFoundException {
		Student currentUser = null;
		while (true) {
			System.out.println("Please provide your ID:");
			System.out.println("----\nSuggestion: Enter \"150119063\"");
			String providedID = scanner.nextLine();
			// currentUser = DataManager.getInstance().findStudent(FilterType.ID,
			// providedID);
			for (Student student : objects1.getStudents()) {
				if (providedID.equals(student.getId())) {
					currentUser = student;
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

		while (menuChoice != 6) {

			System.out.println("Please choose a menu: ");
			System.out.println("1-Transcript");
			System.out.println("2-Make Lecture Registration");
			System.out.println("3-Schedule");
			System.out.println("4-Registration Status");
			System.out.println("5-Debt");
			System.out.println("6-Sign Out");
			System.out.println(
					"----\nSuggestion: Enter \"2\" to go to he registartion menu, then check by entering \"4\" to go to the status menu");

			validInput = false;

			while (!validInput) {

				menuChoice = scanner.nextInt();

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

	}

	private void transcriptMenu(Student currentUser) throws FileNotFoundException {
		int semesterSize = currentUser.getTranscript().getListOfSemester().size();
		for (int i = 0; i < semesterSize; i++) {
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

			Map<Lecture, LetterGrade> tempTakenLectures = currentUser.getTranscript().getListOfSemester().get(i)
					.getListOfLecturesTaken();

			for (Lecture l : tempTakenLectures.keySet()) {

				System.out.printf("%-12s", l.getID());
				System.out.printf("%-40s", l.getName());
				System.out.printf("%-10s", l.getCredit());
				System.out.printf("%-15s%n", tempTakenLectures.get(l).toString());
			}

			System.out.printf("%-31s", "Credits taken in Semester:");
			System.out.println(currentUser.getTranscript().getListOfSemester().get(i).getCreditsTaken());
			System.out.printf("%-31s", "Credits completed in Semester:");
			System.out.println(currentUser.getTranscript().getListOfSemester().get(i).getCreditsCompleted());
		}


	}

	private void scheduleMenu(Student currentUser) throws FileNotFoundException {
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

		studentMenu(currentUser);
	}

	private void scheduleMenu(Student currentUser) throws FileNotFoundException {

		Schedule schedule = new Schedule(currentUser);
		schedule.showSchedule();
		studentMenu(currentUser);

	}

	private void makeRegistrationMenu(Student currentUser) throws FileNotFoundException {

		List<Lecture> currentStudentAvailableLectures = objects1.getLectures();
		System.out.println("Lectures: ");

		for (int i = 0; i < currentStudentAvailableLectures.size(); i++) {
			for (LectureSession s : currentStudentAvailableLectures.get(i).getSessions()) {
				System.out.printf("Lecture Code: %-15s",
						currentStudentAvailableLectures.get(i).getID() + "." + s.getSessionID());
				System.out.printf("Lecture Name: %-40s", currentStudentAvailableLectures.get(i).getName());
				System.out.printf("Lecture Type: %-10s",
						currentStudentAvailableLectures.get(i).getLectureType().toString());
				System.out.printf("Lecture Credit: %-4s%n", currentStudentAvailableLectures.get(i).getCredit());
			}
		}

		System.out.println("Enter a lecture session code that you will send for approval.\n"
				+ "\"add lecture_id\" to add session for approval list.\n"
				+ "\"remove lecture_id\" to remove session from approval list.\n" + "Enter \"send\" to send\n"
				+ "Enter \"exit\" to exit");
		ArrayList<LectureSession> chosenLectures = new ArrayList<LectureSession>();
		while (true) {
			String input = scanner.nextLine();

			parseSelectionCommand(input, chosenLectures);

			if (input.equalsIgnoreCase("send")) {
				currentUser.sendForApproval(chosenLectures);
				// currentUser.getAdvisor().approveApplication(currentUser.getRegistirationApplication());
				// currentUser.setListOfLectureSessions(chosenLectures);
				break;
			}

			if (input.equalsIgnoreCase("exit")) {
				break;
			}
		}
	}

	private void parseSelectionCommand(String input, List<LectureSession> chosenLectures) {
		String[] partedInput;
		String[] partedLectureID;

		if (input.contains(" ")) {
			partedInput = input.split(" ");
		} else {
			return;
		}

		if (partedInput[1].contains(".")) {
			partedLectureID = partedInput[1].split("[.]");
		} else {
			System.out.println("Please enter a valid input.");
			return;
		}

		if (partedInput[0].equalsIgnoreCase("add")) {
			for (Lecture l : objects1.getLectures()) {
				if (l.getID().equalsIgnoreCase(partedLectureID[0])) {
					for (LectureSession ls : l.getSessions()) {
						if (ls.getSessionID().equalsIgnoreCase(partedLectureID[1])) {
							chosenLectures.add(ls);
							showChosenLectureSessions(chosenLectures);
							return;
						}
					}
				}
			}
			System.out.printf("Couldn't find %s", partedInput[1]);
		}
		if (partedInput[0].equalsIgnoreCase("remove")) {
			for (Lecture l : objects1.getLectures()) {
				if (l.getID().equalsIgnoreCase(partedLectureID[0])) {
					for (LectureSession ls : l.getSessions()) {
						if (ls.getSessionID().equalsIgnoreCase(partedLectureID[1])) {
							chosenLectures.remove(ls);
							showChosenLectureSessions(chosenLectures);
							return;
						}
					}
				}
			}
			System.out.printf("Couldn't find %s", partedInput[1]);
		}
	}

	private void showChosenLectureSessions(List<LectureSession> chosenLectureSessions) {
		System.out.println("Chosen Lectures:\n");
		for (LectureSession ls : chosenLectureSessions) {
			System.out.printf("Lecture Code: %-15s", ls.getLecture().getID() + "." + ls.getSessionID());
			System.out.printf("Lecture Name: %-40s", ls.getLecture().getName());
			System.out.printf("Lecture Type: %-10s", ls.getLecture().getLectureType().toString());
			System.out.printf("Lecture Credit: %-4s%n", ls.getLecture().getCredit());
		}
		System.out.println("\n\n\nEnter a lecture session code that you will send for approval.\n"
				+ "\"add lecture_id\" to add session for approval list.\n"
				+ "\"remove lecture_id\" to remove session from approval list.\n" + "Enter \"send\" to send\n"
				+ "Enter \"exit\" to exit");
	}

	private void registrationStatusMenu(Student currentUser) throws FileNotFoundException {
		if (currentUser.getRegistirationApplication() == null) {
			System.out.println("You did not apply for registration.\n");
			return;
		}
		Map<LectureSession, ApprovalState> sessions = currentUser.getRegistirationApplication()
				.getSessionsSentForApproval();
		System.out.println();
		for (LectureSession s : sessions.keySet()) {
			
			System.out.printf("%s.%s", s.getLecture().getID(), s.getSessionID());
			System.out.printf(" %-15s%n", sessions.get(s).toString());
		}
		System.out.println();
	}

	private void debtMenu(Student currentUser) throws FileNotFoundException {
		if (currentUser.getDebt().getAmount() == 0) {
			System.out.println("You have no debt.");
		} else {
			System.out.println("Your debt is " + currentUser.getDebt().getAmount() + "TL.");
			System.out.println("1- Pay your debt");
			System.out.println("2- Go back");

			int payDebtChoice = 0;

			boolean validInput = false;

			while (!validInput) {

				payDebtChoice = scanner.nextInt();

				switch (payDebtChoice) {
				case 1:
					currentUser.getDebt().setAmount(0);
					validInput = true;
					break;
				case 2:
					validInput = true;
					break;
				default:
					System.out.println("Please enter a valid input(1,2)");
				}
			}

		}
	}

	private void signOut() throws FileNotFoundException {
		registrationSystem1.menu();
	}

}
