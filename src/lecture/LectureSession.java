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

	public LectureSession(SessionID sessionID, Lecture lecture, LectureHour[][] sessionHours, SessionType sessionType,
			Instructor instructor, List<Instructor> listOfAssistans) {
		super();
		this.sessionID = sessionID;
		this.lecture = lecture;
		this.sessionHours = sessionHours;
		this.sessionType = sessionType;
		this.instructor = instructor;
		this.listOfAssistans = listOfAssistans;
	}
	//Creating get and set methods for variables
	public String getSessionID() {
		return sessionID.getID();
	}

	public LectureHour[][] getSessionHours() {
		return sessionHours;
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

	public void setSessionID(SessionID sessionID) {
		this.sessionID = sessionID;
	}
	public void setSessionHours(LectureHour[][] sessionHours) {
		this.sessionHours = sessionHours;
	}
	public void setSessionType(SessionType sessionType) {
		this.sessionType = sessionType;
	}
	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}
	public void setListOfAssistans(List<Instructor> listOfAssistans) {
		this.listOfAssistans = listOfAssistans;
	}
	public Lecture getLecture() {
		return lecture;
	}
	
	public void setLecture(Lecture lecture) {
		this.lecture=lecture;
	}
	

}