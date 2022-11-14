package data.json;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentJSON extends PersonJSON {
	
	private String advisorID;
	private String studentID;
	// CourseID/SessionID
	private Map<String, String> sessions;
	private List<Map<String,String>> transcript;
	
	public StudentJSON(String firstName, String lastName) {
		super(firstName, lastName);
		//Left side of sessions is the lecture id,
		//right side of the sessions is the session id
		sessions = new HashMap<String, String>();
		//Every ArrayList element is a semester, 
		//Left side of the map is lecture id, 
		//right side of the map is letter grade
		transcript = new ArrayList<Map<String,String>>();
		
	}
	
	public void setAdvisorID(String id) {
		this.advisorID = id;
	}
	
	public void setStudentID(String id) {
		this.studentID = id;
	}
	
	public void addSemester() {
		transcript.add(new HashMap<String,String>());
	}
	
	
}
