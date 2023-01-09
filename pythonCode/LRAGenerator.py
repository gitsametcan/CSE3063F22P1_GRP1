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
        self.__log.info("Initiating LectureRegistrationApplication Generation...")
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
                print(l.getID())
                lectureAvaileble = False
                canTakeLecture = False
                isScheduleAvaliable = False
                quotaSituation = False
                e = 0
                #aavleslis = s.availableLessons(l)
                #print("bir kere gel")
                #for la in aavleslis:
                 #   if l.getID() == la.getID():
                  #      print(l.getID()+" to "+la.getID())
                   #     input()
                    #    lectureAvaileble = 1
                     #   print(lectureAvaileble)
                if s.availableLessons(l):
                    lectureAvaileble = True
                #print(str(lectureAvaileble) + " disarisi")
                if s.canTakeLecture(l,s.getTranscript()):
                    canTakeLecture = True

                #print(str(lectureAvaileble) + " disarisi22222")

                if s.checkScheduleForLecture(s.getSchedule(),l):
                    isScheduleAvaliable = True
                if len(l.getSessions()[0].getListOfStudents()) < l.getQuota():
                    quotaSituation = True
                    
                if lectureAvaileble == 0 :
                    self.__log.info(" Student number {id} could not take lecture {lecture} because of lecture is not availeble".format(id=s.getID(),lecture = l.getName()))
                    
                if not quotaSituation:
                    self.__log.info(" Student number {id} could not take lecture {lecture} because of lecture quota is full".format(id=s.getID(),lecture = l.getName()))
                    
                if not canTakeLecture:
                    self.__log.info(" Student number {id} could not take lecture {lecture} because of prequisite lecture is not succes or the lecture already given with CC Letter grade or more".format(id=s.getID(),lecture = l.getName()))
                #input()
                if not isScheduleAvaliable:
                    self.__log.info(" Student number {id} could not take lecture {lecture} because of Schedule is not availeble".format(id=s.getID(),lecture = l.getName()))

                if lectureAvaileble and canTakeLecture and isScheduleAvaliable and quotaSituation:
                    #print("aldi")

                    e = e + 1 

                    print(e)
                    ssaprovar = LRA.getSessionsSentForApproval()
                    ssaprovar[l.getSessions()[0]] = ApprovalState.Pending
                    LRA.setSessionsSentForApproval(ssaprovar)
                    #print(len(LRA.getSessionsSentForApproval()))
                    
                    
                    
                    slist = s.getSchedule().getListOfLectureSessions()
                    slist.append(l.getSessions()[0])
                    s.getSchedule().setListOfLectureSessions(slist)
                    print(s.getSchedule().getListOfLectureSessions()[0])


                    llist = l.getSessions()[0].getListOfStudents()
                    llist.append(s)
                    l.getSessions()[0].setListOfStudents(llist)
                

            if s.getSchedule().getTermYear == TermYear.Senior:
                for l in ueList:
                    lectureAvaileble = False
                    canTakeLecture = False
                    isScheduleAvaliable = False
                    quotaSituation = False
                    e = 0
                    if s.availableLessons(l):
                        lectureAvaileble = True
                    if s.canTakeLecture(l,s.getTranscript()):
                        canTakeLecture = True
                    if s.checkScheduleForLecture(s.getSchedule(),l):
                        isScheduleAvaliable = True
                    if len(l.getSessions()[0].getListOfStudents()) < l.getQuota():
                        quotaSituation = True
                    
                    if not lectureAvaileble:
                        self.__log.info(" Student number {id} could not take lecture {lecture} because of lecture is not availeble".format(id=s.getID(),lecture = l.getName()))
                    
                    if not quotaSituation:
                        self.__log.info(" Student number {id} could not take lecture {lecture} because of lecture quota is full".format(id=s.getID(),lecture = l.getName()))
                    
                    if not canTakeLecture:
                        self.__log.info(" Student number {id} could not take lecture {lecture} because of prequisite lecture is not succes or the lecture already given with CC Letter grade or more".format(id=s.getID(),lecture = l.getName()))

                    if not isScheduleAvaliable:
                        self.__log.info(" Student number {id} could not take lecture {lecture} because of Schedule is not availeble".format(id=s.getID(),lecture = l.getName()))
                    #input()
                    if lectureAvaileble and canTakeLecture and isScheduleAvaliable and quotaSituation and e!=1:
                        print("ders aliyor")
                        #input()
                        e = e + 1 
                        LRA.getSessionsSentForApproval()[l.getSessions()[0]] = ApprovalState.Pending
                        slist = s.getSchedule().getListOfLectureSessions()
                        slist.append(l.getSessions()[0])
                        s.getSchedule().setListOfLectureSessions(slist)
                        llist = l.getSessions()[0].getListOfStudents()
                        llist.append(s)
                        l.getSessions()[0].setListOfStudents(llist)

                for l in fteList:
                    lectureAvaileble = False
                    canTakeLecture = False
                    isScheduleAvaliable = False
                    quotaSituation = False
                    e = 0
                    if s.availableLessons(l):
                        lectureAvaileble = True
                    if s.canTakeLecture(l,s.getTranscript()):
                        canTakeLecture = True
                    if s.checkScheduleForLecture(s.getSchedule(),l):
                        isScheduleAvaliable = True
                    if len(l.getSessions()[0].getListOfStudents()) < l.getQuota():
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
                        LRA.getSessionsSentForApproval()[l.getSessions()[0]] = ApprovalState.Pending
                        slist = s.getSchedule().getListOfLectureSessions()
                        slist.append(l.getSessions()[0])
                        s.getSchedule().setListOfLectureSessions(slist)
                        llist = l.getSessions()[0].getListOfStudents()
                        llist.append(s)
                        l.getSessions()[0].setListOfStudents(llist)

            print(len(LRA.getSessionsSentForApproval()))

            s.setRegistirationApplication(LRA)
            print(len(s.getRegistirationApplication().getSessionsSentForApproval()))
            for ls in s.getRegistirationApplication().getSessionsSentForApproval().keys():            
                print(ls.getLecture().getID())
        return listOfStudents

    def lectureTakenCalculaterFromType (self, student:Student, lecture : Lecture):
        a = 0


        student.getTranscript().getListOfSemester()



        return a
