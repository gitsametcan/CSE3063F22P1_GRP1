package test.unit;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import org.junit.Test;

import Debt_LRA_Transcript.Debt;
import Debt_LRA_Transcript.LectureRegistrationApplication;
import Debt_LRA_Transcript.Transcript;
import Enums.InstructorType;
import Enums.Term;
import Enums.TermYear;
import IDs.InstructorID;
import IDs.StudentID;
import lecture.Lecture;
import lecture.Schedule;
import lecture.Semester;
import person.Advisor;
import person.Student;

public class StudentTest {
	
	@Test
	public void test_student_advisor() {
		InstructorID testInstructorID = new InstructorID(1,2);
		List<Lecture> testListOfLectures = new ArrayList<Lecture>();
		Calendar testDateOfEntry = new GregorianCalendar(2009,10,28);
		List<Student> testListOfStudents = new ArrayList<Student>();
		List<LectureRegistrationApplication> testListOfApplications = new ArrayList<LectureRegistrationApplication>();
		InstructorType testInstructorType = InstructorType.Assistant;
		Schedule testSchedule = new Schedule(null,Term.Spring,TermYear.Freshman);
		
		Student testStudent1 = new Student("John","Green",null,null,null,null);
		Student testStudent2 = new Student("Eva","Green",null,null,null,null);
		testListOfStudents.add(testStudent1);
		testListOfStudents.add(testStudent2);

		Lecture testLecture1 = new Lecture(null,"ab",null,0,null,null,0,null,null);
		Lecture testLecture2 = new Lecture(null,"cd",null,0,null,null,0,null,null);
		testListOfLectures.add(testLecture1);
		testListOfLectures.add(testLecture2);
		
		LectureRegistrationApplication testListOfApplications1 = new LectureRegistrationApplication(null,null,testStudent1);
		LectureRegistrationApplication testListOfApplications2 = new LectureRegistrationApplication(null,null,testStudent2);
		testListOfApplications.add(testListOfApplications1);
		testListOfApplications.add(testListOfApplications2);

		Advisor testAdvisor = new Advisor("A","B",testInstructorID,testListOfLectures,testDateOfEntry,testListOfStudents,testListOfApplications,testInstructorType,testSchedule);
		
		assertEquals(testAdvisor, testStudent1.getAdvisor());
	}
	@Test
	public void test_student_debt() {
		StudentID testStudentID = new StudentID(1,2,3);
		Schedule testSchedule = new Schedule(null,Term.Spring,TermYear.Freshman);
		Transcript testTranscript = new Transcript(null, null);
		Calendar testStudentDateOfEntry = new GregorianCalendar(2010,10,28);
		Student testStudent = new Student("John","Green",testStudentID,testSchedule,testTranscript,testStudentDateOfEntry);
		
		Debt testDebt = new Debt(12, testStudent);
		
		assertEquals(testDebt, testStudent.getDebt());
	}
	@Test
	public void test_student_registiration_application() {
		StudentID testStudentID = new StudentID(1,2,3);
		Schedule testSchedule = new Schedule(null,Term.Spring,TermYear.Freshman);
		Transcript testTranscript = new Transcript(null, null);
		Calendar testStudentDateOfEntry = new GregorianCalendar(2010,10,28);
		Student testStudent = new Student("John","Green",testStudentID,testSchedule,testTranscript,testStudentDateOfEntry);
		
		Advisor testAdvisor = new Advisor(null,null,null,null,null,null,null,null);
		LectureRegistrationApplication testRegistrationApplication = new LectureRegistrationApplication(null,testAdvisor,testStudent);
		
		assertEquals(testRegistrationApplication, testStudent.getRegistirationApplication());
	}
	@Test
	public void test_student_id() {		
		StudentID testStudentID = new StudentID(1,2,3);
		Schedule testSchedule = new Schedule(null,Term.Spring,TermYear.Freshman);
		Transcript testTranscript = new Transcript(null, null);
		Calendar testStudentDateOfEntry = new GregorianCalendar(2010,10,28);
		Student testStudent = new Student("John","Green",testStudentID,testSchedule,testTranscript,testStudentDateOfEntry);
		
		assertEquals(001002003, testStudent.getID());
	}
	@Test
	public void test_student_schedule() {
		StudentID testStudentID = new StudentID(1,2,3);
		Schedule testSchedule = new Schedule(null,Term.Spring,TermYear.Freshman);
		Transcript testTranscript = new Transcript(null, null);
		Calendar testStudentDateOfEntry = new GregorianCalendar(2010,10,28);
		Student testStudent = new Student("John","Green",testStudentID,testSchedule,testTranscript,testStudentDateOfEntry);
		
		testSchedule.setPerson(testStudent);
		
		assertEquals(testSchedule, testStudent.getSchedule());
	}
	@Test
	public void test_student_transcript() {
		StudentID testStudentID = new StudentID(1,2,3);
		Schedule testSchedule = new Schedule(null,Term.Spring,TermYear.Freshman);
		
		List<Semester> testListOfSemester = new ArrayList<Semester>();
		Semester testSemester = new Semester(null);
		testListOfSemester.add(testSemester);
		Transcript testTranscript = new Transcript(null, testListOfSemester);
		
		Calendar testStudentDateOfEntry = new GregorianCalendar(2010,10,28);
		Student testStudent = new Student("John","Green",testStudentID,testSchedule,testTranscript,testStudentDateOfEntry);
		
		testTranscript.setStudent(testStudent);
		
		assertEquals(testTranscript, testStudent.getTranscript());
	}
	@Test
	public void test_student_date_of_entry() {	
		StudentID testStudentID = new StudentID(1,2,3);
		Schedule testSchedule = new Schedule(null,Term.Spring,TermYear.Freshman);
		Transcript testTranscript = new Transcript(null, null);
		Calendar testStudentDateOfEntry = new GregorianCalendar(2010,10,28);
		Student testStudent = new Student("John","Green",testStudentID,testSchedule,testTranscript,testStudentDateOfEntry);
		
		assertEquals(testStudentDateOfEntry, testStudent.getDateOfEntry());
	}
}
