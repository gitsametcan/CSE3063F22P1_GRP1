class LectureRegistrationApplication():

    def __init__(self):
        pass

     # Creating properties for variables
    def getSessionsSentForApproval(self):
        try:
            x = self.__sessionsSentForApproval
        except AttributeError:
            return dict()
        return self.__sessionsSentForApproval

    def getAdvisor(self):
        return self.__advisor

    def getStudent(self):
        return self.__student

    def setSessionsSentForApproval(self, sessionsSentForApproval):
        self.__sessionsSentForApproval = sessionsSentForApproval

    def setStudent(self, student):
        self.__student = student

    def setAdvisor(self, advisor):
        self.__advisor = advisor
