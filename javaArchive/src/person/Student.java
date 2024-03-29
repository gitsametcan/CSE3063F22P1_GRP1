package person;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import logger.Logger;

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

public class Student extends Person {
	private Logger log;
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
		log = Logger.getLogger("logs");
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
				log.info("1st Semester");
			} else if (i == 1) {
				log.info("2nd Semester");
			} else {
				log.info((i + 1) + "th Semester");
			}
			log.info("%-12s%-40s%-10s%-15s","Lecture Code","Lecture Name","Credit","Letter Grade");

			Map<Lecture, LetterGrade> tempTakenLectures = this.getTranscript().getListOfSemester().get(i)
					.getListOfLecturesTaken();

			for (Lecture l : tempTakenLectures.keySet()) {

				log.info("%-12s%-40s%-10s%-15s%n",l.getID(),l.getName(),l.getCredit(),tempTakenLectures.get(l).toString());
			}

			log.info("%-31s", "Credits taken in Semester:");
			log.info(""+this.getTranscript().getListOfSemester().get(i).getCreditsTaken());
			log.info("%-31s", "Credits completed in Semester:");
			log.info(""+this.getTranscript().getListOfSemester().get(i).getCreditsCompleted());
		}

	}

	public void showSchedule() throws FileNotFoundException {
		this.getSchedule().showSchedule();
	}

	public void debtMenu() throws FileNotFoundException {
		if (this.getDebt().getAmount() == 0) {
			log.info("You have no debt.");
		} else {
			log.info("Your debt is " + this.getDebt().getAmount() + "TL.");
			log.info("1- Pay your debt");
			log.info("2- Go back");

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
					log.info("Please enter a valid input(1,2)");
				}
			}

		}
	}

	public void registrationStatusMenu() throws FileNotFoundException {
		if (this.getRegistirationApplication() == null) {
			log.info("You did not apply for registration.\n");
			return;
		}
		Map<LectureSession, ApprovalState> sessions = this.getRegistirationApplication().getSessionsSentForApproval();
		log.info("");
		for (LectureSession s : sessions.keySet()) {

			log.info("%s.%s%-15s%n",s.getLecture().getID(), s.getSessionID(),sessions.get(s).toString());
		}
		log.info("");
	}

	public void makeRegistrationMenu() throws FileNotFoundException {

		List<Lecture> currentStudentAvailableLectures = availableLessons();
		log.info("Lectures: ");

		for (int i = 0; i < currentStudentAvailableLectures.size(); i++) {
			for (LectureSession s : currentStudentAvailableLectures.get(i).getSessions()) {
				log.info("Lecture Code: %-15sLecture Name: %-40sLecture Type: %-10sLecture Credit: %-4s%n",
						currentStudentAvailableLectures.get(i).getID() + "." + s.getSessionID(),currentStudentAvailableLectures.get(i).getName(),currentStudentAvailableLectures.get(i).getLectureType().toString(),currentStudentAvailableLectures.get(i).getCredit());
			}
		}

		log.info("Enter a lecture session code that you will send for approval.\n"
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
			log.info("Please enter a valid input.");
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
			log.info("Couldn't find %s", partedInput[1]);
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
			log.info("Couldn't find %s", partedInput[1]);
		}
	}

	private void showChosenLectureSessions(List<LectureSession> chosenLectureSessions) {
		log.info("Chosen Lectures:\n");
		for (LectureSession ls : chosenLectureSessions) {
			log.info("Lecture Code: %-15sLecture Name: %-40sLecture Type: %-10sLecture Credit: %-4s%n",ls.getLecture().getID() + "." + ls.getSessionID(),ls.getLecture().getName(),ls.getLecture().getLectureType().toString(),ls.getLecture().getCredit());
		}
		log.info("\n\n\nEnter a lecture session code that you will send for approval.\n"
				+ "\"add lecture_id\" to add session for approval list.\n"
				+ "\"remove lecture_id\" to remove session from approval list.\n" + "Enter \"send\" to send\n"
				+ "Enter \"exit\" to exit");
	}

	public boolean canTakeLecture(Lecture lecture, Transcript transcript) {
		if (transcript == null) {
			return true;
		}
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
		if (preqLecture == null) {
			return true;
		}
		
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
	
	public List<Lecture> availableLessons(){
		List<Lecture> availableLessons = new ArrayList<Lecture>();
		List<Lecture> lecturesUntilNow = DataManager.getInstance().searchLectureUntilTerm(this.getSchedule().getTerm(), this.getSchedule().getTermYear());

		for (Lecture l : lecturesUntilNow) {
			if (l.getTerm() == this.getSchedule().getTerm() && 
					l.getTermYear() == this.getSchedule().getTermYear() && 
					canTakeLecture(l,this.getTranscript())
				)
				availableLessons.add(l);
		}
		
		return availableLessons;
	}

}
