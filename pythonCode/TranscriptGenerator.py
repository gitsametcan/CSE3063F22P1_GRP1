from LectureRegistrationApplication import LectureRegistrationApplication
from LetterGrade import LetterGrade
from DataManager import DataManager
from Lecture import Lecture
from Schedule import Schedule
from Semester import Semester
from Student import Student
import random
from TermAndYear import TermAndYear


class TranscriptGenerator():



    def __init__(self):
        pass

    def generate(self, student, schedule):
        #transcript = Transcript()
        transcript.setListOfSemester(self.setAllSemester(student, schedule))
        return transcript

    def __randomLetterGrade(self):
        
        a = random.randint(0, 9)
        grade = LetterGrade.Non
        if a==0:
            grade = LetterGrade.FF
        elif a==1:
            grade = LetterGrade.FD
        elif a==2:
            grade = LetterGrade.DD
        elif a==3:
            grade = LetterGrade.DC
        elif a==4:
            grade = LetterGrade.CC
        elif a==5:
            grade = LetterGrade.CB
        elif a==6:
            grade = LetterGrade.BB
        elif a==7:
            grade = LetterGrade.BA
        elif a==8:
            grade = LetterGrade.AA
        return grade

    def semesterGenerator(self, student, schedule, i):
        """ generated source for method semesterGenerator """
        semester = Semester()
        listOfLecture = {hash(Lecture): LetterGrade for Lecture, LetterGrade in listOfLecture.items()}
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
        semesterList = List()
        i = 0
        while i < TermAndYear[schedule.Term+""+schedule.TermYear].value:
            semesterList.add(self.semesterGenerator(student, schedule, i))
            i += 1
        return semesterList