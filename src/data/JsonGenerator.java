package data;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Debt_LRA_Transcript.Transcript;
import Enums.LectureHour;
import Enums.LetterGrade;
import Enums.Term;
import Enums.TermYear;
import data.json.AdvisorJSON;
import data.json.LectureJSON;
import data.json.LectureSessionJSON;
import data.json.MetaData;
import data.json.NamePool;
import data.json.ScheduleJSON;
import data.json.SemesterJSON;
import data.json.StudentJSON;
import data.json.TranscriptJSON;
import lecture.Lecture;
import lecture.LectureSession;
import lecture.Semester;
import person.Advisor;
import person.Student;

public class JsonGenerator {

    private List<StudentJSON> studentsList;
    private List<LectureJSON> lecturesList;
    private List<AdvisorJSON> advisorsList;
    private List<TranscriptJSON> transcriptsList;
    private JsonOperator jsonOperator;

    public JsonGenerator(JsonOperator jsonOperator) {
        this.studentsList = new ArrayList<StudentJSON>();
        this.lecturesList = new ArrayList<LectureJSON>();
        this.advisorsList = new ArrayList<AdvisorJSON>();
        this.transcriptsList = new ArrayList<TranscriptJSON>();
        
        this.jsonOperator = jsonOperator;
    }

    public void generateTranscript(Transcript transcript) {
        TranscriptJSON transcriptJson = new TranscriptJSON(transcript.getStudent().getID());

        List<SemesterJSON> semesterJSONs = new ArrayList<SemesterJSON>();
        for (Semester semester : transcript.getListOfSemester()) {
            Map<Lecture, LetterGrade> semestersList = semester.getListOfLecturesTaken();
            Map<String, String> listOfLecturesTaken = new HashMap<String, String>();
            for (Lecture lecture : semestersList.keySet()) {
                listOfLecturesTaken.put(lecture.getID(), semestersList.get(lecture).toString());
            }
            SemesterJSON semesterJson = new SemesterJSON(listOfLecturesTaken);
            semesterJSONs.add(semesterJson);
        }
        transcriptJson.setListOfSemesters(semesterJSONs);

        transcriptsList.add(transcriptJson);
    }

    public void generateAdvisor(Advisor advisor) {
        AdvisorJSON advisorJson = new AdvisorJSON(advisor.getFirstName(), advisor.getLastName());
        String ID = advisor.getID();
        String dateOfEntry = CalendarToString(advisor.getDateOfEntry());
        String instructorType = advisor.getInstructorType().toString();
        Term term = advisor.getSchedule().getTerm();
        TermYear termYear = advisor.getSchedule().getTermYear();

        ScheduleJSON scheduleJson = new ScheduleJSON(ID, term.toString(), termYear.toString());
        scheduleJson.setID(ID);
        HashMap<String, String> lectureSessions =  new HashMap<String, String>();
        for (LectureSession ls : advisor.getSchedule().getListOfLectureSessions()) {
            lectureSessions.put(ls.getLecture().getID(), ls.getSessionID());
        }

        scheduleJson.setSessions(lectureSessions);

        advisorJson.setInstructorID(ID);
        advisorJson.setDateOfEntry(dateOfEntry);
        advisorJson.setInstructorType(instructorType);
        advisorJson.setSchedule(scheduleJson);

        advisorsList.add(advisorJson);
    }

    public void generateStudent(Student student) {
        StudentJSON tempStudent = new StudentJSON(student.getFirstName(), student.getLastName());
        
        tempStudent.setAdvisorID(student.getAdvisor().getID());
        
        //Turning the Calendar Instance into String
        String stringFormOfDate = CalendarToString(student.getDateOfEntry());
        tempStudent.setDateOfEntry(stringFormOfDate);
        
        String term = student.getSchedule().getTerm().toString();
        String termYear = student.getSchedule().getTermYear().toString();


        // Creating schedule
        ScheduleJSON tempSchedule = new ScheduleJSON(student.getID(), term, termYear);
        tempSchedule.setID(student.getID());
        HashMap<String, String> sessionsList = new HashMap<String, String>();
        List<LectureSession> lectureSessions = student.getSchedule().getListOfLectureSessions(); 

        //Filling the map with corresponding IDs.
        for (LectureSession ls : lectureSessions) {
            String lectureID = ls.getLecture().getID();
            String sessionID = ls.getSessionID();
            sessionsList.put(lectureID, sessionID);
        }
        tempSchedule.setSessions(sessionsList);

        tempStudent.setSchedule(null);
        tempStudent.setStudentID(student.getID());

        studentsList.add(tempStudent);
    }

