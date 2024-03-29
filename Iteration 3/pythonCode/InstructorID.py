from UniqueID import UniqueID

class InstructorID(UniqueID):

    def __init__(self, *args):
        index = 0
        for t in args: 
            if (isinstance(t, int)):
                if index == 0:
                    self.__departmentCode = t
                if index == 1:
                    self.__orderOfEntry = t
            index += 1
            if (isinstance(t, str)):
                self.setID(t)

    # Creating another properties for variables

    def getID(self) -> str:
        return self.digitFixer(self.__departmentCode) + self.digitFixer(self.__orderOfEntry)
        
    def setID(self, *args):
        index = 0
        for t in args: 
            if (isinstance(t, int)):
                if index == 0:
                    self.__departmentCode = t
                if index == 1:
                    self.__orderOfPlacement = t
            index += 1
            if (isinstance(t, str)):
                try:
                    int(t)
                except ValueError:
                    pass
                finally:
                    self.__departmentCode = int(t[:3])
                    self.__orderOfEntry = int(t[3:])

    ## Creeate another methods
    def digitFixer(self, integer: int) -> str:
        tempOrder = str(integer)
        if integer < 10:
            tempOrder = "00" + tempOrder
        elif integer < 100:
            tempOrder = "0" + tempOrder
        return tempOrder
