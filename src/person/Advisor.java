package person;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;


import Debt_LRA_Transcript.LectureRegistrationApplication;
import Enums.ApprovalState;
import Enums.InstructorType;
import IDs.InstructorID;
import lecture.LectureSession;
import lecture.Schedule;

//Kaan Camci 150119063
public class Advisor extends Instructor {

	private List<Student> listOfStudents;
	private List<LectureRegistrationApplication> listOfApplications;


	public Advisor(String firstName, String lastName, InstructorID id, List<Lecture> listOfLectures,
			Calendar dateOfEntry, List<Student> listOfStudents, List<LectureRegistrationApplication> listOfApplications,
			InstructorType instructorType) {
		super(firstName, lastName, id, listOfLectures, dateOfEntry, instructorType);
		this.listOfStudents = listOfStudents;
		this.listOfApplications = listOfApplications;
		if (this.listOfStudents == null) {
			this.listOfStudents = new ArrayList<Student>();
		}
		if (this.listOfApplications == null) {
			this.listOfApplications = new ArrayList<LectureRegistrationApplication>();
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
