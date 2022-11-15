package lecture;

import java.util.List;

import Enums.LectureHour;
import Enums.SessionType;
import IDs.SessionID;
import person.Instructor;

//Serdar Alsan    150120034 
public class LectureSession {

	private SessionID sessionID;
	private transient Lecture lecture;
	private LectureHour[][] sessionHours;
	private SessionType sessionType;
	private Instructor instructor;
	private List<Instructor> listOfAssistans;

	public LectureSession(SessionID sessionID, Lecture lecture, LectureHour[][] sessionHour, SessionType sessionType,
			Instructor instructor, List<Instructor> listOfAssistans) {
		super();
		this.sessionID = sessionID;
		this.lecture = lecture;
		this.sessionHour = sessionHour;
		this.sessionType = sessionType;
		this.instructor = instructor;
		this.listOfAssistans = listOfAssistans;
	}

	public String getSessionID() {
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

	public Lecture getLecture() {
		return lecture;
	}
	

}