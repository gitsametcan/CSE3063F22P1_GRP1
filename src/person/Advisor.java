package person;

import java.util.Calendar;
import java.util.List;

import Debt_LRA_Transcript.LectureRegistrationApplication;
import Enums.InstructorType;
import IDs.InstructorID;
import lecture.Lecture;

//Kaan Camci 150119063
public class Advisor extends Instructor {

	private List<Student> listOfStudents;
	private List<LectureRegistrationApplication> listOfApplications;

	public List<Student> getListOfStudents() {
		return listOfStudents;
	}

	public List<LectureRegistrationApplication> getListOfApplications() {
		return listOfApplications;
	}

	public void approveApplication(LectureRegistrationApplication lectureRegistirationApplication) {
		lectureRegistirationApplication.approveApplication();
	}

	public Advisor(InstructorID id, List<Lecture> listOfLectures, Calendar dateOfEntry, List<Student> listOfStudents,
			List<LectureRegistrationApplication> listOfApplications, InstructorType instructorType) {
		super(id, listOfLectures, dateOfEntry, instructorType);
		this.listOfStudents = listOfStudents;
		this.listOfApplications = listOfApplications;
	}

}
