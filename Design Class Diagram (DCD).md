### Design Class Diagram
----

**UniqueID** is an interface

**UniqueID** has a method named *setID(String)*

**UniqueID** has a method named *getID():String* 

**UniqueID** has a method named *digitFixer(Integer):String* 

----

**LectureID** implements **UniqueID**

**LectureID** has a private *departmentCode* as a **String**

**LectureID** has a constructor *LectureID(String, Integer, Integer)*

**LectureID** has a private *yearCode* as a **Integer**

**LectureID** has a private *lectureCode* as a **Integer**

**LectureID** has a method named *setID(String, Integer, Integer)* which directly sets the *departmentCode*, *yearCode*, and *lectureCode*

**LectureID** has a method named *setID(String)*

**LectureID** has a method named *digitFixer(Integer): String*

**LectureID** has a method named *getID():String* which concatanates the variables and returns them as a **String**

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

**Student** has methods named *setAdvisor(Advisor)*, *setDebt(Double)*, *setRegistirationApplication(LectureRegistirationApplication)*, *sendApprovement()*, *setId(StudentID)*, *setTranscript(Transcript)*, *setDateOfEntry(Calendar)*

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

**Semester** has a private *listOfLecturesTaken* as **HashMap<-Lecture,LetterGrade->**

**Semester** has a private *creditsTaken* as **Integer**

**Semester** has a private *creditsCompleted* as **Integer**

**Semester** has a private *points* as **Double**

**Semester** has a private *yano* as **Double**

**Semester** has a constructor *Semester(HashMap<-Lecture, LetterGrade->, Integer, Integer, Double, Double)*

**Semester** has methods named *getListOfLecturesTaken():HashMap<-Lecture,LetterGrade->*,*getCreditsTaken():Integer*, *getCreditsCompleted():Integer*, *getPoints():Double*, *getYano(): Double* which returns their counterparts

**Semester** has methods named *setLecture(Lecture,LetterGrade)*,*setCreditsTaken(Integer)*, *setCreditsCompleted(Integer)*, *setPoints(Double)*

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

**Lecture** has a private *price* as **Double**

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

**LectureRegistirationApplication** has a method named *approveApplication():void* which inserts its session data to the student.

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

**DataManager** has a private method named *loadLectures()*

**DataManager** has a private method named *loadAdvisors()*

**DataManager** has a private method named *loadInstructors()*

**DataManager** has a private method named *loadStudents()*

**DataManager** has a private method names *listOfFilesInDirectory(String):File[]*

**DataManager** has a private method names *contentsOfFiles(File[]):List<-String->*

----

**JsonOperator** has a private static *singleInstance* as **JsonOperator**

**JsonOperator** has a private constructor *JsonOperator()*

**JsonOperator** has a method named *readJsonFile(File, Class<-T->):T*

**JsonOperator** has a method named *writeJsonFile(String,<-T->)*

----

**AdvisorJSON** inherits from InstructorJSON

**AdvisorJSON** has a *listOfStudentIDs* as **List<-String->**

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

**StudentJSON** has a *advisorID* as **String**

**StudentJSON** has a *studentID* as **String**

**StudentJSON** has a *sessions* as **Map<-String, String->**

**StudentJSON** has a *transcript* as **Map<-String, String->**

----

**RegistirationSystem** has a public method named *menu()*