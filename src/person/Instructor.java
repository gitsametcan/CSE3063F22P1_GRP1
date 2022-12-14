package person;

import java.util.Calendar;
import java.util.List;

import Enums.InstructorType;
import IDs.InstructorID;
import lecture.LectureSession;
import lecture.Schedule;

//Kaan Camci 150119063
public class Instructor extends Person {

	protected InstructorID id;
	private Schedule schedule;
	protected Calendar dateOfEntry;
	protected InstructorType instructorType;

	public String getID() {

		return id.getID();
	}

	// Creating get methods for variables

	public Calendar getDateOfEntry() {
		return dateOfEntry;
	}

	public InstructorType getInstructorType() {
		return instructorType;
	}

	public Instructor(String firstName, String lastName, InstructorID id,
			Calendar dateOfEntry, InstructorType InstructorType, Schedule schedule) {
		super(firstName, lastName);
		this.id = id;
		this.setSchedule(schedule);
		this.dateOfEntry = dateOfEntry;
		this.instructorType = InstructorType;
	}

	public Schedule getSchedule() {
		return schedule;
	}

	public void setSchedule(Schedule schedule) {
		this.schedule = schedule;
	}

}
