class Debt:

    def __init__(self):
        pass

    # Creating properties for variables
    
    def getAmount(self):
        return self.__amount

    def setAmount(self, amount: float):
        self.__amount = amount

    def getStudent(self):
        try: 
            x = self.__student
        except AttributeError:
            return None
        return self.__student

    def setStudent(self, student):
        self.__student = student

