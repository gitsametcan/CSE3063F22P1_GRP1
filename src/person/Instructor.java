package person;

import java.util.Calendar;
import java.util.List;

import Enums.InstructorType;
import IDs.InstructorID;
import lecture.Lecture;
import lecture.LectureSession;

//Kaan Camci 150119063
public class Instructor extends Person {

	protected InstructorID id;
	private List<LectureSession> listOfLectures;
	protected Calendar dateOfEntry;
	protected InstructorType instructorType;
	
	public Instructor(String firstName, String lastName, InstructorID id, List<LectureSession> listOfLectures,
			Calendar dateOfEntry, InstructorType InstructorType) {
		super(firstName, lastName);
		this.id = id;
		this.listOfLectures = listOfLectures;
		this.dateOfEntry = dateOfEntry;
		this.instructorType = InstructorType;
	}
	
	public String getID() {
		return id.getID();
	}

	// Creating get methods for variables
	public List<LectureSession> getListOfLectures() {
		return listOfLectures;
	}

	public Calendar getDateOfEntry() {
		return dateOfEntry;
	}

	public InstructorType getInstructorType() {
		return instructorType;
	}

	public void addLecture(LectureSession lecture) {
		this.listOfLectures.add(lecture);
	}

	public void removeLecture(LectureSession lecture) {
		this.listOfLectures.remove(lecture);
	}

}
