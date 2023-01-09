from UniqueID import UniqueID

class StudentID(UniqueID):

    def __init__(self, *args):
        self.__departmentCode = 0
        self.__yearCode = 0
        self.__orderOfPlacement = 0
        index = 0
        for t in args: 
            if (isinstance(t, int)):
                if index == 0:
                    self.__departmentCode = t
                if index == 1:
                    self.__yearCode = t
                if index == 2:
                    self.__orderOfPlacement = t
            index += 1
            if (isinstance(t, str)):
                self.setID(t)

    # Creating properties for variables
        
    def setID(self, *args):
        index = 0
        for t in args: 
            if (isinstance(t, int)):
                if index == 0:
                    self.__departmentCode = t
                if index == 1:
                    self.__yearCode = t
                if index == 2:
                    self.__orderOfPlacement = t
            index += 1

            if (isinstance(t, str)):
                try:
                    int(t)
                except ValueError:
                    pass
                self.__departmentCode = int(t[:3])
                self.__yearCode = int(t[3:6])
                self.__orderOfPlacement = int(t[6:])

    def getID(self) -> str:
        return self.digitFixer(self.__departmentCode) + self.digitFixer(self.__yearCode) + self.digitFixer(self.__orderOfPlacement)

    ## Creating another methods
    def digitFixer(self, integer: int) -> str:
        tempOrder = str(integer)
        if integer < 10:
            tempOrder = "00" + tempOrder
        elif integer < 100:
            tempOrder = "0" + tempOrder
        return tempOrder
