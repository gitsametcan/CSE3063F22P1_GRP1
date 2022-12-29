class LectureRegistrationApplication:

    def __init__(self, __sessionsSentForApproval, __advisor, __student):
        self.__sessionsSentForApproval = __sessionsSentForApproval or {}
        self.__advisor = __advisor
        self.__student = __student

     # Creating properties for variables

    @property
    def __sessionsSentForApproval(self):
        return self.__sessionsSentForApproval
    
    @property
    def __advisor(self):
        return self.__advisor

    @property
    def __student(self):
        return self.__student

    @__sessionsSentForApproval.setter
    def __sessionsSentForApproval(self, __sessionsSentForApproval):
        self.__sessionsSentForApproval = __sessionsSentForApproval

    @__student.setter
    def __student(self, __student):
        self.__student = __student

    @__advisor.setter
    def __advisor(self, __advisor):
        self.__advisor = __advisor

