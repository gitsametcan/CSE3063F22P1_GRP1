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
        from Logger import Logger
        self.__log = Logger.getLogger("logs")

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
                lectureAvaileble = False
                canTakeLecture = False
                isScheduleAvaliable = False
                quotaSituation = False
                e = 0
                for la in s.availableLessons():
                    if l == la:
                        lectureAvaileble = True
                if s.canTakeLecture(l,s.getTranscript()):
                    canTakeLecture = True
                if s.checkScheduleForLecture(s.getSchedule(),l):
                    isScheduleAvaliable = True
                if l.getSessions(0).getStudentList().size < l.getQuota():
                    quotaSituation = True
                    
                if not lectureAvaileble:
                    self.__log.info(" Student number {id} could not take lecture {lecture} because of lecture is not availeble".format(id=s.getID(),lecture = l.getName()))
                    
                if not quotaSituation:
                    self.__log.info(" Student number {id} could not take lecture {lecture} because of lecture quota is full".format(id=s.getID(),lecture = l.getName()))
                    
                if not canTakeLecture:
                    self.__log.info(" Student number {id} could not take lecture {lecture} because of prequisite lecture is not succes or the lecture already given with CC Letter grade or more".format(id=s.getID(),lecture = l.getName()))

                if not isScheduleAvaliable:
                    self.__log.info(" Student number {id} could not take lecture {lecture} because of Schedule is not availeble".format(id=s.getID(),lecture = l.getName()))

                if lectureAvaileble and canTakeLecture and isScheduleAvaliable and quotaSituation and e!=1:
                    e = e + 1 
                    LRA.getSessionsSentForApproval().append(l.getSessions(0))
                    s.getSchedule().append(l.getSessions(0))
                    l.getLectureSessions(0).getStudentList().append(s)

            if s.getSchedule().getTermYear == TermYear.Senior:
                for l in ueList:
                    lectureAvaileble = False
                    canTakeLecture = False
                    isScheduleAvaliable = False
                    quotaSituation = False
                    e = 0
                    for la in s.availableLessons():
                        if l == la:
                            lectureAvaileble = True
                    if s.canTakeLecture(l,s.getTranscript()):
                        canTakeLecture = True
                    if s.checkScheduleForLecture(s.getSchedule(),l):
                        isScheduleAvaliable = True
                    if l.getSessions(0).getStudentList().size < l.getQuota():
                        quotaSituation = True
                    
                    if not lectureAvaileble:
                        self.__log.info(" Student number {id} could not take lecture {lecture} because of lecture is not availeble".format(id=s.getID(),lecture = l.getName()))
                    
                    if not quotaSituation:
                        self.__log.info(" Student number {id} could not take lecture {lecture} because of lecture quota is full".format(id=s.getID(),lecture = l.getName()))
                    
                    if not canTakeLecture:
                        self.__log.info(" Student number {id} could not take lecture {lecture} because of prequisite lecture is not succes or the lecture already given with CC Letter grade or more".format(id=s.getID(),lecture = l.getName()))

                    if not isScheduleAvaliable:
                        self.__log.info(" Student number {id} could not take lecture {lecture} because of Schedule is not availeble".format(id=s.getID(),lecture = l.getName()))

                    if lectureAvaileble and canTakeLecture and isScheduleAvaliable and quotaSituation and e!=1:
                        e = e + 1 
                        LRA.getSessionsSentForApproval().append(l.getSessions(0))
                        s.getSchedule().append(l.getSessions(0))
                        l.getLectureSessions(0).getStudentList().append(s)

                for l in fteList:
                    lectureAvaileble = False
                    canTakeLecture = False
                    isScheduleAvaliable = False
                    quotaSituation = False
                    e = 0
                    for la in s.availableLessons():
                        if l == la:
                            lectureAvaileble = True
                    if s.canTakeLecture(l,s.getTranscript()):
                        canTakeLecture = True
                    if s.checkScheduleForLecture(s.getSchedule(),l):
                        isScheduleAvaliable = True
                    if l.getSessions(0).getStudentList().size < l.getQuota():
                        quotaSituation = True
                    
                    if not lectureAvaileble:
                        self.__log.info(" Student number {id} could not take lecture {lecture} because of lecture is not availeble".format(id=s.getID(),lecture = l.getName()))
                    
                    if not quotaSituation:
                        self.__log.info(" Student number {id} could not take lecture {lecture} because of lecture quota is full".format(id=s.getID(),lecture = l.getName()))
                    
                    if not canTakeLecture:
                        self.__log.info(" Student number {id} could not take lecture {lecture} because of prequisite lecture is not succes or the lecture already given with CC Letter grade or more".format(id=s.getID(),lecture = l.getName()))

                    if not isScheduleAvaliable:
                        self.__log.info(" Student number {id} could not take lecture {lecture} because of Schedule is not availeble".format(id=s.getID(),lecture = l.getName()))

                    if lectureAvaileble and canTakeLecture and isScheduleAvaliable and quotaSituation and e!=1:
                        e = e + 1 
                        LRA.getSessionsSentForApproval().append(l.getSessions(0))
                        s.getSchedule().append(l.getSessions(0))
                        l.getLectureSessions(0).getStudentList().append(s)

        s.setRegistirationApplication(LRA)

        return listOfStudents

    def lectureTakenCalculaterFromType (self, student:Student, lecture : Lecture):
        a = 0


        student.getTranscript().getListOfSemester()



        return a
