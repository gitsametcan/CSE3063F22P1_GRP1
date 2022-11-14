import java.util.List;

import Enums.LectureHour;
import Enums.SessionType;
import IDs.UniqueID;
import person.Instructor;

//Serdar Alsan    150120034 
public class LectureSession {

    private UniqueID sessionID;
    private transient Lecture lecture;
    private LectureHour[][] sessionHour;
    private SessionType sessionType;
    private Instructor instructor;
    private List<Assistant> listOfAssistans;

    public String getSession() {
        return session;
    }

    public LectureHour[7][10] getSessionHours() {
        return sessionHour;
    }

    public SessionType getSessionType() {
        return sessionType;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public List<Assistant> getListOfAssistans() {
        return listOfAssistans;
    }
    public Lecture getLecture() {
        return lecture;
    }
    
    public void setLecture(Lecture lecture) {
        this.lecture = lecture;
    }


}