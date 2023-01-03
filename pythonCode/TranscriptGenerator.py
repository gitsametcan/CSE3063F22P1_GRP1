
class TranscriptGenerator():


    """ generated source for class TranscriptGenerator """
    termAndYear = Map()

    def __init__(self):
        """ generated source for method __init__ """

    def generate(self, student, schedule):
        """ generated source for method generate """
        build()
        transcript = Transcript(student, None)
        transcript.setListOfSemester(setAllSemester(student, schedule))
        return transcript

    def build(self):
        """ generated source for method build """
        self.termAndYear = HashMap()
        self.termAndYear.put("FallFreshman", 0)
        self.termAndYear.put("SpringFreshman", 1)
        self.termAndYear.put("FallSophomore", 2)
        self.termAndYear.put("SpringSophomore", 3)
        self.termAndYear.put("FallJunior", 4)
        self.termAndYear.put("SpringJunior", 5)
        self.termAndYear.put("FallSenior", 6)
        self.termAndYear.put("SpringSenior", 7)

    def randomLetterGrade(self):
        """ generated source for method randomLetterGrade """
        grade = LetterGrade.None_
        if ((Math.random() * 9))==0:
            grade = LetterGrade.FF
        elif ((Math.random() * 9))==1:
            grade = LetterGrade.FD
        elif ((Math.random() * 9))==2:
            grade = LetterGrade.DD
        elif ((Math.random() * 9))==3:
            grade = LetterGrade.DC
        elif ((Math.random() * 9))==4:
            grade = LetterGrade.CC
        elif ((Math.random() * 9))==5:
            grade = LetterGrade.CB
        elif ((Math.random() * 9))==6:
            grade = LetterGrade.BB
        elif ((Math.random() * 9))==7:
            grade = LetterGrade.BA
        elif ((Math.random() * 9))==8:
            grade = LetterGrade.AA
        return grade

    def semesterGenerator(self, student, schedule, i):
        """ generated source for method semesterGenerator """
        semester = Semester(None)
        listOfLecture = HashMap()
        for l in DataManager.getInstance().searchLecture(i):
            if student.getTranscript() == None:
                listOfLecture.put(l, self.randomLetterGrade())
                continue 
            if student.canTakeLecture(l, student.getTranscript()):
                listOfLecture.put(l, self.randomLetterGrade())
        semester.setListOfLecturesTaken(listOfLecture)
        return semester

    def setAllSemester(self, student, schedule):
        """ generated source for method setAllSemester """
        semesterList = ArrayList()
        i = 0
        while i < termAndYear.get(schedule.getTerm() + "" + schedule.getTermYear()):
            semesterList.add(self.semesterGenerator(student, schedule, i))
            i += 1
        return semesterList