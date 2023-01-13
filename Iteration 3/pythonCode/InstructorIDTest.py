#!/usr/bin/env python
from InstructorID import InstructorID
import unittest
class InstructorIDTest(unittest.TestCase):
    def test_InstructorID_ID(self):
        # generated source for method test_InstructorID_ID 
        testInstructorID = InstructorID(1, 2)
        testInstructorID.SetId(1, 2)
        self.assertEqual("001002", testInstructorID.getID())
if __name__ == '__main__':
    unittest.main()