from Person import Person
from LectureRegistrationApplication import LectureRegistrationApplication
from ApprovalState import ApprovalState

#from DataManager import DataManager

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

    """def debtMenu(self):
        # generated source for method debtMenu 

        if self.getDebt().getAmount() == 0:
            self.__log.info("You have no debt.")
        else:
            self.__log.info("Your debt is " + self.getDebt().getAmount() + "TL.")
            self.__log.info("1- Pay your debt")
            self.__log.info("2- Go back")
            while not validInput:
                payDebtChoice = scanner.nextInt()
                if payDebtChoice==1:
                    self.getDebt().setAmount(0)
                    validInput = True
                elif payDebtChoice==2:
                    validInput = True
                else:
                    self.__log.info("Please enter a valid input(1,2)")"""

    """def registrationStatusMenu(self):

        # generated source for method registrationStatusMenu 

        if self.getRegistirationApplication() == None:
            self.__log.info("You did not apply for registration.\n")
            return
        sessions = self.getRegistirationApplication().getSessionsSentForApproval()
        self.__log.info("")
        for s in sessions.keySet():
            self.__log.info("%s.%s%-15s%n", s.getLecture().getID(), s.getSessionID(), sessions.get(s).__str__())
        self.__log.info("")"""


    """def makeRegistrationMenu(self):

        # generated source for method makeRegistrationMenu 
        currentStudentAvailableLectures = self.availableLessons()

        self.__log.info("Lectures: ")
        i = 0
        while i < len(currentStudentAvailableLectures):
            for s in currentStudentAvailableLectures.get(i).getSessions():
                self.__log.info("Lecture Code: %-15sLecture Name: %-40sLecture Type: %-10sLecture Credit: %-4s%n", currentStudentAvailableLectures.get(i).getID() 
                + "." + s.getSessionID(), currentStudentAvailableLectures.get(i).__name__,
                 currentStudentAvailableLectures.get(i).getLectureType().__str__(), currentStudentAvailableLectures.get(i).getCredit())
            i += 1
        self.__log.info("Enter a lecture session code that you will send for approval.\n" 
        + "\"add lecture_id\" to add session for approval list.\n" + "\"remove lecture_id\" to remove session from approval list.\n" 
        + "Enter \"send\" to send\n" + "Enter \"exit\" to exit")

        chosenLectures = list()
        while True:
            self.parseSelectionCommand(input, chosenLectures)

            if input.lower() == "send".lower():
                self.sendForApproval(chosenLectures)
                #  currentUser.getAdvisor().approveApplication(currentUser.getRegistirationApplication());
                #  currentUser.setListOfLectureSessions(chosenLectures);
                break
            if input.lower() == "exit".lower():
                break"""

    """def parseSelectionCommand(self, input, chosenLectures):

        # generated source for method parseSelectionCommand 


        partedInput = []
        partedLectureID = []
        lectures = DataManager.getInstance().searchLecture("", FilterType.Name)
        if input.contains(" "):
            partedInput = input.split(" ")
        else:
            return
        if partedInput[1].contains("."):
            partedLectureID = partedInput[1].split("[.]")
        else:
            self.__log.info("Please enter a valid input.")
            return
        if partedInput[0].lower() == "add".lower():
            for l in lectures:
                if l.getID().lower() == partedLectureID[0].lower():
                    for ls in l.getSessions():
                        if ls.getSessionID().lower() == partedLectureID[1].lower():
                            chosenLectures.add(ls)

                            self.showChosenLectureSessions(chosenLectures)


                            return
            self.__log.info("Couldn't find %s", partedInput[1])
        if partedInput[0].lower() == "remove".lower():
            for l in lectures:
                if l.getID().lower() == partedLectureID[0].lower():
                    for ls in l.getSessions():
                        if ls.getSessionID().lower() == partedLectureID[1].lower():
                            chosenLectures.remove(ls)

                            self.showChosenLectureSessions(chosenLectures)


                            return
            self.__log.info("Couldn't find %s", partedInput[1])"""

    """def showChosenLectureSessions(self, chosenLectureSessions):

        # generated source for method showChosenLectureSessions 
        

        self.__log.info("Chosen Lectures:\n")
        for ls in chosenLectureSessions:
            self.__log.info("Lecture Code: %-15sLecture Name: %-40sLecture Type: %-10sLecture Credit: %-4s%n",
             ls.getLecture().getID() + "." + ls.getSessionID(), ls.getLecture().__name__,
              ls.getLecture().getLectureType().__str__(), ls.getLecture().getCredit())
        self.__log.info("\n\n\nEnter a lecture session code that you will send for approval.\n"
         + "\"add lecture_id\" to add session for approval list.\n" 
         + "\"remove lecture_id\" to remove session from approval list.\n" 
         + "Enter \"send\" to send\n" + "Enter \"exit\" to exit")"""

    def canTakeLecture(self, lecture, transcript):

        # generated source for method canTakeLecture 

        if self.__transcript == None:
            return True
        canTake = bool()
        listOfTaken = list()
        a = 0
        in_ = False
        i = 0
        while i < self.__transcript.getListOfSemester().size():
            semester = transcript.getListOfSemester().get(i)
            for lectureTaken in semester.keySet():
                listOfTaken.append(lectureTaken)

                if lectureTaken.getID() == lecture.getID():
                    a = i
                    in_ = True
            i += 1
        canTake = self.hasPreqLectureTaken(lecture.getPrerequisite(), listOfTaken)
        if canTake:
            if in_:
                canTake = self.takenPoint(lecture, transcript.getListOfSemester().get(a).getListOfLecturesTaken())
        return canTake

    def hasPreqLectureTaken(self, preqLecture, listOfLecture : list):
        # generated source for method hasPreqLectureTaken 


        if preqLecture == None:
            return True
        for lecture in listOfLecture:
            if lecture.getID() == preqLecture.getID:
                return True
        return False

    def takenPoint(self, lecture, listOfLecturesTaken : list):


        # generated source for method takenPoint 


        point = True
        if listOfLecturesTaken.get(lecture).getLetterGradeValue() > 1.99:
            point = False
        return point

    def availableLessons(self):

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
            if l.getTerm() == self.getSchedule().getTerm() and (l.getTermYear() == self.getSchedule().getTermYear()) and self.canTakeLecture(l, self.getTranscript()):
                availableLessons.append(l)
        return availableLessons

    def checkScheduleForLecture(self, schedule, lecture):

        chechResult = True
        listOfSessions = schedule.getListOfLectureSessions()
        listOfLectureSessions = lecture.getSessions()
        lectureHours = list()
        scheduleHours= list()

        for ses in listOfLectureSessions:
            for i in range(0,7):
                for j in range(0,10):
                    if ses.getSessionHours()[i][j] == 1:
                        lectureHours[i][j]=1
        
        for ses in listOfSessions:
            for i in range(0,7):
                for j in range(0,10):
                    if ses.getSessionHours()[i][j] == 1:
                        scheduleHours[i][j]=1
        
        for i in range(0,7):
            for j in range(0,10):
                if lectureHours[i][j] ==1 & scheduleHours[i][j] ==1:
                    chechResult = False

        return chechResult