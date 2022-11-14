package person;

import java.util.Calendar;
import java.util.List;

import IDs.InstructorID;
import lecture.Lecture;

//Kaan Camci 150119063
public class Instructor extends Person {

	protected InstructorID id;
	private List<Lecture> listOfLectures;
	protected Calendar dateOfEntry;

	public String getId() {
		return id.getID();
	}

	public List<Lecture> getListOfLectures() {
		return listOfLectures;
	}

	public Calendar getDateOfEntry() {
		return dateOfEntry;
	}

	public void addLecture(Lecture lecture) {
		this.listOfLectures.add(lecture);
	}

	public void removeLecture(Lecture lecture) {
		this.listOfLectures.remove(lecture);
	}

	public Instructor(InstructorID id, List<Lecture> listOfLectures, Calendar dateOfEntry) {
		super();
		this.id = id;
		this.listOfLectures = listOfLectures;
		this.dateOfEntry = dateOfEntry;
	}

}
