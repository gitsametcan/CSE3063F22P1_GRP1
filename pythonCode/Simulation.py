
import random
from Term import Term
from TermYear import TermYear
from ApprovalState import ApprovalState
from LectureRegistrationApplication import LectureRegistrationApplication
from StudentGenerator import StudentGenerator
from LRAGenerator import LRAGenerator
from LetterGrade import LetterGrade

class Simulation():

    def __init__(self):
        self.__studentGenerator = StudentGenerator()
        self.__LRA = LRAGenerator()
        self.__listOfStudents = list()

    def run(self): #öğrenci üretme

        year = 118

        listOfStudents = list()

        self.setYear(121)
        self.setTerm(Term.Spring)
        
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
        return listOfStudents

    def startSimulation(self, studentsList):
        if(self.getTerm() == Term.Spring):
            self.setYear(self.getYear()+1)
            self.skipTerm(studentsList, self.getTerm())
            for i in range(1, 101):
                student = self.__studentGenerator.generate(self.getYear(),i)
                studentsList.append(student)
        listOfStudents = self.__LRA.generate(studentsList,self.getTerm())
        self.takeAutoAnswerForLRA(listOfStudents)
        self.fillSemesterFromLRA(listOfStudents)
        self.emptyLRA(listOfStudents)
        self.takeAutoLetterGradeForSemester(listOfStudents)

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
                    sessions[l.getSessions()[0]] = ApprovalState.Approved
                else:
                    sessions[l.getSessions()[0]] = ApprovalState.Rejected
        
            s.getRegistirationApplication().setSessionsSentForApproval(sessions)

    def fillSemesterFromLRA(self, listOfStudent):
        from Semester import Semester
        for s in listOfStudent:
            listOflecture = dict()
            sessions = s.getRegistirationApplication().getSessionsSentForApproval()
            for l in sessions.keys():
                if sessions[l] == ApprovalState.Approved:
                    listOflecture[l] = LetterGrade.Non
            semester = Semester()
            semester.setListOfLecturesTaken(listOflecture)
            listOfSemester = s.getTranscript().getListOfSemester()

            """for ls in s.getTranscript().getLastSemester().getListOfLecturesTaken():
                s.getTranscript().getLastSemester().addToGradeList(ls,LetterGrade.Non)"""

            listOfSemester.append(semester)
            s.getTranscript().setListOfSemester(listOfSemester)


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

    def setYear(self, year):
        self.__year = year
    def getYear(self):
        return self.__year
    def setTerm(self, term):
        self.__term = term
    def getTerm(self):
        return self.__term