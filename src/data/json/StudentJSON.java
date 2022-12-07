package data.json;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentJSON extends PersonJSON {
	
	private String advisorID;
	private String studentID;
	// LectureID / SessionID
	private ScheduleJSON schedule;
	private String dateOfEntry;
	
	public StudentJSON(String firstName, String lastName) {
		super(firstName, lastName);
		//Left side of sessions is the lecture id,
		//right side of the sessions is the session id
		
	}
	
	public void setAdvisorID(String id) {
		this.advisorID = id;
	}
	
	public void setStudentID(String id) {
		this.studentID = id;
	}
}
