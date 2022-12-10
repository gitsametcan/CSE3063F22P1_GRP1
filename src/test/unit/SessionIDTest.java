package test.unit;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import IDs.SessionID;

public class SessionIDTest {
	
	@Test
	public void test_SessionID_default_constructor() {
		
		SessionID testSessionID = new SessionID(0);
		
		testSessionID.setID("test");
		assertEquals("test", testSessionID.getID());
		
		testSessionID.setID(1);
	//	assertEquals(1, testSessionID.digitFixer());
		
		
	}
		
	

}
