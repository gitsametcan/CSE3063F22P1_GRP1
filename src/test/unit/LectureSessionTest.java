package test.unit;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import IDs.SessionID;
import lecture.LectureSession;
import Enums.SessionType;
import test.unit.LectureTest;

public class LectureSessionTest {
	
	@Test
	public void test_LectureSession_default_constructor() {
	
		SessionID testID = new SessionID(000);
		
		LectureSession testLectureSession = new LectureSession(testID, testLecture, null,
				SessionType.Application,null,null);
		
		assertEquals(000, testLectureSession.getSessionID());
		
		assertEquals(SessionType.Application, testLectureSession.getSessionType());
		
	}

}
