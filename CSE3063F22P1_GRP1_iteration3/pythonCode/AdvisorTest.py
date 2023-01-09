#!/usr/bin/env python
from Advisor import Advisor
from Student import Student
import datetime
import unittest
class AdvisorTest(unittest.TestCase):
    # generated source for class AdvisorTest 
    def test_advisor_list_of_student(self):
        # generated source for method test_advisor_list_of_student 
        testStudent = Student()
        testListOfStudents = list()
        testListOfStudents.append(testStudent)
        testAdvisor = Advisor()
        testAdvisor.__listOfStudents(testListOfStudents)
        self.assertEquals(testListOfStudents, testAdvisor.getListOfStudents())
    def test_advisor_list_of_application(self):
        # generated source for method test_advisor_list_of_application 
        testListOfApplications = list()
        testAdvisor = Advisor()
        testAdvisor.__listOfApplications(testListOfApplications)
        self.assertEqual(testListOfApplications, testAdvisor.getListOfApplications())
if __name__ == '__main__':
    unittest.main()