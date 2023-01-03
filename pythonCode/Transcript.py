

from Semester import Semester
from Student import Student

class Transcript:

    def __init__(self):
        pass
        #self.__student = __student
        #self.__listOfSemester = __listOfSemester

        #if self.__listOfSemester == None:
        #    self.__listOfSemester = [Semester]

        #self.__totalCreditsTaken = self.totalCreditsTakenCalculator(self.__listOfSemester)
        #self.__totalCreditsCompleted = self.totalCreditsCompletedCalculator(self.__listOfSemester)
        #self.__points = self.pointsCalculator(self.__listOfSemester)
        #self.__gano = self.__points / self.__totalCreditsTaken
 
     # Creating properties for variables 
    
    def getStudent(self):
        return self.student

    def setStudent(self,  student):
        self.student = student
    
    def getListOfSemester(self):
        return self.listOfSemester

    def setListOfSemester(self, listOfSemester):
        self.listOfSemester = listOfSemester

    def getGano(self):
        return self.gano

    def setGano(self, gano):
        self.gano = gano   

    def getTotalCreditsTaken(self):
        return self.totalCreditsTaken

    def setTotalCreditsTaken(self, totalCreditsTaken):
        self.totalCreditsTaken = totalCreditsTaken

    def getPoints(self):
        return self.points

    def setPoints(self, points):
        self.points = points

    def getTotalCreditsCompleted(self):
        return self.totalCreditsCompleted

    def setTotalCreditsCompleted(self, totalCreditsCompleted):
        self.totalCreditsCompleted = totalCreditsCompleted


    # Creating other methods

    def addSemester(self, semester):

        self.__listOfSemester.append(semester)

    def totalCreditsTakenCalculator(self, listOfSemester):
        totalCreditsTaken = 0
        for semester in listOfSemester:
            totalCreditsTaken += semester.creditsTaken()
        return totalCreditsTaken

    def totalCreditsCompletedCalculator(self, listOfSemester):
        totalCreditsCompleted = 0
        for semester in self.listOfSemester:
            totalCreditsCompleted += semester.creditsCompleted
        return totalCreditsCompleted

    def pointsCalculator(self):
        points = 0
        for semester in self.listOfSemester:
            points += semester.points
        return points
