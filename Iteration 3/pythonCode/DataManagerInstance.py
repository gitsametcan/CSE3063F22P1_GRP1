from JsonOperator import JsonOperator
from LectureType import LectureType
from FilterType import FilterType
from Term import Term
from TermYear import TermYear

class DataManagerInstance():

    def __init__(self):
        self.__listOfLectures = list()
        self.__listOfPeople = list()
        self.__jsonOperator = JsonOperator()
        

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
            elif s.getFullName() == key and filterType is FilterType.Name and isinstance(s, Student):
                student : Student = s
                return student
        return None

    def findAdvisor(self, key: str, filterType: FilterType):
        from Advisor import Advisor
        for a in self.__listOfPeople:
            if a.getID() == key and filterType is FilterType.ID and isinstance(a, Advisor):
                advisor : Advisor = a
                return advisor
            elif a.getFullName() == key and filterType is FilterType.Name and isinstance(a, Advisor):
                advisor : Advisor = a
                return advisor
        return None

    def searchLectures(self, key: str, filterType: FilterType):
        result = list()
        for l in self.__listOfLectures:
            if key in l.getID() and filterType is FilterType.ID:
                result.append(l)
            if key in l.getName() and filterType is FilterType.Name:
                result.append(l)
        return result

    def searchStudents(self, key: str, filterType: FilterType):
        from Student import Student
        result = list()
        for s in self.__listOfPeople:
            if key in s.getID() and filterType is FilterType.ID and isinstance(s, Student):
                student : Student = s
                result.append(student)
            if key in s.getFullName() and filterType is FilterType.ID and isinstance(s, Student):
                student : Student = s
                result.append(student)
        return result
        
    def searchAdvisors(self, key: str, filterType: FilterType):
        from Advisor import Advisor
        result = list()
        for a in self.__listOfPeople:
            if isinstance(a, Advisor) == False:
                continue

            if key in a.getID() and filterType == FilterType.ID:
                advisor : Advisor = a
                result.append(advisor)
            if key in a.getFullName() and filterType == FilterType.Name:
                advisor : Advisor = a
                result.append(advisor)
        return result

    def searchLecturesUntilTerm(self, key: str, term: Term, termYear: TermYear):
        result = list()
        for l in self.__listOfLectures:
            if key in l.getName() and l.getTermYear().value < termYear.value:
                result.append(l)
            if key in l.getName() and l.getTermYear().value == termYear.value and l.getTerm().value <= term.value:
                result.append(l)
        # mandatory, 
        mandatoryList = list()
        fteList = list()
        teList = list()
        ueList = list()
        nteList = list()

        for l in result:
            if l.getLectureType() == LectureType.MANDATORY:
                mandatoryList.append(l)
                continue
            if l.getLectureType() == LectureType.FTE:
                fteList.append(l)
                continue
            if l.getLectureType() == LectureType.NTE:
                nteList.append(l)
                continue
            if l.getLectureType() == LectureType.TE:
                teList.append(l)
                continue
            if l.getLectureType() == LectureType.UE:
                ueList.append(l)
                continue

        return (nteList, ueList, teList, fteList, mandatoryList)

    def searchLecturesOfTerm(self, key: str, term: Term):
        result = list()
        for l in self.__listOfLectures:
            if key in l.getName() and l.getTerm().value == term.value:
                result.append(l)
        mandatoryList = list()
        fteList = list()
        teList = list()
        ueList = list()
        nteList = list()
        
        for l in result:
            if l.getLectureType() == LectureType.MANDATORY:
                mandatoryList.append(l)
                continue
            if l.getLectureType() == LectureType.FTE:
                fteList.append(l)
                continue
            if l.getLectureType() == LectureType.NTE:
                nteList.append(l)
                continue
            if l.getLectureType() == LectureType.TE:
                teList.append(l)
                continue
            if l.getLectureType() == LectureType.UE:
                ueList.append(l)
                continue
        
        return (nteList, ueList, teList, fteList, mandatoryList)

    def getMetaData(self):
        return self.__jsonOperator.getMetaData()
    
    def getNamePool(self):
        return self.__jsonOperator.getNamePool()

    def loadFiles(self):
        self.__jsonOperator.readMetaData()
        self.__jsonOperator.readNamePool()
        self.__jsonOperator.readLectures()
        self.__jsonOperator.readAdvisors()
        self.__jsonOperator.readStudents()
        self.__jsonOperator.readTranscripts()
        self.__jsonOperator.pairObjects()

        self.__listOfLectures = self.__listOfLectures + self.__jsonOperator.getLectureList()
        self.__listOfPeople = self.__listOfPeople + self.__jsonOperator.getStudentList()
        self.__listOfPeople = self.__listOfPeople + self.__jsonOperator.getAdvisorList()

    def saveFiles(self):
        from Student import Student
        from Advisor import Advisor
        for p in self.__listOfPeople:
            if isinstance(p, Student):
                s: Student = p
                self.__jsonOperator.saveStudent(s)
                self.__jsonOperator.saveTranscript(s.getTranscript())
            if isinstance(p, Advisor):
                a: Advisor = p
                self.__jsonOperator.saveAdvisor(a)
        
        for l in self.__listOfLectures:
            self.__jsonOperator.saveLecture(l)

    def addStudents(self, studentsList : list):
        self.__listOfPeople = self.__listOfPeople + studentsList

