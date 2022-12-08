package test.unit;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.junit.Test;

import Debt_LRA_Transcript.LectureRegistrationApplication;
import Enums.InstructorType;
import IDs.InstructorID;
import IDs.StudentID;
import lecture.Lecture;
import person.Advisor;
import person.Student;

public class StudentTest {
	
	@Test
	public void test_student_default_conscructor() {
		InstructorID testInstructorID = new InstructorID(1,2);
		List<Lecture> testListOfLectures = new ArrayList<Lecture>();
		Calendar testDateOfEntry = null;
		List<Student> testListOfStudents = new ArrayList<Student>();
		List<LectureRegistrationApplication> testListOfApplications = new ArrayList<LectureRegistrationApplication>();
		InstructorType testInstructorType = InstructorType.Assistant;
		Advisor testAdvisor = new Advisor("A","B",testInstructorID,testListOfLectures,testDateOfEntry,testListOfStudents,testListOfApplications,testInstructorType);
		
		StudentID testStudentID = new StudentID(1,2,3);
		
		
		Student testStudent = new Student("John","Green",testStudentID,null,null,null);
		
		assertEquals(testAdvisor, testStudent.getAdvisor());
		assertEquals(null, testStudent.getDebt());
		assertEquals(null, testStudent.getRegistirationApplication());
		assertEquals("123", testStudent.getId());
		assertEquals(null, testStudent.getListOfLectureSessions());
		assertEquals(null, testStudent.getTranscript());
		assertEquals(null, testStudent.getDateOfEntry());
	}
}
