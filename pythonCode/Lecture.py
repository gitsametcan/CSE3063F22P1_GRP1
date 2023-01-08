from LectureType import LectureType

class Lecture():
    def __init__(self):
        pass

    def __hash__(self):
        return hash((self.getID(), self.getName(), self.getLectureType(), self.getCredit(), self.getQuota(), self.getTerm(), self.getTermYear()))

    def __eq__(self, other):
        return (self.getID(), self.getName(), self.getLectureType(),
            self.getCredit(), self.getSessions() , self.getPrerequisite(),
            self.getQuota(), self.getTerm(), self.getTermYear()) ==  (other.getID(), other.getName(),
            other.getLectureType(), other.getCredit(), other.getSessions(),
            other.getPrerequisite(), other.getQuota(), other.getTerm(), other.getTermYear())


    # Creating properties for variables
    def getID(self):
        return self.__id.getID()

    def getName(self):
        return self.__name

    def getLectureType(self):
        return self.__lectureType

    def getCredit(self):
        return self.__credit

    def getSessions(self):
        for ls in self.__sessions:
           ls.setLecture(self)
        if self.__sessions is None:
            self.__sessions = []
        return self.__sessions

    def getPrerequisite(self):
        try:
            x = self.__prerequisite
        except AttributeError:
            return None
        return self.__prerequisite

    def getId(self):
        return self.__id

    def setId(self, id):
        self.__id = id

    def setSessions(self, sessions : list):
        self.__sessions = sessions

    def setPrerequisite(self, prerequisite):
        self.__prerequisite = prerequisite

    def getQuota(self):
        return self.__quota

    def setName(self, name : str):
        self.__name = name

    def setLectureType(self, lectureType : LectureType):
        self.__lectureType = lectureType

    def setCredit(self, credit : int):
        self.__credit = credit

    def setQuota(self, quota : int):
        self.__quota = quota

    def getTerm(self):
        return self.__term

    def setTerm(self, term):
        self.__term = term

    def getTermYear(self):
        return self.__termYear

    def setTermYear(self, termYear):
        self.__termYear = termYear

    # Creating another methods
    def removeLectureSession(self, lectureSession):
        self.__sessions.remove(lectureSession)

    def addPrerequisiteLecture(self, lecture):
        self.__prerequisite = lecture

    def removePrerequisitielLecture(self):
        self.__prerequisite = None
