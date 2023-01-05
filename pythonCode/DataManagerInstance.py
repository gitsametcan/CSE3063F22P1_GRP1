from JsonOperator import JsonOperator
from FilterType import FilterType

class DataManagerInstance():

    def __init__(self):
        self.__listOfLectures = list()
        self.__listOfPeople = list()
        self.__jsonOperator = JsonOperator()
        
        print("FIRST TIME CREATING DATAMANAGERINSTANCE")

    def findLecture(self, key: str, filterType: FilterType):
        for l in self.__listOfLectures:
            if l.getID() == key and filterType is FilterType.ID:
                return l
            elif l.getName() == key and filterType is FilterType.Name:
                return l
        return None

    def findStudent(self, key: str, filterType: FilterType):
        from Student import Student
        for s in self.__listOfPeople:
            if s.getID() == key and filterType is FilterType.ID and isinstance(s, Student):
                student : Student = s
                return student
            elif s.getName() == key and filterType is FilterType.Name and isinstance(s, Student):
                student : Student = s
                return student
        return None

    def findAdvisor(self, key: str, filterType: FilterType):
        from Advisor import Advisor
        for a in self.__listOfPeople:
            if a.getID() == key and filterType is FilterType.ID and isinstance(a, Advisor):
                advisor : Advisor = a
                return advisor
            elif a.getName() == key and filterType is FilterType.Name and isinstance(a, Advisor):
                advisor : Advisor = a
                return advisor
        return None

    def hello(self):
       print("hello")

    def getMetaData(self):
        return self.__jsonOperator.getMetaData()
    
    def logCircleDeneme(self):
        from Logger import Logger
        Logger.getLogger("denemelog").info("circle!!")

    def getNamePool(self):
        return self.__jsonOperator.getNamePool()

    def loadFiles(self):
        self.__jsonOperator.readMetaData()
        self.__jsonOperator.readNamePool()
        self.__jsonOperator.readLectures()
        self.__jsonOperator.readAdvisors()
        self.__jsonOperator.readStudents()
        self.__jsonOperator.readTranscripts()
