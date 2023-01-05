from SessionID import SessionID
from Lecture import Lecture
from LectureHour import LectureHour
# from Instructor import Instructor
from Student import Student

class LectureSession(object):

    def __init__(self):
    #    if self.listOfStudents is None:
    #        self.__listOfStudents = [Student]
        pass
     

    # Creating properties for variables
    def setSessionID(self, sessionID):
        self.sessionID = sessionID

    def setLecture(self, lecture):
        self.lecture = lecture

    def setSessionHours(self, sessionHours):
        self.sessionHours = sessionHours

    def setSessionType(self, sessionType):
        self.sessionType = sessionType

    def setInstructor(self, instructor):
        self.instructor = instructor

    def setListOfAssistans(self, listOfAssistans):
        self.listOfAssistans = listOfAssistans

    def getSessionID(self):
        return self.sessionID.getID()

    def getSessionHours(self):
        return self.sessionHours

    def getSessionType(self):
        return self.sessionType

    def getInstructor(self):
        return self.instructor

    def getListOfAssistans(self):
        return self.listOfAssistans

    def getLecture(self):
        return self.lecture

    def getListOfStudents(self):
        return self.listOfStudents

    def setListOfStudents(self, listOfStudents):
        self.listOfStudents = listOfStudents
