#!/usr/bin/env python
from InstructorID import InstructorID;
from InstructorType import InstructorType
from Schedule import Schedule
from Instructor import Instructor
import datetime
import unittest
class InstructorTest(unittest.TestCase):
    # generated source for class JavaInUse 
    def test_instructor_InstructorID(self):
        # generated source for method test_instructor_InstructorID 
        testInstructorID = InstructorID(1, 2)
        testDateOfEntry = datetime.date(2011, 10, 28)
        testInstructorType = InstructorType.Assistant
        testSchedule = Schedule(None, None, None)
        testInstructor = Instructor("a", "b", testInstructorID, testDateOfEntry, testInstructorType, testSchedule)
        self.assertEqual(testInstructorID, testInstructor.getID())
    def test_instructor_scheudle(self):
        """ generated source for method test_instructor_scheudle """
        testInstructorID = InstructorID(1, 2)
        testSchedule = Schedule(None, None, None)
        testDateOfEntry = datetime.date(2011, 10, 28)
        testInstructorType = InstructorType.Assistant
        testInstructor = Instructor("a", "b", testInstructorID, testDateOfEntry, testInstructorType, testSchedule)
        testSchedule.setPerson(testInstructor)
        self.assertEqual(testSchedule, testInstructor.getSchedule())
    def test_instructor_date_of_entry(self):
        """ generated source for method test_instructor_date_of_entry """
        testInstructorID = InstructorID(1, 2)
        testSchedule = Schedule(None, None, None)
        testDateOfEntry = datetime.date(2011, 10, 28)
        testInstructorType = InstructorType.Assistant
        testInstructor = Instructor("a", "b", testInstructorID, testDateOfEntry, testInstructorType, testSchedule)
        self.assertEqual(None, testInstructor.getDateOfEntry())
    def test_instructor_instructor_type(self):
        """ generated source for method test_instructor_instructor_type """
        testInstructorID = InstructorID(1, 2)
        testSchedule = Schedule(None, None, None)
        testDateOfEntry = datetime.date(2011, 10, 28)
        testInstructorType = InstructorType.Assistant
        testInstructor = Instructor("a", "b", testInstructorID, testDateOfEntry, testInstructorType, testSchedule)
        self.assertEqual(InstructorType.Assistant, testInstructor.getInstructorType())
if __name__ == '__main__':
    unittest.main()
    