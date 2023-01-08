import sys
import os
from Simulation import Simulation
from StudentRegistrationSystem import StudentRegistrationSystem
from AdvisorRegistrationSystem import AdvisorRegistrationSystem
from InstructorRegistrationSystem import InstructorRegistrationSystem
from DataManager import DataManager
from Logger import Logger

class RegistrationSystem(object):


    def __init__(self):
        self.__simulation = Simulation()
        #Constructor of RegistrationSystem
        self.__log = Logger.getLogger("logs")

    def menu(self):
        #Prints menu choices

        metaData = DataManager.getInstance().getMetaData()

        dirlist = os.listdir(metaData["studentsPath"])
        studentsList = list()
        while True:
            self.__log.info("1-Generate Students")
            if len(dirlist) >= 1:
                self.__log.info("2-Start Simulation")
                self.__log.info("3-Student Simulation Logs")
                self.__log.info("4-Advisor Simulation Logs")
                self.__log.info("5-Instructor Simulation Logs")
                self.__log.info("6-Exit")
            else:
                self.__log.info("2-Exit")

            loginChoice = input()
            intLoginChoice = int(loginChoice)

            if len(dirlist) < 1 and intLoginChoice == 2:
                intLoginChoice = intLoginChoice + 4

            if(intLoginChoice == 1):
                self.__log.info("Generating Students...")
                studentsList = self.__simulation.run()
                self.__log.info("Done.")
                self.__log.info("Saving Files...")
                DataManager.getInstance().addStudents(studentsList)
                DataManager.getInstance().saveFiles()
                self.__log.info("Done.")
            elif(intLoginChoice == 2):
                self.__log.info("Initiating simulation...")
                self.__simulation.startSimulation(studentsList)
                self.__log.info("Done.")
            elif(intLoginChoice == 3):
                StudentRegistrationSystem(self)
            elif(intLoginChoice == 4):
                AdvisorRegistrationSystem(self)
            elif(intLoginChoice == 5):
                InstructorRegistrationSystem(self)
            elif(intLoginChoice == 6):
                self.__log.info("Exiting...")
                sys.exit("Exit...")
            else:
                self.__log.info("The input is not valid, please provide a valid input.")
