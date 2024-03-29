### Design Class Diagram
----

**UniqueID** is an interface

**UniqueID** has a method named *setID(String)*

**UniqueID** has a method named *getID():String* 

**UniqueID** has a method named *digitFixer(Integer):String* 

----

**LectureID** implements **UniqueID**

**LectureID** has a constructor *LectureID(String)*

**LectureID** has a private *lectureCode* as a **Integer**

**LectureID** has a method named *setID(String)*

**LectureID** has a method named *digitFixer(Integer): String*

**LectureID** has a method named *getID():String*

----

**StudentID** implements **UniqueID**

**StudentID** has a private *departmentCode* as a **Integer**

**StudentID** has a private *yearCode* as a **Integer**

**StudentID** has a private *orderOfPlacement* as a **Integer**

**StudentID** has a method named *setID(String)*

**StudentID** has a method named *digitFixer(Integer): String*

**StudentID** has a method named *setID(Integer, Integer, Integer)* which directly sets the *departmentCode*, *yearCode*, and *orderOfPlacement*

**StudentID** has a method named *getID():String* which concatanates the variables and returns them as a **String**

----

**SessionID** implements **UniqueID**

**SessionID** has a private *id* as a **Integer**

**SessionID** has a method named *setID(Integer)* which directly sets the *id*

**SessionID** has a method named *getID():String* returns the *id* as a **String**

**SessionID** has a method named *setID(String)*

**SessionID** has a method named *digitFixer(Integer): String*

----

**InstructorID** implements **UniqueID**

**InstructorID** has a private *departmentCode* as a **Integer**

**InstructorID** has a private *orderOfEntry* as a **Integer**

**InstructorID** has a method named *setID(Integer, Integer)* which directly sets the *departmentCode*, and *orderOfEntry*

**InstructorID** has a method named *getID():String* which concatanates the variables and returns them as a **String**

**InstructorID** has a method named *setID(String)*

**InstructorID** has a method named *digitFixer(Integer): String*

----

**Person** has a protected *firstName* as **String**

**Person** has a protected *lastName* as **String**

**Person** has a constructor *Person(String,String)*

**Person** has methods named *getFirstName():String*, *getLastName():String*, and *getID():String* which returns their counterparts

**Person** has methods named *setFirstName(String)*, *setLastName(String)*

----

**Student** inherits from **Person**

**Student** has a private transient *advisor* as **Advisor**

**Student** has a private *id* as **StudentID**

**Student** has a private *listOfLectureSessions* as **List<-LectureSession->**

**Student** has a private *transcript* as **Transcript**

**Student** has a private *dateOfEntry* as **Calendar**

**Student** has a private *debt* as **Debt**

**Student** has a private *registirationApplication* as **LectureRegistirationApplication**

**Student** has a constructor *Student(String, String, StudentID, List<-LectureSession->, Transcript, Calendar)*

**Student** has methods named *getAdvisor():Advisor*, *getID():String*, *getListOfLectureSessions():List<-LectureSession->*, *getTranscript():Transcript*, *getDebt():Debt*, *getRegistirationApplication():LectureRegistirationApplication*,and *getDateOfEntry():Calendar* which returns their counterparts

**Student** has methods named *setAdvisor(Advisor)*, *setDebt(Double)*, *setRegistirationApplication(LectureRegistirationApplication)*, *sendForApproval(List<-LectureSession->)*, *setId(StudentID)*, *setTranscript(Transcript)*, *setDateOfEntry(Calendar)*

----

**Transcript** has a private *student* as **Student**

**Transcript** has a private *listOfSemesters* as **List<-Semester->** 

**Transcript** has a private *gano* as **Double**

**Transcript** has a private *totalCreditsTaken* as **Integer**

**Transcript** has a private *totalCreditsCompleted* as **Integer**

**Transcript** has a private *points* as **Double**

**Transcript** has a constructor *Transcript(Student, ArrayList<-Semester->, Double, Integer, Integer, Double)*

**Transcript** has methods named *getStudent():Student*, *getListOfSemesters():List<-Semester->*, *getGano():Double*, *getTotalCreditsTaken():Integer*, *getTotalCreditsCompleted():Integer*, *getPoints():Double* which returns their counterparts

