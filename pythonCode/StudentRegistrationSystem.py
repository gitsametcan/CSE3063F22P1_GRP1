from FilterType import FilterType
from DataManager import DataManager
from Student import Student
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

        currentUser = None
        self.__log.info("Please provide your ID:")
        self.__log.info("----\nSuggestion: Enter \"150119063\"")#
        while True:
            providedID = input()
            #Optional<Student> currentOptionalStudent = DataManager.getInstance().findStudent(providedID, FilterType.ID);#
            #if currentOptionalStudent.isPresent():
            #    currentUser = currentOptionalStudent.get()
            #    studentMenu(currentUser)
            #    break
            #else:
            #    self.__log.info("Student not found, please try again: ")#

    def studentMenu(self, currentUser):
        #Showing Student's menu choices and making a choice#


        validInput = False
        menuChoice = 0
        while menuChoice != 6:
            self.__log.info("Please choose a menu: ")
            self.__log.info("1-Transcript")
            self.__log.info("2-Make Lecture Registration")
            self.__log.info("3-Schedule")
            self.__log.info("4-Registration Status")
            self.__log.info("5-Debt")
            self.__log.info("6-Sign Out")
            self.__log.info("----\nSuggestion: Enter \"2\" to go to he registration menu, then check by entering \"4\" to go to the status menu")#

            validInput = False
            while not validInput:
                menuChoice = input()
                if menuChoice==1:
                    validInput = True
                    currentUser.showTranscript()
                elif menuChoice==2:
                    validInput = True
                    currentUser.makeRegistrationMenu()
                elif menuChoice==3:
                    validInput = True
                    currentUser.showSchedule()
                elif menuChoice==4:
                    validInput = True
                    currentUser.registrationStatusMenu()
                elif menuChoice==5:
                    validInput = True
                    currentUser.debtMenu()
                elif menuChoice==6:
                    validInput = True
                    self.signOut()
                else:
                    self.__log.info("The input is not valid, please provide a valid input.")#

    def signOut(self):
        #returning back to RegistrationSystem's menu#
        self.__registrationSystem1.menu()

