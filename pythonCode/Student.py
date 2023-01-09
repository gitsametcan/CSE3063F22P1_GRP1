from Person import Person
from LectureRegistrationApplication import LectureRegistrationApplication
from ApprovalState import ApprovalState
from Lecture import Lecture

class Student(Person):
    
    def __init__(self):
        pass

    def setID(self, nID):        
        self.__id = nID

    def setTranscript(self,transcript):     
        self.__transcript = transcript

    def setDateOfEntry(self,dateOfEntry):       
        self.__dateOfEntry = dateOfEntry

    def getAdvisor(self):      
        return self.__advisor

    def setAdvisor(self,advisor):       
        self.__advisor = advisor

    def getDebt(self):        
        return self.__debt

    def setDebt(self, debt):       
        self.__debt = debt

    def getRegistirationApplication(self):       
        return self.__registirationApplication

    def setRegistirationApplication(self,registirationApplication):        
        self.__registirationApplication = registirationApplication

    def getID(self):       
        return self.__id.getID()

    def getSchedule(self):       
        return self.__schedule

    def setSchedule(self,schedule):       
        self.__schedule = schedule

    def getTranscript(self):        
        return self.__transcript

    def getDateOfEntry(self):        
        return self.__dateOfEntry

    def sendForApproval(self, chosenLectureSessions : list):

        # generated source for method sendForApproval 
        approvalList = dict()

        for ls in chosenLectureSessions:
            approvalList[ls] = ApprovalState.Pending
        #adding lectureSessions and pending state to student's RegistrationApplication
        self.__registirationApplication = LectureRegistrationApplication()
        self.__registirationApplication.setAdvisor(self.__advisor)
        self.__registirationApplication.setSsessionsSentForApproval(approvalList)
        self.__registirationApplication.setStudent(self)
        self.__advisor.getListOfApplications().add(self.__registirationApplication)

    def canTakeLecture(self, lecture, transcript):

        # generated source for method canTakeLecture 

        if self.__transcript is None:
            return True
        canTake = False
        listOfTaken = dict()
        a = 0
        in_ = True
        i = 0

        while i < len(transcript.getListOfSemester()):
            semester = transcript.getListOfSemester()[i]
            for l in semester.getListOfLecturesTaken():
                listOfTaken[l] = semester.getListOfLecturesTaken()[l]
            i += 1
        
        canTake = self.hasPreqLectureTaken(lecture.getPrerequisite(), listOfTaken)

        if canTake:
            if in_:
                listLecture = dict()
                for b in range(0,len(transcript.getListOfSemester())):
                    semester = transcript.getListOfSemester()[b]
                    for l in semester.getListOfLecturesTaken():
                        listLecture[l] = semester.getListOfLecturesTaken()[l]

                canTake = self.takenPoint(lecture, listLecture)
        return canTake

    def hasPreqLectureTaken(self, preqLecture, listOfLecture : dict):

        if preqLecture is None:
            return True
        for lecture in listOfLecture.keys():
            if lecture.getID() == preqLecture.getID():
                if listOfLecture[lecture].value > 0.4:
                    return True
        return False

    def takenPoint(self, lecture, listOfLecturesTaken : dict):

        point = True
        try:
            x = listOfLecturesTaken[lecture].value
        except KeyError:
            return True

        if listOfLecturesTaken[lecture].value > 1.99:
            point = False
        return point

    def availableLessons(self, lecture:Lecture):
        from DataManager import DataManager
        # generated source for method availableLessons 
        availableLessons = list()
        lecturesUntilNow = list()

        ml,ul,el,tl,ntl = DataManager.getInstance().searchLecturesUntilTerm("", self.getSchedule().getTerm(), self.getSchedule().getTermYear())
        for l in ml:
            lecturesUntilNow.append(l)
        for l in ul:
            lecturesUntilNow.append(l)
        for l in el:
            lecturesUntilNow.append(l)
        for l in tl:
            lecturesUntilNow.append(l)
        for l in ntl:
            lecturesUntilNow.append(l)

        for l in lecturesUntilNow:
            if l is None:
                continue
            if l.getTerm() == self.getSchedule().getTerm() and (l.getTermYear() == self.getSchedule().getTermYear()) and self.canTakeLecture(l, self.getTranscript()):
                availableLessons.append(l)

        for lectureIn in availableLessons:
            if lecture.getID() == lectureIn.getID():
                return True
        return False

    def checkScheduleForLecture(self, schedule, lecture):

        chechResult = True
        listOfSessions = schedule.getListOfLectureSessions()
        listOfLectureSessions = lecture.getSessions()
        lectureHours = list()
        scheduleHours = list()

        for ses in listOfLectureSessions:
            for i in ses.getSessionHours():
                day = list()
                for j in i:
                    if j == 1:
                        day.append(1)
                    else:
                        day.append(0)
                lectureHours.append(day)
        if listOfSessions is not None:
            for ses in listOfSessions:
                for i in ses.getSessionHours():
                    day = list()
                    for j in i:
                        if j == 1:
                            day.append(1)
                        else:
                            day.append(0)
                    scheduleHours.append(day)
        
        for i in range(0,7):
            for j in range(0,10):
                if lectureHours[i][j] == 1 and scheduleHours[i][j] == 1:
                    chechResult = False

        return chechResult