package data;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

import data.json.MetaData;
import data.json.NamePool;
import data.json.ScheduleJSON;
import data.json.StudentJSON;
import lecture.LectureSession;
import person.Student;

public class JsonGenerator {

    private List<StudentJSON> studentsList;

    public JsonGenerator() {
        this.studentsList = new ArrayList<StudentJSON>();
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
