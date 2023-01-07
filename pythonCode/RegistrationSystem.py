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

        while True:
            if len(dirlist) < 1:
                self.__log.info("1-Simulation")
                self.__log.info("2-Exit")

                loginType = input()
                if loginType == str(1):
                    self.__log.info("1-Generate Students")
                    self.__log.info("2-Exit")
                    loginChoice = input()
                    if loginChoice == str(1):
                        self.__log.info("Generating students...")
                        self.__simulation.run() #doğru mu bilmiyorum, burda öğrenci oluşturma methodu çağırılacak
                        self.__log.info("Done.")
                    elif loginChoice == str(2):
                        self.__log.info("Exiting...")
                    else:
                        pass #buraya exception yazılabilir
                elif loginType == str(2):
                    self.__log.info("Exiting...")
                    sys.exit("Exit...")
                else:
                    self.__log.info("The input is not valid, please provide a valid input.")
            elif len(dirlist) < 1:
                self.__log.info("1-Simulation")
                self.__log.info("2-Exit")

                loginType = input()
                if loginType == str(1):
                    self.__log.info("1-Generate Students")
                    self.__log.info("2-Start Simulation")
                    self.__log.info("3-Exit")
                    loginChoice = input()
                    if loginChoice == str(1):
                        self.__log.info("Generating students...")
                        self.__simulation.studentGenerator() #doğru mu bilmiyorum, burda öğrenci oluşturma methodu çağırılacak
                        self.__log.info("Done.")
                    elif loginChoice == str(2):
                        self.__log.info("Initiating simulation...")
                        self.__simulation.run()
                        self.__log.info("Done.")
                    elif loginChoice == str(3):
                        self.__log.info("Exiting...")
                    else:
                        pass #buraya exception yazılabilir
                elif loginType == str(2):
                    self.__log.info("Exiting...")
                    sys.exit("Exit...")
                else:
                    self.__log.info("The input is not valid, please provide a valid input.")
            else:
                self.__log.info("1-Simulation")
                self.__log.info("2-Student Simulation Logs")
                self.__log.info("3-Advisor Simulation Logs")
                self.__log.info("4-Instructor Simulation Logs")
                self.__log.info("5-Exit")

                loginType = input()
                if loginType == str(1):
                    self.__log.info("1-Generate Students")
                    self.__log.info("2-Start Simulation")
                    self.__log.info("3-Exit")
                    loginChoice = input()
                    if loginChoice == str(1):
                        self.__log.info("Generating students...")
                        self.__simulation.studentGenerator() #doğru mu bilmiyorum, burda öğrenci oluşturma methodu çağırılacak
                        self.__log.info("Done.")
                    elif loginChoice == str(2):
                        self.__log.info("Initiating simulation...")
                        self.__simulation.run()
                        self.__log.info("Done.")
                    elif loginChoice == str(3):
                        self.__log.info("Exiting...")
                    else:
                        pass #buraya exception yazılabilir
                elif loginType == str(2):
                    StudentRegistrationSystem(self)
                elif loginType == str(3):
                    AdvisorRegistrationSystem(self)
                elif loginType == str(4):
                    InstructorRegistrationSystem(self)
                elif loginType == str(5):
                    self.__log.info("Exiting...")
                    sys.exit("Exit...")
                else:
                    self.__log.info("The input is not valid, please provide a valid input.")
