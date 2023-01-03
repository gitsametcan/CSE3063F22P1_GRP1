from Debt import Debt
from LectureRegistrationApplication import LectureRegistrationApplication
from StudentID import StudentID
from DataManager import DataManager
from Lecture import Lecture
from LectureSession import LectureSession
import Schedule #1
from Advisor import Advisor
from Student import Student
from ApprovalState import ApprovalState
from FilterType import FilterType
from Term import Term
from TermYear import TermYear
from TranscriptGenerator import TranscriptGenerator
import datetime
import random

class StudentGenerator():

    def __init__(self):

        __namePool = DataManager.getInstance().getNamePool()
        self.__transcriptGenerator = TranscriptGenerator()
        if __namePool.isPresent():
            namePool = __namePool.get()
        self.__transcriptGenerator = TranscriptGenerator()

    def generate(self, studentCount, semesterCount):
        
        dateOfEntry = datetime.date(2000 + (semesterCount / 2) + 18, 10, 22)
        student = Student()
        #2 schedule = Schedule(student, Term.values()[semesterCount % 2], TermYear.values()[semesterCount / 2])
        #5 student.setSchedule(schedule)
        student.setDebt(studentDebtGenerator())
        student.setAdvisor(getRandomAdvisor())
        student.setTranscript(self.transcriptGenerator.generate(student, schedule))
        student.setRegistirationApplication(LRAGenerator(student))
        return student

    def getRandomFirstName(self):
        namePool = DataManager.getInstance().getNamePool().getRandomName()
        a = random.randint(0, 50)
        name = namePool(a)
        return name

    def getRandomLastName(self):
        namePool = DataManager.getInstance().getNamePool().getRandomName()
        a = random.randint(0, 50)
        name = namePool(a)
        return name

    def studentIdGenerator(self, year, orderOf):
        return StudentID(150, year, orderOf)

    def studentDebtGenerator(self):
        debt = Debt()
        a = random()
        if a <= 0.3:
            debt = Debt(20000, None)
        else:
            debt = Debt(0, None)
        return debt

    def getRandomAdvisor(self):
        #3
        return DataManager.getInstance().searchAdvisor("", FilterType.Name).get(((Math.random() * 13)))

    def LRAGenerator(self, student):
        #4
        LRA = LectureRegistrationApplication(None, student.getAdvisor(), student)
        listOfLecture = HashMap()
        for l in student.availableLessons():
            listOfLecture.put(l.getSessions().get(0), ApprovalState.Pending)
        return LRA