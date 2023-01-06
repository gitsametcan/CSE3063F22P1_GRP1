from LetterGrade import LetterGrade
from Term import Term
from TermYear import TermYear

class Semester():

    def __init__(self):
        pass

    # Creating properties for variables
    def getListOfLecturesTaken(self):
        return self.__listOfLecturesTaken

    def getCreditsTaken(self):
        self.__creditsTaken = self.creditsTakenCalculator(self.__listOfLecturesTaken)
        return self.__creditsTaken

    def getCreditsCompleted(self):
        self.__creditsCompleted = self.creditsCompletedCalculator(self.__listOfLecturesTaken)
        return self.__creditsCompleted

    def getPoints(self):
        self.__points = self.pointsCalculator(self.__listOfLecturesTaken);
        return self.__points

    def getYano(self):
        self.__yano = self.__points/self.__creditsTaken
        return self.__yano

    def setListOfLecturesTaken(self, listOfLecturesTaken):
        self.__listOfLecturesTaken = listOfLecturesTaken

    def addLecture(self, lecture, grade):
        self.__listOfLecturesTaken.put(lecture, grade)

    def creditsTakenCalculator(self, listOfLecturesTaken):
        totalCredit = 0
        for lecture in listOfLecturesTaken.keySet():
            totalCredit = totalCredit + lecture.getCredit()
        return totalCredit

    def creditsCompletedCalculator(self, listOfLecturesTaken):
        totalCredit = 0
        for lecture in listOfLecturesTaken.keySet():
            if listOfLecturesTaken.get(lecture) != LetterGrade.FD and listOfLecturesTaken.get(lecture) != LetterGrade.FF:
                totalCredit = totalCredit + lecture.getCredit()
        return totalCredit

    def pointsCalculator(self, listOfLecturesTaken):
        points = 0
        for lecture in listOfLecturesTaken.keySet():
            points = points + (lecture.getCredit() * listOfLecturesTaken.get(lecture).getLetterGradeValue())
        return points