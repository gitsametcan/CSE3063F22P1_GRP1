from Student import Student
from LectureRegistrationApplication import LectureRegistrationApplication
from Transcript import Transcript
from Lecture import Lecture
from LectureType import LectureType


class LRAGenerator():

    def __init__(self):
        pass

    def generate(self, student : Student):
        LRA = LectureRegistrationApplication()
        
        if student.getTranscript() == None:
            student.getTranscript().setStudent(student)
            # student.getSchedule().setStudent(student)
            # student.getSchedule().setTerm(Term.Fall)
            # student.getSchedule().setTermYear(TermYear.Freshman)
            listOfSemester = list()
            student.getTranscript().setListOfSemester(listOfSemester)
        return LRA

    def fillLRA(self, LRA:LectureRegistrationApplication, student:Student):

        #searchmandatorylecture
        # for l in mandatoryList:
            #checkavaliable
            #checkiflectureavaliableforschedule # we should add method to Schedule
            #LRA.addLesson(l) #we should add addLecture method to LRA
                                #this method also check quota
        
        # while (UELecture ==2)
            # for l in ElectiveList:
                #choose random2 lecture
                #checkavaliable
        
        return LRA