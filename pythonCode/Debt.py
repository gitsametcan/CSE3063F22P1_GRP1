from Student import Student

class Debt:
    
    __student = Student()
    __amount = float

    def __init__(self, __amount, __student):
        self.amount = __amount
        self.student = __student

    # Creating properties for variables
    
    def getAmount(self):
        return self.__amount

    def setAmount(self, __amount):
        self._amount = __amount

    def getStudent(self):
        return self.__student

    def setStudent(self, __student):
        self._student = __student
