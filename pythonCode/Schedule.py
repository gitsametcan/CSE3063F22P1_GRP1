from LectureHour import LectureHour
from Term import Term
from TermYear import TermYear
from Person import Person
from Logger import Logger

class Schedule():
    
    def __init__(self):
        pass

    # Creating show method
    def showSchedule(self, log):
        lectureSessions = self.getListOfLectureSessions()
        if len(lectureSessions) == 0:
            log.info("You dont have any lecture to be shown.")
            return
        lecturePlaceX = 0
        lecturePlaceY = 1
        temp = ""
        for y in range(1, 42):
            for x in range(1, 79):
                if y == 1 or y == 41:
                    temp += "_"
                    if x == 78 and y == 1:
                        log.info(temp)
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
                        log.info(temp)
                        temp = ""
                elif (y - 1) % 4 == 0:
                    temp += "_"
                elif (x - 1) % 11 == 0:
                    temp += "|"
                else:
                    temp += " "
        log.info(temp)
        temp = ""

    # Creating properties for variables

    def getPerson(self):
        return self.person

    def setPerson(self, person):
        self.person = person

    def getListOfLectureSessions(self):
        return self.getListOfLectureSessions

    def setListOfLectureSessions(self, ListOfLectureSessions):
        self.ListOfLectureSessions = ListOfLectureSessions

    def getTerm(self):
        return self.term

    def setTerm(self, term):
        self.term = term

    def getTermYear(self):
        return self.termYear

    def setTermYear(self, termYear):
        self.termYear = termYear
    