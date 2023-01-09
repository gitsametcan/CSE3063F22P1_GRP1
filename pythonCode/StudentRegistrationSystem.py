from FilterType import FilterType
from DataManager import DataManager
from Logger import Logger

class StudentRegistrationSystem(object):

    #Holding registrationSystem object for returning after signing out

    def __init__(self, registrationSystem):
        #Constructor of StudentRegistrationSystem

        self.__log = Logger.getLogger("logs")

        self.__registrationSystem1 = registrationSystem
        self.studentLogin()

    def studentLogin(self):
        #Searching for a Student with a given id. If there is an id equal with providedId currentUser is that Student.

        self.__log.info("Please provide a Student ID:")
        self.__log.info("----\nSuggestion: Enter \"150119063\"")#
        while True:
            providedID = input()
            currentUser = DataManager.getInstance().findStudent(providedID, FilterType.ID)
            self.studentMenu(currentUser)

    def studentMenu(self, currentUser):
        #Showing Student's menu choices and making a choice#


        validInput = False
        menuChoice = str(0)
        while menuChoice != str(4):
            self.__log.info("Choose a menu: ")
            self.__log.info("1-Transcript")
            self.__log.info("2-Schedule")
            self.__log.info("3-Simulation Results")
            self.__log.info("4-Exit")
            
            validInput = False
            while not validInput:
                menuChoice = input()
                if menuChoice==str(1):
                    validInput = True
                    self.showTranscript(currentUser)
                elif menuChoice==str(2):
                    validInput = True
                    self.showSchedule(currentUser)
                elif menuChoice==str(3):
                    validInput = True
                    #showing student logs
                elif menuChoice==str(4):
                    validInput = True
                    self.signOut()
                else:
                    self.__log.info("The input is not valid, please provide a valid input.")#

    def showTranscript(self, currentUser):

        # generated source for method showTranscript 

        semesterSize = len(currentUser.getTranscript().getListOfSemester())
        i = 0
        while i < semesterSize:
            if i == 0:
                self.__log.info("1st Semester")
            elif i == 1:
                self.__log.info("2nd Semester")
            else:
                self.__log.info((i + 1) + "th Semester")
            self.__log.info("%-12s%-40s%-10s%-15s", "Lecture Code", "Lecture Name", "Credit", "Letter Grade")

            tempTakenLectures = currentUser.getTranscript().getListOfSemester()[i].getListOfLecturesTaken()


            for l in tempTakenLectures.keys():
                self.__log.info("%-12s%-40s%-10s%-15s%n", l.getID(), l.__name__, l.getCredit(), tempTakenLectures.get(l).__str__())
            self.__log.info("%-31s", "Credits taken in Semester:")
            self.__log.info(currentUser.getTranscript().getListOfSemester()[i].getCreditsTaken())
            self.__log.info("%-31s", "Credits completed in Semester:")
            self.__log.info(currentUser.getTranscript().getListOfSemester()[i].getCreditsCompleted())
            i += 1

    def showSchedule(self, currentUser):

        # generated source for method showSchedule 
        currentUser.getSchedule().showSchedule()


    def signOut(self):
        #returning back to RegistrationSystem's menu#
        self.__registrationSystem1.menu()
