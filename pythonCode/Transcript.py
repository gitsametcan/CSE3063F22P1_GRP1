from Semester import Semester

class Transcript:

    def __init__(self):
        pass

     # Creating properties for variables 
    
    def getStudent(self):
        return self.__student

    def setStudent(self,  student):
        self.__student = student
    
    def getListOfSemester(self):
        if self.__listOfSemester == None:
            self.__listOfSemester = list
        return self.__listOfSemester

    def setListOfSemester(self, listOfSemester : list):
        self.__listOfSemester = listOfSemester

    def getGano(self):
        gano = self.__points / self.__totalCreditsTaken
        return self.__gano

    def setGano(self, gano):
        self.__gano = gano   

    def getTotalCreditsTaken(self):
        totalCreditsTaken = self.totalCreditsTakenCalculator(self.__listOfSemester)
        return self.__totalCreditsTaken

    def setTotalCreditsTaken(self, totalCreditsTaken):
        self.__totalCreditsTaken = totalCreditsTaken

    def getPoints(self):
        points = self.pointsCalculator()
        return self.__points

    def setPoints(self, points):
        self.__points = points

    def getTotalCreditsCompleted(self):
        totalCreditsCompleted = self.totalCreditsCompletedCalculator(self.__listOfSemester)
        return self.__totalCreditsCompleted

    def setTotalCreditsCompleted(self, totalCreditsCompleted):
        self.__totalCreditsCompleted = totalCreditsCompleted


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
        for semester in self.__listOfSemester:
            totalCreditsCompleted += semester.creditsCompleted
        return totalCreditsCompleted

    def pointsCalculator(self):
        points = 0
        for semester in self.__listOfSemester:
            points += semester.points
        return points
