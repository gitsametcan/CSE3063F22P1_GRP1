Use Case 
_____________
Use Case Name: Enrolling To Courses
_____________
Summary: In order to get courses, students must enroll to courses from system and send request to their advisor.
_____________
Subject: Student
_____________
Basic Flow:
1- Student opens "Enroll to Courses" tab at site.
2- Student needs to select their courses from a course list according to their current curriculum, current semester and their current status of course progression.
3- System drafts selected courses to another tab.
4- Student sends their selected course list to their advisor.
5- Student's enrolling to a course process has done, courses from list added to their syllabus.
______________
Alternative Flow:
Step 2:
    if selected course has reached their quota capacity system gives warning to student,
    then use case returns to step 2.
Step 5:
    if two or more attendance needed course hours collides advisor rejects all of the collided courses, student needs to return step 2 for enrolling rejected courses and change some settings before advencing to step 3. 
Step 5:
    if student sent TE course to advisor for approval, even though they have taken 2 TE courses in fall semester,
    advisor rejects that TE course.
Step 5:
    if student sent TE course to advisor for approval, even though they have taken 3 TE courses in spring semester, advisor rejects that TE course.
Step 5:
    if student sent FTE course to advisor for approval and if student's graduation is impossible at that semester advisor rejects that FTE course.
¯¯¯¯¯¯¯¯¯¯¯¯¯¯

______________
Use Case Name: Approving/Rejecting Course Requests
______________
Summary: In order to enregister students to courses, advisor must enter the system and approve or reject coming requests from their students.
______________
Subject: Advisor
_____________
Basic Flow:
1- Advisor enters to systems's site and selects coming requests tab from site.
2- Advisor checks coming course requests from student.
3- Advisor approves the request.
_____________
Alternative Flow:
Step 2:
    if two or more attendance needed course hours collides at requested course list advisor needs reject all of the collided courses, after that advisor returns to step 2 for another student.
Step 2:
    if request has TE course even though student took 2 TE courses in fall semester, advisor needs ro reject that TE course, after that advisor returns to step 2 for another student.
Step 2:
    if request has TE course even though student took 3 TE courses in spring semester, advisor needs to reject that TE course, after that advisor returns to step 2 for another student.
Step 2:
    if request has FTE course and if student's graduation is impossible at that semester advisor needs to reject that FTE course, after that advisor returns to step 2 for another student.
¯¯¯¯¯¯¯¯¯¯¯¯¯¯