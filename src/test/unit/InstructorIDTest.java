package test.unit;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import IDs.InstructorID;

public class InstructorIDTest {
		
	

	@Test
	public void test_InstructorID_default_constructor() {
		
		InstructorID testInstructorID = new InstructorID(1, 2);
		
		testInstructorID.SetId(1, 2);
		
		
	}
}
