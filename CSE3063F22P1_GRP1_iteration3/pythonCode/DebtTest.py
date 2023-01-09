#!/usr/bin/env python
from Debt import Debt
from Student import Student
import unittest
class DebtTest(unittest.TestCase):
    # generated source for class DebtTest
    def test_debt_amount(self):
        # generated source for method test_debt_amount
        testDebt = Debt()
        testDebt.setAmount(23.23)
        self.assertEqual(23.23, testDebt.getAmount())
    def test_debt_student(self):
        # generated source for method test_debt_student
        testStudent = Student()
        testStudent.setFirstName("testFName")
        testDebt = Debt()
        testDebt.setStudent(testStudent)
        self.assertEqual(testStudent, testDebt.getAmount())
if __name__ == '__main__':
    unittest.main()