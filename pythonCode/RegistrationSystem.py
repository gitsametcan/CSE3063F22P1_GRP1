import sys
from Simulation import Simulation
from StudentRegistrationSystem import StudentRegistrationSystem
from AdvisorRegistrationSystem import AdvisorRegistrationSystem
from InstructorRegistrationSystem import InstructorRegistrationSystem
from Logger import Logger

class RegistrationSystem(object):


    def __init__(self):
        self.__simulation = Simulation()
        #Constructor of RegistrationSystem

        self.__log = Logger.getLogger("logs")

    def menu(self):
        #Prints menu choices

        while True:
            self.__log.info("Log in as...")
            self.__log.info("1-Student")
            self.__log.info("2-Instructor")
            self.__log.info("3-Advisor")
            self.__log.info("4-Simulation")
            self.__log.info("5-Exit")

            loginType = input()
            if loginType==1:
                StudentRegistrationSystem(self)
            elif loginType==2:
                InstructorRegistrationSystem(self)
            elif loginType==3:
                AdvisorRegistrationSystem(self)
            elif loginType==4:
                self.__log.info("Initiating simulation...")
                self.__simulation.run()
                self.__log.info("Done.")
            elif loginType==5:
                self.__log.info("Exiting...")
                sys.exit("Exit...")
            else:
                self.__log.info("The input is not valid, please provide a valid input.")
