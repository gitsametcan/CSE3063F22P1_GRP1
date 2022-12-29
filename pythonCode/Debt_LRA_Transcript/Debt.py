class Debt:
    def __init__(self, __amount, __student):
        self.amount = __amount
        self.student = __student

    # Creating properties for variables
    @property
    def __amount(self):
        return self.__amount

    @__amount.setter
    def __amount(self, __amount):
        self._amount = __amount

    @property
    def __student(self):
        return self.__student

    @__student.setter
    def __student(self, __student):
        self._student = __student
