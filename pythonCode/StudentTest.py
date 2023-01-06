import unittest
from Student import Student
from Advisor import Advisor
from Debt import Debt
from Schedule import Schedule
from Term import Term
from Transcript import Transcript
from Lecture import Lecture
import datetime
from LectureRegistrationApplication import LectureRegistrationApplication
class StudentTest(unittest.TestCase):
    # generated source for class StudentTest
    def test_student_advisor(self):
        # generated source for method test_student_advisor 
        testStudent = Student()
        testAdvisor = Advisor()
        testAdvisor.setFirstName("testFName")
        testStudent.setAdvisor(testAdvisor)
        self.assertEqual(testAdvisor, testStudent.getAdvisor())
    def test_student_Debt(self):
        # generated source for method test_student_Debt 
        testStudent = Student()
        testDebt = Debt()
        testDebt.setAmount(5)
        testStudent.setDebt(testDebt)
        self.assertEqual(testDebt, testStudent.getDebt())
    def test_student_RegistirationApplication(self):
        # generated source for method test_student_RegistirationApplication 
        testStudent = Student()
        testLectureRegistrationApplication = LectureRegistrationApplication()
        testLectureRegistrationApplication.setStudent(testStudent)
        testStudent.setRegistirationApplication(testLectureRegistrationApplication)
        self.assertEqual(testLectureRegistrationApplication, testStudent.getRegistirationApplication())
    def test_student_ID(self):
        # generated source for method test_student_ID 
        testStudent = Student()
        testStudent.setID(1,2,3)
        self.assertEqual(001002003, testStudent.getID())
    def test_student_Schedule(self):
        # generated source for method test_student_Schedule 
        testStudent = Student()
        testSchedule = Schedule()
        testSchedule.setTerm(Term.Fall)
        testStudent.setSchedule(testSchedule)
        self.assertEqual(testSchedule, testStudent.getSchedule())
    def test_student_Transcript(self):
        # generated source for method test_student_Transcript 
        testStudent = Student()
        testTranscript = Transcript()
        testLecture = Lecture()
        testListOfLectures = list(Lecture)
        testTranscript.setListOfSemester(testListOfLectures)
        testStudent.setTranscript(testTranscript)
        self.assertEqual(testTranscript, testStudent.getTranscript())
    def test_student_DateOfEntryr(self):
        # generated source for method test_student_DateOfEntryr 
        testStudent = Student()
        testDateOfEntry = datetime.date(2011, 10, 28)
        testStudent.setDateOfEntry(testDateOfEntry)
        self.assertEqual(testDateOfEntry, testStudent.getDateOfEntry())
if __name__ == '__main__':
    unittest.main()