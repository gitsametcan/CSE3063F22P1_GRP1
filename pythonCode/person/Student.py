# package: person

"""import logger.Logger;"""

import Debt_LRA_Transcript.Debt;
import Debt_LRA_Transcript.LectureRegistrationApplication;
import Debt_LRA_Transcript.Transcript;
import Enums.ApprovalState;
import Enums.FilterType;
import Enums.LetterGrade;
import IDs.StudentID;
import data.DataManager;
import lecture.Lecture;
import lecture.LectureSession;
import lecture.Schedule;
import lecture.Semester;

class Student(Person):
    """ generated source for class Advisor """
    """log = Logger()"""
    advisor = Advisor()
    id = StudentID()
    schedule = Schedule()
    transcript = Transcript()
    dateOfEntry = Calendar()
    debt = Debt()
    registirationApplication = LectureRegistrationApplication()
    scanner = input()
    def __init__(self, firstName, lastName, id, schedule, transcript, dateOfEntry):
    super(firstName, lastName)
    """log = Logger.getLogger("logs")"""
    self.scanner = input()
    self.id = id
    self.schedule = schedule
    self.transcript = transcript
    self.dateOfEntry = dateOfEntry
    def setID(nID):
        """ generated source for method getInstructorType """
        self.id.setID(nID)
    def setID(DepartmentCode, YearCode, OrderOfPlacement):
        """ generated source for method getInstructorType """
        self.setID(DepartmentCode, YearCode, OrderOfPlacement)
    def setTranscript(transcript):
        """ generated source for method getInstructorType """
        self.transcript(transcript)
    def setDateOfEntry(dateOfEntry):
        """ generated source for method getInstructorType """
        self.dateOfEntry(dateOfEntry)
    def getAdvisor(self):
        """ generated source for method getInstructorType """
        return self.advisor
    def setAdvisor(advisor):
        """ generated source for method getInstructorType """
        self.advisor(advisor)
    def getDebt(self):
        """ generated source for method getInstructorType """
        return self.debt
    def setDebt(dateOfEntry):
        """ generated source for method getInstructorType """
        self.dateOfEntry(dateOfEntry)
    def getID(self):
        """ generated source for method getInstructorType """
        return id.getID()
    def sendForApproval(List(LectureSession) chosenLectureSessions):
        approvalList = dict()
        for (LectureSession ls : chosenLectureSessions)


