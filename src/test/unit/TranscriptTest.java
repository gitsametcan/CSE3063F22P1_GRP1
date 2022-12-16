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
	public void test_transcript_student() {
		StudentID testId = new StudentID(000,000,000);
		Semester testSemester = new Semester(null);
		Semester testSemester2 = new Semester(null);
		List<Semester> testListOfSemester = new ArrayList<>();
		testListOfSemester.add(testSemester);
		testListOfSemester.add(testSemester2);
		
		Transcript testTranscript = new Transcript(null, testListOfSemester);
		
		Student testStudent2 = new Student("testFName2", "testLName2",
				testId, null, testTranscript, null);
				
		testTranscript.setStudent(testStudent2);;
		assertEquals(testStudent2, testTranscript.getStudent());		
	}
	@Test
	public void test_transcript_list_of_semester() {
		Semester testSemester = new Semester(null);
		Semester testSemester2 = new Semester(null);
		List<Semester> testListOfSemester = new ArrayList<>();
		testListOfSemester.add(testSemester);
		testListOfSemester.add(testSemester2);
		
		Semester testSemester3 = new Semester(null);
		List<Semester> testListOfSemester2 = new ArrayList<>();
		testListOfSemester2.add(testSemester3);
		testListOfSemester2.add(testSemester2);
		
		Transcript testTranscript = new Transcript(null, testListOfSemester);
				
		testTranscript.setListOfSemester(testListOfSemester2);
		assertEquals(testListOfSemester2 , testTranscript.getListOfSemester());
	}
	@Test
	public void test_transcript_total_credits_completed() {
		Semester testSemester = new Semester(null);
		Semester testSemester2 = new Semester(null);
		List<Semester> testListOfSemester = new ArrayList<>();
		testListOfSemester.add(testSemester);
		testListOfSemester.add(testSemester2);
		
		Transcript testTranscript = new Transcript(null, testListOfSemester);
			
		testTranscript.setTotalCreditsCompleted(6);
		assertEquals(6 , testTranscript.getTotalCreditsCompleted());	
	}
	@Test
	public void test_transcript_gano() {
		Semester testSemester = new Semester(null);
		Semester testSemester2 = new Semester(null);
		List<Semester> testListOfSemester = new ArrayList<>();
		testListOfSemester.add(testSemester);
		testListOfSemester.add(testSemester2);
		
		Transcript testTranscript = new Transcript(null, testListOfSemester);
		
		testTranscript.setGano(3.2);
		assertEquals(3.2 , testTranscript.getGano(),0.001);
	}
	@Test
	public void test_transcript_points() {
		Semester testSemester = new Semester(null);
		Semester testSemester2 = new Semester(null);
		List<Semester> testListOfSemester = new ArrayList<>();
		testListOfSemester.add(testSemester);
		testListOfSemester.add(testSemester2);
		
		Transcript testTranscript = new Transcript(null, testListOfSemester);

		testTranscript.setPoints(5.1);
		assertEquals(5.1 , testTranscript.getPoints(),0.001);
	}
	@Test
	public void test_transcript_total_credits_taken() {
		Semester testSemester = new Semester(null);
		Semester testSemester2 = new Semester(null);
		List<Semester> testListOfSemester = new ArrayList<>();
		testListOfSemester.add(testSemester);
		testListOfSemester.add(testSemester2);	
		
		Transcript testTranscript = new Transcript(null, testListOfSemester);
		
		testTranscript.setTotalCreditsTaken(8);
		assertEquals(8, testTranscript.getTotalCreditsTaken());
	}
}
