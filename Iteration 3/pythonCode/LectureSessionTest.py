#!/usr/bin/env python
import unittest
from LectureSession import LectureSession
from SessionID import SessionID
from Lecture import Lecture
from Instructor import Instructor
from Student import Student
from SessionType import SessionType
from LectureHour import LectureHour
class LectureSessionTest(unittest.TestCase):
    # generated source for class LectureSessionTest
    def test_lecture_session_SessionID(self):
        # generated source for method test_lecture_session_SessionID
        testLectureSession = LectureSession()
        testSessionID = SessionID(23)
        testLectureSession.setSessionID(testSessionID)
        self.assertEqual(testSessionID, testLectureSession.getID())
    def test_lecture_session_SessionHours(self):
        # generated source for method test_lecture_session_SessionHours
        testLectureSession = LectureSession()
        testSessionHours = LectureHour[7]*10
        testSessionHours[1] = LectureHour.NO
        testLectureSession.setSessionHours(testSessionHours)
        self.assertEqual(testSessionHours, testLectureSession.getSessionHours)
    def test_lecture_session_SessionType(self):
        # generated source for method test_lecture_session_SessionType
        testLectureSession = LectureSession()
        testLectureSession.setSessionType(SessionType.Theorytical)
        self.assertEqual(SessionType.Theorytical, testLectureSession.getSessionType)
    def test_lecture_session_Instructor(self):
        # generated source for method test_lecture_session_Instructor
        testLectureSession = LectureSession()
        testInstructor = Instructor()
        testInstructor.setFirstName("testFName")
        testLectureSession.setInstructor(testInstructor)
        self.assertEqual(testInstructor, testLectureSession.getInstructor)
    def test_lecture_session_ListOfAssistans(self):
        # generated source for method test_lecture_session_ListOfAssistans
        testLectureSession = LectureSession()
        testInstructor = Instructor()
        testInstructor.setFirstName("testFName")
        testListOfAssistans = list()
        testListOfAssistans.append(testInstructor)
        testLectureSession.setListOfAssistans(testListOfAssistans)
        self.assertEqual(testListOfAssistans, testLectureSession.getListOfAssistans)
    def test_lecture_session_Lecture(self):
        # generated source for method test_lecture_session_Lecture
        testLectureSession = LectureSession()
        testLecture = Lecture()
        testLecture.setId(5)
        testLectureSession.setLecture(testLecture)
        self.assertEqual(testLecture, testLectureSession.getLecture)
    def test_lecture_session_ListOfStudents(self):
        # generated source for method test_lecture_session_ListOfStudents
        testLectureSession = LectureSession()
        testStudent = Student()
        testStudent.setFirstName("testFName")
        testListOfStudents = list()
        testListOfStudents.append(testStudent)
        testLectureSession.setListOfStudents(testListOfStudents)
        self.assertEqual(testListOfStudents, testLectureSession.getListOfStudents)
if __name__ == '__main__':
    unittest.main()