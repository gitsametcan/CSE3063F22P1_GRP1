from Student import Student
from LectureRegistrationApplication import LectureRegistrationApplication
from Term import Term
from TermYear import TermYear
from DataManager import DataManager
from Lecture import Lecture
from FilterType import FilterType
from Schedule import Schedule
from Instructor import Instructor

class LRAGenerator():

    def __init__(self):
        pass

    def generate(self, listOfStudents:list, term:Term):
        from ApprovalState import ApprovalState
        nteList, ueList, teList, fteList, mandatoryList = DataManager.getInstance().searchLecturesUntilTerm("",Term.Spring, TermYear.Senior)
        
        lecturesToAdvisor = list()
        for l in teList:
            if l.getTerm() == term:
                lecturesToAdvisor.append(l)
        for l in mandatoryList:
            if l.getTerm() == term:
                lecturesToAdvisor.append(l)

        listOfAdvisor = DataManager.getInstance().searchAdvisors("", FilterType.Name)


        for a in listOfAdvisor:
            schedule = Schedule()
            a.setSchedule(schedule)

        for l in lecturesToAdvisor:
            for i in range(0,len(listOfAdvisor)):
                instructor = listOfAdvisor[i]
                if instructor.checkScheduleForLecture(instructor.getSchedule(),l):
                    instructor.getSchedule().getListOfLectureSessions().append(l.getSessions()[0])
                    l.getSessions()[0].setInstructor(instructor)
                    break

        for s in listOfStudents:

            LRA = LectureRegistrationApplication()

            for l in mandatoryList:
                a = 0
                b = 0
                c = 0
                d = 0
                for la in s.availableLessons():
                    if l == la:
                        a=1
                if s.canTakeLecture(l,s.getTranscript()):
                    b = 1
                if s.checkScheduleForLecture(s.getSchedule(),l):
                    c = 1
                if len(l.getSessions()[0].getListOfStudents()) < l.getQuota():
                    d = 1
                if a == 1 and b == 1 and c == 1 and d == 1:
                    LRA.getSessionsSentForApproval()[l.getSessions()[0]] = ApprovalState.Pending
                    s.getSchedule().getListOfLectureSessions().append(l.getSessions()[0])
                    l.getSessions()[0].getListOfStudents().append(s)

            if s.getSchedule().getTermYear == TermYear.Senior:
                for l in ueList:
                    a = 0
                    b = 0
                    c = 0
                    d = 0
                    e = 0
                    for la in s.availableLessons():
                        if l == la:
                            a=1
                    if s.canTakeLecture(l,s.getTranscript()):
                        b = 1
                    if s.checkScheduleForLecture(s.getSchedule(),l):
                        c = 1
                    if l.getSessions(0).getStudentList().size < l.getQuota():
                        d = 1
                    if a==1 & b==1 & c==1 & d==1 & e==1:
                        e = e + 1 
                        LRA.getSessionsSentForApproval().append(l.getSessions(0))
                        s.getSchedule().append(l.getSessions(0))
                        l.getLectureSessions(0).getStudentList().append(s)

                for l in fteList:
                    a = 0
                    b = 0
                    c = 0
                    d = 0
                    e = 0
                    for la in s.availableLessons():
                        if l == la:
                            a=1
                    if s.canTakeLecture(l,s.getTranscript()):
                        b = 1
                    if s.checkScheduleForLecture(s.getSchedule(),l):
                        c = 1
                    if l.getSessions(0).getStudentList().size < l.getQuota():
                        d = 1
                    if a==1 & b==1 & c==1 & d==1 & e==1:
                        e = e + 1 
                        LRA.getSessionsSentForApproval().append(l.getSessions(0))
                        s.getSchedule().append(l.getSessions(0))
                        l.getLectureSessions(0).getStudentList().append(s)


        return listOfStudents

    def lectureTakenCalculaterFromType (self, student:Student, lecture : Lecture):
        a = 0


        student.getTranscript().getListOfSemester()



        return a
