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
    
    def getAdvisorList(self):
        return self.__advisorObjectsList
    
    def getStudentList(self):
        return self.__studentObjectsList
    
    def getLectureList(self):
        return self.__lectureObjectsList

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
            lectureSessionObject.setLecture(lecture)
            lectureSessionObject.setSessionID(idObject)
            lectureSessionObject.setSessionType(sessionTypeObject)
            lectureSessionObject.setSessionHours(sessionHoursObject)

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
            advisorObject.setDateOfEntry(dateOfEntryObject)
            advisorObject.setID(instructorIDObject)
            advisorObject.setInstructorType = instructorTypeObject

            self.__advisorObjectsList.append(advisorObject)

    def readStudents(self):
        studentsPath = self.__metaData["studentsPath"]
        fileList = os.listdir(studentsPath)
        for fileName in fileList:
            fullPath = studentsPath + fileName
            f = open(fullPath, "r")
            jsonDict = json.load(f)
            self.__studentJsonDicts.append(jsonDict)
        self.__generateStudentObjects()

    def __generateStudentObjects(self):
        from StudentID import StudentID
        for s in self.__studentJsonDicts:
            dateOfEntryObject = self.__strToDateTime(s["dateOfEntry"])
            firstName = s["firstName"]
            lastName = s["lastName"]

            studentObject = Student()
            studentObject.setID(StudentID(s["studentID"]))
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
            self.__transcriptJsonDicts.append(jsonDict)

    def pairObjects(self):
        self.__pairLectures()
        self.__pairStudents()
        self.__pairAdvisors()

    def __pairLectures(self):
        for ljs in self.__lectureJsonDicts:
            currentLecture = self.__findLecture(ljs["ID"])
            prerequisiteLecture = self.__findLecture(ljs["prerequisiteID"])
            if (prerequisiteLecture is not None):
                currentLecture.setPrerequisite(prerequisiteLecture)
            lectureSessions = ljs["lectureSessions"]

            for lsjs in lectureSessions:
                for ls in currentLecture.getSessions():
                    if ls.getSessionID() == lsjs["ID"]:
                        instructorID = lsjs["instructorID"]
                        advisor = self.__findAdvisor(instructorID)
                        ls.setInstructor(advisor)

    def __pairStudents(self):
        from Schedule import Schedule
        for sjs in self.__studentJsonDicts:
            currentStudent = self.__findStudent(sjs["studentID"])

            schedule = Schedule()
            schedulejs = sjs["schedule"]

            schedule.setPerson(currentStudent)
            schedule.setTerm(Term[schedulejs["term"]])
            schedule.setTermYear(TermYear[schedulejs["termYear"]])

            sessions = schedulejs["sessions"]

            for key in sessions.keys():
                tempLecture = self.__findLecture(key)
                sessionsList = schedule.getListOfLectureSessions()
                sessionsOfLecture = tempLecture.getSessions()
                sessionsList.append(sessionsOfLecture[0])
                schedule.setListOfLectureSessions(sessionsList)

            currentStudent.setSchedule(schedule)

            self.__pairTranscripts(currentStudent)
    
    def __pairAdvisors(self):
        from Schedule import Schedule
        for ajs in self.__advisorJsonDicts:
            currentAdvisor = self.__findAdvisor(ajs["instructorID"])

            schedule = Schedule()
            schedulejs = ajs["schedule"]

            schedule.setPerson(currentAdvisor)
            schedule.setTerm(Term[schedulejs["term"]])
            schedule.setTermYear(TermYear[schedulejs["termYear"]])

            sessions = schedulejs["sessions"]

            for key in sessions.keys():
                tempLecture = self.__findLecture(key)
                sessionsList = schedule.getListOfLectureSessions()
                sessionsOfLecture = tempLecture.getSessions()
                sessionsList.append(sessionsOfLecture[0])
                schedule.setListOfLectureSessions(sessionsList)

            currentAdvisor.setSchedule(schedule)

            listOfStudents = ajs["listOfStudentIDs"]
            for studentID in listOfStudents:
                for student in self.__studentJsonDicts:
                    if studentID == student["studentID"]:
                        currentStudent = self.__findStudent(studentID)
                        currentStudent.setAdvisor(currentAdvisor)
                        advisorStudents = currentAdvisor.getListOfStudents()
                        advisorStudents.append(currentStudent)
                        currentAdvisor.setListOfStudents(advisorStudents)

        pass

    def __pairTranscripts(self, student):
        from LetterGrade import LetterGrade
        from Semester import Semester
        from Transcript import Transcript
        for tjs in self.__transcriptJsonDicts:
            if tjs["studentID"] != student.getId():
                continue
            
            listOfSemesters = tjs["listOfSemesters"]
            listOfSemesterObjects = list()
            for semester in listOfSemesters:
                listOfLecturesTaken = dict()
                for key in semester.keys():
                    lecture = self.__findLecture(key)
                    letterGrade = LetterGrade[semester[key]]
                    listOfLecturesTaken[lecture] = letterGrade
                semesterObject = Semester()
                semesterObject.setListOfLecturesTaken(listOfLecturesTaken)
                listOfSemesterObjects.append(semesterObject)

            transcript = Transcript()
            transcript.setListOfSemester(listOfSemesterObjects)
            transcript.setStudent(student)
            student.setTranscript(transcript)
            self.__transcriptObjectsList.append(transcript)
        
    def saveStudent(self, student):
        advisorID = student.getAdvisor().getID()
        studentID = student.getID()
        schedule = student.getSchedule()
        schedulejs = dict()
        schedulejs["ID"] = studentID
        schedulejs["term"] = schedule.getTerm().name
        schedulejs["termYear"] = schedule.getTermYear().name
        sessionsjs = dict()
        sessions = schedule.getListOfLectureSessions()
        for session in sessions:
            sessionsjs[session.getLecture().getID()] = session.getSessionID()
        schedulejs["sessions"] = sessionsjs
        dateOfEntry = student.getDateOfEntry().strftime("%Y-%m-%d")
        firstName = student.getFirstName()
        lastName = student.getLastName()

        writeJson = dict()
        writeJson["advisorID"] = advisorID
        writeJson["studentID"] = studentID
        writeJson["schedule"] = schedulejs
        writeJson["dateOfEntry"] = dateOfEntry
        writeJson["firstName"] = firstName
        writeJson["lastName"] = lastName
        
        dumpedJson = json.dumps(writeJson, indent=4)
        writeFile = open(self.__metaData["studentsPath"] + studentID + ".JSON", "w")
        writeFile.writelines(dumpedJson)

    def saveAdvisor(self, advisor):
        instructorID = advisor.getID()
        listOfStudents = advisor.getListOfStudents()
        studentList = list()
        for s in listOfStudents:
            studentList.append(s.getID())
        schedule = advisor.getSchedule()
        schedulejs = dict()
        schedulejs["ID"] = instructorID
        schedulejs["term"] = schedule.getTerm().name
        schedulejs["termYear"] = schedule.getTermYear().name
        sessionsjs = dict()
        sessions = schedule.getListOfLectureSessions()
        for session in sessions:
            sessionsjs[session.getLecture().getID()] = session.getSessionID()
        schedulejs["sessions"] = sessionsjs
        instructorType = advisor.getInstructorType().name
        dateOfEntry = advisor.getDateOfEntry().strftime("%Y-%m-%d")
        firstName = advisor.getFirstName()
        lastName = advisor.getLastName()

        writeJson = dict()
        writeJson["instructorID"] = instructorID
        writeJson["listOfStudentIDs"] = studentList
        writeJson["schedule"] = schedulejs
        writeJson["instructorType"] = instructorType
        writeJson["dateOfEntry"] = dateOfEntry
        writeJson["firstName"] = firstName
        writeJson["lastName"] = lastName
        
        dumpedJson = json.dumps(writeJson, indent=4)
        writeFile = open(self.__metaData["advisorsPath"] + instructorID + ".JSON", "w")
        writeFile.writelines(dumpedJson)
        
    def saveLecture(self, lecture):
        lectureID = lecture.getID()
        lectureName = lecture.getName()
        prerequisite = lecture.getPrerequisite()
        prerequisiteID = ""
        if prerequisite is not None:
            prerequisiteID = prerequisite.getID()
        lectureType = lecture.getLectureType().name
        quota = lecture.getQuota()
        credit = lecture.getCredit()
        term = lecture.getTerm().name
        termYear = lecture.getTermYear().name
        lectureSessionsjs = list()
        sessions = lecture.getSessions()
        for ls in sessions:
            currentSession = dict()
            currentSession["ID"] = ls.getSessionID()
            currentSession["lectureID"] = lectureID
            if ls.getInstructor() is not None:
                currentSession["instructorID"] = ls.getInstructor().getID()
            else:
                currentSession["instructorID"] = ""
            currentSession["sessionType"] = ls.getSessionType().name
            sessionHours = ls.getSessionHours()
            sessionHoursJson = list()
            for i in sessionHours:
                day = list()
                for j in i:
                    if j == LectureHour.YES:
                        day.append(1)
                    else:
                        day.append(0)
                sessionHoursJson.append(day)
            currentSession["sessionHours"] = sessionHoursJson
            lectureSessionsjs.append(currentSession)
        writeJson = dict()
        writeJson["ID"] = lectureID
        writeJson["Name"] = lectureName
        writeJson["prerequisiteID"] = prerequisiteID
        writeJson["lectureType"] = lectureType
        writeJson["quota"] = quota
        writeJson["credit"] = credit
        writeJson["term"] = term
        writeJson["termYear"] = termYear
        writeJson["lectureSessions"] = lectureSessionsjs

        dumpedJson = json.dumps(writeJson, indent=4)
        writeFile = open(self.__metaData["lecturesPath"] + lectureID + ".JSON", "w")
        writeFile.writelines(dumpedJson)

    def saveTranscript(self, transcript):
        studentID = transcript.getStudent().getID()
        semesterList = transcript.getListOfSemester()

        semesterListJson = list()
        for semester in semesterList:
            lecturesAndGrades = dict()
            listOfLecturesTaken = semester.getListOfLecturesTaken()
            for key in listOfLecturesTaken.keys():
                lecturesAndGrades[key.getID()] = listOfLecturesTaken[key].name
            semesterListJson.append(lecturesAndGrades)

        writeJson = dict()
        writeJson["studentID"] = studentID
        writeJson["listOfSemesters"] = semesterListJson

        dumpedJson = json.dumps(writeJson, indent=4)
        writeFile = open(self.__metaData["transcriptsPath"] + studentID + ".JSON", "w")
        writeFile.writelines(dumpedJson)

        pass

    def __findLecture(self, id: str):
        for l in self.__lectureObjectsList:
            if l.getID() == id:
                return l
        return None

    def __findAdvisor(self, id: str):
        for a in self.__advisorObjectsList:
            if a.getID() == id:
                return a
        return None

    def __findStudent(self, id: str):
        for s in self.__studentObjectsList:
            if s.getID() == id:
                return s
        return None

    def __strToDateTime(self, dtstr: str):
        dtformat = "%Y-%m-%d"
        dtobject = datetime.strptime(dtstr, dtformat)
        return dtobject

