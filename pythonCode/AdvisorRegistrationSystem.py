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
        self.__log.info("Please provide an Advisor ID:")
        self.__log.info("----\nSuggestion: Enter \"150097\"")#
        while True:
            providedID = input()
            currentUser = DataManager.getInstance().findAdvisor(providedID, FilterType.ID)
            self.advisorMenu(currentUser)

    def advisorMenu(self, currentUser):
        #Showing Advisor's menu choices and making a choice#
        validInput = False
        menuChoice = str(0)
        while menuChoice != str(2):
            self.__log.info("Choose a menu: ")
            self.__log.info("1-Simulation Results")
            self.__log.info("2-Exit")

            validInput = False
            while not validInput:
                menuChoice = input()
                if menuChoice==str(1):
                    validInput = True
                    #simulasyon sonuçları
                elif menuChoice==str(2):
                    validInput = True
                    self.signOut()
                else:
                    self.__log.info("The input is not valid, please provide a valid input.")

    def signOut(self):
        #returning back to RegistrationSystem's menu#
        self.__registrationSystem1.menu()