**Transcript** has a method named *addSemester(Semester)*

----

**Semester** has a private *listOfLecturesTaken* as **Map<-Lecture,LetterGrade->**

**Semester** has a private *creditsTaken* as **Integer**

**Semester** has a private *creditsCompleted* as **Integer**

**Semester** has a private *points* as **Double**

**Semester** has a private *yano* as **Double**

**Semester** has a constructor *Semester(Map<-Lecture, LetterGrade->, Integer, Integer, Double, Double)*

**Semester** has methods named *getListOfLecturesTaken():Map<-Lecture,LetterGrade->*,*getCreditsTaken():Integer*, *getCreditsCompleted():Integer*, *getPoints():Double*, *getYano(): Double* which returns their counterparts

**Semester** has methods named *addLecture(Lecture,LetterGrade)*, *removeLecture(Lecture, LetterGrade)*,*setCreditsTaken(Integer)*, *setCreditsCompleted(Integer)*, *setPoints(Double)*

----

**LetterGrade** is a enum with **Double** values

**LetterGrade** has a private final *grade* as **Double**

**LetterGrade** has a constructor *LetterGrade(Double)*

**LetterGrade** has a method named *getLetterGradeValue(): Double*

----

**Instructor** inherits from **Person**

**Instructor** has a protected *id* as **InstructorID**

**Instructor** has a private *ListOfLectures* as **List<-Lecture->**

**Instructor** has a protected *dateOfEntry* as **Calendar**

**Instructor** has a protected *instructorType* as **InstructorType**

**Instructor** has a constructor *Instructor(String, String, InstructorID, List<-Lecture->, Calendar, InstructorType)*

**Instructor** has methods named *getID():String*, *getListOfLectures():List<-Lecture->*, and *getDateOfEntry():Calendar*, *getInstructorType():InstructorType* which returns their counterparts

**Instructor** has methods named *addLecture(Lecture)*, and *removeLecture(Lecture)*

----

**SessionType** is an enum with values of *Theorytical* and *Application*

----

**Lecture** has a private *id* as **LectureID**

**Lecture** has a private *name* as **String**

**Lecture** has a private *lectureType* as **LectureType**

**Lecture** has a private *credit* as **Integer**

**Lecture** has a private *sessions* as **List<-LectureSession->**

**Lecture** has a private *prerequisite* as **Lecture**

**Lecture** has a private *quota* as **Integer**

**Lecture** has a constructor *Lecture(LectureID, String, LectureType, Integer, List<-LectureSesion->, Lecture, Integer)*

**Lecture** has methods named *getID():String*,*getName():String*, *getLectureType():LectureType*, *getCredit():Integer*, *getSessions():List<-LectureSession->*, *getPrerequisite()Lecture*, and *getQuota():Integer* which returns their counterparts

**Lecture** has methods named *setName(String)*, *setLectureType(LectureType)*, *setCredit(Integer)*, *setQuota(Integer)*, *addLectureSession(LectureSession)*, *removeLectureSession(LectureSession)*, *addPrerequisiteLecture(Lecture)*, *removePrerequisiteLecture(Lecture)*


----

**LectureSession** has a private *sessionID* as **SessionID**

**LectureSession** has a private transient *lecture* as **Lecture**

**LectureSession** has a private *sessionHours* as **LectureHour[][]**

**LectureSession** has a private *sessionType* as **SessionType**

**LectureSession** has a private *instructor* as **Instructor**

**LectureSession** has a private *listOfAssistants* as **List<-Instructor->**

**LectureSession** has a constructor *LectureSession(SessionID, Lecture, LectureHour[][], SessionType, Instructor, List<-Instructor->)*

**LectureSession** has a method named *getSessionID(): String*

**LectureSession** has a method named *getSessionHours():LectureHour[7][10]*

**LectureSession** has a method named *getSessionType():SessionType*

**LectureSession** has a method named *getInstructor(): Instructor*

**LectureSession** has a method named *getListOfAssistants():List<-Instructor->*

**LectureSession** has a method named *getLecture(): Lecture*

