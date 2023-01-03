
from calendar import Calendar
from Logger import Logger
from Instructor import Instructor
from Student import Student
from LectureRegistrationApplication import LectureRegistrationApplication
from ApprovalState import ApprovalState
from InstructorType import InstructorType
from InstructorID import InstructorID
from Lecture import Lecture
from LectureSession import LectureSession
#from Schedule import Schedule;

class Advisor(Instructor):
    # generated source for class Advisor 
    #log = Logger.getLogger("logs")
    #__listOfStudents = List()
    #__listOfApplications = List()
    #__scanner = input()

    def __init__(self):
        # generated source for method __init__ 
        #super(firstName, lastName, id, dateOfEntry, instructorType, schedule)
        self.__listOfStudents = list()
        self.__listOfApplications = list()
        self.__log = Logger.getLogger("logs")

        if self.__listOfStudents == None:
            self.__listOfStudents = list(Student)
        if self.__listOfApplications == None:
            self.__listOfApplications = list(LectureRegistrationApplication)


    def showApplications(self):
        # generated source for method showApplications 
        choice = -1
        while choice != 0:
            count = 0
            for lectureRegistrationApplication in self.getListOfApplications():
                count += 1
                self.__log.info("" + count + ". " + lectureRegistrationApplication.getStudent().getFullName())
            self.__log.info("0. Exit")
            self.__log.info("Choose A Lecture Registration Application: ")
            choice = input()
            if choice != 0:
                self.applicationOperations(choice - 1)

    def applicationOperations(self, choice):
        # generated source for method applicationOperations 
        lectureRegistrationApplication = self.getListOfApplications()[choice]
        lectureChoice = ""
        while not lectureChoice == "0":
            self.__log.info("Name Of Student: " + lectureRegistrationApplication.getStudent().getFullName())
            count = 0
            self.__log.info("Session Name                 Approval State")
            for me in lectureRegistrationApplication.getSessionsSentForApproval().entrySet():
                count += 1
                sessionName = me.getKey().getLecture().getID() + "." + me.getKey().getSessionID()
                self.__log.info("%d. %-30s%s", count, sessionName, me.getValue())
            self.__log.info("0. Exit")
            self.__log.info("Please Enter The Session Name(0 for exit): ")
            lectureChoice = input()
            lectureSession = None
            for me in lectureRegistrationApplication.getSessionsSentForApproval().entrySet():
                sessionName = me.getKey().getLecture().getID() + "." + me.getKey().getSessionID()
                if sessionName.lower() == lectureChoice.lower():
                    lectureSession = me.getKey()
            self.__log.info("1. Approve")
            self.__log.info("2. Reject")
            self.__log.info("3. Go Back")
            approveChoice = input()
            if approveChoice==1:
                self.approveApplication(lectureRegistrationApplication, lectureSession)
            elif approveChoice==2:
                self.rejectApplication(lectureRegistrationApplication, lectureSession)
            else:
                pass


    def getListOfStudents(self):
        # generated source for method getListOfStudents 
        return self.__listOfStudents

    def getListOfApplications(self):
        # generated source for method getListOfApplications 
        return self.__listOfApplications

    def approveApplication(self, lectureRegistirationApplication, lectureSession):
        # generated source for method approveApplication 
        lectureRegistirationApplication.getSessionsSentForApproval().put(lectureSession, ApprovalState.Approved)
        lectureRegistirationApplication.getStudent().getSchedule().getListOfLectureSessions().add(lectureSession)

    def rejectApplication(self, lectureRegistirationApplication, lectureSession):
        # generated source for method rejectApplication 
        lectureRegistirationApplication.getSessionsSentForApproval().put(lectureSession, ApprovalState.Rejected)