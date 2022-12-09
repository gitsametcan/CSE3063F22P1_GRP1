package test.unit;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import Debt_LRA_Transcript.Debt;
import Debt_LRA_Transcript.Transcript;
import IDs.StudentID;
import lecture.Semester;
import person.Student;

public class TranscriptTest {
	
	@Test
	public void test_transcript_default_constructor() {
		StudentID testId = new StudentID(000,000,000);
		Semester testSemester = new Semester(null, 1, 2, 2.1 , 1.2);
		Semester testSemester2 = new Semester(null, 2, 3, 3.1, 1.3);
		List<Semester> testListOfSemester = new ArrayList<>();
		testListOfSemester.add(testSemester);
		testListOfSemester.add(testSemester2);
		
		Semester testSemester3 = new Semester(null, 2, 3, 1.3 , 2.3);
		List<Semester> testListOfSemester2 = new ArrayList<>();
		testListOfSemester2.add(testSemester3);
		testListOfSemester2.add(testSemester2);
		
		
		Transcript testTranscript = new Transcript(null, testListOfSemester, 
				3.4, 23, 13, 2.3);
		Student testStudent = new Student("testFName", "testLName",
				testId, null, testTranscript, null);
		
		Student testStudent2 = new Student("testFName2", "testLName2",
				testId, null, testTranscript, null);
		
		testTranscript.setStudent(testStudent);
		Debt testDebt = new Debt(23.23 , testStudent);
		
		testTranscript.setStudent(testStudent2);;
		assertEquals(testStudent2, testTranscript.getStudent());
		
		testTranscript.setListOfSemester(testListOfSemester2);
		assertEquals(testListOfSemester2 , testTranscript.getListOfSemester());
		
		testTranscript.setTotalCreditsCompleted(6);
		assertEquals(6 , testTranscript.getTotalCreditsCompleted());
		
		testTranscript.setGano(3.2);
		assertEquals(3.2 , testTranscript.getGano());
		
		testTranscript.setPoints(5.1);
		assertEquals(5.1 , testTranscript.getPoints());
		
		testTranscript.setTotalCreditsTaken(8);
		assertEquals(8, testTranscript.getTotalCreditsTaken());

		
		
		
		
	}


}
