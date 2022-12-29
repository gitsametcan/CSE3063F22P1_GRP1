class LectureID:
    def __init__(self, __lectureCode: str):
        self.__lectureCode = __lectureCode

     # Creating another properties for variables
    @ID.setter
    def ID(self, string: str):
        self.__lectureCode = string

    @property
    def ID(self) -> str:
        return self.__lectureCode

