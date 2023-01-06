import unittest
from Transcript import Transcript
from Student import Student
from Lecture import Lecture
from Semester import Semester
class TranscriptTest(unittest.TestCase):
    # generated source for class TranscriptTest
    def test_transcript_student(self):
        # generated source for method test_transcript_student 
        testTranscript = Transcript()
        testStudent = Student()
        testStudent.setFirstName("testFName")
        testTranscript.setStudent(testStudent)
        self.assertEqual(testStudent, testTranscript.getStudent())
    def test_transcript_ListOfSemester(self):
        # generated source for method test_transcript_ListOfSemester 
        testTranscript = Transcript()
        testSemester = Semester()
        testListOfSemester = list(testSemester)
        testTranscript.setListOfSemester(testListOfSemester)
        self.assertEqual(testListOfSemester, testTranscript.getListOfSemester())
    def test_semester_Gano(self):
        # generated source for method test_semester_Gano 
        testTranscript = Transcript()
        testTranscript.setGano(3.2)
        self.assertEqual(3.2, testTranscript.getGano)
    def test_transcript_TotalCreditsTaken(self):
        # generated source for method test_transcript_TotalCreditsTaken 
        testTranscript = Transcript()
        testTranscript.setTotalCreditsTaken(5)
        self.assertEqual(5, testTranscript.getTotalCreditsTaken())
    def test_transcript_Points(self):
        # generated source for method test_transcript_Points 
        testTranscript = Transcript()
        testTranscript.setPoints(5)
        self.assertEqual(5, testTranscript.getPoints())
    def test_transcript_TotalCreditsCompleted(self):
        # generated source for method test_transcript_TotalCreditsCompleted 
        testTranscript = Transcript()
        testTranscript.setTotalCreditsCompleted(10)
        self.assertEqual(10, testTranscript.getTotalCreditsCompleted())
if __name__ == '__main__':
    unittest.main()