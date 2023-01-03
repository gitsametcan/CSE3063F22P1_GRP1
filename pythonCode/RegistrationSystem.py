#/usr/bin/env python
#package: System"""

#import logger.Logger
import sys
from Simulation import Simulation
from StudentRegistrationSystem import StudentRegistrationSystem
from AdvisorRegistrationSystem import AdvisorRegistrationSystem
from InstructorRegistrationSystem import InstructorRegistrationSystem

class RegistrationSystem(object):
    #log = Logger()
    #scanner = Scanner()


    def __init__(self):
        simulation = Simulation();
        #Constructor of RegistrationSystem#

        #self.log = Logger.getLogger("logs")
        #self.scanner = Scanner(System.in_)

    def menu(self):
        #Prints menu choices

        while True:
            #self.log.info("Log in as...")
            #self.log.info("1-Student")
            #self.log.info("2-Instructor")
            #self.log.info("3-Advisor")
            #self.log.info("4-Simulation")
            #self.log.info("5-Exit")
            loginType = input()
            if loginType==1:
                StudentRegistrationSystem(self)
            elif loginType==2:
                InstructorRegistrationSystem(self)
            elif loginType==3:
                AdvisorRegistrationSystem(self)
            elif loginType==4:
                #self.log.info("Initiating simulation...")
                simulation.run()
                #self.log.info("Done.")
            elif loginType==5:
                #self.log.info("Exiting...")
                sys.exit("Exit...")
            else:
                pass
                #self.log.info("The input is not valid, please provide a valid input.")