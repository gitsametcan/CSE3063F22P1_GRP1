from Student import Student
from Advisor import Advisor
from LectureSession import LectureSession
from ApprovalState import ApprovalState

class LectureRegistrationApplication:

    __advisor = Advisor()
    __student = Student()
    __sessionsSentForApproval = {hash(LectureSession()): ApprovalState()}



    def __init__(self, __sessionsSentForApproval, __advisor, __student):
        self.__sessionsSentForApproval = {hash(LectureSession): ApprovalState for LectureSession, ApprovalState in __sessionsSentForApproval.items()}
        self.__advisor = __advisor
        self.__student = __student

        if self.__sessionsSentForApproval is None:
            self.__sessionsSentForApproval = {hash(LectureSession): ApprovalState for LectureSession in hash(LectureSession)}


     # Creating properties for variables

    def getSessionsSentForApproval(self):
        return self.__sessionsSentForApproval

    
    def getAdvisor(self):
        return self.__advisor

    def getStudent(self):
        return self.__student

    def setSsessionsSentForApproval(self, __sessionsSentForApproval):
        self.__sessionsSentForApproval = __sessionsSentForApproval

    def setStudent(self, __student):
        self.__student = __student

    def setAdvisor(self, __advisor):
        self.__advisor = __advisor

