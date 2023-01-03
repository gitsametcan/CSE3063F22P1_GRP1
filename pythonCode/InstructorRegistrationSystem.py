from FilterType import FilterType
from DataManager import DataManager
from Instructor import Instructor
from Logger import Logger

class InstructorRegistrationSystem():

    #Holding registrationSystem object for returning after signing out

    def __init__(self, registrationSystem):
        #Constructor of InstructorRegistrationSystem

        self.__log = Logger.getLogger("logs")
        self.__registrationSystem1 = registrationSystem

    def instructorLogin(self):

        #Searching for a Instructor with a given id. If there is an id equal with providedId currentUser is that Instructor.

        currentUser = None
        self.__log.info("Please provide your ID:")
        self.__log.info("----\nSuggestion: Enter \"150097\"")
        while True:
            providedID = input()
            #Optional<Instructor> currentOptionalAdvisor = DataManager.getInstance().findInstructor(providedID,FilterType.ID)
            #if currentOptionalAdvisor.isPresent():
             #       currentUser = currentOptionalAdvisor.get()
              #      self.instructorMenu(currentUser)
               #     break
                #else:
                 #   self.__log.info("Instructor not found, please try again: ")

    def instructorMenu(self, currentUser):
        #Showing Instructor's menu choices and making a choice
        validInput = False
        menuChoice = 0
        while menuChoice != 3:
            self.__log.info("Please choose a menu: ")
            self.__log.info("1-Show Lecture Sessions")
            self.__log.info("2-Show Students Of A Lecture Session")
            self.__log.info("3-Sign Out")

            validInput = False
            while not validInput:
                menuChoice = input()
                if menuChoice==1:
                    validInput = True
                    self.showLectures(currentUser)
                elif menuChoice==2:
                    validInput = True
                    self.showStudents(currentUser)
                elif menuChoice==3:
                    validInput = True
                    self.signOut()
                else:
                    self.__log.info("The input is not valid, please provide a valid input.")

    def showLectures(self, currentUser):
        # generated source for method showLectures 
        schedule = currentUser.getSchedule()
        listOfLectureSessions = schedule.getListOfLectureSessions()
        for lectureSession in listOfLectureSessions:
            self.__log.info(lectureSession.getLecture().getName() + "." + lectureSession.getSessionID())
            self.__log.info("---------------------------------------")
            self.__log.info("Quota: " + lectureSession.getLecture().getQuota())
            self.__log.info("Number Of Students: " + lectureSession.getListOfStudents().size() + "\n")
            self.__log.info("---------------------------------------")

        schedule.showSchedule()

    def showStudents(self, currentUser):
        # generated source for method showStudents 
        count = 0
        for lectureSession in currentUser.getSchedule().getListOfLectureSessions():
            count += 1
            self.__log.info(count + ". " + lectureSession.getLecture().getName() + "." + lectureSession.getSessionID())
        self.__log.info("Choose A Session: ")
        sessionChoice = input()
        lectureSession = currentUser.getSchedule().getListOfLectureSessions().get(sessionChoice - 1)
        for student in lectureSession.getListOfStudents():
            self.__log.info("ID: " + student.getID() + "Name: " + student.getFullName())


    def signOut(self):
        #returning back to RegistrationSystem's menu
        self.__registrationSystem1.menu()
