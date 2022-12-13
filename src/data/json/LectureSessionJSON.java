package data.json;

import java.util.ArrayList;
import java.util.List;

public class LectureSessionJSON {

	private String ID;
	private String lectureID;
	private String instructorID;
	private String sessionType;
	private int[][] sessionHours;
	private List<String> listOfAssistantIDs;
	private List<String> listOfStudentIDs;

	public LectureSessionJSON(String iD, String lectureID, String instructorID, String sessionType, 
			int[][] sessionHours, List<String> listOfStudentIDs) {
		super();
		
		if (sessionHours == null) {
			this.sessionHours = new int[7][10];
		} else {
			this.sessionHours = sessionHours;
		}
		
		if (listOfAssistantIDs == null) {
			listOfAssistantIDs = new ArrayList<String>();
		} else {
			this.listOfAssistantIDs = listOfAssistantIDs;
		}
		
		ID = iD;
		this.lectureID = lectureID;
		this.instructorID = instructorID;
		this.sessionType = sessionType;
	}

	public String getID() {
		return ID;
	}

	public void setID(String ID) {
		this.ID = ID;
	}

	public String getLectureID() {
		return lectureID;
	}

	public void setLectureID(String lectureID) {
		this.lectureID = lectureID;
	}

	public String getInstructorID() {
		return instructorID;
	}

	public void setInstructorID(String instructorID) {
		this.instructorID = instructorID;
	}

	public String getSessionType() {
		return sessionType;
	}

	public void setSessionType(String sessionType) {
		this.sessionType = sessionType;
	}

	public int[][] getListOfSessionHours() {
		return sessionHours;
	}

	public void setListOfSessionHours(int[][] sessionHours) {
		this.sessionHours = sessionHours;
	}

	public List<String> getListOfAssistantIDs() {
		return listOfAssistantIDs;
	}

	public void setListOfAssistantIDs(List<String> listOfAssistantIDs) {
		this.listOfAssistantIDs = listOfAssistantIDs;
	}

	public List<String> getListOfStudentIDs() {
		return listOfStudentIDs;
	}

	public void setListOfStudentIDs(List<String> listOfStudentIDs) {
		this.listOfStudentIDs = listOfStudentIDs;
	}
	
}
