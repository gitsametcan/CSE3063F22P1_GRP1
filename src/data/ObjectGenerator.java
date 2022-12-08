package data;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import Debt_LRA_Transcript.Transcript;
import Enums.LectureHour;
import Enums.LectureType;
import Enums.SessionType;
import IDs.InstructorID;
import IDs.LectureID;
import IDs.SessionID;
import IDs.StudentID;
import data.json.AdvisorJSON;
import data.json.LectureJSON;
import data.json.LectureSessionJSON;
import data.json.StudentJSON;
import data.json.TranscriptJSON;
import lecture.Lecture;
import lecture.LectureSession;
import lecture.Schedule;
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
		generateAdvisors();
		
	}
	
	public void pairObjects() {
		
		for (LectureJSON ljs : lectureList) {
			
			// Collecting the Lecture reference
			Optional<Lecture> optLecture = findLecture(ljs.getID());
			Lecture currentLecture = null;
			
			if (optLecture.isPresent()) {
				currentLecture = optLecture.get();
			} else {
				continue;
			}
			
			//Collecting the prerequisite lecture's reference, and assigning it
			Optional<Lecture> optPrerequisiteLecture = findLecture(ljs.getPrerequisiteID());
			Lecture prerequisiteLecture = null;
			
			if (optPrerequisiteLecture.isPresent()) {
				prerequisiteLecture = optPrerequisiteLecture.get();
				currentLecture.addPrerequisiteLecture(prerequisiteLecture);
			}
			
			sessionloop:
			for (LectureSession ls : currentLecture.getSessions()) {
				for (LectureSessionJSON lsjs : ljs.getLectureSessions()) {
					if (lsjs.getID().equalsIgnoreCase(ls.getSessionID())) {
						Optional<Advisor> optAdvisor = findAdvisor(lsjs.getInstructorID());
						Advisor currentAdvisor = null;
						if (optAdvisor.isPresent()) {
							currentAdvisor = optAdvisor.get();
							ls.setInstructor(currentAdvisor);
							currentAdvisor.addLecture(ls);
						}
						break sessionloop;
					}
				}
			}
			
		}
		
		for (AdvisorJSON ajs : advisorList) {
			
			Optional<Advisor> optAdvisor = findAdvisor(ajs.getInstructorID());
			Advisor currentAdvisor = null;
			
			if (optAdvisor.isPresent()) {
				currentAdvisor = optAdvisor.get();
			} else {
				continue;
			}
			
			
		}
		
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
			
			lectureObjectList.add(tempLecture);
		}
	}
	
	private void generateStudents() {
		for (StudentJSON sjs : studentList) {
			String ID = sjs.getStudentID();
			StudentID tempStudentID = new StudentID(ID);
			String firstName = sjs.getFirstName();
			String lastName = sjs.getLastName();
			
			Student tempStudent = new Student(firstName, lastName, tempStudentID, new Schedule(null), null, null);
			
			studentObjectList.add(tempStudent);
		}
	}
	
	private void generateAdvisors() {
		for (AdvisorJSON ajs : advisorList) {
			String ID = ajs.getInstructorID();
			InstructorID tempInstructorID = new InstructorID(ID); 
			String firstName = ajs.getFirstName();
			String lastName = ajs.getLastName();
			
			Advisor tempAdvisor = new Advisor(firstName, lastName, tempInstructorID, null, null, studentObjectList, null, null);
			advisorObjectList.add(tempAdvisor);
		}
	}
	
	
	private Optional<Lecture> findLecture(String id) {
		for (Lecture l : lectureObjectList) {
			if (l.getID().equalsIgnoreCase(id)) {
				return Optional.of(l);
			}
		}
		return Optional.empty();
	}
	
	private Optional<Student> findStudent(String id) {
		for (Student s : studentObjectList) {
			if (s.getID().equalsIgnoreCase(id)) {
				return Optional.of(s);
			}
		}
		return Optional.empty();
	}
	
	private Optional<Advisor> findAdvisor(String id) {
		for (Advisor a : advisorObjectList) {
			if (a.getID().equalsIgnoreCase(id)) {
				return Optional.of(a);
			}
		}
		return Optional.empty();
	}
	
	private List<LectureSession> generateLectureSessions(List<LectureSessionJSON> jsonList) {
		List<LectureSession> result = new ArrayList<LectureSession>();
		for (LectureSessionJSON ls : jsonList) {
			String ID = ls.getID();
			SessionID tempSessionID = new SessionID(Integer.parseInt(ID));
			LectureHour[][] sessionHours = intToLectureHours(ls.getListOfSessionHours());
			SessionType sessionType = stringToSessionType(ls.getSessionType());
			
			LectureSession tempLectureSession = new LectureSession(tempSessionID, null, sessionHours, sessionType, null, null, null);
			result.add(tempLectureSession);
		}
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
	
	private LectureHour[][] intToLectureHours(int[][] array) {
		LectureHour[][] result = new LectureHour[7][10];
		for (int i = 0; i < 7; i++) {
			for (int j = 0; j < 10; j++) {
				int current = array[i][j];
				if (current == 1) {
					result[i][j] = LectureHour.YES;
					continue;
				}
				result[i][j] = LectureHour.NO;
			}
		}
		return result;
	}
}
