class Lecture(object):
    """ generated source for class Lecture """
    id = LectureID()
    name = str()
    lectureType = LectureType()
    credit = int()
    sessions = List()
    prerequisite = Lecture()
    quota = int()
    term = Term()
    termYear = TermYear()

    def __init__(self, id, name, lectureType, credit, sessions, prerequisite, quota, term, termYear):
        super(Lecture, self).__init__()
        self.id = id
        self.name = name
        self.lectureType = lectureType
        self.credit = credit
        self.sessions = sessions
        for ls in self.sessions:
            ls.setLecture(self)
        self.prerequisite = prerequisite
        self.quota = quota
        self.term = term
        self.termYear = termYear
        if sessions == None:
            self.sessions = ArrayList()

    #  Creating get and set methods for variables
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