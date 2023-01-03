##!/usr/bin/env python
# package: System#

from FilterType import FilterType
from DataManager import DataManager
from Student import Student
#import logger.Logger#

class StudentRegistrationSystem(object):
    #log = Logger()
    #scanner = Scanner()#

    #Holding registrationSystem object for returning after signing out#

    def __init__(self, registrationSystem):
        #Constructor of StudentRegistrationSystem#

        #self.log = Logger.getLogger("logs")
        #self.scanner = Scanner(System.in_)#
        self.registrationSystem1 = registrationSystem
        self.studentLogin()

    def studentLogin(self):
        #Searching for a Student with a given id. If there is an id equal with providedId currentUser is that Student.#

        currentUser = None
        #self.log.info("Please provide your ID:")
        #self.log.info("----\nSuggestion: Enter \"150119063\"")#
        while True:
            providedID = input()
            #Optional<Student> currentOptionalStudent = DataManager.getInstance().findStudent(providedID, FilterType.ID);#
            #if currentOptionalStudent.isPresent():
            #    currentUser = currentOptionalStudent.get()
            #    studentMenu(currentUser)
            #    break
            #else:
            #    self.log.info("Student not found, please try again: ")#

    def studentMenu(self, currentUser):
        #Showing Student's menu choices and making a choice#

        validInput = False
        menuChoice = 0
        while menuChoice != 6:
            #self.log.info("Please choose a menu: ")
            #self.log.info("1-Transcript")
            #self.log.info("2-Make Lecture Registration")
            #self.log.info("3-Schedule")
            #self.log.info("4-Registration Status")
            #self.log.info("5-Debt")
            #self.log.info("6-Sign Out")
            #self.log.info("----\nSuggestion: Enter \"2\" to go to he registration menu, then check by entering \"4\" to go to the status menu")#
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
                    pass
                    #self.log.info("The input is not valid, please provide a valid input.")#

    def signOut(self):
        #returning back to RegistrationSystem's menu#
        self.registrationSystem1.menu()
