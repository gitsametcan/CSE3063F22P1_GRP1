package lecture;

import java.util.List;

import Enums.LectureHour;
import Enums.SessionType;
import IDs.SessionID;
import person.Instructor;
import java.util.Random;

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

	public Lecture getLecture() {
		return lecture;
	}
	public LectureHour[][] randomizeSessionHours() {
		for(int i=0;i<7;i++) {
			for(int j=0;j<10;j++) {
				Random rand = new Random(); 
				int randomNumber = rand.nextInt(2); 
				if (randomNumber == 1) {
					sessionHours[i][j] = LectureHour.YES;
				}
		}}
		return sessionHours;
	}
	
	

}