----

**LectureHour** is an Enum which contains Yes and No

----

**Advisor** inherits from **Instructor**

**Advisor** has a private *listOfStudents* as **List<-Student->**

**Advisor** has a private *listOfApplications* as **List<-LectureRegistirationApplication->**

**Advisor** has a constructor *Advisor(String, String, InstructorID, List<-Lecture->, Calendar, List<-Student->, List<-LectureRegistrationApplication->, InstructorType)*

**Advisor** has a method named *getListOfStudents(): List<-Student->*

**Advisor** has a method named *getListOfApplications(): List<-LectureRegistirationApplication->*

**Advisor** has a method named *approveApplication(LectureRegistirationApplication):void*


----

**LectureRegistirationApplication** has a private *sessionsSentForApproval* as a **Map<-LectureSession, ApprovalState->**

**LectureRegistirationApplication** has a private *advisor* as an **Advisor**

**LectureRegistirationApplication** has a private *student* as a **Student**

**LectureRegistirationApplication** has a constructor *LectureRegistirationApplication(Map<-LectureSession, ApprovalState->, Advisor, Student)*

**LectureRegistirationApplication** has a method named *getSessionsSentForApproval(): Map<-LectureSession, ApprovalState->*

----

**Debt** has a private *amount* as **Double**

**Debt** has a private *student* as **Student**

**Debt** has a constructor *Debt(Double, Student)*

**Debt** has methods named *getStudent():Student*, *getAmound():Double*

**Debt** has methods named *setAmount(Double)*, *setStudent(Student)*

----

**FilterType** is an enum with *Name*, *ID*

----

**DataManager** has a private static *singleInstance* as **DataManager**

**DataManager** has a public static method named *getInstance()* which returns the *singleInstance*

**DataManager** has a private *listOfLectures* as **List<-Lectures->**

**DataManager** has a private *listOfPeople* as **List<-Person->**

**DataManager** has a private *cacheList* as **List<-Person->**

**DataManager** has a private constructor *DataManager()*

**DataManager** has a private method named *searchInPerson():Person*

**DataManager** has a private method named *findListOfFilesInDirectory():File[]*

**DataManager** has a private method named *loadLectures()*

**DataManager** has a private method named *loadAdvisors()*

**DataManager** has a private method named *loadInstructors()*

**DataManager** has a private method named *loadStudents()*

**DataManager** has a method named *findLecture(FilterType, String)* which returns a **Lecture**

**DataManager** has a method named *findPerson(FilterType, String)* which returns a **Person**

**DataManager** has a method named *findStudent(FilterType, String)* which returns a **Student**

**DataManager** has a method named *findInstructor(FilterType, String)* which returns a **Instructor**

**DataManager** has a method named *findAdvisor(FilterType, String)* which returns a **Advisor**

**DataManager** has a private method names *listOfFilesInDirectory(String):File[]*

**DataManager** has a private method names *contentsOfFiles(File[]):List<-String->*

----

**JsonOperator** has a private static *singleInstance* as **JsonOperator**

**JsonOperator** has a private constructor *JsonOperator()*

**JsonOperator** has a method named *readJsonFile(File, Class<-T->):T*

**JsonOperator** has a method named *writeJsonFile(String,<-T->)*

----

**AdvisorJSON** inherits from InstructorJSON

**AdvisorJSON** has a private *listOfStudentIDs* as **List<-String->**

**AdvisorJSON** has a constructor *AdvisorJSON(String, String)*

**AdvisorJSON** has a method named *addStudent(String)*

----

**InstructorJSON** inherits from PersonJSON

**InstructorJSON** has a constructor *InstructorJSON(String, String)*

----

**PersonJSON** has a protected *firstName* as **String**

**PersonJSON** has a protected *lastName* as **String**

**PersonJSON** has a constructor *PersonJSON(String, String)*

----

**StudentJSON** inherits from PersonJSON

**StudentJSON** has a private *advisorID* as **String**

**StudentJSON** has a private *studentID* as **String**

**StudentJSON** has a private *sessions* as **Map<-String, String->**

**StudentJSON** has a private *transcript* as **List<-Map<-String, String->->**

