import random
import datetime
from Debt import Debt
from LectureRegistrationApplication import LectureRegistrationApplication
from StudentID import StudentID
from DataManager import DataManager
from Schedule import Schedule
from Student import Student
from FilterType import FilterType
from Transcript import Transcript
from Term import Term
from TermYear import TermYear



class StudentGenerator():

    def __init__(self):
        pass

    def generate(self, year, i):

        student = Student()

        student.setID(self.studentIdGenerator(year,i))
        student.setFirstName(self.getRandomFirstName())
        student.setLastName(self.getRandomLastName())
        student.setDebt(self.studentDebtGenerator())
        student.setAdvisor(self.getRandomAdvisor())
        transcript = Transcript()
        student.setTranscript(transcript)
        student.getTranscript().setStudent(student)
        student.setDateOfEntry(datetime.date( int(year/10) +2000, 10, 22))
        schedule = Schedule()
        student.setSchedule(schedule)
        student.setDebt(self.studentDebtGenerator())
        student.getSchedule().setTerm(Term.Fall)
        student.getSchedule().setTermYear(TermYear.Freshman)
        student.setRegistirationApplication(LectureRegistrationApplication())

        self.__log.info("Student {x}, {name} is generated.".format(x=student.getID(), name=student.getFullName()))
        return student



    def getRandomFirstName(self):

        namePool = DataManager.getInstance().getNamePool()
        nameList = namePool["names"]
        a = random.randint(0, len(nameList) - 1)
        name = nameList[a]
        return name

    def getRandomLastName(self):

        namePool = DataManager.getInstance().getNamePool()
        nameList = namePool["lastNames"]
        a = random.randint(0, len(nameList) - 1)
        name = nameList[a]
        return name

    def studentIdGenerator(self, year, orderOf):
        return StudentID(150, year, orderOf)

    def studentDebtGenerator(self):
        debt = Debt()
        a = random.random()
        if a <= 0.3:
            debt = Debt()
            debt.setAmount(20000)
        else:
            debt = Debt()
            debt.setAmount(0)
        return debt

    def getRandomAdvisor(self):

        listOfAdvisor = DataManager.getInstance().searchAdvisors("", FilterType.Name)
        return listOfAdvisor[random.randint(0,len(listOfAdvisor) - 1)]