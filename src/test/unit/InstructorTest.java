package test.unit;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.junit.Test;

import Enums.InstructorType;
import IDs.InstructorID;
import lecture.Lecture;
import person.Instructor;

public class InstructorTest {

	@Test
	public void test_student_default_conscructor() {
	
		InstructorID testInstructorID = new InstructorID(1,2);
		List<Lecture> testListOfLectures = new ArrayList<Lecture>();
		Calendar testDateOfEntry = null;
		InstructorType testInstructorType = InstructorType.Assistant;
		
		Instructor testInstructor = new Instructor("a","b",testInstructorID,testListOfLectures,testDateOfEntry,testInstructorType);
		
		assertEquals(testInstructorID, testInstructor.getId());
		assertEquals(testListOfLectures, testInstructor.getListOfLectures());
		assertEquals(null, testInstructor.getDateOfEntry());
		assertEquals(InstructorType.Assistant, testInstructor.getInstructorType());
		

	}
}