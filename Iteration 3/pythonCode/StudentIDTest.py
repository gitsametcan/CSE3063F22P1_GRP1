#!/usr/bin/env python
from StudentID import StudentID
import unittest
class StudentIDTest(unittest.TestCase):
    def test_StudentID_ID_str(self):
        # generated source for method test_StudentID_ID_str
        testStudentID = StudentID("000111222")
        testStudentID.SetID("000111222")
        self.assertEqual("000111222", testStudentID.getID())
    def test_StudentID_ID(self):
        # generated source for method test_StudentID_ID
        testStudentID = StudentID(111, 222, 333)
        testStudentID.SetID(44, 5, 666)
        self.assertEqual("044005666", testStudentID.getID())
if __name__ == '__main__':
    unittest.main()