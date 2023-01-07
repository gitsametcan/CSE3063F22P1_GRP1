
import random
from Term import Term
from TermYear import TermYear
from Semester import Semester
from ApprovalState import ApprovalState
from LectureRegistrationApplication import LectureRegistrationApplication
from StudentGenerator import StudentGenerator
from LRAGenerator import LRAGenerator
from DataManager import DataManager
from LetterGrade import LetterGrade

class Simulation():

    def __init__(self):
        self.__studentGenerator = StudentGenerator()
        self.__LRA = LRAGenerator()
        self.__listOfStudents = list()

    def run(self):

        year = 118

        listOfStudents = list()

        for i in range(1, 7):
            term = Term.Fall
            if i % 2 ==0:
                term = Term.Spring
            if i !=1:
                self.skipTerm(listOfStudents, term)
            if i % 2 != 0:
                year = year + 1
                for i in range(1, 101):
                    student = self.__studentGenerator.generate(year,i)
                    listOfStudents.append(student)
            listOfStudents = self.__LRA.generate(listOfStudents,term)
            self.takeAutoAnswerForLRA(listOfStudents)
            self.fillSemesterFromLRA(listOfStudents)
            self.emptyLRA(listOfStudents)
            self.takeAutoLetterGradeForSemester(listOfStudents)

        DataManager.getInstance().addStudents(listOfStudents)
        return listOfStudents


    #logs will come here

    def skipTerm(self, listOfStudents:list(), term:Term):

        for s in listOfStudents:
            if term == term.Spring:
                if s.getSchedule().getTermYear() == TermYear.Freshman:
                    s.getSchedule().setTermYear(TermYear.Sophomore)
                elif s.getSchedule().getTermYear() == TermYear.Sophomore:
                    s.getSchedule().setTermYear(TermYear.Junior)
                elif s.getSchedule().getTermYear() == TermYear.Junior:
                    s.getSchedule().setTermYear(TermYear.Senior)
            s.getSchedule().setTerm(term)

    def takeAutoAnswerForLRA(self, listOfStudent):
        for s in listOfStudent:
            sessions = s.getRegistirationApplication().getSessionsSentForApproval()
            for l in sessions.keys():
                a = random.random()
                if a <= 0.95:
                    sessions[l] = ApprovalState.Approved
                else:
                    sessions[l] = ApprovalState.Rejected

    def fillSemesterFromLRA(self, listOfStudent):
        from Semester import Semester
        for s in listOfStudent:
            listOflecture = list()
            sessions = s.getRegistirationApplication().getSessionsSentForApproval()
            for l in sessions.keys():
                if sessions[l] == ApprovalState.Approved:
                    listOflecture.append(l)
            semester = Semester()
            semester.setListOfLecturesTaken(listOflecture)
            s.getTranscript().addSemester(semester)


    def takeAutoLetterGradeForSemester(self, listOfStudents):
        for s in listOfStudents:
            semester = s.getTranscript().getLastSemester()
            lectureList = semester.getListOfLecturesTaken()

            possible_grades = (LetterGrade.AA, LetterGrade.BA, LetterGrade.BB, LetterGrade.CB, LetterGrade.CC, LetterGrade.DC, LetterGrade.DD, LetterGrade.FD, LetterGrade.FF)
            random_grade = random.choice(possible_grades)

            for ls in s.getTranscript().getLastSemester().getListOfLecturesTaken():
                s.getTranscript().getLastSemester().addToGradeList(ls,random_grade)

        s.getTranscript().getLastSemester().setListOfLecturesTaken(lectureList)

    def emptyLRA(self, listOfStudent):
        lra = LectureRegistrationApplication()
        for s in listOfStudent:
            s.setRegistirationApplication(lra)

    def getListOfStudents(self):
        return self.__listOfStudents

    def setListOfStudents(self, listOfStudents:list()):
        self.__listOfStudents = listOfStudents
