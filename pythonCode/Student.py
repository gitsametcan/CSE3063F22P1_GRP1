from Logger import Logger;

from Person import Person
from StudentID import StudentID

class Student(Person):
    # generated source for class Student 
    #__log = Logger()
    #__advisor = Advisor()
    #__id = StudentID()
    #__schedule = Schedule()
    #__transcript = Transcript()
    #__dateOfEntry = Calendar()
    #__debt = Debt()
    #__registirationApplication = LectureRegistrationApplication()
    #__scanner = input()
    def __init__(self):
        #super(firstName, lastName)
        self.__log = Logger.getLogger("logs")
        self.scanner = input()
        self.__id = StudentID()
        self.__schedule = Schedule()
        self.__transcript = Transcript()
        self.__dateOfEntry = Calendar()
        pass
    def setID(self, nID):        
        self.id.setID(nID)
    def setID(self,DepartmentCode, YearCode, OrderOfPlacement):        
        self.setID(DepartmentCode, YearCode, OrderOfPlacement)
    def setTranscript(self,transcript):     
        self.transcript(transcript)
    def setDateOfEntry(self,dateOfEntry):       
        self.dateOfEntry(dateOfEntry)
    def getAdvisor(self):      
        return self.advisor
    def setAdvisor(self,advisor):       
        self.advisor(advisor)
    def getDebt(self):        
        return self.debt
    def setDebt(self,dateOfEntry):       
        self.dateOfEntry(dateOfEntry)
    def getRegistirationApplication(self):       
        return self.registirationApplication
    def setRegistirationApplication(self,registirationApplication):        

        self.registirationApplication(registirationApplication)
    def getID(self):       
        return id.getID()
    def getSchedule(self):       
        return self.schedule


    def setSchedule(self,schedule):       

        self.schedule(schedule)
    def getTranscript(self):        
        return self.transcript
    def getDateOfEntry(self):        
        return self.dateOfEntry
    def sendForApproval(self, chosenLectureSessions):

        # generated source for method sendForApproval 
        approvalList = None

        for ls in chosenLectureSessions:
            approvalList.put(ls, ApprovalState.Pending)
        self.registirationApplication = LectureRegistrationApplication(approvalList, self.advisor, self)
        self.advisor.getListOfApplications().add(self.registirationApplication)
    def showTranscript(self):

        # generated source for method showTranscript 

        semesterSize = self.getTranscript().getListOfSemester().size()
        i = 0
        while i < semesterSize:
            if i == 0:
                self.__log.info("1st Semester")
            elif i == 1:
                self.__log.info("2nd Semester")
            else:
                self.__log.info((i + 1) + "th Semester")
            self.__log.info("%-12s%-40s%-10s%-15s", "Lecture Code", "Lecture Name", "Credit", "Letter Grade")

            tempTakenLectures = self.getTranscript().getListOfSemester().get(i).getListOfLecturesTaken()


            for l in tempTakenLectures.keySet():
                self.__log.info("%-12s%-40s%-10s%-15s%n", l.getID(), l.__name__, l.getCredit(), tempTakenLectures.get(l).__str__())
            self.__log.info("%-31s", "Credits taken in Semester:")
            self.__log.info("" + self.getTranscript().getListOfSemester().get(i).getCreditsTaken())
            self.__log.info("%-31s", "Credits completed in Semester:")
            self.__log.info("" + self.getTranscript().getListOfSemester().get(i).getCreditsCompleted())
            i += 1

    def showSchedule(self):

        # generated source for method showSchedule 
        self.getSchedule().showSchedule()
    def debtMenu(self):
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
                    self.__log.info("Please enter a valid input(1,2)")

    def registrationStatusMenu(self):

        # generated source for method registrationStatusMenu 


        if self.getRegistirationApplication() == None:
            self.__log.info("You did not apply for registration.\n")
            return
        sessions = self.getRegistirationApplication().getSessionsSentForApproval()
        self.__log.info("")
        for s in sessions.keySet():
            self.__log.info("%s.%s%-15s%n", s.getLecture().getID(), s.getSessionID(), sessions.get(s).__str__())
        self.__log.info("")

    def makeRegistrationMenu(self):

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

        chosenLectures = List()
        while True:
            self.parseSelectionCommand(input, chosenLectures)


            if input.lower() == "send".lower():
                self.sendForApproval(chosenLectures)
                #  currentUser.getAdvisor().approveApplication(currentUser.getRegistirationApplication());
                #  currentUser.setListOfLectureSessions(chosenLectures);
                break
            if input.lower() == "exit".lower():
                break

    def parseSelectionCommand(self, input, chosenLectures):

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
            self.__log.info("Couldn't find %s", partedInput[1])

    def showChosenLectureSessions(self, chosenLectureSessions):

        # generated source for method showChosenLectureSessions 


        self.__log.info("Chosen Lectures:\n")
        for ls in chosenLectureSessions:
            self.__log.info("Lecture Code: %-15sLecture Name: %-40sLecture Type: %-10sLecture Credit: %-4s%n",
             ls.getLecture().getID() + "." + ls.getSessionID(), ls.getLecture().__name__,
              ls.getLecture().getLectureType().__str__(), ls.getLecture().getCredit())
        self.__log.info("\n\n\nEnter a lecture session code that you will send for approval.\n"
         + "\"add lecture_id\" to add session for approval list.\n" 
         + "\"remove lecture_id\" to remove session from approval list.\n" 
         + "Enter \"send\" to send\n" + "Enter \"exit\" to exit")

    def canTakeLecture(self, lecture, transcript):

        # generated source for method canTakeLecture 


        if transcript == None:
            return True
        canTake = bool()
        listOfTaken = List()
        a = 0
        in_ = False
        i = 0
        while i < transcript.getListOfSemester().size():

            for lectureTaken in Semester.getListOfLecturesTaken().keySet():


                listOfTaken.add(lectureTaken)
                if lectureTaken.__name__ == lecture.__name__:
                    a = i
                    in_ = True
            i += 1
        if canTake == hasPreqLectureTaken(lecture.getPrerequisite(), listOfTaken):
            if in_:
                canTake = self.takenPoint(lecture, transcript.getListOfSemester().get(a).getListOfLecturesTaken())
        return canTake

    def hasPreqLectureTaken(self, preqLecture, listOfLecture):
        # generated source for method hasPreqLectureTaken 


        if preqLecture == None:
            return True
        for lecture in listOfLecture:
            if lecture.__name__ == preqLecture.__name__:
                return True
        return False

    def takenPoint(self, lecture, listOfLecturesTaken):


        # generated source for method takenPoint 


        point = True
        if listOfLecturesTaken.get(lecture).getLetterGradeValue() > 1.99:
            point = False
        return point

    def availableLessons(self):

        # generated source for method availableLessons 
        availableLessons = List()

        lecturesUntilNow = DataManager.getInstance().searchLectureUntilTerm(self.getSchedule().getTerm(), self.getSchedule().getTermYear())
        for l in lecturesUntilNow:
            if l.getTerm() == self.getSchedule().getTerm() and l.getTermYear() == self.getSchedule().getTermYear() and canTakeLecture(l, self.getTranscript()):
                availableLessons.add(l)
        return availableLessons




