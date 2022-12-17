package test.unit;

import static org.junit.Assert.assertEquals;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.Test;

import Enums.InstructorType;
import IDs.InstructorID;
import lecture.Schedule;
import person.Instructor;

public class InstructorTest {

	@Test
	public void test_instructor_InstructorID() {
	
		InstructorID testInstructorID = new InstructorID(1,2);
		Calendar testDateOfEntry = new GregorianCalendar(2011,10,28);
		InstructorType testInstructorType = InstructorType.Assistant;
		Schedule testSchedule = new Schedule(null, null, null);
		
		Instructor testInstructor = new Instructor("a","b",testInstructorID,testDateOfEntry,testInstructorType,testSchedule);
		
		assertEquals(testInstructorID, testInstructor.getID());

	}
	@Test
	public void test_instructor_scheudle() {
	
		InstructorID testInstructorID = new InstructorID(1,2);
		Schedule testSchedule = new Schedule(null, null, null);
		Calendar testDateOfEntry = new GregorianCalendar(2011,10,28);
		InstructorType testInstructorType = InstructorType.Assistant;
		
		Instructor testInstructor = new Instructor("a","b",testInstructorID,testDateOfEntry,testInstructorType,testSchedule);
		
		testSchedule.setPerson(testInstructor);
		
		assertEquals(testSchedule, testInstructor.getSchedule());

	}
	@Test
	public void test_instructor_date_of_entry() {
	
		InstructorID testInstructorID = new InstructorID(1,2);
		Schedule testSchedule = new Schedule(null, null, null);
		Calendar testDateOfEntry = new GregorianCalendar(2011,10,28);
		InstructorType testInstructorType = InstructorType.Assistant;
		
		Instructor testInstructor = new Instructor("a","b",testInstructorID,testDateOfEntry,testInstructorType,testSchedule);
		
		assertEquals(null, testInstructor.getDateOfEntry());

	}
	@Test
	public void test_instructor_instructor_type() {
	
		InstructorID testInstructorID = new InstructorID(1,2);
		Schedule testSchedule = new Schedule(null, null, null);
		Calendar testDateOfEntry = new GregorianCalendar(2011,10,28);
		InstructorType testInstructorType = InstructorType.Assistant;
		
		Instructor testInstructor = new Instructor("a","b",testInstructorID,testDateOfEntry,testInstructorType,testSchedule);
	
		assertEquals(InstructorType.Assistant, testInstructor.getInstructorType());
		
	}
}