class LectureRegistrationApplication():


    def __init__(self):
        pass
        #self.__sessionsSentForApproval = {hash(LectureSession): ApprovalState for LectureSession, ApprovalState in __sessionsSentForApproval.items()}
        #self.__advisor = __advisor
        #self.__student = __student

        #if self.__sessionsSentForApproval is None:
        #    self.__sessionsSentForApproval = {hash(LectureSession): ApprovalState for LectureSession in hash(LectureSession)}


     # Creating properties for variables

    def getSessionsSentForApproval(self):
        return self.__sessionsSentForApproval

    
    def getAdvisor(self):
        return self.__advisor

    def getStudent(self):
        return self.__student

    def setSsessionsSentForApproval(self, sessionsSentForApproval):
        self.__sessionsSentForApproval = sessionsSentForApproval

    def setStudent(self, student):
        self.__student = student

    def setAdvisor(self, advisor):
        self.__advisor = advisor
