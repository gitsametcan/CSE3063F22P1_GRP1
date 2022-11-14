package lecture;

import java.util.List;

import Enums.LectureHour;
import Enums.SessionType;
import IDs.UniqueID;
import person.Instructor;

//Serdar Alsan    150120034 
public class LectureSession {


	private UniqueID sessionID;
	private transient Lecture lecture;
	private LectureHour[][] sessionHour;
	private SessionType sessionType;
	private Instructor instructor;
	private List<Instructor> listOfAssistans;

	public String getSession() {
		return sessionID.getID();
	}

	public LectureHour[][] getSessionHours() {
		return sessionHour;
	}

	public SessionType getSessionType() {
		return sessionType;
	}

	public Instructor getInstructor() {
		return instructor;
	}

	public List<Instructor> getListOfAssistans() {
		return listOfAssistans;
	}

}