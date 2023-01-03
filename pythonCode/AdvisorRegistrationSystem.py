from FilterType import FilterType
from DataManager import DataManager
from Advisor import Advisor
#import logger.Logger#

class AdvisorRegistrationSystem():
    #log = Logger()
    #scanner = Scanner()#

    #Holding registrationSystem object for returning after signing out#

    def __init__(self, registrationSystem):
        #Constructor of InstructorRegistrationSystem#

        #self.log = Logger.getLogger("logs")
        #self.scanner = Scanner(System.in_)#

        self.registrationSystem1 = registrationSystem
        self.advisorLogin()

    def advisorLogin(self):

        #Searching for a Advisor with a given id. If there is an id equal with providedId currentUser is that Advisor.#
        currentUser = None
        self.log.info("Please provide your ID:")
        self.log.info("----\nSuggestion: Enter \"150097\"")#
        while True:
            providedID = input()
            #Optional<Advisor> currentOptionalAdvisor = DataManager.getInstance().findAdvisor(providedID, FilterType.ID);#
            if currentOptionalAdvisor.isPresent():
                currentUser = currentOptionalAdvisor.get()
                self.advisorMenu(currentUser)
                break
            else:
                self.log.info("Advisor not found, please try again: ")#

    def advisorMenu(self, currentUser):
        #Showing Advisor's menu choices and making a choice#
        validInput = False
        menuChoice = 0
        while menuChoice != 3:
            #self.log.info("Please choose a menu: ")
            #self.log.info("1-Registration Applications")
            #self.log.info("2-Sign Out")#

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
                    pass
                    #self.log.info("The input is not valid, please provide a valid input.")

    def signOut(self):
        #returning back to RegistrationSystem's menu#

        
        self.registrationSystem1.menu()