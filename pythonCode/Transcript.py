class Transcript:

    def __init__(self):
        pass
        
     # Creating properties for variables 
    
    def getStudent(self):
        return self.__student

    def setStudent(self,  student):
        self.__student = student
    
    def getListOfSemester(self):
        try:
            x = self.__listOfSemester
        except AttributeError:
            self.__listOfSemester = list()           
        return self.__listOfSemester

    def setListOfSemester(self, listOfSemester : list):
        self.__listOfSemester = listOfSemester

    def getGano(self):
        gano = self.__points / self.__totalCreditsTaken
        return self.__gano

    def setGano(self, gano : float):
        self.__gano = gano   

    def getTotalCreditsTaken(self):
        totalCreditsTaken = self.totalCreditsTakenCalculator(self.__listOfSemester)
        return self.__totalCreditsTaken

    def setTotalCreditsTaken(self, totalCreditsTaken : int):
        self.__totalCreditsTaken = totalCreditsTaken

    def getPoints(self):
        points = self.pointsCalculator()
        return self.__points

    def setPoints(self, points : float):
        self.__points = points

    def getTotalCreditsCompleted(self):
        totalCreditsCompleted = self.totalCreditsCompletedCalculator(self.__listOfSemester)
        return self.__totalCreditsCompleted

    def setTotalCreditsCompleted(self, totalCreditsCompleted : int):
        self.__totalCreditsCompleted = totalCreditsCompleted

    def getLastSemester(self):
        from Semester import Semester
        lastSemester = Semester()
        for s in range(0, len(self.__listOfSemester)):
            if s == (len(self.__listOfSemester)-1):
                lastSemester = s
        return self.getListOfSemester()[lastSemester - 1]

    # Creating other methods

    def addSemester(self, semester):
        self.__listOfSemester.append(semester)

    def totalCreditsTakenCalculator(self, listOfSemester : list):
        totalCreditsTaken = 0
        for semester in listOfSemester:
            totalCreditsTaken += semester.creditsTaken()
        return totalCreditsTaken

    def totalCreditsCompletedCalculator(self, listOfSemester : list):
        totalCreditsCompleted = 0
        for semester in self.__listOfSemester:
            totalCreditsCompleted += semester.creditsCompleted
        return totalCreditsCompleted

    def pointsCalculator(self):
        points = 0
        for semester in self.__listOfSemester:
            points += semester.points
        return points
