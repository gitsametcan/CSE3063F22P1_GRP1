class StudentID:
    def __init__(self, __departmentCode: int, __yearCode: int, __orderOfPlacement: int):
        self.__departmentCode = __departmentCode
        self.__yearCode = __yearCode
        self.__orderOfPlacement = __orderOfPlacement
    
    # Creating another properties for variables
    @ ID.setter
    def __init__(self, ID: str):
        self.__ID(ID)

    @ ID.setter
    def ID(self, __departmentCode: int, __yearCode: int, __orderOfPlacement: int):
        self.__departmentCode = __departmentCode
        self.yearCode = __yearCode
        self.orderOfPlacement = __orderOfPlacement

    @property
    def getID(self) -> str:
        return self.digitFixer(self.__departmentCode) + self.digitFixer(self.__yearCode) + self.digitFixer(self.__orderOfPlacement)

    @ ID.setter
    def setID(self, string: str):
        try:
            int(string)
        except ValueError:
            pass
        finally:
            self.__departmentCode = int(string[:3])
            self.__yearCode = int(string[3:6])
            self.__orderOfPlacement = int(string[6:])

    ## Creating another methods
    def digitFixer(self, integer: int) -> str:
        temp_order = str(integer)
        if integer < 10:
            temp_order = "00" + temp_order
        elif integer < 100:
            temp_order = "0" + temp_order
        return temp_order
