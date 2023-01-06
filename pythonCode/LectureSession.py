from SessionID import SessionID
from LectureHour import LectureHour
from SessionType import SessionType
from Student import Student
from Instructor import Instructor

class LectureSession(object):

    def __init__(self):
    #    if self.listOfStudents is None:
    #        self.__listOfStudents = [Student]
        pass

    # Creating properties for variables
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
