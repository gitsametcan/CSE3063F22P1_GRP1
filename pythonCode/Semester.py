from LetterGrade import LetterGrade

class Semester():

    def __init__(self):
        self.__gradeLectureList = dict()
        pass

    # Creating properties for variables

    def getGradeLectureList(self):
        return self.__gradeLectureList

    def addGradeToList(self, lectureSession, letterGrade):
        self.getGradeLectureList()[lectureSession.getLecture()] = letterGrade

    def getListOfLecturesTaken(self):
        return self.__gradeLectureList

    def getCreditsTaken(self):
        self.__creditsTaken = self.__creditsTakenCalculator(self.__gradeLectureList)
        return self.__creditsTaken

    def getCreditsCompleted(self):
        self.__creditsCompleted = self.__creditsCompletedCalculator(self.__gradeLectureList)
        return self.__creditsCompleted

    def getPoints(self):
        self.__points = self.__pointsCalculator(self.__gradeLectureList)
        return self.__points

    def getYano(self):
        self.__yano = self.__points/self.__creditsTaken
        return self.__yano

    def setListOfLecturesTaken(self, listOfLecturesTaken : dict):
        self.__gradeLectureList = listOfLecturesTaken

    def addLecture(self, lecture, grade : LetterGrade):
        self.__gradeLectureList[lecture] = grade

    def __creditsTakenCalculator(self, listOfLecturesTaken : dict):
        totalCredit = 0
        for lecture in listOfLecturesTaken.keys():
            totalCredit = totalCredit + lecture.getCredit()
        return totalCredit

    def __creditsCompletedCalculator(self, listOfLecturesTaken : dict):
        totalCredit = 0
        for lecture in listOfLecturesTaken.keys():
            if listOfLecturesTaken[lecture] != LetterGrade.FD and listOfLecturesTaken[lecture] != LetterGrade.FF:
                totalCredit = totalCredit + lecture.getCredit()
        return totalCredit

    def __pointsCalculator(self, listOfLecturesTaken : dict):
        points = 0
        for lecture in listOfLecturesTaken.keys():
            points = points + (lecture.getCredit() * listOfLecturesTaken[lecture].value)
        return points