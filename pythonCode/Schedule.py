from LectureHour import LectureHour

class Schedule():
    
    def __init__(self):
        from Logger import Logger
        self.__log = Logger.getLogger("logs")
        self.__ListOfLectureSessions = list()

    # Creating show method
    def showSchedule(self, log):
        lectureSessions = self.getListOfLectureSessions()
        if len(lectureSessions) == 0:
            self.__log.info("You dont have any lecture to be shown.")
            return
        lecturePlaceX = 0
        lecturePlaceY = 1
        temp = ""
        for y in range(1, 42):
            for x in range(1, 79):
                if y == 1 or y == 41:
                    temp += "_"
                    if x == 78 and y == 1:
                        self.__log.info(temp)
                        temp = ""
                elif (x - 2) % 11 == 0 and (y - 3) % 4 == 0:
                    if lecturePlaceX == 7:
                        lecturePlaceX = 1
                        lecturePlaceY += 1
                    else:
                        lecturePlaceX += 1
                    thereIsLecture = False
                    for ls in lectureSessions is []:
                        if ls.getSessionHours()[lecturePlaceX - 1][lecturePlaceY - 1] == LectureHour.YES:
                            lectureSessionName = f"{ls.getLecture().getID()}.{ls.getSessionID()}"
                            temp += lectureSessionName
                            x += lectureSessionName.length - 1
                            thereIsLecture = True
                            break
                    if not thereIsLecture:
                        temp += " "
                elif x == 1 or x == 78:
                    temp += "|"
                    if x == 78:
                        self.__log.info(temp)
                        temp = ""
                elif (y - 1) % 4 == 0:
                    temp += "_"
                elif (x - 1) % 11 == 0:
                    temp += "|"
                else:
                    temp += " "
        self.__log.info(temp)
        temp = ""

    # Creating properties for variables

    def getPerson(self):
        return self.__person

    def setPerson(self, person):
        self.__person = person

    def getListOfLectureSessions(self):
        try:
            x = self.__ListOfLectureSessions
        except AttributeError:
            self.__ListOfLectureSessions = list()
        return self.__ListOfLectureSessions

    def setListOfLectureSessions(self, ListOfLectureSessions : list):
        self.__ListOfLectureSessions = ListOfLectureSessions

    def getTerm(self):
        from Term import Term
        try:
            x = self.__term
        except AttributeError:
            self.__term = Term.Fall
        return self.__term

    def setTerm(self, term):
        self.__term = term

    def getTermYear(self):
        from TermYear import TermYear
        try:
            x = self.__termYear
        except AttributeError:
            self.__termYear = TermYear.Freshman
        return self.__termYear

    def setTermYear(self, termYear):
        self.__termYear = termYear
