package data.json;

public class StudentJSON extends PersonJSON {

	private String advisorID;
	private String studentID;
	
	// LectureID / SessionID
	private ScheduleJSON schedule;
	private String dateOfEntry;

	public ScheduleJSON getSchedule() {
		return schedule;
	}

	public void setSchedule(ScheduleJSON schedule) {
		this.schedule = schedule;
	}

	public String getDateOfEntry() {
		return dateOfEntry;
	}

	public void setDateOfEntry(String dateOfEntry) {
		this.dateOfEntry = dateOfEntry;
	}

	public String getAdvisorID() {
		return advisorID;
	}

	public String getStudentID() {
		return studentID;
	}

	public StudentJSON(String firstName, String lastName) {
		super(firstName, lastName);

	}

	public void setAdvisorID(String id) {
		this.advisorID = id;
	}

	public void setStudentID(String id) {
		this.studentID = id;
	}
}
