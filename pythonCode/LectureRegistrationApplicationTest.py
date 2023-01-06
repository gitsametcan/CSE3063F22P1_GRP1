#!/usr/bin/env python
from Advisor import Advisor;
from Session import Session
from Student import Student
from LectureRegistrationApplication import LectureRegistrationApplication
import unittest
class LectureRegistrationApplicationTest(unittest.TestCase):
    # generated source for class LectureRegistrationApplicationTest 
    def test_LectureRegistrationApplicationTest_Advisor(self):
        # generated source for method test_LectureRegistrationApplicationTest_Advisor 
        testAdvisor = Advisor()
        testAdvisor.setFirstName("testFName")
        testLectureRegistrationApplicationTest = LectureRegistrationApplication()
        testLectureRegistrationApplicationTest.setAdvisor(testAdvisor)
        self.assertEqual(testAdvisor, testLectureRegistrationApplicationTest.getAdvisor())
    def test_LectureRegistrationApplicationTest_Student(self):
        # generated source for method test_LectureRegistrationApplicationTest_Student 
        testStudent = Student()
        testStudent.setFirstName("testFName")
        testLectureRegistrationApplicationTest = LectureRegistrationApplication()
        testLectureRegistrationApplicationTest.setStudent(testStudent)
        self.assertEqual(testStudent, testLectureRegistrationApplicationTest.getStudent())
    def test_LectureRegistrationApplicationTest_SessionsSentForApproval(self):
        # generated source for method test_LectureRegistrationApplicationTest_SessionsSentForApproval
        testSession = Session()
        testSessionsSentForApproval = list()
        testSessionsSentForApproval.append(testSession)
        testLectureRegistrationApplicationTest = LectureRegistrationApplication()
        testLectureRegistrationApplicationTest.setSsessionsSentForApproval(testSessionsSentForApproval)
        self.assertEqual(testSessionsSentForApproval, testLectureRegistrationApplicationTest.getSessionsSentForApproval())
if __name__ == '__main__':
    unittest.main()