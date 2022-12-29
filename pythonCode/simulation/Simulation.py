import StudentGenerator

class simulation:
    list = []
    studentGenerator = StudentGenerator()

    def __init__(self) -> None:
        pass


def ListOfStudents():
    list = []

#!/usr/bin/env python
# package: simulation
import java.util.ArrayList

import java.util.List

import java.util.Scanner

import data.DataManager

import logger.Logger

import person.Student

class Simulation(object):
    """ generated source for class Simulation """
    listOfStudents = List()
    studentGenerator = StudentGenerator()

    def __init__(self):
        """ generated source for method __init__ """
        self.studentGenerator = StudentGenerator()
        self.listOfStudents = ArrayList()

    def newSemester(self, semesterCount):
        """ generated source for method newSemester """
        studentCount = 0
        while studentCount < 50:
            try:
                student = studentGenerator.generate((studentCount + 1), semesterCount)
                self.listOfStudents.add(student)
            except Exception as e:
                e.printStackTrace()
            studentCount += 1

    def run(self):
        """ generated source for method run """
        i = 0
        while i < 8:
            self.newSemester(i)
            i += 1
        log = Logger.getLogger("logs")
        log.info("Do you want to save generated Students? Y/N : ")
        scanner = Scanner(System.in_)
        answer = scanner.next()
        if answer.lower() == "Y".lower():
            DataManager.getInstance().addStudents(self.listOfStudents)
            DataManager.getInstance().saveObjectAsJson()
            log.info("All students that is generated and their effect on lectures and advisors are saved")

    def getListOfStudents(self):
        """ generated source for method getListOfStudents """
        return self.listOfStudents

    def setListOfStudents(self, listOfStudents):
        """ generated source for method setListOfStudents """
        self.listOfStudents = listOfStudents