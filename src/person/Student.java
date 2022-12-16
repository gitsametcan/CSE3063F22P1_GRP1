package person;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import Debt_LRA_Transcript.Debt;
import Debt_LRA_Transcript.LectureRegistrationApplication;
import Debt_LRA_Transcript.Transcript;
import Enums.ApprovalState;
import Enums.FilterType;
import Enums.LetterGrade;
import IDs.StudentID;
import data.DataManager;
import lecture.Lecture;
import lecture.LectureSession;
import lecture.Schedule;
import lecture.Semester;

//Kaan Camci 150119063
public class Student extends Person {

	private transient Advisor advisor;
	private StudentID id;
	private Schedule schedule;
	private Transcript transcript;
	private Calendar dateOfEntry;
	private Debt debt;
	private LectureRegistrationApplication registirationApplication;
	private Scanner scanner;

	public Student(String firstName, String lastName, StudentID id, Schedule schedule, Transcript transcript,
			Calendar dateOfEntry) {
		super(firstName, lastName);
		scanner = new Scanner(System.in);
		this.id = id;
		this.schedule = schedule;
		this.transcript = transcript;
		this.dateOfEntry = dateOfEntry;
	}

	// Creating get and set methods for variables
	public void setID(String nID) {
		this.id.setID(nID);
	}

	public void setID(int DepartmentCode, int YearCode, int OrderOfPlacement) {
		this.setID(DepartmentCode, YearCode, OrderOfPlacement);
	}

	public void setTranscript(Transcript transcript) {
		this.transcript = transcript;
	}

	public void setDateOfEntry(Calendar dateOfEntry) {
		this.dateOfEntry = dateOfEntry;
	}

	public Advisor getAdvisor() {
		return advisor;
	}

	public void setAdvisor(Advisor advisor) {
		this.advisor = advisor;
	}

	public Debt getDebt() {
		return debt;
	}

	public void setDebt(Debt debt) {
		this.debt = debt;
	}

	public LectureRegistrationApplication getRegistirationApplication() {
		return registirationApplication;
	}

	public void setRegistirationApplication(LectureRegistrationApplication registirationApplication) {
		this.registirationApplication = registirationApplication;
	}

	public String getID() {
		return id.getID();
	}

	public Schedule getSchedule() {
		return this.schedule;
	}

	public void setSchedule(Schedule schedule) {
		this.schedule = schedule;
	}

	public Transcript getTranscript() {
		return transcript;
	}

	public Calendar getDateOfEntry() {
		return dateOfEntry;
	}

	public void sendForApproval(List<LectureSession> chosenLectureSessions) {
		HashMap<LectureSession, ApprovalState> approvalList = new HashMap<LectureSession, ApprovalState>();
		for (LectureSession ls : chosenLectureSessions) {
			approvalList.put(ls, ApprovalState.Pending);
		}
		this.registirationApplication = new LectureRegistrationApplication(approvalList, this.advisor, this);
		this.advisor.getListOfApplications().add(this.registirationApplication);
	}

	public void showTranscript() throws FileNotFoundException {
		int semesterSize = this.getTranscript().getListOfSemester().size();
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

			Map<Lecture, LetterGrade> tempTakenLectures = this.getTranscript().getListOfSemester().get(i)
					.getListOfLecturesTaken();

			for (Lecture l : tempTakenLectures.keySet()) {

				System.out.printf("%-12s", l.getID());
				System.out.printf("%-40s", l.getName());
				System.out.printf("%-10s", l.getCredit());
				System.out.printf("%-15s%n", tempTakenLectures.get(l).toString());
			}

			System.out.printf("%-31s", "Credits taken in Semester:");
			System.out.println(this.getTranscript().getListOfSemester().get(i).getCreditsTaken());
			System.out.printf("%-31s", "Credits completed in Semester:");
			System.out.println(this.getTranscript().getListOfSemester().get(i).getCreditsCompleted());
		}

	}

	public void showSchedule() throws FileNotFoundException {
		this.getSchedule().showSchedule();
	}

	public void debtMenu() throws FileNotFoundException {
		if (this.getDebt().getAmount() == 0) {
			System.out.println("You have no debt.");
		} else {
			System.out.println("Your debt is " + this.getDebt().getAmount() + "TL.");
			System.out.println("1- Pay your debt");
			System.out.println("2- Go back");

			int payDebtChoice = 0;

			boolean validInput = false;

			while (!validInput) {

				payDebtChoice = scanner.nextInt();

				switch (payDebtChoice) {
				case 1:
					this.getDebt().setAmount(0);
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

	public void registrationStatusMenu() throws FileNotFoundException {
		if (this.getRegistirationApplication() == null) {
			System.out.println("You did not apply for registration.\n");
			return;
		}
		Map<LectureSession, ApprovalState> sessions = this.getRegistirationApplication().getSessionsSentForApproval();
		System.out.println();
		for (LectureSession s : sessions.keySet()) {

			System.out.printf("%s.%s", s.getLecture().getID(), s.getSessionID());
			System.out.printf(" %-15s%n", sessions.get(s).toString());
		}
		System.out.println();
	}

	public void makeRegistrationMenu() throws FileNotFoundException {

		List<Lecture> currentStudentAvailableLectures = DataManager.getInstance().searchLecture("", FilterType.Name);
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
				this.sendForApproval(chosenLectures);
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
		List<Lecture> lectures = DataManager.getInstance().searchLecture("", FilterType.Name);

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
			for (Lecture l : lectures) {
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
			for (Lecture l : lectures) {
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

	private boolean canTakeLecture(Lecture lecture, Transcript transcript) {
		boolean canTake;

		List<Lecture> listOfTaken = new ArrayList<>();

		int a = 0;
		boolean in = false;

		for (int i = 0; i < transcript.getListOfSemester().size(); i++) {
			Semester semester = transcript.getListOfSemester().get(i);
			for (Lecture lectureTaken : semester.getListOfLecturesTaken().keySet()) {
				listOfTaken.add(lectureTaken);
				if (lectureTaken.getName() == lecture.getName()) {
					a = i;
					in = true;
				}
			}
		}
		if (canTake = hasPreqLectureTaken(lecture.getPrerequisite(), listOfTaken)) {
			if (in) {
				canTake = takenPoint(lecture, transcript.getListOfSemester().get(a).getListOfLecturesTaken());
			}
		}
		return canTake;
	}

	private boolean hasPreqLectureTaken(Lecture preqLecture, List<Lecture> listOfLecture) {
		for (Lecture lecture : listOfLecture) {
			if (lecture.getName() == preqLecture.getName())
				return true;
		}
		return false;
	}

	private boolean takenPoint(Lecture lecture, Map<Lecture, LetterGrade> listOfLecturesTaken) {
		boolean point = true;
		if (listOfLecturesTaken.get(lecture).getLetterGradeValue() > 1.99)
			point = false;
		return point;
	}

}
