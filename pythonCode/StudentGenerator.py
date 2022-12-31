
#!/usr/bin/env python
# package: simulation
class StudentGenerator(object):
    """ generated source for class StudentGenerator """
    namePool = NamePool()
    transcriptGenerator = TranscriptGenerator()

    def __init__(self):
        """ generated source for method __init__ """
        optNamePool = DataManager.getInstance().getNamePool()
        self.namePool = None
        if optNamePool.isPresent():
            self.namePool = optNamePool.get()
        self.transcriptGenerator = TranscriptGenerator()

    def generate(self, studentCount, semesterCount):
        """ generated source for method generate """
        dateOfEntry = GregorianCalendar(2000 + (semesterCount / 2) + 18, 1, 22)
        student = Student(getRandomFirstName(), getRandomLastName(), studentIdGenerator(semesterCount + 18, studentCount), None, None, dateOfEntry)
        schedule = Schedule(student, Term.values()[semesterCount % 2], TermYear.values()[semesterCount / 2])
        student.setSchedule(schedule)
        student.setDebt(studentDebtGenerator())
        student.setAdvisor(getRandomAdvisor())
        student.setTranscript(self.transcriptGenerator.generate(student, schedule))
        student.setRegistirationApplication(LRAGenerator(student))
        return student

    def getRandomFirstName(self):
        """ generated source for method getRandomFirstName """
        return self.namePool.getRandomName()

    def getRandomLastName(self):
        """ generated source for method getRandomLastName """
        return self.namePool.getRandomLastName()

    def studentIdGenerator(self, year, orderOf):
        """ generated source for method studentIdGenerator """
        return StudentID(150, year, orderOf)

    def studentDebtGenerator(self):
        """ generated source for method studentDebtGenerator """
        debt = Debt()
        min = 1
        max = 10
        a = (Math.random()) * (max - min + 1) + min
        if a <= 3:
            debt = Debt(20000, None)
        else:
            debt = Debt(0, None)
        return debt

    def getRandomAdvisor(self):
        """ generated source for method getRandomAdvisor """
        return DataManager.getInstance().searchAdvisor("", FilterType.Name).get(((Math.random() * 13)))

    def LRAGenerator(self, student):
        """ generated source for method LRAGenerator """
        LRA = LectureRegistrationApplication(None, student.getAdvisor(), student)
        listOfLecture = HashMap()
        for l in student.availableLessons():
            listOfLecture.put(l.getSessions().get(0), ApprovalState.Pending)
        return LRA