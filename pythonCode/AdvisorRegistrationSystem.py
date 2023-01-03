from FilterType import FilterType
from DataManager import DataManager
from Advisor import Advisor
from Logger import Logger

class AdvisorRegistrationSystem():

    #Holding registrationSystem object for returning after signing out#

    def __init__(self, registrationSystem):
        #Constructor of AdvisorRegistrationSystem

        self.__log = Logger.getLogger("logs")

        self.__registrationSystem1 = registrationSystem
        self.advisorLogin()

    def advisorLogin(self):

        #Searching for a Advisor with a given id. If there is an id equal with providedId currentUser is that Advisor.#
        currentUser = None
        self.__log.info("Please provide your ID:")
        self.__log.info("----\nSuggestion: Enter \"150097\"")#
        while True:
            providedID = input()
            #Optional<Advisor> currentOptionalAdvisor = DataManager.getInstance().findAdvisor(providedID, FilterType.ID);#
            #if currentOptionalAdvisor.isPresent():
            #    currentUser = currentOptionalAdvisor.get()
            #    self.advisorMenu(currentUser)
            #    break
            #else:
            #    self.__log.info("Advisor not found, please try again: ")#

    def advisorMenu(self, currentUser):
        #Showing Advisor's menu choices and making a choice#
        validInput = False
        menuChoice = 0
        while menuChoice != 3:
            self.__log.info("Please choose a menu: ")
            self.__log.info("1-Registration Applications")
            self.__log.info("2-Sign Out")#

            validInput = False
            while not validInput:
                menuChoice = input()
                if menuChoice==1:
                    validInput = True
                    currentUser.showApplications()
                elif menuChoice==2:
                    validInput = True
                    self.signOut()
                else:
                    self.__log.info("The input is not valid, please provide a valid input.")

    def signOut(self):
        #returning back to RegistrationSystem's menu#
        self.__registrationSystem1.menu()
