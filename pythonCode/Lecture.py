from LectureType import LectureType
from Term import Term
from TermYear import TermYear
from LectureID import LectureID

class Lecture():

    def __init__(self):
    #    for ls in self.sessions:
    #        ls.set_lecture(self)

    #    if self.sessions is None:
    #        self.sessions = []
        pass

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
        return self.__sessions

    def getPrerequisite(self):
        return self.__prerequisite

    def getId(self):
        return self.__id

    def setId(self, id):
        self.__id = id

    def setSessions(self, sessions):
        self.__sessions = sessions

    def setPrerequisite(self, prerequisite):
        self.__prerequisite = prerequisite

    def getQuota(self):
        return self.__quota

    def setName(self, name):
        self.__name = name

    def setLectureType(self, lectureType):
        self.__lectureType = lectureType

    def setCredit(self, credit):
        self.__credit = credit

    def setQuota(self, quota):
        self.__quota = quota

    def removeLectureSession(self, lectureSession):
        self.__sessions.remove(lectureSession)

    def addPrerequisiteLecture(self, lecture):
        self.__prerequisite = lecture

    def removePrerequisitielLecture(self):
        self.__prerequisite = None

    def getTerm(self):
        return self.__term

    def setTerm(self, term):
        self.__term = term

    def getTermYear(self):
        return self.__termYear

    def setTermYear(self, termYear):
        self.__termYear = termYear
