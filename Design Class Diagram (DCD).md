### Design Class Diagram
----

**UniqueID** is an interface

**UniqueID** has a method named *setID(String)*

**UniqueID** has a method named *getID():String* 

----

**LectureID** implements **UniqueID**

**LectureID** has a private *departmentCode* as a **String**

**LectureID** has a private *yearCode* as a **Integer**

**LectureID** has a private *lectureCode* as a **Integer**

**LectureID** has a method named *setID(String, Integer, Integer)* which directly sets the *departmentCode*, *yearCode*, and *lectureCode*

**LectureID** has a method named *getID():String* which concatanates the variables and returns them as a **String**

----

**StudentID** implements **UniqueID**

**StudentID** has a private *departmentCode* as a **Integer**

**StudentID** has a private *yearCode* as a **Integer**

**StudentID** has a private *orderOfPlacement* as a **Integer**

**StudentID** has a method named *setID(Integer, Integer, Integer)* which directly sets the *departmentCode*, *yearCode*, and *orderOfPlacement*

**StudentID** has a method named *getID():String* which concatanates the variables and returns them as a **String**

----

**SessionID** implements **UniqueID**

**SessionID** has a private *id* as a **Integer**

**SessionID** has a method named *setID(Integer)* which directly sets the *id*

**SessionID** has a method named *getID():String* returns the *id* as a **String**

----

**InstructorID** implements **UniqueID**

**InstructorID** has a private *departmentCode* as a **Integer**

**InstructorID** has a private *orderOfEntry* as a **Integer**

**InstructorID** has a method named *setID(Integer, Integer)* which directly sets the *departmentCode*, and *orderOfEntry*

**InstructorID** has a method named *getID():String* which concatanates the variables and returns them as a **String**

----

**Person** has a protected *firstName* as **String**

**Person** has a protected *lastName* as **String**

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

**Student** has methods named *getAdvisor():Advisor*, *getID():String*, *getListOfLectureSessions():List<-LectureSession->*, *getTranscript():Transcript*, *getDebt():Debt*, *getRegistirationApplication():LectureRegistirationApplication*,and *getDateOfEntry():Calendar* which returns their counterparts

**Student** has methods named *setAdvisor(Advisor)*, *setDebt(Double)*, *setRegistirationApplication(LectureRegistirationApplication)*, *sendApprovement()*

----

**Transcript** has a private *student* as **Student**

**Transcript** has a private *listOfSemesters* as **List<-Semester->** 

**Transcript** has a private *gano* as **Double**

**Transcript** has a private *yano* as **Double**

**Transcript** has a private *totalCreditsTaken* as **Integer**

**Transcript** has a private *totalCreditsCompleted* as **Integer**

**Transcript** has a private *points* as **Double**

**Transcript** has methods named *getStudent():Student*, *getListOfSemesters():List<-Semester->*, *getGano():Double*, and *getYano():Double*, *getTotalCreditsTaken():Integer*, *getTotalCreditsCompleted():Integer*, *getPoints():Double* which returns their counterparts

**Transcript** has a method named *addSemester(Semester)*

----

**Semester** has a private *listOfLecturesTaken* as **HashMap<-Lecture,LetterGrade->**

**Semester** has a private *creditsTaken* as **Integer**

**Semester** has a private *creditsCompleted* as **Integer**

**Semester** has a private *points* as **Double**

**Semester** has methods named *getListOfLecturesTaken():HashMap<-Lecture,LetterGrade->*,*getCreditsTaken():Integer*, *getCreditsCompleted():Integer*, *getPoints():Double* which returns their counterparts

**Semester** has methods named *setLecture(Lecture,LetterGrade)*,*setCreditsTaken(Integer)*, *setCreditsCompleted(Integer)*, *setPoints(Double)*

----

**LetterGrade** is a enum with **Double** values

----

**Instructor** inherits from **Person**

**Instructor** has a protected *id* as **InstructorID**

**Instructor** has a private *ListOfLectures* as **List<-Lecture->**

**Instructor** has a protected *dateOfEntry* as **Calendar**

**Instructor** has methods named *getID():String*, *getListOfLectures():List<-Lecture->*, and *getDateOfEntry():Calendar* which returns their counterparts

**Instructor** has methods named *addLecture(Lecture)*, and *removeLecture(Lecture)*

----

**SessionType** is an enum with values of *Theorytical* and *Application*

