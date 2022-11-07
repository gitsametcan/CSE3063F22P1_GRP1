### Design Class Diagram
---------------

**Person** has a *firstName* as **String**, *lastName* as **String** and an *id* as **UniqueID**

----

**StudentID**, **InstructorID** and **LectureID** inherits from **UniqueID**

----

**Student** inherits from **Person**

**Student** has a *consultant* as **Consultant**

**Student** has a *id* as **StudentID**

**Student** has a *listOfLectures* as **List<-Lecture->**

**Student** has a transcript as **Transcript**


----

**Instructor** inherits from **Person**

**Instructor** has a *id* as **InstructorID**

**Instructor** has a *ListOfLectures* as **List<-Lecture->**

----

**Lecture** has an *id* as **LectureID**

**Lecture** has a *name* as **String**

**Lecture** has an *instructor* as **Instructor**

**Lecture** has a listOfAssistants as **List<-Assistant->**

**Lecture** has *lectureHours* 

----

**Consultant** inherits from **Instructor**

**Consultant** has a *ListOfStudents* as **List<-Student->**


