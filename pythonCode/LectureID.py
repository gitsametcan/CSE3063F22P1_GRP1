from UniqueID import UniqueID

class LectureID(UniqueID):
    def init(self, __lectureCode: str):
        self.__lectureCode = __lectureCode

     # Creating properties for variables

    def setID(self, string: str):
        self.lectureCode = string

    def getID(self) -> str:
        return self.lectureCode

