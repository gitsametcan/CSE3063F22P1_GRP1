#!/usr/bin/env python
from LectureID import LectureID
import unittest
class LectureIDTest(unittest.TestCase):
    def test_LectureIDTest_ID(self):
        # generated source for method test_LectureIDTest_ID 
        testLectureID = LectureID("test")
        testLectureID.setID("test")
        self.assertEqual("test", testLectureID.getID())
if __name__ == '__main__':
    unittest.main()