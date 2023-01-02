from UniqueID import UniqueID

class InstructorID(UniqueID):

    def init(self, __departmentCode: int, __orderOfEntry: int):
        self.__departmentCode = __departmentCode
        self.__orderOfEntry = __orderOfEntry

    def init(self, ID: str):
        self.setID(ID)

    # Creating another properties for variables

    def setID(self, string: str):
        try:
            int(string)
        except ValueError:
            pass
        finally:
            self.departmentCode = int(string[:3])
            self.orderOfEntry = int(string[3:])

     # Creating properties for variables

    def setId(self, departmentCode: int, orderOfEntry: int):
        self.departmentCode = departmentCode
        self.orderOfEntry = orderOfEntry

    def getID(self) -> str:
        return self.digitFixer(self.departmentCode) + self.digitFixer(self.orderOfEntry)

    ## Creeate another methods
    def digitFixer(self, integer: int) -> str:
        tempOrder = str(integer)
        if integer < 10:
            tempOrder = "00" + tempOrder
        elif integer < 100:
            tempOrder = "0" + tempOrder
        return tempOrder
