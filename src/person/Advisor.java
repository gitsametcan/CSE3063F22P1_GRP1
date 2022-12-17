package person;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;
import java.util.Map.Entry;
import logger.Logger;

import Debt_LRA_Transcript.LectureRegistrationApplication;
import Enums.ApprovalState;
import Enums.InstructorType;
import IDs.InstructorID;
import lecture.Lecture;
import lecture.LectureSession;
import lecture.Schedule;

//Kaan Camci 150119063
public class Advisor extends Instructor {
	Logger log = Logger.getLogger("logs");
	private List<Student> listOfStudents;
	private List<LectureRegistrationApplication> listOfApplications;
	private Scanner scanner;

	public Advisor(String firstName, String lastName, InstructorID id, List<Lecture> listOfLectures,
			Calendar dateOfEntry, List<Student> listOfStudents, List<LectureRegistrationApplication> listOfApplications,
			InstructorType instructorType, Schedule schedule) {
		super(firstName, lastName, id, dateOfEntry, instructorType, schedule);
		scanner = new Scanner(System.in);
		this.listOfStudents = listOfStudents;
		this.listOfApplications = listOfApplications;
		if (this.listOfStudents == null) {
			this.listOfStudents = new ArrayList<Student>();
		}
		if (this.listOfApplications == null) {
			this.listOfApplications = new ArrayList<LectureRegistrationApplication>();
		}
	}
	
	public void showApplications() {
		int choice = -1;
		while (choice != 0) {
			int count = 0;
			for (LectureRegistrationApplication lectureRegistrationApplication : this.getListOfApplications()) {
				count++;
				log.info("" + count + ". " + lectureRegistrationApplication.getStudent().getFullName());
			}
			log.info("0. Exit");

			log.info("Choose A Lecture Registration Application: ");
			choice = scanner.nextInt();
			if (choice != 0) {
				applicationOperations(choice - 1);
			}
		}
	}

	private void applicationOperations(int choice) {
		LectureRegistrationApplication lectureRegistrationApplication = this.getListOfApplications().get(choice);
		String lectureChoice = "";
		while (!lectureChoice.equals("0")) {
			log.info("Name Of Student: " + lectureRegistrationApplication.getStudent().getFullName());
			int count = 0;

			log.info("Session Name                 Approval State");
			for (Entry<LectureSession, ApprovalState> me : lectureRegistrationApplication.getSessionsSentForApproval()
					.entrySet()) {
				count++;
				String sessionName = me.getKey().getLecture().getID() + "." + me.getKey().getSessionID();
				log.info("%d. %-30s%s", count, sessionName, me.getValue());
			}
			log.info("0. Exit");
			log.info("Please Enter The Session Name(0 for exit): ");
			lectureChoice = scanner.nextLine();

			LectureSession lectureSession = null;

			for (Entry<LectureSession, ApprovalState> me : lectureRegistrationApplication.getSessionsSentForApproval()
					.entrySet()) {
				String sessionName = me.getKey().getLecture().getID() + "." + me.getKey().getSessionID();
				if (sessionName.equalsIgnoreCase(lectureChoice)) {
					lectureSession = me.getKey();
				}
			}

			log.info("1. Approve");
			log.info("2. Reject");
			log.info("3. Go Back");

			int approveChoice = scanner.nextInt();

			switch (approveChoice) {
			case 1:
				this.approveApplication(lectureRegistrationApplication, lectureSession);
				break;
			case 2:
				this.rejectApplication(lectureRegistrationApplication, lectureSession);
				break;
			default:
				break;
			}

		}

	}
	
	public List<Student> getListOfStudents() {
		return listOfStudents;
	}

	public List<LectureRegistrationApplication> getListOfApplications() {
		return listOfApplications;
	}

	public void approveApplication(LectureRegistrationApplication lectureRegistirationApplication,
			LectureSession lectureSession) {

		lectureRegistirationApplication.getSessionsSentForApproval().put(lectureSession, ApprovalState.Approved);
		lectureRegistirationApplication.getStudent().getSchedule().getListOfLectureSessions().add(lectureSession);
	}

	public void rejectApplication(LectureRegistrationApplication lectureRegistirationApplication,
			LectureSession lectureSession) {

		lectureRegistirationApplication.getSessionsSentForApproval().put(lectureSession, ApprovalState.Rejected);
	}

	public Advisor(String firstName, String lastName, InstructorID id,
			Calendar dateOfEntry, List<Student> listOfStudents, List<LectureRegistrationApplication> listOfApplications,
			InstructorType instructorType, Schedule schedule) {
		super(firstName, lastName, id, dateOfEntry, instructorType, schedule);
		this.listOfStudents = listOfStudents;
		this.listOfApplications = listOfApplications;
		if (this.listOfStudents == null) {
			this.listOfStudents = new ArrayList<Student>();
		}
		if (this.listOfApplications == null) {
			this.listOfApplications = new ArrayList<LectureRegistrationApplication>();
		}

	}

}
