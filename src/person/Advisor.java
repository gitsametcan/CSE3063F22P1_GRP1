package person;

import java.util.Calendar;
import java.util.List;

import Debt_LRA_Transcript.LectureRegistirationApplication;
import IDs.InstructorID;
import lecture.Lecture;

//Kaan Camci 150119063
public class Advisor extends Instructor {

	private List<Student> listOfStudents;
	private List<LectureRegistirationApplication> listOfApplications;

	public List<Student> getListOfStudents() {
		return listOfStudents;
	}

	public List<LectureRegistirationApplication> getListOfApplications() {
		return listOfApplications;
	}

	public void approveApplication(LectureRegistirationApplication lectureRegistirationApplication) {
		lectureRegistirationApplication.approveApplication();
	}

	public Advisor(InstructorID id, List<Lecture> listOfLectures, Calendar dateOfEntry, List<Student> listOfStudents,
			List<LectureRegistirationApplication> listOfApplications) {
		super(id, listOfLectures, dateOfEntry);
		this.listOfStudents = listOfStudents;
		this.listOfApplications = listOfApplications;
	}

}
