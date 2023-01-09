from Instructor import Instructor
from ApprovalState import ApprovalState

class Advisor(Instructor):

    def __init__(self):
        pass

    def getListOfStudents(self):
        try:
            x = self.__listOfStudents
        except AttributeError:
            self.__listOfStudents = list()
        
        return self.__listOfStudents

    def getListOfApplications(self):
        try:
            x = self.__listOfApplications
        except AttributeError:
            self.__listOfApplications = list()

        return self.__listOfApplications

    def approveApplication(self, lectureRegistirationApplication, lectureSession):
        # generated source for method approveApplication 
        lectureRegistirationApplication.getSessionsSentForApproval().put(lectureSession, ApprovalState.Approved)
        lectureRegistirationApplication.getStudent().getSchedule().getListOfLectureSessions().add(lectureSession)

    def rejectApplication(self, lectureRegistirationApplication, lectureSession):
        # generated source for method rejectApplication 
        lectureRegistirationApplication.getSessionsSentForApproval().put(lectureSession, ApprovalState.Rejected)

