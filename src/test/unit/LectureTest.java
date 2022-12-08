package test.unit;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import IDs.*;
import Enums.*;
import person.*;
import lecture.Lecture;
import lecture.LectureSession;

public class LectureTest {
	
	@Test
	public void test_Lecture_default_constructor() {
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
		InstructorID testInsID = new InstructorID(123,123);
		Instructor testInstructor = new Instructor("testInsFName","testInsLName",testInsID,
				null,null,InstructorType.Instructor);
		LectureSession testSession1 = new LectureSession(testSemID1,null,sessionHours,SessionType.Application,
				testInstructor,null);
		LectureSession testSession2 = new LectureSession(testSemID2,null,sessionHours,SessionType.Theorytical,
				testInstructor,null);
		List<LectureSession> testSessions = new ArrayList<>();
		testSessions.add(testSession1);
		testSessions.add(testSession2);
		
		Lecture testLecture1 = new Lecture(testLecID1,"testLecName1", LectureType.FTE, 3,
				testSessions, null, 5);
		Lecture testLecture = new Lecture(testLecID2,"testLecName2", LectureType.NTE, 4,
				testSessions, testLecture1, 6);
		
		testLecture.setCredit(0);
		assertEquals(0, testLecture.getCredit());
		
		testLecture.setLectureType(LectureType.NTE);
		assertEquals(LectureType.NTE, testLecture.getLectureType());
		
		testLecture.setName("testString");
		assertEquals("testString", testLecture.getName());
		
		testLecture.setQuota(23);
		assertEquals(23, testLecture.getName());
		
		testLecture.addLectureSession(null);
	}

}
