package data;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

import Enums.LectureHour;
import data.json.AdvisorJSON;
import data.json.LectureJSON;
import data.json.LectureSessionJSON;
import data.json.MetaData;
import data.json.NamePool;
import data.json.ScheduleJSON;
import data.json.StudentJSON;
import data.json.TranscriptJSON;
import lecture.Lecture;
import lecture.LectureSession;
import person.Student;

public class JsonGenerator {

    private List<StudentJSON> studentsList;
    private List<LectureJSON> lecturesList;
    private List<AdvisorJSON> advisorsList;
    private List<TranscriptJSON> transcriptsList;

    public JsonGenerator() {
        this.studentsList = new ArrayList<StudentJSON>();
        this.lecturesList = new ArrayList<LectureJSON>();
        this.advisorsList = new ArrayList<AdvisorJSON>();
        this.transcriptsList = new ArrayList<TranscriptJSON>();
        
    }

    public void generateStudent(Student student) {
        StudentJSON tempStudent = new StudentJSON(student.getFirstName(), student.getLastName());
        
        tempStudent.setAdvisorID(student.getAdvisor().getID());
        
        //Turning the Calendar Instance into String
        String stringFormOfDate = CalendarToString(student.getDateOfEntry());
        tempStudent.setDateOfEntry(stringFormOfDate);
        
        // Creating schedule
        ScheduleJSON tempSchedule = new ScheduleJSON();
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

        LectureJSON tempLecture = new LectureJSON(ID, name, prerequisiteID, lectureType, quota, credits);
        tempLecture.setLectureSessions(lectureSessionsList);
        lecturesList.add(tempLecture);
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
