class Semester(object):
    listOfLecturesTaken = Map()
    creditsTaken = int()
    creditsCompleted = int()
    points = float()
    yano = float()
    term = Term()
    termYear = TermYear()

    def __init__(self, listOfLecturesTaken):
        super(Semester, self).__init__()
        self.listOfLecturesTaken = listOfLecturesTaken
        if self.listOfLecturesTaken == None:
            self.listOfLecturesTaken = HashMap()
        self.creditsTaken = creditsTakenCalculator(self.listOfLecturesTaken)
        self.creditsCompleted = creditsCompletedCalculator(self.listOfLecturesTaken)
        self.points = pointsCalculator(self.listOfLecturesTaken)
        self.yano = points / creditsTaken

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

    @overloaded
    def addLecture(self, lecture):
        self.listOfLecturesTaken.put(lecture, LetterGrade.None_)

    @addLecture.register(object, Lecture, LetterGrade)
    def addLecture_0(self, lecture, grade):
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