class InstructorID:
    def __init__(self, __departmentCode: int, __orderOfEntry: int, __ID: str):
        self.__departmentCode = __departmentCode
        self.__orderOfEntry = __orderOfEntry
        self.__ID = __ID

    def __init__(self, ID: str):
        self.ID(ID)

     # Creating properties for variables
    @ ID.setter
    def Id(self, departmentCode: int, orderOfEntry: int):
        self.__departmentCode = departmentCode
        self.__orderOfEntry = orderOfEntry

    @property
    def ID(self) -> str:
        return self.digitFixer(self.__departmentCode) + self.digitFixer(self.__orderOfEntry)

     # Creating another properties for variables
    @ ID.setter
    def ID(self, string: str):
        try:
            int(string)
        except ValueError:
            pass
        finally:
            self.__departmentCode = int(string[:3])
            self.__orderOfEntry = int(string[3:])

    ## Creeate another methods
    def digitFixer(self, integer: int) -> str:
        tempOrder = str(integer)
        if integer < 10:
            tempOrder = "00" + tempOrder
        elif integer < 100:
            tempOrder = "0" + tempOrder
        return tempOrder
