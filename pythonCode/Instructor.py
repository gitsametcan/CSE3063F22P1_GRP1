#!/usr/bin/env python
# package: person


from calendar import Calendar
from Logger import Logger

from InstructorType import InstructorType

from InstructorID import InstructorID

from LectureSession import LectureSession

from Schedule import Schedule

from Person import Person

class Instructor(Person):
    # generated source for class Instructor 
    #log = Logger.getLogger("logs")
    #_id = InstructorID()
    #__schedule = Schedule()
    #_dateOfEntry = Calendar()
    #_instructorType = InstructorType()
    #__scanner = input()

    def getID(self):
        # generated source for method getID 
        return self._id.getID()

    def getDateOfEntry(self):
        # generated source for method getDateOfEntry 
        return self._dateOfEntry

    def getInstructorType(self):
        # generated source for method getInstructorType 
        return self._instructorType

    def showLectures(self):
        # generated source for method showLectures 
        schedule = self.getSchedule()
        listOfLectureSessions = schedule.getListOfLectureSessions()
        for lectureSession in listOfLectureSessions:
            self.log.info(lectureSession.getLecture().__name__ + "." + lectureSession.getSessionID())
            self.log.info("------------")
            self.log.info("Quota: " + lectureSession.getLecture().getQuota())
            self.log.info("Number Of Students: " + lectureSession.getListOfStudents().size() + "\n")
        schedule.showSchedule()

    def showStudents(self):
        # generated source for method showStudents 
        count = 0
        for lectureSession in self.getSchedule().getListOfLectureSessions():
            count += 1
            self.log.info(count + ". " + lectureSession.getLecture().__name__ + "." + lectureSession.getSessionID())
        self.log.info("Choose A Session: ")
        sessionChoice = input()
        lectureSession = self.getSchedule().getListOfLectureSessions().get(sessionChoice - 1)
        for student in lectureSession.getListOfStudents():
            self.log.info("ID: " + student.getID() + "Name: " + student.getFullName())

    def __init__(self):
        # generated source for method __init__ 
        #super(firstName, lastName)
        self.scanner = input()
        self._id = InstructorID()
        self.__schedule = Schedule()
        self._dateOfEntry = Calendar()
        self._instructorType = InstructorType()
        pass

    def getSchedule(self):
        # generated source for method getSchedule 
        return self.schedule

    def setSchedule(self, schedule):
        # generated source for method setSchedule 
        self.schedule = schedule