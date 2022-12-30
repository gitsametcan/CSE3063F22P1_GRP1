class LectureSession(object):
    sessionID = SessionID()
    lecture = Lecture()
    sessionHours = []
    sessionType = SessionType()
    instructor = Instructor()
    listOfAssistans = List()
    listOfStudents = List()

    #  Method will add about this property
    def __init__(self, sessionID, lecture, sessionHours, sessionType, instructor, listOfAssistans, listOfStudents):
        super(LectureSession, self).__init__()
        self.sessionID = sessionID
        self.lecture = lecture
        self.sessionHours = sessionHours
        self.sessionType = sessionType
        self.instructor = instructor
        self.listOfAssistans = listOfAssistans
        self.listOfStudents = listOfStudents
        if listOfStudents == None:
            self.listOfStudents = ArrayList()

    #  Creating get and set methods for variables
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