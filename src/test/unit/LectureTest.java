package test.unit;
import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import IDs.LectureID;
import Enums.LectureType;
import lecture.Lecture;
import lecture.LectureSession;

public class LectureTest {
	
	@Test
	public void test_Lecture_default_constructor() {
		LectureID testID = new LectureID("000");
		Lecture testLecture = new Lecture(testID,"testName", LectureType.FTE, 3, null, null, 5);
		
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
