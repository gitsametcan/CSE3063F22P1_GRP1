#!/usr/bin/env python
# package: person
class Person():

    #__firstName = str()
    #__lastName = str()

    def __init__(self):
        # generated source for method __init__ 
        self.__firstName = str()
        self.__lastName = str()

    #  Creating get and set methods for variables
    def getFirstName(self):
        # generated source for method getFirstName 
        return self.__firstName

    def setFirstName(self, firstName):
        # generated source for method setFirstName 
        self.__firstName = firstName

    def getLastName(self):
        # generated source for method getLastName 
        return self.__lastName

    def setLastName(self, lastName):
        # generated source for method setLastName 
        self.__lastName = lastName

    def getFullName(self):
        # generated source for method getFullName 
        return self.__firstName + " " + self.__lastName

    #def getID(self):---------------------------------------------------
        # generated source for method getID 