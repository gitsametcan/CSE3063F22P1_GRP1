package test.unit;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import org.junit.Test;

import Debt_LRA_Transcript.LectureRegistrationApplication;
import Debt_LRA_Transcript.Transcript;
import Enums.InstructorType;
import IDs.InstructorID;
import IDs.StudentID;
import lecture.Lecture;
import lecture.LectureSession;
import lecture.Semester;
import person.Advisor;
import person.Student;

public class StudentTest {
	
	@Test
	public void test_student_default_conscructor() {
		InstructorID testInstructorID = new InstructorID(1,2);
		List<Lecture> testListOfLectures = new ArrayList<Lecture>();
		Calendar testDateOfEntry = new GregorianCalendar(2009,10,28);
		List<Student> testListOfStudents = new ArrayList<Student>();
		List<LectureRegistrationApplication> testListOfApplications = new ArrayList<LectureRegistrationApplication>();
		InstructorType testInstructorType = InstructorType.Assistant;
		Advisor testAdvisor = new Advisor("A","B",testInstructorID,testListOfLectures,testDateOfEntry,testListOfStudents,testListOfApplications,testInstructorType);
		
		StudentID testStudentID = new StudentID(1,2,3);
		List<LectureSession> testListOfLectureSessions = new ArrayList<LectureSession>();
		
		List<Semester> testListOfSemester = new ArrayList<Semester>();
		double testGano = 1;
		int testTotalCreditsTaken = 2;
		int testTotalCreditsCompleted = 3;
		double testPoints = 4;
		
		Transcript testTranscript = new Transcript(null, testListOfSemester, testGano, testTotalCreditsTaken, testTotalCreditsCompleted, testPoints);
		Calendar testStudentDateOfEntry = new GregorianCalendar(2010,10,28);
		
		Student testStudent = new Student("John","Green",testStudentID,testListOfLectureSessions,testTranscript,testStudentDateOfEntry);
		
		assertEquals(testAdvisor, testStudent.getAdvisor());
		assertEquals(null, testStudent.getDebt());
		assertEquals(null, testStudent.getRegistirationApplication());
		assertEquals("123", testStudent.getId());
		assertEquals(null, testStudent.getListOfLectureSessions());
		assertEquals(null, testStudent.getTranscript());
		assertEquals(null, testStudent.getDateOfEntry());
	}
}
