package data;

import java.util.ArrayList;
import java.util.List;

import Debt_LRA_Transcript.Transcript;
import Enums.LectureType;
import Enums.SessionType;
import IDs.LectureID;
import data.json.AdvisorJSON;
import data.json.LectureJSON;
import data.json.LectureSessionJSON;
import data.json.StudentJSON;
import data.json.TranscriptJSON;
import lecture.Lecture;
import lecture.LectureSession;
import person.Advisor;
import person.Student;

public class ObjectGenerator {
	
	private List<LectureJSON> lectureList;
	private List<StudentJSON> studentList;
	private List<TranscriptJSON> transcriptList;
	private List<AdvisorJSON> advisorList;
	
	private List<Lecture> lectureObjectList;
	private List<Student> studentObjectList;
	private List<Transcript> transcriptObjectList;
	private List<Advisor> advisorObjectList;
	
	public ObjectGenerator(List<LectureJSON> lectureList, List<StudentJSON> studentList, List<TranscriptJSON> transcriptList, 
			List<AdvisorJSON> advisorList) {
		this.lectureList = lectureList;
		this.studentList = studentList;
		this.transcriptList = transcriptList;
		this.advisorList = advisorList;
		
		lectureObjectList = new ArrayList<Lecture>();
		studentObjectList = new ArrayList<Student>();
		transcriptObjectList = new ArrayList<Transcript>();
		advisorObjectList = new ArrayList<Advisor>();
	}
	
	public void generateObjects() {
		
		generateLectures();
		generateStudents();
		generateTranscripts();
		generateAdvisors();
		
	}
	
	public void pairObjects() {
		
		
		
	}
	
	private void generateLectures() {
		for (LectureJSON ljs : lectureList) {
			String ID = ljs.getID();
			LectureID lectureID = new LectureID(ID);
			String name = ljs.getName();
			String tempLectureType = ljs.getLectureType();
			LectureType lectureType = stringToLectureType(tempLectureType);
			int credits = ljs.getCredit();
			int quota = ljs.getQuota();
			
			List<LectureSession> lectureSessions = generateLectureSessions(ljs.getLectureSessions());
			
			Lecture tempLecture = new Lecture(lectureID, name, lectureType, credits, lectureSessions, null, quota);
		}
	}
	
	private void generateStudents() {
		
	}

	private void generateTranscripts() {
	
	}
	
	private void generateAdvisors() {
		
	}
	
	private List<LectureSession> generateLectureSessions(List<LectureSessionJSON> jsonList) {
		List<LectureSession> result = new ArrayList<LectureSession>();
		
		return result;
	}
	
	private LectureType stringToLectureType(String key) {
		if (key.equalsIgnoreCase("NTE")) {
			return LectureType.NTE;
		}
		
		if (key.equalsIgnoreCase("FTE")) {
			return LectureType.FTE;
		}
		
		if (key.equalsIgnoreCase("MANDATORY")) {
			return LectureType.MANDATORY;
		}
		
		if (key.equalsIgnoreCase("TE")) {
			return LectureType.TE;
		}
		
		if (key.equalsIgnoreCase("UE")) {
			return LectureType.UE;
		}
		return LectureType.MANDATORY;
	}
	
	private SessionType stringToSessionType(String key) {
		if (key.equalsIgnoreCase("Application")) {
			return SessionType.Application;
		}
		
		if (key.equalsIgnoreCase("Theorytical")) {
			return SessionType.Theorytical;
		}
		return SessionType.Theorytical;
	}
	
}
