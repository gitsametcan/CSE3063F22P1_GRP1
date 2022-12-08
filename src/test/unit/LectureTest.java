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
		 Lecture testLecture = new Lecture(testID,"testName","FTE", 3, List<LectureSession> sessions,
					Lecture prerequisite, 5);
		 
		 testLecture.setCredit("try_1");
		 assertEquals("try_1", testLecture.getCredit())
		 
	 }

}
