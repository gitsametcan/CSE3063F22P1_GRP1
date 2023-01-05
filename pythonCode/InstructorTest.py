#!/usr/bin/env python
from InstructorID import InstructorID;
from InstructorType import InstructorType
from Schedule import Schedule
from Instructor import Instructor
import datetime
import unittest
class InstructorTest(unittest.TestCase):
    # generated source for class InstructorTest 
    def test_instructor_InstructorID(self):
        # generated source for method test_instructor_InstructorID 
        testInstructorID = InstructorID(1, 2)
        testInstructor = Instructor(None, None, testInstructorID, None, None, None)
        self.assertEqual(testInstructorID, testInstructor.getID())
    def test_instructor_scheudle(self):
        # generated source for method test_instructor_scheudle 
        testSchedule = Schedule(None, None, None)
        testInstructor = Instructor(None, None, None, None, None, testSchedule)
        testSchedule.setPerson(testInstructor)
        self.assertEqual(testSchedule, testInstructor.getSchedule())
    def test_instructor_date_of_entry(self):
        # generated source for method test_instructor_date_of_entry 
        testDateOfEntry = datetime.date(2011, 10, 28)
        testInstructor = Instructor(None, None, None, testDateOfEntry, None, None)
        self.assertEqual(testDateOfEntry, testInstructor.getDateOfEntry())
    def test_instructor_instructor_type(self):
        # generated source for method test_instructor_instructor_type 
        testInstructorType = InstructorType.Assistant
        testInstructor = Instructor(None, None, None, None, testInstructorType, None)
        self.assertEqual(InstructorType.Assistant, testInstructor.getInstructorType())
if __name__ == '__main__':
    unittest.main()
    