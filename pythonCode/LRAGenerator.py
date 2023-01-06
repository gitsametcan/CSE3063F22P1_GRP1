from Student import Student
from LectureRegistrationApplication import LectureRegistrationApplication
from Transcript import Transcript
from Lecture import Lecture
from LectureType import LectureType
from Term import Term
from TermYear import TermYear
from DataManager import DataManager


class LRAGenerator():

    def __init__(self):
        pass

    def generate(self, listOfStudents:list, term: Term):

        nteList, ueList, teList, fteList, mandatoryList = DataManager.getInstance().searchLecturesUntilTerm("",Term.Spring, TermYear.Senior)
        lectureQuota ={}
        student = Student()
        for s in listOfStudents:

            LRA = LectureRegistrationApplication()

            for l in mandatoryList:
                lectureQuota.update({l : 1})
                a = 0
                b = 0
                c = 0
                for la in student.availableLessons():
                    if l == la:
                        a=1
                if student.canTakeLecture(l,student.getTranscript()):
                    b = 1
                if student.checkScheduleForLecture(student.getSchedule(),l):
                    c = 1
                
                #Add Lecture
            


        return listOfStudents

    def fillLRA(self, student:Student):

        LRA = LectureRegistrationApplication()


        #if
        #UE
        #TE
        #NTE
        #FTE

        #searchmandatorylecture
        # for l in mandatoryList:
            #checkavaliable
            #checkiflectureavaliableforschedule # we should add method to Schedule
                #LRA.addLesson(l) #we should add addLecture method to LRA
                                #this method also check quota
        
        
        # for l in ElectiveList:
            #choose random2 lecture
            #checkavaliable
            #checkiflectureavaliableforschedule
                #LRA.addLesson(1) #//
                #Elextive -1
            
        
        return LRA