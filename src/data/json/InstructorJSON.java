package data.json;

public class InstructorJSON extends PersonJSON {

	private ScheduleJSON schedule;
	private String instructorType;
	private String instructorID;
	private String dateOfEntry;

	public InstructorJSON(String firstName, String lastName) {
		super(firstName, lastName);
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String getDateOfEntry() {
		return dateOfEntry;
	}

	public void setDateOfEntry(String dateOfEntry) {
		this.dateOfEntry = dateOfEntry;
	}

	public String getInstructorType() {
		return instructorType;
	}

	public void setInstructorType(String instructorType) {
		this.instructorType = instructorType;
	}

	public String getInstructorID() {
		return instructorID;
	}

	public void setInstructorID(String instructorID) {
		this.instructorID = instructorID;
	}

	public ScheduleJSON getSchedule() {
		return schedule;
	}

	public void setSchedule(ScheduleJSON schedule) {
		this.schedule = schedule;
	}

}
