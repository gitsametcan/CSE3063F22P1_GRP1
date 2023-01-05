from Debt import Debt
from LectureRegistrationApplication import LectureRegistrationApplication
from StudentID import StudentID
from DataManager import DataManager
from Lecture import Lecture
from LectureSession import LectureSession
from Schedule import Schedule
from Advisor import Advisor
from Student import Student
from ApprovalState import ApprovalState
from FilterType import FilterType
from Transcript import Transcript
from Term import Term
from TermYear import TermYear
from TranscriptGenerator import TranscriptGenerator
import datetime
import random

class StudentGenerator():

    def __init__(self):
        pass

    def generate(self, year, i):

        student = Student()

        student.setID = self.studentIdGenerator(150,year,i)
        student.setFirstName = self.getRandomFirstName()
        student.setLastName = self.getRandomLastName()
        student.setDebt = self.studentDebtGenerator()
        student.setAdvisor = self.getRandomAdvisor()
        student.setTranscript = Transcript()
        student.getTranscript().setStudent(student)
        student.setDateOfEntry = datetime.date( (year/10) +2000, 10, 22)
        student.setSchedule = Schedule()
        student.getSchedule().setTerm(Term.Fall)
        student.getSchedule().setTermYear(TermYear.Freshman)
        student.setRegistirationApplication = LectureRegistrationApplication()

        return student



    def getRandomFirstName(self):

        namePool = DataManager.getInstance().getNamePool()
        nameList = namePool["names"]
        a = random.randint(0, 50)
        name = nameList[a]
        return name

    def getRandomLastName(self):

        namePool = DataManager.getInstance().getNamePool()
        nameList = namePool["lastNames"]
        a = random.randint(0, 50)
        name = nameList[a]
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

        return DataManager.getInstance().searchAdvisor("", FilterType.Name).get(((random.randint(1,13))))