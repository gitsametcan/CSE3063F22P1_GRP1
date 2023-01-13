#!/usr/bin/env python
import unittest
from Lecture import Lecture
from LectureID import LectureID
from LectureType import LectureType
from LectureSession import LectureSession
class LectureTest(unittest.TestCase):
    # generated source for class LectureTest
    def test_lecture_lectureID(self):
        # generated source for method test_lecture_lectureID 
        testLecture = Lecture()
        testLectureID = LectureID("000")
        testLecture.setId(testLecture)
        self.assertEqual(testLectureID, testLecture.getID())
    def test_lecture_Name(self):
        # generated source for method test_lecture_Name 
        testLecture = Lecture()
        testLecture.setName("testString")
        self.assertEqual("testString", testLecture.getName())
    def test_lecture_LectureType(self):
        # generated source for method test_lecture_LectureType 
        testLecture = Lecture()
        testLecture.setLectureType(LectureType.MANDATORY)
        self.assertEqual(LectureType.MANDATORY, testLecture.getLectureType())
    def test_lecture_Credit(self):
        # generated source for method test_lecture_Credit 
        testLecture = Lecture()
        testLecture.setCredit(4)
        self.assertEqual(4, testLecture.getCredit())
    def test_lecture_Sessions(self):
        # generated source for method test_lecture_Sessions 
        testLecture = Lecture()
        testLectureSession = LectureSession()
        testLectureSession.setLecture(testLecture)
        testLecture.setSessions(testLectureSession)
        self.assertEqual(testLectureSession, testLecture.getSessions())
    def test_lecture_Prerequisite(self):
        # generated source for method test_lecture_Prerequisite 
        testLecture1 = Lecture()
        testLecture2 = Lecture()
        testLecture2.setName("testLName2")
        testLecture1.setPrerequisite(testLecture2)
        self.assertEqual(testLecture2, testLecture1.getPrerequisite())
if __name__ == '__main__':
    unittest.main()