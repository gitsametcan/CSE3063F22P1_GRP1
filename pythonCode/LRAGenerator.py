from Student import Student
from LectureRegistrationApplication import LectureRegistrationApplication
from Transcript import Transcript
from Lecture import Lecture
from LectureType import LectureType
from Term import Term


class LRAGenerator():

    def __init__(self):
        pass

    def generate(self, listOfStudents):

        for s in listOfStudents:

            s.setRegistirationApplication = self.fillLRA(s)
        
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