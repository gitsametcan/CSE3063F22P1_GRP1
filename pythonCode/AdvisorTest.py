#!/usr/bin/env python
from Advisor import Advisor
import datetime
import unittest
class AdvisorTest(unittest.TestCase):
    # generated source for class AdvisorTest 
    def test_advisor_list_of_student(self):
        # generated source for method test_advisor_list_of_student 
        testListOfStudents = list()
        testAdvisor = Advisor(None, None, None, None, None, testListOfStudents, None, None, None)
        self.assertEquals(testListOfStudents, testAdvisor.getListOfStudents())
    def test_advisor_list_of_application(self):
        # generated source for method test_advisor_list_of_application 
        testListOfApplications = list()
        testAdvisor = Advisor(None, None, None, None, None, None, testListOfApplications, None, None)
        self.assertEqual(testListOfApplications, testAdvisor.getListOfApplications())
if __name__ == '__main__':
    unittest.main()