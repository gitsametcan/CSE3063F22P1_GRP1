#!/usr/bin/env python
from Advisor import Advisor;
from Student import Student
import unittest
class LectureRegistrationApplicationTest(unittest.TestCase):
    # generated source for class LectureRegistrationApplicationTest 
    def test_LectureRegistrationApplicationTest_Advisor(self):
        # generated source for method test_LectureRegistrationApplicationTest_Advisor 
        testAdvisor = Advisor("firstName", "lastName", None, None, None, None, None, None)
        testLectureRegistrationApplicationTest = LectureRegistrationApplicationTest(None, testAdvisor, None)
        self.assertEqual(testAdvisor, testLectureRegistrationApplicationTest.getAdvisor())
    def test_LectureRegistrationApplicationTest_Student(self):
        # generated source for method test_LectureRegistrationApplicationTest_Student 
        testStudent = Student("testFName", "testLName", None, None, None, None)
        testLectureRegistrationApplicationTest = LectureRegistrationApplicationTest(None, None, testStudent)
        self.assertEqual(testStudent, testLectureRegistrationApplicationTest.getStudent())
    def test_LectureRegistrationApplicationTest_SessionsSentForApproval(self):
        # generated source for method test_LectureRegistrationApplicationTest_SessionsSentForApproval
        #this needs to be fixed
        #
        #
        #
        testSessionsSentForApproval = None
        testLectureRegistrationApplicationTest = LectureRegistrationApplicationTest(testSessionsSentForApproval, None, None)
        self.assertEqual(testSessionsSentForApproval, testLectureRegistrationApplicationTest.getSessionsSentForApproval())
if __name__ == '__main__':
    unittest.main()