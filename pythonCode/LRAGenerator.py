from Student import Student
from LectureRegistrationApplication import LectureRegistrationApplication
from Term import Term
from TermYear import TermYear
from DataManager import DataManager


class LRAGenerator():

    def __init__(self):
        pass

    def generate(self, listOfStudents:list, term:Term):

        nteList, ueList, teList, fteList, mandatoryList = DataManager.getInstance().searchLecturesUntilTerm("",Term.Spring, TermYear.Senior)
        student = Student()
        for s in listOfStudents:

            LRA = LectureRegistrationApplication()

            for l in mandatoryList:
                a = 0
                b = 0
                c = 0
                d = 0
                for la in student.availableLessons():
                    if l == la:
                        a=1
                if student.canTakeLecture(l,student.getTranscript()):
                    b = 1
                if student.checkScheduleForLecture(student.getSchedule(),l):
                    c = 1
                if l.getSessions(0).getStudentList().size < l.getQuota():
                    d = 1
                if a==1 & b==1 & c==1 & d==1:
                    LRA.getSessionsSentForApproval().append(l.getSessions(0))
                    student.getSchedule().append(l.getSessions(0))
                    l.getLectureSessions(0).getStudentList().append(s)

        return listOfStudents
