"""#!/usr/bin/env python
# package: System"""

import Enums.FilterType
import data.DataManager
import person.Instructor
"""import logger.Logger"""

class InstructorRegistrationSystem(object):
    """log = Logger()
    scanner = Scanner()"""

    """Holding registrationSystem object for returning after signing out"""
    registrationSystem1 =  None

    def __init__(self, registrationSystem):
        """Constructor of InstructorRegistrationSystem"""

        """self.log = Logger.getLogger("logs")
        self.scanner = Scanner(System.in_)"""
        self.registrationSystem1 = registrationSystem
        self.instructorLogin()

    def instructorLogin(self):
        """Searching for a Instructor with a given id. If there is an id equal with providedId currentUser is that Instructor."""

        currentUser = None
        """self.log.info("Please provide your ID:")
        self.log.info("----\nSuggestion: Enter \"150097\"")"""
        while True:
            providedID = input()
            """Optional<Instructor> currentOptionalAdvisor = DataManager.getInstance().findInstructor(providedID,FilterType.ID)"""
            """if currentOptionalAdvisor.isPresent():
                    currentUser = currentOptionalAdvisor.get()
                    self.instructorMenu(currentUser)
                    break
                else:
                    self.log.info("Instructor not found, please try again: ")"""

    def instructorMenu(self, currentUser):
        """Showing Instructor's menu choices and making a choice"""
        validInput = False
        menuChoice = 0
        while menuChoice != 3:
            """self.log.info("Please choose a menu: ")
            self.log.info("1-Show Lecture Sessions")
            self.log.info("2-Show Students Of A Lecture Session")
            self.log.info("3-Sign Out")"""
            validInput = False
            while not validInput:
                menuChoice = input()
                if menuChoice==1:
                    validInput = True
                    currentUser.showLectures()
                elif menuChoice==2:
                    validInput = True
                    currentUser.showStudents()
                elif menuChoice==3:
                    validInput = True
                    self.signOut()
                else:
                    """self.log.info("The input is not valid, please provide a valid input.")"""

    def signOut(self):
        """returning back to RegistrationSystem's menu"""
        self.registrationSystem1.menu()