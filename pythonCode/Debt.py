from Student import Student
class Debt:

    def __init__(self):
        pass
    #    self.amount = __amount
    #    self.student = __student

    # Creating properties for variables
    
    def getAmount(self):
        return self.__amount

    def setAmount(self, amount: float):
        self.__amount = amount

    #def getStudent(self):
    #    return self.__student

    def setStudent(self, student: Student):
        self.__student = student

