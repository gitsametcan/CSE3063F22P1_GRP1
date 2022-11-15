package main;

import java.util.ArrayList;
import java.util.List;

import Debt_LRA_Transcript.Debt;
import Debt_LRA_Transcript.Transcript;
import Enums.InstructorType;
import Enums.LectureType;
import IDs.InstructorID;
import IDs.LectureID;
import IDs.StudentID;
import lecture.Lecture;
import person.Advisor;
import person.Student;

public class ObjectCreator {
	
	private List<Advisor> advisors;
	private List<Student> students;
	private List<Lecture> lectures;

	
	public ObjectCreator() {
		advisors = new ArrayList<Advisor>();
		students = new ArrayList<Student>();
		lectures = new ArrayList<Lecture>();
	}
	
	// at the end of code , getter methods for adivors,students and lectures added
	// i used primitive types for some objects of particular classes because of sync problem . it's to be changed and imports have to be done.
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
		
		newStudent("Zeynep", "ARSLAN", "150119205", 17800);
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
	
	void newLecture(String ID, String lectureName, LectureType lectureType, int credits, Lecture prerequisite, int quota) {
		LectureID tempID = new LectureID(null, 0, 0);
		tempID.setID(ID);
		Lecture lecture = new Lecture(tempID, lectureName, lectureType, credits, null, prerequisite, quota);
		lectures.add(lecture);
	}
	
	// Creating lecture objects by hand
	void createLectures() {
		
		newLecture("CSE1241", "Computer Programming I", LectureType.MANDATORY, 6, null, 40);
		newLecture("CSE1242", "Cpmputer Programming II", LectureType.MANDATORY, 6, lectures.get(0), 40);
		newLecture("CSE3063", "Object-Oriented Software Design", LectureType.MANDATORY, 5, lectures.get(1), 60);
		newLecture("CSE3033", "Operating Systems", LectureType.MANDATORY, 7, null, 60);
		newLecture("CSE1200", "Instroduction to Computer Engineering", LectureType.MANDATORY, 4, null, 40);
		newLecture("EE2031", "Electric Circuits", LectureType.MANDATORY, 5, null, 100);
		newLecture("EE2032", "Electronics", LectureType.MANDATORY, 5, lectures.get(5), 100);
		newLecture("CSE2138", "Systems Programming", LectureType.MANDATORY, 7, null, 40);
		newLecture("CSE3215", "Digital Logic Design", LectureType.MANDATORY, 6, null, 30);
		newLecture("ISG121", "Work Safety I", LectureType.MANDATORY, 2, null, 40);
		
	}
	
	private void newAdvisor(String firstName, String lastName, String ID) {
		InstructorID tempID = new InstructorID(0, 0);
		tempID.setID(ID);
		Advisor advisor = new Advisor(firstName, lastName, tempID, null, null, null, null, InstructorType.Instructor);
		
		advisors.add(advisor);
	}
	
// Creating advisor objects by hand
	public void createAdvisors() {
		
		newAdvisor("Tayfun", "KURAK", "150410");
		newAdvisor("Mehmet", "SAYAR", "150325");
		newAdvisor("Ali", "DERMAN", "150533");
		newAdvisor("Ece", "KESER", "150669");
		newAdvisor("Dilara", "BEYRAN", "150219");
	}

	
 	public List<Advisor> getAdvisors() {
		return advisors;
	}
	
	public List<Student> getStudents() {
		return students;
	}
	
	public List<Lecture> getLectures() {
		return lectures;
	}
	
}
