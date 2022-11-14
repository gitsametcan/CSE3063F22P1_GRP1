package data.json;

import java.util.HashMap;
import java.util.Map;

public class StudentJSON extends PersonJSON {
	
	private String advisorID;
	private String studentID;
	// CourseID/SessionID
	private Map<String, String> sessions;
	
	public StudentJSON(String firstName, String lastName) {
		super(firstName, lastName);
		sessions = new HashMap<String, String>();
	}
	
	public void setAdvisorID(String id) {
		this.advisorID = id;
	}
	
	public void setStudentID(String id) {
		this.studentID = id;
	}
	
	
}
