package test.unit;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import org.junit.Test;

import Enums.InstructorType;
import IDs.InstructorID;
import lecture.Lecture;
import person.Instructor;

public class InstructorTest {

	@Test
	public void test_student_InstructorID() {
	
		InstructorID testInstructorID = new InstructorID(1,2);
		List<Lecture> testListOfLectures = new ArrayList<Lecture>();
		Calendar testDateOfEntry = new GregorianCalendar(2011,10,28);
		InstructorType testInstructorType = InstructorType.Assistant;
		
		Instructor testInstructor = new Instructor("a","b",testInstructorID,testListOfLectures,testDateOfEntry,testInstructorType);
		
		assertEquals(testInstructorID, testInstructor.getId());

	}
	@Test
	public void test_student_list_of_lectures() {
	
		InstructorID testInstructorID = new InstructorID(1,2);
		List<Lecture> testListOfLectures = new ArrayList<Lecture>();
		Calendar testDateOfEntry = new GregorianCalendar(2011,10,28);
		InstructorType testInstructorType = InstructorType.Assistant;
		
		Instructor testInstructor = new Instructor("a","b",testInstructorID,testListOfLectures,testDateOfEntry,testInstructorType);
		
		assertEquals(testListOfLectures, testInstructor.getListOfLectures());

	}
	@Test
	public void test_student_date_of_entry() {
	
		InstructorID testInstructorID = new InstructorID(1,2);
		List<Lecture> testListOfLectures = new ArrayList<Lecture>();
		Calendar testDateOfEntry = new GregorianCalendar(2011,10,28);
		InstructorType testInstructorType = InstructorType.Assistant;
		
		Instructor testInstructor = new Instructor("a","b",testInstructorID,testListOfLectures,testDateOfEntry,testInstructorType);
		
		assertEquals(null, testInstructor.getDateOfEntry());

	}
	@Test
	public void test_student_instructor_type() {
	
		InstructorID testInstructorID = new InstructorID(1,2);
		List<Lecture> testListOfLectures = new ArrayList<Lecture>();
		Calendar testDateOfEntry = new GregorianCalendar(2011,10,28);
		InstructorType testInstructorType = InstructorType.Assistant;
		
		Instructor testInstructor = new Instructor("a","b",testInstructorID,testListOfLectures,testDateOfEntry,testInstructorType);
	
		assertEquals(InstructorType.Assistant, testInstructor.getInstructorType());
		
	}
}