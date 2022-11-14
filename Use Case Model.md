Use Case 
_____________
Use Case Name: Enrolling To lectures
_____________
Summary: In order to get lectures, students must enroll to lectures from system and send request to their advisor.
_____________
Subject: Student
_____________
Basic Flow:
1- Student opens "Enroll to lectures" tab at site to view lectures.
2- Student needs to select their lectures from a lecture list according to their current curriculum, current semester and their current status of lecture progression.
3- System saves lectures as draft at another tab.
4- Student sends their lecture draft list to their advisor for approval.
5- Student's enrolling to a lecture process has done, lectures from list added to their syllabus.
______________
Alternative Flow:
Step 2:
    if selected lecture has reached their quota capacity system gives warning to student,
    then use case returns to step 2.
Step 3:
    if student needs to pay education debt and he/she didn't paid it yet, system sends warning to student and student returns to step 2.
Step 5:
    if two or more attendance needed lecture hours collides advisor rejects all of the collided lectures, student needs to return step 2 for enrolling rejected lectures and change some settings before advencing to step 3. 
Step 5:
    if student sent TE lecture to advisor for approval, even though they have taken 2 TE lectures in fall semester,
    advisor rejects that TE lecture.
Step 5:
    if student sent TE lecture to advisor for approval, even though they have taken 3 TE lectures in spring semester, advisor rejects that TE lecture.
Step 5:
    if student sent FTE lecture to advisor for approval and if student's graduation is impossible at that semester advisor rejects that FTE lecture.
¯¯¯¯¯¯¯¯¯¯¯¯¯¯

______________
Use Case Name: Approving/Rejecting lecture Requests
______________
Summary: In order to enregister students to lectures, advisor must enter the system and approve or reject coming requests from their students.
______________
Subject: Advisor
_____________
Basic Flow:
1- Advisor enters to systems's site and selects coming requests tab from site for approving or rejecting coming requests.
2- Advisor checks coming lecture requests from student.
3- Based on advisor's feedback system sends notification to student.
_____________
Alternative Flow:
Step 2:
    if two or more attendance needed lecture hours collides at requested lecture list advisor needs reject all of the collided lectures, after that advisor returns to step 2 for another student.
Step 2:
    if request has TE lecture even though student took 2 TE lectures in fall semester, advisor needs ro reject that TE lecture, after that advisor returns to step 2 for another student.
Step 2:
    if request has TE lecture even though student took 3 TE lectures in spring semester, advisor needs to reject that TE lecture, after that advisor returns to step 2 for another student.
Step 2:
    if request has FTE lecture and if student's graduation is impossible at that semester advisor needs to reject that FTE lecture, after that advisor returns to step 2 for another student.
¯¯¯¯¯¯¯¯¯¯¯¯¯¯