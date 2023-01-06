from calendar import Calendar
from Logger import Logger
from InstructorType import InstructorType
from InstructorID import InstructorID
from LectureSession import LectureSession
from Schedule import Schedule
from Person import Person

class Instructor(Person):

    def __init__(self):
        pass

    def getID(self):
        # generated source for method getID 
        return self.__id.getID()
    
    def setID(self, id : InstructorID):
        # generated source for method setID 
        self.__id = id

    def getDateOfEntry(self):
        # generated source for method getDateOfEntry 
        return self.__dateOfEntry
        
    def setDateOfEntry(self, dateOfEntry : Calendar):
        # generated source for method setDateOfEntry 
        self.__dateOfEntry = dateOfEntry

    def getInstructorType(self):
        # generated source for method getInstructorType 
        return self.__instructorType
    
    def setInstructorType(self, instructorType : InstructorType):
        # generated source for method setInstructorType 
        self.__instructorType = instructorType

    def getSchedule(self):
        # generated source for method getSchedule 
        return self.__schedule

    def setSchedule(self, schedule : Schedule):
        # generated source for method setSchedule 
        self.__schedule = schedule
