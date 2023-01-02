#!/usr/bin/env python
# package person;

from ast import List
import logger.Logger
from pythonCode.person.Instructor import Instructor

from pythonCode.person.Student import Student


import Debt_LRA_Transcript.LectureRegistrationApplication;
import Enums.ApprovalState;
import Enums.InstructorType;
import IDs.InstructorID;
import lecture.Lecture;
import lecture.LectureSession;
import lecture.Schedule;

class Advisor(Instructor):
    # generated source for class Advisor 
    log = Logger.getLogger("logs")
    __listOfStudents = List()
    __listOfApplications = List()
    __scanner = input()

    @overloaded
    def __init__(self, firstName, lastName, id, listOfLectures, dateOfEntry, listOfStudents, listOfApplications, instructorType, schedule):
        # generated source for method __init__ 
        super(firstName, lastName, id, dateOfEntry, instructorType, schedule)
        self.scanner = input()
        self.listOfStudents = listOfStudents
        self.listOfApplications = listOfApplications
        if self.listOfStudents == None:
            self.listOfStudents = List(Student)
        if self.listOfApplications == None:
            self.listOfApplications = List(LectureRegistrationApplication)

    def showApplications(self):
        # generated source for method showApplications 
        self.scanner = input()
        choice = -1
        while choice != 0:
            count = 0
            for lectureRegistrationApplication in self.getListOfApplications():
                count += 1
                self.log.info("" + count + ". " + lectureRegistrationApplication.getStudent().getFullName())
            self.log.info("0. Exit")
            self.log.info("Choose A Lecture Registration Application: ")
            choice = input()
            if choice != 0:
                applicationOperations(choice - 1)

    def applicationOperations(self, choice):
        # generated source for method applicationOperations 
        lectureRegistrationApplication = self.getListOfApplications().get(choice)
        lectureChoice = ""
        while not lectureChoice == "0":
            self.log.info("Name Of Student: " + lectureRegistrationApplication.getStudent().getFullName())
            count = 0
            self.log.info("Session Name                 Approval State")
            for me in lectureRegistrationApplication.getSessionsSentForApproval().entrySet():
                count += 1
                sessionName = me.getKey().getLecture().getID() + "." + me.getKey().getSessionID()
                self.log.info("%d. %-30s%s", count, sessionName, me.getValue())
            self.log.info("0. Exit")
            self.log.info("Please Enter The Session Name(0 for exit): ")
            lectureChoice = input()
            lectureSession = None
            for me in lectureRegistrationApplication.getSessionsSentForApproval().entrySet():
                sessionName = me.getKey().getLecture().getID() + "." + me.getKey().getSessionID()
                if sessionName.lower() == lectureChoice.lower():
                    lectureSession = me.getKey()
            self.log.info("1. Approve")
            self.log.info("2. Reject")
            self.log.info("3. Go Back")
            approveChoice = input()
            if approveChoice==1:
                self.approveApplication(lectureRegistrationApplication, lectureSession)
            elif approveChoice==2:
                self.rejectApplication(lectureRegistrationApplication, lectureSession)
            """else:"""

    def getListOfStudents(self):
        # generated source for method getListOfStudents 
        return self.listOfStudents

    def getListOfApplications(self):
        # generated source for method getListOfApplications 
        return self.listOfApplications

    def approveApplication(self, lectureRegistirationApplication, lectureSession):
        # generated source for method approveApplication 
        lectureRegistirationApplication.getSessionsSentForApproval().put(lectureSession, ApprovalState.Approved)
        lectureRegistirationApplication.getStudent().getSchedule().getListOfLectureSessions().add(lectureSession)

    def rejectApplication(self, lectureRegistirationApplication, lectureSession):
        # generated source for method rejectApplication 
        lectureRegistirationApplication.getSessionsSentForApproval().put(lectureSession, ApprovalState.Rejected)

    @__init__.register(object, str, str, InstructorID, Calendar, List, List, InstructorType, Schedule)
    def __init___0(self, firstName, lastName, id, dateOfEntry, listOfStudents, listOfApplications, instructorType, schedule):
        # generated source for method __init___0 
        super(firstName, lastName, id, dateOfEntry, instructorType, schedule)
        self.listOfStudents = listOfStudents
        self.listOfApplications = listOfApplications
        if self.listOfStudents == None:
            self.listOfStudents = List(Student)
        if self.listOfApplications == None:
            self.listOfApplications = List(LectureRegistrationApplication)