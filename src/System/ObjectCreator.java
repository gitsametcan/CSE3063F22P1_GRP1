package System;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import Debt_LRA_Transcript.Debt;
import Debt_LRA_Transcript.Transcript;
import Enums.InstructorType;
import Enums.LectureHour;
import Enums.LectureType;
import IDs.InstructorID;
import IDs.LectureID;
import IDs.SessionID;
import IDs.StudentID;
import lecture.Lecture;
import lecture.LectureSession;
import lecture.Semester;
import person.Advisor;
import person.Student;

public class ObjectCreator {
	
	private List<Advisor> advisors;
	private List<Student> students;
	private List<Lecture> lectures;
	private List<Transcript> transcripts;

	
	public ObjectCreator() {
		advisors = new ArrayList<Advisor>();
		students = new ArrayList<Student>();
		lectures = new ArrayList<Lecture>();
		transcripts = new ArrayList<Transcript>();
	}
	
	
	// Creating student objects by hand
	private void newStudent(String firstName, String lastName, String ID, int debt) {
		StudentID tempID = new StudentID(0, 0, 0);
		Student student = new Student(firstName, lastName, null, null, null, null);
		tempID.setID(ID);
		student.setId(tempID);
		Transcript st1Transcript = new Transcript(student, null, 0, 0, 0, 0);
		Debt st1Debt = new Debt(debt, student);
		students.add(student);
	}
	
	public void createStudents() {
		
		newStudent("Zeynep", "ARSLAN", "150119063", 17800);
		newStudent("Aylin", "CANBERK", "150117018", 0);
		newStudent("Tuana", "SOLAK", "150121112", 0);
		newStudent("Olivia", "ADAM", "150120097", 0);
		newStudent("Yusuf", "MUAZ", "150118086", 0);
		newStudent("Yunus", "ATAR", "150111916", 0);
		newStudent("Omar", "ADAB", "150118316", 12500);
		newStudent("Ege", "SOLMAZ", "150122002", 0);
		newStudent("Serkan", "ATALAR", "150120211", 0);
		newStudent("Defne", "KORKUSUZ", "150119692", 12500);
		
	}
	// Creating lecture objects by hand
	private void newLecture(String ID, String lectureName, LectureType lectureType, int credits, Lecture prerequisite, int quota) {
		LectureID tempID = new LectureID(null);
		tempID.setID(ID);
		Lecture lecture = new Lecture(tempID, lectureName, lectureType, credits, null, prerequisite, quota);
		
		SessionID tempSessionID = new SessionID(1);
		LectureSession lectureSession = new LectureSession(tempSessionID, lecture, randomizeSessionHours(), null, null, null);
		lecture.addLectureSession(lectureSession);
		
		lectures.add(lecture);
	}
	
	
	void createLectures() {
		
		newLecture("CSE1241", "Computer Programming I", LectureType.MANDATORY, 6, null, 40);
		newLecture("CSE1242", "Cpmputer Programming II", LectureType.MANDATORY, 6, lectures.get(0), 40);
		newLecture("CSE3063", "Object-Oriented Software Design", LectureType.MANDATORY, 5, lectures.get(1), 60);
		newLecture("CSE3033", "Operating Systems", LectureType.MANDATORY, 7, null, 60);
		newLecture("CSE1200", "Introduction to Computer Engineering", LectureType.MANDATORY, 4, null, 40);
		newLecture("EE2031", "Electric Circuits", LectureType.MANDATORY, 5, null, 100);
		newLecture("EE2032", "Electronics", LectureType.MANDATORY, 5, lectures.get(5), 100);
		newLecture("CSE2138", "Systems Programming", LectureType.MANDATORY, 7, null, 40);
		newLecture("CSE3215", "Digital Logic Design", LectureType.MANDATORY, 6, null, 30);
		newLecture("ISG121", "Work Safety I", LectureType.MANDATORY, 2, null, 40);
		
	}
	// Creating advisor objects by hand
	private void newAdvisor(String firstName, String lastName, String ID, Student student, Student student1) {
		InstructorID tempID = new InstructorID(0, 0);
		tempID.setID(ID);
		Advisor advisor = new Advisor(firstName, lastName, tempID, null, null, null, null, InstructorType.Instructor);
		advisors.add(advisor);
		
		student.setAdvisor(advisor);
		student1.setAdvisor(advisor);
		advisor.getListOfStudents().add(student);
		advisor.getListOfStudents().add(student1);
	}
	

	public void createAdvisors() {
		
		newAdvisor("Tayfun", "KURAK", "150410", this.students.get(0),this.students.get(1));
		newAdvisor("Mehmet", "SAYAR", "150325", this.students.get(2),this.students.get(3));
		newAdvisor("Ali", "DERMAN", "150533", this.students.get(4),this.students.get(5));
		newAdvisor("Ece", "KESER", "150669", this.students.get(6),this.students.get(7));
		newAdvisor("Dilara", "BEYRAN", "150219", this.students.get(8),this.students.get(9));
	}

	// Creating transcript objects by hand
	private void newTranscript(Student student, List<Semester> listOfSemester, double gano, int totalCreditsTaken,
			int totalCreditsCompleted, double points) {
		
		if(listOfSemester == null) {
			listOfSemester = new ArrayList<Semester>();
		}
		
		Transcript transcript = new Transcript(student, listOfSemester, 0, 0, 0, 0);
		transcripts.add(transcript);
		
	}
	
	public void createTranscripts() {
		
		newTranscript(this.students.get(0), null, 0,0,0,0);
		newTranscript(this.students.get(1), null, 0,0,0,0);
		newTranscript(this.students.get(2), null, 0,0,0,0);
		newTranscript(this.students.get(3), null, 0,0,0,0);
		newTranscript(this.students.get(4), null, 0,0,0,0);
		newTranscript(this.students.get(5), null, 0,0,0,0);
		newTranscript(this.students.get(6), null, 0,0,0,0);
		newTranscript(this.students.get(7), null, 0,0,0,0);
		newTranscript(this.students.get(8), null, 0,0,0,0);
		newTranscript(this.students.get(9), null, 0,0,0,0);
	}

	private LectureHour[][] randomizeSessionHours() {
		
		LectureHour[][] h = new LectureHour[7][10];
		
		for(int i = 0; i < 7; i++) {
			for(int j = 0; j < 10; j++) {
				Random rand = new Random(); 
				int randomNumber = rand.nextInt(20); 
				if (randomNumber == 1) {
					h[i][j] = LectureHour.YES;
				}else {
					h[i][j] = LectureHour.NO;
				}
			}
		}
		return h;
	}

	//Creating get methods for advisors, students, lectures and transcripts
 	public List<Advisor> getAdvisors() {
		return advisors;
	}
	
	public List<Student> getStudents() {
		return students;
	}
	
	public List<Lecture> getLectures() {
		return lectures;
	}
	public List<Transcript> getTranscripts() {
		return transcripts;
	}
	
}
