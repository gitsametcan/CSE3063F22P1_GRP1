from abc import ABC , abstractmethod
class Person():

    def __init__(self):
        pass

    #  Creating get and set methods for variables
    def getFirstName(self):
        return self.__firstName

    def setFirstName(self, firstName:str):
        self.__firstName = firstName

    def getLastName(self):
        return self.__lastName

    def setLastName(self, lastName : str):
        self.__lastName = lastName

    def getFullName(self):
        return self.__firstName + " " + self.__lastName

    @abstractmethod
    def getID(self): str