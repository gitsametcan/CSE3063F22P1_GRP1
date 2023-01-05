
from Logger import Logger
from Student import Student
from Term import Term
from TermYear import TermYear
from LectureRegistrationApplication import LectureRegistrationApplication

from StudentGenerator import StudentGenerator
from LRAGenerator import LRAGenerator

class Simulation():

    def __init__(self):
        
        self.__studentGenerator = StudentGenerator()
        self.__LRA = LectureRegistrationApplication()
        self.__listOfStudents = list()

    def run(self):

        year = 118

        listOfStudents = list()

        for i in range(1, 7):
            term = Term.Fall
            if i % 2 ==0:
                term = Term.Spring
            self.skipTerm(listOfStudents, term)
            if i % 2 != 0:
                year = year + 1
                for i in range(1, 101):
                    student = self.__studentGenerator.generate(year,i)
                    listOfStudents.append(student)
            listOfStudents = self.__LRA.generate(listOfStudents)
            self.takeAutoAnswerForLRA(listOfStudents)
            self.fillSemesterFromLRA(listOfStudents)
            self.emptyLRA(listOfStudents)
            self.takeAutoLetterGradeForSemester(listOfStudents)
            
            


    #loglar gelecek

    def skipTerm(self, listOfStudents:list(), term:Term):

        for s in listOfStudents:
            if term == term.Spring:
                if s.getSchedule.getTermYear() == TermYear.Freshman:
                    s.getSchedule.setTermYear(TermYear.Sophomore)
                elif s.getSchedule.getTermYear() == TermYear.Sophomore:
                    s.getSchedule.setTermYear(TermYear.Junior)
                elif s.getSchedule.getTermYear() == TermYear.Junior:
                    s.getSchedule.setTermYear(TermYear.Senior)
            s.getSchedule.setTerm(term)
        
    def takeAutoAnswerForLRA(self, listOfStudents):
        #Give states for every students LRA lectures 
        pass

    def emptyLRA(self, listOfStudent):      
        for s in listOfStudent:
            s.setRegistirationApplication(None)

    def getListOfStudents(self):
        return self.__listOfStudents

    def setListOfStudents(self, listOfStudents:list()):
        self.__listOfStudents = listOfStudents
