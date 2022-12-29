class Transcript:
    def __init__(self, __student, __listOfSemester=None):
        self.__student = __student
        self.__listOfSemester = __listOfSemester or []
        self.__totalCreditsTaken = self.totalCreditsTakenCalculator(self, self.__listOfSemester)
        self.__totalCreditsCompleted = self.totalCreditsCompletedCalculator()
        self.__points = self.pointsCalculator()
        self.__gano = self.__points / self.__totalCreditsTaken

     # Creating properties for variables 
    @property
    def student(self):
        return self.__student

    @student.setter
    def student(self, __student):
        self.__student = __student
    
    @property
    def listOfSemester(self):
        return self.__listOfSemester

    @listOfSemester.setter
    def listOfSemester(self, __listOfSemester):
        self.__listOfSemester = __listOfSemester

    @property
    def gano(self):
        return self.__gano

    @gano.setter
    def gano(self, __gano):
        self.__gano = __gano   

    @property
    def totalCreditsTaken(self):
        return self.__totalCreditsTaken

    @totalCreditsTaken.setter
    def totalCreditsTaken(self, __totalCreditsTaken):
        self.__totalCreditsTaken = __totalCreditsTaken

    @property
    def points(self):
        return self.__points

    @points.setter
    def points(self, __points):
        self.__points = __points

    @property
    def totalCreditsCompleted(self):
        return self.__totalCreditsCompleted

    @totalCreditsCompleted.setter
    def totalCreditsCompleted(self, __totalCreditsCompleted):
        self.__totalCreditsCompleted = __totalCreditsCompleted

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
