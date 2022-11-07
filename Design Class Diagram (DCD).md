### Design Class Diagram
----

**UniqueID** has a protected *id* as **String**

----

**Person** has a protected *firstName* as **String**

**Person** has a protected *lastName* as **String**

**Person** has a protected *id* as **UniqueID**

----

**StudentID**, **InstructorID** and **LectureID** inherits from **UniqueID**

----

**Student** inherits from **Person**

**Student** has a private *consultant* as **Consultant**

**Student** has a private *id* as **StudentID**

**Student** has a private *listOfLectures* as **List<-Lecture->**

**Student** has a private *transcript* as **Transcript**

----

**Transcript** has a private *student* as **Student**
**Transcript** has a private *listOfSemesters* as **List<-Semester->** 

----

**Instructor** inherits from **Person**

**Instructor** has a private *id* as **InstructorID**

**Instructor** has a private *ListOfLectures* as **List<-Lecture->**

----

**Lecture** has a private *id* as **LectureID**

**Lecture** has a private *name* as **String**

**Lecture** has a private *lectureType* as **LectureType**

**Lecture** has a private *instructor* as **Instructor**

**Lecture** has a private *listOfAssistants* as **List<-Assistant->**

**Lecture** has a private *credit* as **Integer**

**Lecture** has a private *sessions* as **List<-LectureSession->**

**Lecture** has a private *prerequisities* as **List<-Lecture->**

**Lecture** has a private *quota* as **Integer**

----

**LectureSession** has a private *sessionHour* as **LectureHour[][]**

----

**LectureHour** is an Enum which contains Yes and No

----

**Consultant** inherits from **Instructor**

**Consultant** has a private *ListOfStudents* as **List<-Student->**


