from Student import Student
from Advisor import Advisor
from LectureSession import LectureSession
from ApprovalState import ApprovalState

class LectureRegistrationApplication:


    def init(self, __sessionsSentForApproval, __advisor, __student):
        self.__sessionsSentForApproval = {hash(LectureSession): ApprovalState for LectureSession, ApprovalState in __sessionsSentForApproval.items()}
        self.__advisor = __advisor
        self.__student = __student

        if self.__sessionsSentForApproval is None:
            self.__sessionsSentForApproval = {hash(LectureSession): ApprovalState for LectureSession in hash(LectureSession)}


     # Creating properties for variables

    def getSessionsSentForApproval(self):
        return self.sessionsSentForApproval

    
    def getAdvisor(self):
        return self.__advisor

    def getStudent(self):
        return self.student

    def setSsessionsSentForApproval(self, sessionsSentForApproval):
        self.sessionsSentForApproval = sessionsSentForApproval

    def setStudent(self, student):
        self.student = student

    def setAdvisor(self, advisor):
        self.__advisor = advisor

