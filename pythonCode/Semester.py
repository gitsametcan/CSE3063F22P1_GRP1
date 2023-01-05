from LetterGrade import LetterGrade
from Term import Term
from TermYear import TermYear

class Semester():

    def __init__(self ):
        pass

    #  Creating get and set methods for variables
    def getListOfLecturesTaken(self):
        return self.listOfLecturesTaken

    def getCreditsTaken(self):
        return self.creditsTaken

    def getCreditsCompleted(self):
        return self.creditsCompleted

    def getPoints(self):
        return self.points

    def getYano(self):
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