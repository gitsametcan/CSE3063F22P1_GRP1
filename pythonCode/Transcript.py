from Semester import Semester

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
        return self.__student

    def setStudent(self,  student):
        self.__student = student
    
    def getListOfSemester(self):
        return self.__listOfSemester

    def setListOfSemester(self, listOfSemester):
        self.__listOfSemester = listOfSemester

    def getGano(self):
        return self.__gano

    def setGano(self, gano):
        self.__gano = gano

    def getTotalCreditsTaken(self):
        return self.__totalCreditsTaken

    def setTotalCreditsTaken(self, totalCreditsTaken):
        self.__totalCreditsTaken = totalCreditsTaken

    def getPoints(self):
        return self.__points

    def setPoints(self, points):
        self.__points = points

    def getTotalCreditsCompleted(self):
        return self.__totalCreditsCompleted

    def setTotalCreditsCompleted(self, totalCreditsCompleted):
        self.__totalCreditsCompleted = totalCreditsCompleted

    def getLastSemester(self):
        lastSemester = Semester()
        for s in range(0, len(self.__listOfSemester)):
            if s == (len(self.__listOfSemester)-1):
                lastSemester = s
        return lastSemester

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
