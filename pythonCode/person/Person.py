#!/usr/bin/env python
# package: person
class Person(object):
    """ generated source for class Person """
    firstName = str()
    lastName = str()

    def __init__(self, firstName, lastName):
        """ generated source for method __init__ """
        self.firstName = firstName
        self.lastName = lastName

    #  Creating get and set methods for variables
    def getFirstName(self):
        """ generated source for method getFirstName """
        return self.firstName

    def setFirstName(self, firstName):
        """ generated source for method setFirstName """
        self.firstName = firstName

    def getLastName(self):
        """ generated source for method getLastName """
        return self.lastName

    def setLastName(self, lastName):
        """ generated source for method setLastName """
        self.lastName = lastName

    def getFullName(self):
        """ generated source for method getFullName """
        return self.firstName + " " + self.lastName

    def getID(self):
        """ generated source for method getID """