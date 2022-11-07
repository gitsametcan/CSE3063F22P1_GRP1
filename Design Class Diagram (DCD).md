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

**Person** has a protected *id* as **UniqueID**

**Person** has methods named *getFirstName():String*, *getLastName():String*, and *getID():String* which returns their counterparts

**Person** has methods named *setFirstName(String)*, *setLastName(String)*

----

**Student** inherits from **Person**

**Student** has a private *consultant* as **Consultant**

**Student** has a private *id* as **StudentID**

**Student** has a private *listOfLectures* as **List<-Lecture->**

**Student** has a private *transcript* as **Transcript**

**Student** has a private *dateOfEntry* as **Calendar**

**Student** has methods named *getConsultant():Consultant*, *getID():String*, *getListOfLectures():List<-Lecture->*, *getTranscript():Transcript*, and *getDateOfEntry():Calendar* which returns their counterparts

**Student** has method named *setConsultant(Consultant)*

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

**Instructor** has a private *id* as **InstructorID**

**Instructor** has a private *ListOfLectures* as **List<-Lecture->**

**Instructor** has a private *dateOfEntry* as **Calendar**

**Instructor** has methods named *getID():String*, *getListOfLectures():List<-Lecture->*, and *getDateOfEntry():Calendar* which returns their counterparts

**Instructor** has methods named *addLecture(Lecture)*, and *removeLecture(Lecture)*

----

**SessionType** is an enum with values of *Theorytical* and *Application*

----

**Lecture** has a private *id* as **LectureID**

**Lecture** has a private *name* as **String**

**Lecture** has a private *lectureType* as **LectureType**

**Lecture** has a private *credit* as **Integer**

**Lecture** has a private *sessions* as **List<-LectureSession->**

**Lecture** has a private *prerequisities* as **List<-Lecture->**

**Lecture** has a private *quota* as **Integer**

**Lecture** has methods named *getID():String*,*getName():String*, *getLectureType():LectureType*, *getCredit():Integer*, *getSessions():List<-LectureSession->*, *getPrerequisities():List<-Lecture->*, and *getQuota():Integer* which returns their counterparts

**Lecture** has methods named *setName(String)*, *setLectureType(LectureType)*, *setCredit(Integer)*, *setQuota(Integer)*, *addLectureSession(LectureSession)*, *removeLectureSession(LectureSession)*, *addPrerequisiteLecture(Lecture)*, *removePrerequisiteLecture(Lecture)*


----

**LectureSession** has a private *sessionID* as **UniqueID**

**LectureSession** has a private *sessionHour* as **LectureHour[][]**

**LectureSession** has a private *sessionType* as **SessionType**

**LectureSession** has a private *instructor* as **Instructor**

**LectureSession** has a private *listOfAssistants* as **List<-Assistant->**

----

**LectureHour** is an Enum which contains Yes and No

----

**Consultant** inherits from **Instructor**

**Consultant** has a private *ListOfStudents* as **List<-Student->**

**Consultant** has a private *listOfApplications* as **List<-LectureRegistirationApplication->**

----

**LectureRegistirationApplication** has a private *listOfLectures* as a **List<-Lecture->**

**LectureRegistirationApplication** has a private *consultant* as a **Consultant**

**LectureRegistirationApplication** has a private *student* as a **Student**


