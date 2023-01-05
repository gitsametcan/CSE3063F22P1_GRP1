
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
        self.__listOfStudents = list()

    def __newSemester(self, semesterCount):
        
        for studentCount in range(1,51):
            try:
                student = self.__studentGenerator.generate(studentCount, semesterCount)
                self.__listOfStudents.append(student)
            except Exception as e:
                e.printStackTrace() #Instance of 'Exception' has no 'printStackTrace' memberPylint(E1101:no-member)

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
                    student = StudentGenerator.generate(year,i)
                    listOfStudents.append(student)
            LRAGenerator.generate(listOfStudents)
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
            LRA = LectureRegistrationApplication()
            s.setRegistirationApplication(LRA)

    def getListOfStudents(self):
        return self.__listOfStudents

    def setListOfStudents(self, listOfStudents:list()):
        self.__listOfStudents = listOfStudents
