package test.unit;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import IDs.StudentID;

public class StudentIDTest {
	
	@Test
	public void test_SessionID_default_constructor() {
		
		StudentID testStudentID = new StudentID(111, 222, 333);
		
		testStudentID.setID(44, 5, 666);
		assertEquals(044005666, testStudentID.getID());
		
		testStudentID.setID("000111222");
		assertEquals("000111222" , testStudentID.getID());
		
	}

}
