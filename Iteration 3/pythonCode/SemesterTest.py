import unittest
from Semester import Semester
from Lecture import Lecture
from LetterGrade import LetterGrade
class SemesterTest(unittest.TestCase):
    # generated source for class SemesterTest 
    def test_semester_list_of_lectures_taken(self):
        # generated source for method test_semester_list_of_lectures_taken 
        testSemester = Semester()
        testLectuere = Lecture()
        testListOfLecturesTaken = list([testLectuere, LetterGrade.AA])
        testSemester.setListOfLecturesTaken(testListOfLecturesTaken) 
        self.assertEqual(testListOfLecturesTaken, testSemester.getListOfLecturesTaken())
    def test_semester_Credits_Taken(self):
        # generated source for method test_semester_Credits_Taken 
        testSemester = Semester()
        testLectuere = Lecture()
        testLectuere.setCredit(5)
        testListOfLecturesTaken = list([testLectuere, LetterGrade.AA])
        testSemester.setListOfLecturesTaken(testListOfLecturesTaken) 
        self.assertEqual(5, testSemester.getCreditsTaken())
    def test_semester_Credits_Completed(self):
        # generated source for method test_semester_Credits_Completed 
        testSemester = Semester()
        testLectuere = Lecture()
        testLectuere.setCredit(5)
        testListOfLecturesTaken = list([testLectuere, LetterGrade.AA])
        testSemester.setListOfLecturesTaken(testListOfLecturesTaken) 
        self.assertEqual(5, testSemester.getCreditsCompleted())
    def test_semester_Points(self):
        # generated source for method test_semester_Points 
        testSemester = Semester()
        testLectuere = Lecture()
        testLectuere.setCredit(5)
        testListOfLecturesTaken = list([testLectuere, LetterGrade.AA])
        testSemester.setListOfLecturesTaken(testListOfLecturesTaken) 
        testPoints = testSemester.getPoints()
        self.assertEqual(testPoints, testSemester.getPoints())
    def test_semester_Yano(self):
        # generated source for method test_semester_Yano 
        testSemester = Semester()
        testLectuere = Lecture()
        testLectuere.setCredit(5)
        testListOfLecturesTaken = list([testLectuere, LetterGrade.AA])
        testSemester.setListOfLecturesTaken(testListOfLecturesTaken) 
        testYano = testSemester.getYano()
        self.assertEqual(testYano, testSemester.getYano()())
if __name__ == '__main__':
    unittest.main()