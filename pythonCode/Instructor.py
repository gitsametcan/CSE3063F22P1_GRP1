from calendar import Calendar
from Logger import Logger
from InstructorType import InstructorType
from InstructorID import InstructorID
from LectureSession import LectureSession
from Schedule import Schedule
from Person import Person

class Instructor(Person):
    # generated source for class Instructor 

    #log = Logger.getLogger("logs")
    #_id = InstructorID()
    #__schedule = Schedule()
    #_dateOfEntry = Calendar()
    #_instructorType = InstructorType()

    def __init__(self):
        # generated source for method __init__ 
        #super(firstName, lastName)
        self.__id = InstructorID()
        self.__schedule = Schedule()
        self.__dateOfEntry = Calendar()
        self.__instructorType = InstructorType.Assistant
        self.__log = Logger.getLogger("logs")


    def getID(self):
        # generated source for method getID 
        return self.__id.getID()
    
    def setID(self, id):
        # generated source for method setID 
        self.__id = id

    def getDateOfEntry(self):
        # generated source for method getDateOfEntry 
        return self.__dateOfEntry
        
    def setDateOfEntry(self, dateOfEntry):
        # generated source for method setDateOfEntry 
        self.__dateOfEntry = dateOfEntry

    def getInstructorType(self):
        # generated source for method getInstructorType 
        return self.__instructorType
    
    def setInstructorType(self, instructorType):
        # generated source for method setInstructorType 
        self.__instructorType = instructorType

    def getSchedule(self):
        # generated source for method getSchedule 
        return self.__schedule

    def setSchedule(self, schedule):
        # generated source for method setSchedule 
        self.__schedule = schedule