----

**Lecture** has a private *id* as **LectureID**

**Lecture** has a private *name* as **String**

**Lecture** has a private *credit* as **Integer**

**Lecture** has a private *sessions* as **List<-LectureSession->**

**Lecture** has a private *prerequisities* as **List<-Lecture->**

**Lecture** has a private *quota* as **Integer**

**Lecture** has a private *price* as **Double**

**Lecture** has methods named *getID():String*,*getName():String*, *getCredit():Integer*, *getSessions():List<-LectureSession->*, *getPrerequisities():List<-Lecture->*, and *getQuota():Integer* which returns their counterparts

**Lecture** has methods named *setName(String)*, *setCredit(Integer)*, *setQuota(Integer)*, *addLectureSession(LectureSession)*, *removeLectureSession(LectureSession)*, *addPrerequisiteLecture(Lecture)*, *removePrerequisiteLecture(Lecture)*


----

**LectureSession** has a private *sessionID* as **UniqueID**

**LectureSession** has a private transient *lecture* as **Lecture**

**LectureSession** has a private *sessionHours* as **LectureHour[][]**

**LectureSession** has a private *sessionType* as **SessionType**

**LectureSession** has a private *instructor* as **Instructor**

**LectureSession** has a private *listOfAssistants* as **List<-Assistant->**

**LectureSession** has a method named *getSessionID(): String*

**LectureSession** has a method named *getSessionHours():LectureHour[7][10]*

**LectureSession** has a method named *getSessionType():SessionType*

**LectureSession** has a method named *getInstructor(): Instructor*

**LectureSession** has a method named *getListOfAssistants():List<-Assistant->*

----

**LectureHour** is an Enum which contains Yes and No

----

**Advisor** inherits from **Instructor**

**Advisor** has a private *listOfStudents* as **List<-Student->**

**Advisor** has a private *listOfApplications* as **List<-LectureRegistirationApplication->**

**Advisor** has a method named *getListOfStudents(): List<-Student->*

**Advisor** has a method named *getListOfApplications(): List<-LectureRegistirationApplication->*

**Advisor** has a method named *approveApplication(LectureRegistirationApplication):void*


----

**LectureRegistirationApplication** has a private *listOfLectureSessions* as a **List<-LectureSession->**

**LectureRegistirationApplication** has a private *advisor* as an **Advisor**

**LectureRegistirationApplication** has a private *student* as a **Student**

**LectureRegistirationApplication** has a method named *approveApplication():void* which inserts its session data to the student.

----

**Debt** has a private *amount* as **Double**

**Debt** has a private *student* as **Student**

**Debt** has methods named *getStudent():Student*, *getAmound():Double*

**Debt** has methods named *setAmount(Double)*, *setStudent(Student)*

----

**FilterType** is an enum with *Name*, *ID*

----

**DataManager** has a private constructor

**DataManager** has a private static *singleInstance* as **DataManager**

**DataManager** has a public static method named *getInstance()* which returns the *singleInstance*

**DataManager** has a private *listOfLectures* as **List<-Lectures->**

**DataManager** has a private *listOfPeople* as **List<-Person->**

**DataManager** has a private *cacheList* as **LinkedList<-Person->**

**DataManager** has a method named *findLecture(FilterType, String)* which returns a **Lecture**

**DataManager** has a method named *findPerson(FilterType, String)* which returns a **Person**

**DataManager** has a method named *findStudent(FilterType, String)* which returns a **Student**

**DataManager** has a method named *findInstructor(FilterType, String)* which returns a **Instructor**

**DataManager** has a method named *findAdvisor(FilterType, String)* which returns a **Advisor**

**DataManager** has a private method named *findInCache(FilterType, String, Class): Class*

**DataManager** has a private method named *findInPerson(FilterType, String, Class): Class*

**DataManager** has a private method named *loadLectures()*

**DataManager** has a private method named *loadAdvisors()*

**DataManager** has a private method named *loadInstructors()*

**DataManager** has a private method named *loadStudents()*

**DataManager** has a private method names *listOfFilesInDirectory(String):File[]*

**DataManager** has a private method names *contentsOfFiles(File[]):List<-String->*

----

**LectureFactory** has a *listOfLectures* as **List<-Lectures->**

**LectureFactory** has a method named *generateLecture()*

----

**RegistirationSystem** has a public method named *run()*