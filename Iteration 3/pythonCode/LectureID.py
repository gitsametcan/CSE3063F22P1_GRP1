from UniqueID import UniqueID

class LectureID(UniqueID):
    def __init__(self, __lectureCode: str):
        self.__lectureCode = __lectureCode

     # Creating properties for variables

    def setID(self, string: str):
        self.__lectureCode = string

    def getID(self) -> str:
        return self.__lectureCode