**StudentJSON** has a constructor *StudentJSON(String,String)*

**StudentJSON** has a method named *setAdvisorID(String)*

**StudentJSON** has a method named *setStudentID(String)*

**StudentJSON** has a metgod named *addSemester()*

----

**ApprovalState** is an enum with *Approved*, *Rejected*, *Pending*

----

**InstructorType** is an enum with *Assistant*, *Instructor*

----

**LectureType** is an enum with *NTE*, *UE*, *TE*, *FTE*, *MANDATORY*

----

**ObjectCreator** has a private *advisors* as **List<-Advisor->**

**ObjectCreator** has a private *students* as **List<-Srydent->**

**ObjectCreator** has a private *lectures* as **List<-Lecture->**

**ObjectCreator** has a private *transcripts* as **List<-Transcript->**

**ObjectCreator** has a constructor *ObjectCreator()*

**ObjectCreator** has a private method named *newTranscript(Student, List<-Semester->, Double, Integer, Integer, Double)*

**ObjectCreator** has a private method named *newStudent(String, String, String, Integer)*

**ObjectCreator** has a private method named *newLecture(String, String, LectureType, Integer, Lecture, Integer)*

**ObjectCreator** has a private method named *newAdvisor(String, String, String)*

**ObjectCreator** has a private method named *randomizeSessionHours():LectureHour[][]*

**ObjectCreator** has a public method named *createTranscripts()*

**ObjectCreator** has a public method named *createStudents()*

**ObjectCreator** has a public method named *createLectures()*

**ObjectCreator** has a public method named *createAdvisors()*

**ObjectCreator** has a public method named *getAdvisors(): List<-Advisor->*

**ObjectCreator** has a public method named *getStudents(): List<-Student->*

**ObjectCreator** has a public method named *getLectures(): List<-Lecture->*

**ObjectCreator** has a public method named *getTranscripts(): List<-Transcript->*

----

**RegistirationSystem** has a private *objects* as **ObjectCreator**

**RegistirationSystem** has a private *scanner* as **Scanner**

**RegistirationSystem** has a constructor *RegistrationSystem()*

**RegistirationSystem** has a public method named *menu()*

----

**StudentRegistrationSystem** has a private *scanner* as **Scanner**

**StudentRegistrationSystem** has a private *registrationSystem* as **RegistrationSystem**

**StudentRegistrationSystem** has a private *objects1* as **ObjectCreator**

**StudentRegistrationSystem** has a constructor *StudentRegistrationSystem(ObjectCreator)*

**StudentRegistrationSystem** has a private method named *studentLogin()*

**StudentRegistrationSystem** has a private method named *studentMenu(Student)*

**StudentRegistrationSystem** has a private method named *transcriptMenu(Student)*

**StudentRegistrationSystem** has a private method named *scheduleMenu(Student)*

**StudentRegistrationSystem** has a private method named *makeRegistirationMenu(Student)*

**StudentRegistrationSystem** has a private method named *registirationStatusMenu(Student)*

**StudentRegistrationSystem** has a private method named *debtMenu(Student)*

**StudentRegistrationSystem** has a private method named *signOut()*

**StudentRegistrationSystem** has a private method named *showChosenLectureSessions(List<-LectureSession->)*

**StudentRegistrationSystem** has a private method named *parseSelectionCommand(String, List<-LectureSession->) *

----

**InstructorRegistirationSystem**

----

**AdvisorRegistirationSystem**

----

**Simulation** has a private *transcriptCreator* as **TranscriptCreator**

**Simulation** has a private *studentCreator* as **StudentCreator**

----

**StudentCreator** has a private *firstNamePool* as **List<-String->**

**StudentCreator** has a private *lastNamePool* as **List<-String->**

**StudentCreator** has a public method named *generateStudent(): Student* 

----

**TranscriptCreator** has a private *transcriptList* as **List<-Transcript->**

**TranscriptCreator** has a public method named *generateTranscript(Student): Transcript*

**TranscriptCreator** has a public method named *addGeneration(): void*

**TranscriptCreator** has a private *transcriptList* as **List<-Transcript->**

----