package test.unit;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import org.junit.Test;

import Debt_LRA_Transcript.LectureRegistrationApplication;
import Enums.InstructorType;
import IDs.InstructorID;
import lecture.Lecture;
import person.Advisor;
import person.Student;

public class AdvisorTest {
	@Test
	public void test_advisor_list_of_student() {
		
		InstructorID testInstructorID = new InstructorID(1,2);
		List<Lecture> testListOfLectures = new ArrayList<Lecture>();
		Calendar testDateOfEntry = new GregorianCalendar(2013,10,28);
		List<Student> testListOfStudents = new ArrayList<Student>();
		List<LectureRegistrationApplication> testListOfApplications = new ArrayList<LectureRegistrationApplication>();
		InstructorType testInstructorType = InstructorType.Assistant;
		Advisor testAdvisor = new Advisor("A","B",testInstructorID,testListOfLectures,testDateOfEntry,testListOfStudents,testListOfApplications,testInstructorType);
	
		assertEquals(testListOfStudents, testAdvisor.getListOfStudents());
	}	
		
	@Test
	public void test_advisor_list_of_application() {
		
		InstructorID testInstructorID = new InstructorID(1,2);
		List<Lecture> testListOfLectures = new ArrayList<Lecture>();
		Calendar testDateOfEntry = new GregorianCalendar(2013,10,28);
		List<Student> testListOfStudents = new ArrayList<Student>();
		List<LectureRegistrationApplication> testListOfApplications = new ArrayList<LectureRegistrationApplication>();
		InstructorType testInstructorType = InstructorType.Assistant;
		Advisor testAdvisor = new Advisor("A","B",testInstructorID,testListOfLectures,testDateOfEntry,testListOfStudents,testListOfApplications,testInstructorType);
	
		assertEquals(testListOfApplications, testAdvisor.getListOfApplications());
	}
		
	
	
	
}
