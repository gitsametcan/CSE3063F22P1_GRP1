package test.unit;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.junit.Test;

import IDs.*;
import Enums.*;
import person.*;
import lecture.Lecture;
import lecture.LectureSession;
import lecture.Semester;

public class SemesterTest {
	
	@Test
	public void test_Semester_default_constructor() {
		LectureID testLecID1 = new LectureID("000");
		LectureID testLecID2= new LectureID("001");
		LectureID testLecID3= new LectureID("002");
		
		SessionID testSemID1 = new SessionID(23);
		SessionID testSemID2 = new SessionID(24);
		SessionID testSemID3 = new SessionID(25);
		
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
		LectureSession testSession3 = new LectureSession(testSemID3,null,sessionHours,SessionType.Theorytical,
				testInstructor1,null);
		
		List<LectureSession> testSessions = new ArrayList<>();
		testSessions.add(testSession1);
		testSessions.add(testSession2);
		
		List<LectureSession> testSessions2 = new ArrayList<>();
		testSessions.add(testSession1);
		testSessions.add(testSession3);
		
		List<Instructor> testListAssistants = new ArrayList<>();
		testListAssistants.add(testInstructor2);
		
		Lecture testLecture1 = new Lecture(testLecID1,"testLecName1", LectureType.FTE, 3,
				testSessions, null, 5);
		Lecture testLecture2 = new Lecture(testLecID3,"testLecName3", LectureType.MANDATORY, 2,
				testSessions, null, 5);
		Lecture testLecture = new Lecture(testLecID2,"testLecName2", LectureType.NTE, 4,
				testSessions, testLecture1, 6);
		
		HashMap<Lecture, LetterGrade> testListOfLecturesTaken = new HashMap<Lecture, LetterGrade>();
		testListOfLecturesTaken.put(testLecture, LetterGrade.AA);
		testListOfLecturesTaken.put(testLecture1, LetterGrade.BA);
		
		HashMap<Lecture, LetterGrade> testListOfLecturesTaken2 = new HashMap<Lecture, LetterGrade>();
		testListOfLecturesTaken2.put(testLecture2, LetterGrade.AA);
		testListOfLecturesTaken2.put(testLecture1, LetterGrade.BA);
		
		Semester testSemester = new Semester(testListOfLecturesTaken, 23, 17, 3.11, 3.4);
		
		testSemester.setListOfLecturesTaken(testListOfLecturesTaken2);
		assertEquals(testListOfLecturesTaken2, testSemester.getListOfLecturesTaken());
		
		testSemester.setCreditsTaken(20);
		assertEquals(20, testSemester.getCreditsTaken());
		
		testSemester.setCreditsCompleted(13);
		assertEquals(13, testSemester.getCreditsCompleted());
		
		testSemester.setPoints(2.99);
		assertEquals(2.99, testSemester.getPoints());
		
		testSemester.setYano(3.66);
		assertEquals(3.66, testSemester.getYano());
		
		
		
		
		
		
		
		
		
	}

}
