#import Lecture
import json
import os
from datetime import datetime

from LectureID import LectureID
from SessionID import SessionID
from SessionType import SessionType
from LectureHour import LectureHour
from LectureSession import LectureSession
from Lecture import Lecture
from LectureType import LectureType
from Term import Term
from TermYear import TermYear
from InstructorType import InstructorType
from InstructorID import InstructorID
from Advisor import Advisor
from StudentID import StudentID
from Student import Student

class JsonOperator():

    def __init__(self):
        self.__lectureJsonDicts = list()
        self.__lectureObjectsList = list()

        self.__advisorJsonDicts = list()
        self.__advisorObjectsList = list()

        self.__studentJsonDicts = list()
        self.__studentObjectsList = list()

        self.__transcriptJsonDicts = list()
        self.__transcriptObjectsList = list()

        self.__metaData = dict() 
        pass

    def readMetaData(self):
        metaDataFile = open("JSON Files/MetaData.JSON")
        self.__metaData = json.load(metaDataFile)
        metaDataFile.close()
    
    def readNamePool(self):
        namePoolFile = open(self.__metaData["namePoolPath"])
        self.__namePool = json.load(namePoolFile)
        namePoolFile.close()

    def getMetaData(self): 
        return self.__metaData

    def getNamePool(self):
        return self.__namePool
    
    def readLectures(self):
        lecturesPath = self.__metaData["lecturesPath"]
        fileList = os.listdir(lecturesPath)
        for fileName in fileList:
            fullPath = lecturesPath + fileName
            f = open(fullPath, "r")
            jsonDict = json.load(f)
            self.__lectureJsonDicts.append(jsonDict)
        self.__generateLectureObjects()
    
    def __generateLectureObjects(self):
        for i in self.__lectureJsonDicts:
            id = LectureID(i["ID"])
            name = i["Name"]
            lectureType = LectureType[i["lectureType"]]
            quota = i["quota"]
            credit = i["credit"]
            term = i["term"]
            termYear = i["termYear"]
            lectureSessions = i["lectureSessions"]
            lectureObject = Lecture()

            lectureObject.setId(id)
            lectureObject.setName(name)
            lectureObject.setLectureType(lectureType)
            lectureObject.setQuota(quota)
            lectureObject.setCredit(credit)
            lectureObject.setTerm(Term[term])
            lectureObject.setTermYear(TermYear[termYear.strip()])

            lectureSessionsList = self.__generateLectureSessions(lectureSessions, lectureObject)
            lectureObject.setSessions(lectureSessionsList)

            self.__lectureObjectsList.append(lectureObject)
        
    def __generateLectureSessions(self, lectureSessions, lecture):
        sessionsList = list()
        for ls in lectureSessions:

            id = ls["ID"]
            instructorID = ls["instructorID"]
            sessionType = ls["sessionType"]
            sessionHours = ls["sessionHours"]

            idObject = SessionID(id)
            sessionTypeObject = SessionType[sessionType]
            sessionHoursObject = list()

            for i in sessionHours:
                day = list()
                for j in i:
                    if j == 0:
                        day.append(LectureHour.NO)
                    else:
                        day.append(LectureHour.YES)
                sessionHoursObject.append(day)
            
            lectureSessionObject = LectureSession()
            lectureSessionObject.setLecture = lecture
            lectureSessionObject.setSessionID = idObject
            lectureSessionObject.setSessionType = sessionTypeObject
            lectureSessionObject.setSessionHours = sessionHoursObject

            sessionsList.append(lectureSessionObject)

        return sessionsList

    def readAdvisors(self):
        lecturesPath = self.__metaData["advisorsPath"]
        fileList = os.listdir(lecturesPath)
        for fileName in fileList:
            fullPath = lecturesPath + fileName
            f = open(fullPath, "r")
            jsonDict = json.load(f)
            self.__advisorJsonDicts.append(jsonDict)
        self.__generateAdvisors()

    def __generateAdvisors(self):
        for a in self.__advisorJsonDicts:
            instructorTypeObject = InstructorType[a["instructorType"]]
            instructorIDObject = InstructorID(a["instructorID"])
            dateOfEntryObject = self.__strToDateTime(a["dateOfEntry"])
            firstName = a["firstName"]
            lastName = a["lastName"]

            advisorObject = Advisor()
            advisorObject.setFirstName(firstName)
            advisorObject.setLastName(lastName)
            # advisorObject.setDateOfEntry(dateOfEntryObject)
            # advisorObject.setID(instructorIDObject)
            # advisorObject.setInstructorType = instructorTypeObject

            self.__advisorObjectsList.append(advisorObject)

    def readStudents(self):
        studentsPath = self.__metaData["studentsPath"]
        fileList = os.listdir(studentsPath)
        for fileName in fileList:
            fullPath = studentsPath + fileName
            f = open(fullPath, "r")
            jsonDict = json.load(f)
            print(jsonDict)
            self.__studentJsonDicts.append(jsonDict)
        self.__generateStudentObjects()

    def __generateStudentObjects(self):
        for s in self.__studentJsonDicts:
            dateOfEntryObject = self.__strToDateTime(s["dateOfEntry"])
            firstName = s["firstName"]
            lastName = s["lastName"]

            studentObject = Student()
            studentObject.setID(s["studentID"])
            studentObject.setDateOfEntry(dateOfEntryObject)
            studentObject.setFirstName(firstName)
            studentObject.setLastName(lastName)

            self.__studentObjectsList.append(studentObject)

    def readTranscripts(self):
        transcriptsPath = self.__metaData["transcriptsPath"]
        fileList = os.listdir(transcriptsPath)
        for fileName in fileList:
            fullPath = transcriptsPath + fileName
            f = open(fullPath, "r")
            jsonDict = json.load(f)
            print(jsonDict)
            self.__transcriptJsonDicts.append(jsonDict)


    def pairObjects(self):
        self.pairLectures()

    def pairLectures(self):
        for ljs in self.__lectureJsonDicts:
            currentLecture = self.__findLecture(ljs["ID"])
            prerequisiteLecture = self.__findLecture(ljs["prerequisiteID"])
            if (prerequisiteLecture is not None):
                currentLecture.setPrerequisite(prerequisiteLecture)
            


    def __findLecture(self, id):
        for l in self.__lectureObjectsList:
            if l.getID() == id:
                return l
        return None

    def __strToDateTime(self, dtstr):
        dtformat = "%Y-%m-%d"
        dtobject = datetime.strptime(dtstr, dtformat)
        return dtobject

