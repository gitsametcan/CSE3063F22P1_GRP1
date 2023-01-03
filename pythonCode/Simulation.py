
from Logger import Logger
from Student import Student

from StudentGenerator import StudentGenerator
class Simulation():

    def __init__(self):
        
        self.__studentGenerator = StudentGenerator()
        self.__listOfStudents = list()

    def __newSemester(self, semesterCount):
        
        for studentCount in range(1,51):
            try:
                student = self.__studentGenerator.generate(studentCount, semesterCount)
                self.__listOfStudents.append(student)
            except Exception as e:
                e.printStackTrace()

    def run(self):

        for i in range(0, 8):
            self.__newSemester(i)

    #loglar gelecek

        
    def getListOfStudents(self):
        return self.__listOfStudents

    def setListOfStudents(self, listOfStudents:list()):
        self.__listOfStudents = listOfStudents
