package test.unit;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import Debt_LRA_Transcript.Debt;
import Debt_LRA_Transcript.LectureRegistrationApplication;
import Debt_LRA_Transcript.Transcript;
import Enums.ApprovalState;
import IDs.InstructorID;
import IDs.SessionID;
import IDs.StudentID;
import lecture.LectureSession;
import lecture.Semester;
import person.Advisor;
import person.Student;

public class LectureRegistrationApplicationTest {

	@Test
	public void test_LRA_default_constructor() {
		
		Map<LectureSession, ApprovalState> testSessionsSentForApproval = new HashMap<LectureSession, ApprovalState>();
		SessionID testID = new SessionID(123);
		
		LectureSession testLectureSession = new LectureSession(testID , null , null, null, null, null);
		
		Semester testSemester = new Semester(null, 1, 2, 2.1 , 1.2);
		Semester testSemester2 = new Semester(null, 2, 3, 3.1, 1.3);
		List<Semester> testListOfSemester = new ArrayList<>();
		testListOfSemester.add(testSemester);
		testListOfSemester.add(testSemester2);
		
		Transcript testTranscript = new Transcript(null, testListOfSemester, 
				3.4, 23, 13, 2.3);
		
		StudentID testId = new StudentID(000,000,000);
		InstructorID testInstructorID = new InstructorID(123, 456);
		
		Advisor testAdvisor = new Advisor("firstName", "lastName", testInstructorID, null, null, null, null, null);
		
		Student testStudent = new Student("testFName", "testLName",
				testId, null, testTranscript, null);
		
		LectureRegistrationApplication testLRA = new LectureRegistrationApplication(testSessionsSentForApproval, testAdvisor, testStudent);
		
		
		testLRA.setAdvisor(testAdvisor);
		assertEquals(testAdvisor, testLRA.getAdvisor());
		
		testLRA.setStudent(testStudent);
		assertEquals(testStudent, testLRA.getStudent());
		
		testLRA.setSessionsSentForApproval(testSessionsSentForApproval);
		assertEquals(testSessionsSentForApproval, testLRA.getSessionsSentForApproval());
		
		
	}

}
