package data.json;

import java.util.List;

public class LectureSessionJSON {

	private String ID;
	private String lectureID;
	private String instructorID;
	private String sessionType;
	private List<String> listOfSessionHours;
	private List<String> listOfAssistantIDs;

	public LectureSessionJSON(String iD, String lectureID, String instructorID, String sessionType) {
		super();
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

	public List<String> getListOfSessionHours() {
		return listOfSessionHours;
	}

	public void setListOfSessionHours(List<String> listOfSessionHours) {
		this.listOfSessionHours = listOfSessionHours;
	}

	public List<String> getListOfAssistantIDs() {
		return listOfAssistantIDs;
	}

	public void setListOfAssistantIDs(List<String> listOfAssistantIDs) {
		this.listOfAssistantIDs = listOfAssistantIDs;
	}

}