    public void generateLecture(Lecture lecture) {
        String ID = lecture.getID();
        String name = lecture.getName();
        String prerequisiteID = lecture.getPrerequisite().getID();
        String lectureType = lecture.getLectureType().toString();
        int credits = lecture.getCredit();
        int quota = lecture.getQuota();

        List<LectureSessionJSON> lectureSessionsList = new ArrayList<LectureSessionJSON>();
        for (LectureSession ls : lecture.getSessions()) {
            String sessionID = ls.getSessionID();
            String lectureID = ID;
            String instructorID = ls.getInstructor().getID();
            String sessionType = ls.getSessionType().toString();
            LectureHour[][] lectureHours = ls.getSessionHours();
            int[][] sessionHours = new int[7][10];

            for (int i = 0; i < 7; i++) {
                for (int j = 0; j < 10; j++) {
                    if(lectureHours[i][j] == LectureHour.YES) {
                        sessionHours[i][j] = 1;
                    } else {
                        sessionHours[i][j] = 0;
                    }
                }
            }

            List<String> studentIDList = new ArrayList<String>();

            for (Student s : ls.getListOfStudents()) {
                studentIDList.add(s.getID());
            }
            LectureSessionJSON tempSession = new LectureSessionJSON(sessionID, lectureID, instructorID, sessionType, sessionHours, studentIDList);
            lectureSessionsList.add(tempSession);
        }
        String term = lecture.getTerm().toString();
        String termYear = lecture.getTermYear().toString();

        LectureJSON tempLecture = new LectureJSON(ID, name, prerequisiteID, lectureType, quota, credits, term, termYear);
        tempLecture.setLectureSessions(lectureSessionsList);
        lecturesList.add(tempLecture);
    }

    public void writeJsons() {
        writeStudents();
        writeLectures();
        writeAdvisors();
        writeTranscripts();
    }

    private void writeStudents() {
        for (StudentJSON s : studentsList) {
            JsonWriter json = new JsonWriter(jsonOperator.getMetaData().getStudentsPath() + s.getStudentID() + ".json");
            json.writeJsonFile(s);
        }
    }

    private void writeLectures() {
        for (LectureJSON l : lecturesList) {
            JsonWriter json = new JsonWriter(jsonOperator.getMetaData().getLecturesPath() + l.getID() + ".json");
            json.writeJsonFile(l);
        }
    }

    private void writeAdvisors() {
        for (AdvisorJSON a : advisorsList) {
            JsonWriter json = new JsonWriter(jsonOperator.getMetaData().getAdvisorsPath() + a.getInstructorID() + ".json");
            json.writeJsonFile(a);
        }
    }

    private void writeTranscripts() {
        for (TranscriptJSON t : transcriptsList) {
            JsonWriter json = new JsonWriter(jsonOperator.getMetaData().getTranscriptsPath() + t.getStudentID() + ".json");
            json.writeJsonFile(t);
        }
    }

    

    //Silinecek
    public void  generateNamePool() {
        JsonWriter json = new JsonWriter("NamePool.json");
        List<String> firstNames = new ArrayList<String>();
        List<String> lastNames = new ArrayList<String>();

        firstNames.add("firstName1");
        firstNames.add("firstName2");
        firstNames.add("firstName3");

        lastNames.add("lastName1");
        lastNames.add("lastName2");
        lastNames.add("lastName3");

        NamePool namePool = new NamePool(firstNames, lastNames);
        json.writeJsonFile(namePool);
    }
    
    //Silinecek
    public void generateMetaData() {
    	JsonWriter json = new JsonWriter("NamePool.json");
        MetaData metaData = new MetaData("Students/", "Advisors/", 
            "Transcripts/", "Lectures/", "NamePool.json");
        json.writeJsonFile(metaData);
    }


    private String CalendarToString(Calendar calender) {
		
		SimpleDateFormat formOfDate = new SimpleDateFormat("yyyy-MM-dd");
		String stringForm = formOfDate.format(calender.getTime());
		
		return stringForm;
		
	}
}
