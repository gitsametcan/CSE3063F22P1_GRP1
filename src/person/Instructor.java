package person;

import java.util.Calendar;
import java.util.List;

import Enums.InstructorType;
import IDs.InstructorID;
<<<<<<< Updated upstream
import lecture.Lecture;
=======
import lecture.LectureSession;
>>>>>>> Stashed changes

//Kaan Camci 150119063
public class Instructor extends Person {

	protected InstructorID id;
<<<<<<< Updated upstream
	private List<Lecture> listOfLectures;
=======
	private List<LectureSession> listOfLectureSessions;
>>>>>>> Stashed changes
	protected Calendar dateOfEntry;
	protected InstructorType instructorType;
	
	public String getId() {
		return id.getID();
	}
	//Creating get methods for variables
<<<<<<< Updated upstream
	public List<Lecture> getListOfLectures() {
		return listOfLectures;
=======
	public List<LectureSession> getListOfLectureSessions() {
		return listOfLectureSessions;
>>>>>>> Stashed changes
	}

	public Calendar getDateOfEntry() {
		return dateOfEntry;
	}
	
	public InstructorType getInstructorType() {
		return instructorType;
	}

<<<<<<< Updated upstream
	public void addLecture(Lecture lecture) {
		this.listOfLectures.add(lecture);
	}

	public void removeLecture(Lecture lecture) {
		this.listOfLectures.remove(lecture);
	}

	public Instructor(String firstName, String lastName, InstructorID id, List<Lecture> listOfLectures, Calendar dateOfEntry, InstructorType InstructorType) {
		super(firstName, lastName);
		this.id = id;
		this.listOfLectures = listOfLectures;
=======
	public void addLecture(LectureSession lecture) {
		this.listOfLectureSessions.add(lecture);
	}

	public void removeLecture(LectureSession lecture) {
		this.listOfLectureSessions.remove(lecture);
	}

	public Instructor(String firstName, String lastName, InstructorID id, List<LectureSession> listOfLectureSessions, Calendar dateOfEntry, InstructorType InstructorType) {
		super(firstName, lastName);
		this.id = id;
		this.listOfLectureSessions = listOfLectureSessions;
>>>>>>> Stashed changes
		this.dateOfEntry = dateOfEntry;
		this.instructorType = InstructorType;
	}
	

}
