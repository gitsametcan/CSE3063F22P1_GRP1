import unittest
from Person import Person
class PersonTest(unittest.TestCase):
    # generated source for class PersonTest 
    def test_person_first_name(self):
        # generated source for method test_person_first_name 
        testPerson = Person()
        testPerson.setFirstName("testFName")
        self.assertEqual("testFName", testPerson.getFirstName())
    def test_person_last_name(self):
        # generated source for method test_person_last_name 
        testPerson = Person()
        testPerson.setLastName("testLName")
        self.assertEqual("testLName", testPerson.getLastName)
    def test_person_full_name(self):
        # generated source for method test_person_full_name 
        testPerson = Person()
        testPerson.setFirstName("testFName")
        testPerson.setLastName("testLName")
        self.assertEqual("testFName testLName", testPerson.getFullName)
if __name__ == '__main__':
    unittest.main()