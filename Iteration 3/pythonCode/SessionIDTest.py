#!/usr/bin/env python
from SessionID import SessionID
import unittest
class SessionIDTest(unittest.TestCase):
    def test_SessionID_ID_str(self):
        # generated source for method test_SessionID_ID
        testSessionID = SessionID(2)
        testSessionID.SetID("2")
        self.assertEqual("2", testSessionID.getID())
    def test_SessionID_ID(self):
        # generated source for method test_SessionID_ID
        testSessionID = SessionID(0)
        testSessionID.SetID(0)
        self.assertEqual("0", testSessionID.getID())
if __name__ == '__main__':
    unittest.main()