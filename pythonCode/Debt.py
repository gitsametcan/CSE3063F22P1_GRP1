from Student import Student

class Debt:

    def init(self, __amount, __student):
        self.amount = __amount
        self.student = __student

    # Creating properties for variables
    
    def getAmount(self):
        return self.amount

    def setAmount(self, amount):
        self.amount = amount

    def getStudent(self):
        return self.student

    def setStudent(self, student):
        self._student = student
