package test.unit;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import IDs.InstructorID;
import IDs.LectureID;
import IDs.SessionID;
import lecture.Lecture;
import lecture.LectureSession;
import person.Instructor;
import Enums.InstructorType;
import Enums.LectureHour;
import Enums.LectureType;
import Enums.SessionType;

public class LectureSessionTest {
	
	@Test
	public void test_LectureSession_default_constructor() {
	
		LectureID testLecID1 = new LectureID("000");
		LectureID testLecID2= new LectureID("001");
		
		SessionID testSemID1 = new SessionID(23);
		SessionID testSemID2 = new SessionID(24);
		
		LectureHour[][] sessionHours = new LectureHour[7][10];
		for (int i = 0; i<7; i++) {
			for(int j = 0; j<10; j++) {
				sessionHours[i][j] = LectureHour.NO;
			}
		}
		sessionHours[2][3] = LectureHour.YES;
		
		LectureHour[][] sessionHours2 = new LectureHour[7][10];
		for (int i = 0; i<7; i++) {
			for(int j = 0; j<10; j++) {
				sessionHours2[i][j] = LectureHour.NO;
			}
		}
		sessionHours2[2][3] = LectureHour.YES;
		sessionHours2[2][4] = LectureHour.YES;
		
		
		InstructorID testInsID1 = new InstructorID(123,123);
		InstructorID testInsID2 = new InstructorID(124,124);
		Instructor testInstructor1 = new Instructor("testInsFName1","testInsLName1",testInsID1,
				null,InstructorType.Instructor,null);
		Instructor testInstructor2 = new Instructor("testInsFName2","testInsLName2",testInsID2,
				null,InstructorType.Assistant,null);
		LectureSession testSession1 = new LectureSession(testSemID1,null,sessionHours,SessionType.Application,
				testInstructor1,null,null);
		LectureSession testSession2 = new LectureSession(testSemID2,null,sessionHours,SessionType.Theorytical,
				testInstructor1,null,null);
		List<LectureSession> testSessions = new ArrayList<>();
		testSessions.add(testSession1);
		testSessions.add(testSession2);
		
		List<Instructor> testListAssistants = new ArrayList<>();
		testListAssistants.add(testInstructor2);
		
		List<Instructor> testListAssistants2 = new ArrayList<>();
		testListAssistants2.add(testInstructor1);
		
		Lecture testLecture1 = new Lecture(testLecID1,"testLecName1", LectureType.FTE, 3,
				testSessions, null, 5,null,null);
		Lecture testLecture = new Lecture(testLecID2,"testLecName2", LectureType.NTE, 4,
				testSessions, testLecture1, 6,null,null);
		
		testSession1.setLecture(testLecture1);
		testSession2.setLecture(testLecture);
		
		testSession1.setListOfAssistans(testListAssistants);
		testSession2.setListOfAssistans(testListAssistants);
		
		testSession1.setSessionID(testSemID2);
		assertEquals(testSemID2, testSession1.getSessionID());
		
		testSession1.setLecture(testLecture);
		assertEquals(testLecture, testSession1.getLecture());
		
		testSession1.setSessionHours(sessionHours2);
		assertEquals(sessionHours2, testSession1.getSessionHours());
		
		testSession1.setSessionType(SessionType.Theorytical);
		assertEquals(SessionType.Theorytical, testSession1.getSessionType());
		
		testSession1.setInstructor(testInstructor2);
		assertEquals(testInstructor2, testSession1.getInstructor());
		
		testSession1.setListOfAssistans(testListAssistants2);
		assertEquals(testListAssistants, testSession1.getListOfAssistans());
	}

}
