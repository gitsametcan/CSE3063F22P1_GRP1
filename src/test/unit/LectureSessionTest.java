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
		InstructorID testInsID1 = new InstructorID(123,123);
		InstructorID testInsID2 = new InstructorID(124,124);
		Instructor testInstructor1 = new Instructor("testInsFName1","testInsLName1",testInsID1,
				null,null,InstructorType.Instructor);
		Instructor testInstructor2 = new Instructor("testInsFName2","testInsLName2",testInsID2,
				null,null,InstructorType.Assistant);
		LectureSession testSession1 = new LectureSession(testSemID1,null,sessionHours,SessionType.Application,
				testInstructor1,null);
		LectureSession testSession2 = new LectureSession(testSemID2,null,sessionHours,SessionType.Theorytical,
				testInstructor1,null);
		List<LectureSession> testSessions = new ArrayList<>();
		testSessions.add(testSession1);
		testSessions.add(testSession2);
		
		List<Instructor> testListAssistants = new ArrayList<>();
		testListAssistants.add(testInstructor2);
		
		Lecture testLecture1 = new Lecture(testLecID1,"testLecName1", LectureType.FTE, 3,
				testSessions, null, 5);
		Lecture testLecture = new Lecture(testLecID2,"testLecName2", LectureType.NTE, 4,
				testSessions, testLecture1, 6);
		
		testSession1.setLecture(testLecture1);
		testSession2.setLecture(testLecture);
		
		testSession1.setlistOfAssistants(testListAssistants);
		testSession2.setlistOfAssistants(testListAssistants);
		
		assertEquals(000, testSession1.getSessionID());
		
		assertEquals(SessionType.Application, testSession1.getSessionType());
		
	}

}
