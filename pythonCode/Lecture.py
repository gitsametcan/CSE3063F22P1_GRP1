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
        return self.id.getID()

    def getName(self):
        return self.name

    def getLectureType(self):
        return self.lectureType

    def getCredit(self):
        return self.credit

    def getSessions(self):
        return self.sessions

    def getPrerequisite(self):
        return self.prerequisite

    def getId(self):
        return self.id

    def setId(self, id):
        self.id = id

    def setSessions(self, sessions):
        self.sessions = sessions

    def setPrerequisite(self, prerequisite):
        self.prerequisite = prerequisite

    def getQuota(self):
        return self.quota

    def setName(self, name):
        self.name = name

    def setLectureType(self, lectureType):
        self.lectureType = lectureType

    def setCredit(self, credit):
        self.credit = credit

    def setQuota(self, quota):
        self.quota = quota

    def removeLectureSession(self, lectureSession):
        self.sessions.remove(lectureSession)

    def addPrerequisiteLecture(self, lecture):
        self.prerequisite = lecture

    def removePrerequisitielLecture(self):
        self.prerequisite = None

    def getTerm(self):
        return self.term

    def setTerm(self, term):
        self.term = term

    def getTermYear(self):
        return self.termYear

    def setTermYear(self, termYear):
        self.termYear = termYear
