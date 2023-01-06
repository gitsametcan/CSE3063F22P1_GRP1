from LetterGrade import LetterGrade
from Term import Term
from TermYear import TermYear

class Semester():

    def __init__(self):
        self.__gradeLectureList = list()
        pass

    # Creating properties for variables

    def getGradeLectureList(self):
        return self.__gradeLectureList

    def addGradeToList(self, lectureSession,letterGrade):
        self.getGradeLectureList().append((lectureSession, letterGrade))

    
    def getListOfLecturesTaken(self):
        return self.listOfLecturesTaken

    def getCreditsTaken(self):
        self.creditsTaken = self.creditsTakenCalculator(self.listOfLecturesTaken)
        return self.creditsTaken

    def getCreditsCompleted(self):
        self.creditsCompleted = self.creditsCompletedCalculator(self.listOfLecturesTaken)
        return self.creditsCompleted

    def getPoints(self):
        self.points = self.pointsCalculator(self.listOfLecturesTaken)
        return self.points

    def getYano(self):
        self.yano = self.points/self.creditsTaken
        return self.yano

    def setListOfLecturesTaken(self, listOfLecturesTaken):
        self.listOfLecturesTaken = listOfLecturesTaken

    def addLecture(self, lecture, grade):
        self.listOfLecturesTaken.put(lecture, grade)

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