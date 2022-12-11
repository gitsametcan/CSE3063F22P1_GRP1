package test.unit;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import IDs.InstructorID;
import IDs.LectureID;

public class LectureIDTest {
	
	@Test
	public void test_InstructorID_default_constructor() {
		
		LectureID testLectureID = new LectureID("test");
		
		testLectureID.setID("test");
		assertEquals("test", testLectureID.getID());
		
	}

}
