from calendar import Calendar
from Logger import Logger
from InstructorType import InstructorType
from InstructorID import InstructorID
from LectureSession import LectureSession
#from Schedule import Schedule
from Person import Person

class Instructor(Person):
    # generated source for class Instructor 
    #log = Logger.getLogger("logs")
    #_id = InstructorID()
    #__schedule = Schedule()
    #_dateOfEntry = Calendar()
    #_instructorType = InstructorType()
    #__scanner = input()


    def getID(self):
        # generated source for method getID 
        return self.__id.getID()

    def getDateOfEntry(self):
        # generated source for method getDateOfEntry 
        return self.__dateOfEntry

    def getInstructorType(self):
        # generated source for method getInstructorType 
        return self.__instructorType

    def showLectures(self):
        # generated source for method showLectures 
        schedule = self.getSchedule()
        listOfLectureSessions = schedule.getListOfLectureSessions()
        for lectureSession in listOfLectureSessions:
            self.__log.info(lectureSession.getLecture().__name__ + "." + lectureSession.getSessionID())
            self.__log.info("------------")
            self.__log.info("Quota: " + lectureSession.getLecture().getQuota())
            self.__log.info("Number Of Students: " + lectureSession.getListOfStudents().size() + "\n")
        schedule.showSchedule()

    def showStudents(self):
        # generated source for method showStudents 
        count = 0
        for lectureSession in self.getSchedule().getListOfLectureSessions():
            count += 1
            self.__log.info(count + ". " + lectureSession.getLecture().__name__ + "." + lectureSession.getSessionID())
        self.__log.info("Choose A Session: ")
        sessionChoice = input()
        lectureSession = self.getSchedule().getListOfLectureSessions().get(sessionChoice - 1)
        for student in lectureSession.getListOfStudents():
            self.__log.info("ID: " + student.getID() + "Name: " + student.getFullName())


    def __init__(self):
        # generated source for method __init__ 
        #super(firstName, lastName)
        self.__id = InstructorID()
        self.__schedule = Schedule()
        self.__dateOfEntry = Calendar()
        self.__instructorType = InstructorType.Assistant
        self.__log = Logger.getLogger("logs")


    def getSchedule(self):
        # generated source for method getSchedule 
        return self.__schedule

    def setSchedule(self, schedule):
        # generated source for method setSchedule 
        self.__schedule = schedule
        