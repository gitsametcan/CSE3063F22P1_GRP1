package person;

import java.util.Calendar;
import java.util.List;

import Enums.InstructorType;
import IDs.InstructorID;
import lecture.Lecture;

//Kaan Camci 150119063
public class Instructor extends Person {

	protected InstructorID id;
	private List<Lecture> listOfLectures;
	protected Calendar dateOfEntry;
	protected InstructorType instructorType;
	
	public String getId() {
		return id.getID();
	}

	public List<Lecture> getListOfLectures() {
		return listOfLectures;
	}

	public Calendar getDateOfEntry() {
		return dateOfEntry;
	}
	
	public InstructorType getInstructorType() {
		return instructorType;
	}

	public void addLecture(Lecture lecture) {
		this.listOfLectures.add(lecture);
	}

	public void removeLecture(Lecture lecture) {
		this.listOfLectures.remove(lecture);
	}

	public Instructor(InstructorID id, List<Lecture> listOfLectures, Calendar dateOfEntry, InstructorType InstructorType) {
		super();
		this.id = id;
		this.listOfLectures = listOfLectures;
		this.dateOfEntry = dateOfEntry;
		this.instructorType = InstructorType;
	}
	

}
