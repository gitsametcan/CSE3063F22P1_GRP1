from SessionID import SessionID
from Lecture import Lecture
from LectureHour import LectureHour
# from Instructor import Instructor
from Student import Student

class LectureSession(object):
    # __sessionID = SessionID()
    # __lecture = Lecture()
    # __sessionHours = []
    # __sessionType = SessionType()
    # __instructor = Instructor()
    # __listOfAssistans = List()
    # __listOfStudents = List()

    #  Method will add about this property
    def __init__(self):
        # sessionID: SessionID, lecture: Lecture, sessionHours : LectureHour[][], 
        # instructor: Instructor, listOfStudents: list<Student>
        pass
        

    #  Creating get and set methods for variables
    def setSessionID(self, sessionID):
        self.__sessionID = sessionID

    def setLecture(self, lecture):
        self.__lecture = lecture

    def setSessionHours(self, sessionHours):
        self.__sessionHours = sessionHours

    def setSessionType(self, sessionType):
        self.__sessionType = sessionType

    def setInstructor(self, instructor):
        self.__instructor = instructor

    def setListOfAssistans(self, listOfAssistans):
        self.__listOfAssistans = listOfAssistans

    def getSessionID(self):
        return self.__sessionID.getID()

    def getSessionHours(self):
        return self.__sessionHours

    def getSessionType(self):
        return self.__sessionType

    def getInstructor(self):
        return self.__instructor

    def getListOfAssistans(self):
        return self.__listOfAssistans

    def getLecture(self):
        return self.__lecture

    def getListOfStudents(self):
        return self.__listOfStudents

    def setListOfStudents(self, listOfStudents):
        self.__listOfStudents = listOfStudents