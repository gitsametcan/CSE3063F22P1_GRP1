from SessionType import SessionType

class LectureSession(object):

    def __init__(self):
        pass

    # Creating properties for variables
    def setSessionID(self, sessionID):
        self.__sessionID = sessionID

    def setLecture(self, lecture):
        self.__lecture = lecture

    def setSessionHours(self, sessionHours : list):
        self.__sessionHours = sessionHours

    def setSessionType(self, sessionType : SessionType):
        self.__sessionType = sessionType

    def setInstructor(self, instructor):
        self.__instructor = instructor

    def setListOfAssistans(self, listOfAssistans : list):
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
        try:
            x = self.__listOfStudents
        except AttributeError:
            self.__listOfStudents = list()
        return self.__listOfStudents

    def setListOfStudents(self, listOfStudents : list):
        self.__listOfStudents = listOfStudents
