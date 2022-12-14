package data;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import Debt_LRA_Transcript.Transcript;
import Enums.InstructorType;
import Enums.LectureHour;
import Enums.LectureType;
import Enums.LetterGrade;
import Enums.SessionType;
import IDs.InstructorID;
import IDs.LectureID;
import IDs.SessionID;
import IDs.StudentID;
import data.json.AdvisorJSON;
import data.json.LectureJSON;
import data.json.LectureSessionJSON;
import data.json.ScheduleJSON;
import data.json.SemesterJSON;
import data.json.StudentJSON;
import data.json.TranscriptJSON;
import lecture.Lecture;
import lecture.LectureSession;
import lecture.Schedule;
import lecture.Semester;
import person.Advisor;
import person.Student;

public class ObjectGenerator {

	private List<LectureJSON> lectureList;
	private List<StudentJSON> studentList;
	private List<TranscriptJSON> transcriptList;
	private List<AdvisorJSON> advisorList;

	private List<Lecture> lectureObjectList;
	private List<Student> studentObjectList;
	private List<Transcript> transcriptObjectList;
	private List<Advisor> advisorObjectList;

	public ObjectGenerator(List<LectureJSON> lectureList, List<StudentJSON> studentList,
			List<TranscriptJSON> transcriptList, List<AdvisorJSON> advisorList) {
		this.lectureList = lectureList;
		this.studentList = studentList;
		this.transcriptList = transcriptList;
		this.advisorList = advisorList;

		lectureObjectList = new ArrayList<Lecture>();
		studentObjectList = new ArrayList<Student>();
		transcriptObjectList = new ArrayList<Transcript>();
		advisorObjectList = new ArrayList<Advisor>();
	}

	public void generateObjects() {

		generateLectures();
		generateStudents();
		generateAdvisors();

	}

	public void pairObjects() {

		for (LectureJSON ljs : lectureList) {

			// Collecting the Lecture reference
			Optional<Lecture> optLecture = findLecture(ljs.getID());
			Lecture currentLecture = null;

			if (optLecture.isPresent()) {
				currentLecture = optLecture.get();
			} else {
				continue;
			}

			// Collecting the prerequisite lecture's reference, and assigning it
			Optional<Lecture> optPrerequisiteLecture = findLecture(ljs.getPrerequisiteID());
			Lecture prerequisiteLecture = null;

			if (optPrerequisiteLecture.isPresent()) {
				prerequisiteLecture = optPrerequisiteLecture.get();
				currentLecture.addPrerequisiteLecture(prerequisiteLecture);
			}

			// Collecting the Instructor and assigning it
			sessionloop: for (LectureSession ls : currentLecture.getSessions()) {
				for (LectureSessionJSON lsjs : ljs.getLectureSessions()) {
					if (lsjs.getID().equalsIgnoreCase(ls.getSessionID())) {
						Optional<Advisor> optAdvisor = findAdvisor(lsjs.getInstructorID());
						Advisor currentAdvisor = null;
						if (optAdvisor.isPresent()) {
							currentAdvisor = optAdvisor.get();
							ls.setInstructor(currentAdvisor);
							currentAdvisor.getSchedule().getListOfLectureSessions().add(ls);
						}
						break sessionloop;
					}
				}
			}

		}

		for (StudentJSON sjs : studentList) {
			Optional<Student> optStudent = findStudent(sjs.getStudentID());
			Student currentStudent = null;

			if (!optStudent.isPresent()) {
				continue;
			}
			currentStudent = optStudent.get();

			currentStudent.getSchedule().setPerson(currentStudent);

			ScheduleJSON schedule = sjs.getSchedule();

			for (LectureJSON ljs : lectureList) {
				Optional<Lecture> optLecture = findLecture(ljs.getID());
				Lecture currentLecture = null;
				if (!optLecture.isPresent()) {
					continue;
				}
				currentLecture = optLecture.get();

				if (schedule.getSessions().containsKey(ljs.getID())) {
					String sessionID = schedule.getSessions().get(ljs.getID());
					for (LectureSession ls : currentLecture.getSessions()) {
						if (ls.getSessionID().equalsIgnoreCase(sessionID)) {
							currentStudent.getSchedule().getListOfLectureSessions().add(ls);
							ls.getListOfStudents().add(currentStudent);
						}
					}
				}
			}

			for (TranscriptJSON tjs : transcriptList) {
				if (!tjs.getStudentID().equalsIgnoreCase(currentStudent.getID())) {
					continue;
				}
				
				List<Semester> listOfSemesters = new ArrayList<Semester>();
				for (SemesterJSON semesterJson : tjs.getListOfSemesters()) {
					Map<String, String> listOfLecturesTaken = semesterJson.getListOfLecturesTaken();
					HashMap<Lecture, LetterGrade> semesterLectures = new HashMap<Lecture, LetterGrade>(); 
					for (String lectureID : listOfLecturesTaken.keySet()) {
						Optional<Lecture> optLecture = findLecture(lectureID);
						if (!optLecture.isPresent()) {
							continue;
						}
						Lecture tempLecture = optLecture.get();
						LetterGrade tempGrade = stringToLetterGrade(listOfLecturesTaken.get(lectureID));
						semesterLectures.put(tempLecture, tempGrade);
					}

					Semester tempSemester = new Semester(semesterLectures);
					listOfSemesters.add(tempSemester);
				}

				Transcript tempTranscript = new Transcript(currentStudent, listOfSemesters);
				
				transcriptObjectList.add(tempTranscript);
			}

		}

		for (AdvisorJSON ajs : advisorList) {

			Optional<Advisor> optAdvisor = findAdvisor(ajs.getInstructorID());
			Advisor currentAdvisor = null;

			if (optAdvisor.isPresent()) {
				currentAdvisor = optAdvisor.get();
			} else {
				continue;
			}
			
			currentAdvisor.getSchedule().setPerson(currentAdvisor);

			for (StudentJSON sjs : studentList) {
				if (sjs.getAdvisorID().equalsIgnoreCase(currentAdvisor.getID())) {
					Optional<Student> optStudent = findStudent(sjs.getStudentID());
					Student tempStudent = null;
					if (optStudent.isPresent()) {
						tempStudent = optStudent.get();
					} else {
						continue;
					}
					currentAdvisor.getListOfStudents().add(tempStudent);
					tempStudent.setAdvisor(currentAdvisor);
				}
			}

		}

	}

	public List<Lecture> getLectureObjects() {
		return lectureObjectList;
	}

	public List<Student> getStudentObjects() {
		return studentObjectList;
	}

	public List<Transcript> getTranscriptObjects() {
		return transcriptObjectList;
	}

	public List<Advisor> getAdvisorObjects() {
		return advisorObjectList;
	}

	private void generateLectures() {
		for (LectureJSON ljs : lectureList) {
			String ID = ljs.getID();
			LectureID lectureID = new LectureID(ID);
			String name = ljs.getName();
			String tempLectureType = ljs.getLectureType();
			LectureType lectureType = stringToLectureType(tempLectureType);
			int credits = ljs.getCredit();
			int quota = ljs.getQuota();

			List<LectureSession> lectureSessions = generateLectureSessions(ljs.getLectureSessions());

			Lecture tempLecture = new Lecture(lectureID, name, lectureType, credits, lectureSessions, null, quota);

			lectureObjectList.add(tempLecture);
		}
	}

	private void generateStudents() {
		for (StudentJSON sjs : studentList) {
			String ID = sjs.getStudentID();
			StudentID tempStudentID = new StudentID(ID);
			String firstName = sjs.getFirstName();
			String lastName = sjs.getLastName();
			String dateOfEntryString = sjs.getDateOfEntry();
			Optional<Calendar> optDateOfEntry = StringToCalendar(dateOfEntryString);
			Calendar dateOfEntry = null;
			if (optDateOfEntry.isPresent()) {
				dateOfEntry = optDateOfEntry.get();
			}

			Student tempStudent = new Student(firstName, lastName, tempStudentID, new Schedule(null), null, dateOfEntry);

			studentObjectList.add(tempStudent);
		}
	}

	private void generateAdvisors() {
		for (AdvisorJSON ajs : advisorList) {
			String ID = ajs.getInstructorID();
			InstructorID tempInstructorID = new InstructorID(ID);
			String firstName = ajs.getFirstName();
			String lastName = ajs.getLastName();
			InstructorType instructorType = stringToInstructorType(ajs.getInstructorType());
			String dateOfEntryString = ajs.getDateOfEntry();
			Optional<Calendar> optDateOfEntry = StringToCalendar(dateOfEntryString);
			Calendar dateOfEntry = null;
			if (optDateOfEntry.isPresent()) {
				dateOfEntry = optDateOfEntry.get();
			}
			

			Advisor tempAdvisor = new Advisor(firstName, lastName, tempInstructorID, dateOfEntry, null, null,
					instructorType, new Schedule(null));
			advisorObjectList.add(tempAdvisor);
		}
	}

	private Optional<Lecture> findLecture(String id) {
		for (Lecture l : lectureObjectList) {
			if (l.getID().equalsIgnoreCase(id)) {
				return Optional.of(l);
			}
		}
		return Optional.empty();
	}

	private Optional<Student> findStudent(String id) {
		for (Student s : studentObjectList) {
			if (s.getID().equalsIgnoreCase(id)) {
				return Optional.of(s);
			}
		}
		return Optional.empty();
	}

	private Optional<Advisor> findAdvisor(String id) {
		for (Advisor a : advisorObjectList) {
			if (a.getID().equalsIgnoreCase(id)) {
				return Optional.of(a);
			}
		}
		return Optional.empty();
	}

	private List<LectureSession> generateLectureSessions(List<LectureSessionJSON> jsonList) {
		List<LectureSession> result = new ArrayList<LectureSession>();
		for (LectureSessionJSON ls : jsonList) {
			String ID = ls.getID();
			SessionID tempSessionID = new SessionID(Integer.parseInt(ID));
			LectureHour[][] sessionHours = intToLectureHours(ls.getListOfSessionHours());
			SessionType sessionType = stringToSessionType(ls.getSessionType());

			LectureSession tempLectureSession = new LectureSession(tempSessionID, null, sessionHours, sessionType, null,
					null, null);
			result.add(tempLectureSession);
		}
		return result;
	}
	
	private Optional<Calendar> StringToCalendar(String string) {
		
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formOfDate = new SimpleDateFormat("yyyy-MM-dd");
		
		try {
			calendar.setTime(formOfDate.parse(string));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			System.err.println("String format is not suitable");
			return Optional.empty();
		}
		
		return Optional.of(calendar);
		
	}

	private LectureType stringToLectureType(String key) {
		if (key.equalsIgnoreCase("NTE")) {
			return LectureType.NTE;
		}

		if (key.equalsIgnoreCase("FTE")) {
			return LectureType.FTE;
		}

		if (key.equalsIgnoreCase("MANDATORY")) {
			return LectureType.MANDATORY;
		}

		if (key.equalsIgnoreCase("TE")) {
			return LectureType.TE;
		}

		if (key.equalsIgnoreCase("UE")) {
			return LectureType.UE;
		}
		return LectureType.MANDATORY;
	}

	private SessionType stringToSessionType(String key) {
		if (key.equalsIgnoreCase("Application")) {
			return SessionType.Application;
		}

		if (key.equalsIgnoreCase("Theorytical")) {
			return SessionType.Theorytical;
		}
		return SessionType.Theorytical;
	}

	private InstructorType stringToInstructorType(String key) {
		if (key.equalsIgnoreCase("Instructor")) {
			return InstructorType.Instructor;
		}
		return InstructorType.Assistant;
	}

	private LetterGrade stringToLetterGrade(String key) {
		if (key.equalsIgnoreCase("AA")) {
			return LetterGrade.AA;
		}
		if (key.equalsIgnoreCase("BA")) {
			return LetterGrade.BA;
		}
		if (key.equalsIgnoreCase("BB")) {
			return LetterGrade.BB;
		}
		if (key.equalsIgnoreCase("CB")) {
			return LetterGrade.CB;
		}
		if (key.equalsIgnoreCase("CC")) {
			return LetterGrade.CC;
		}
		if (key.equalsIgnoreCase("DC")) {
			return LetterGrade.DC;
		}
		if (key.equalsIgnoreCase("DD")) {
			return LetterGrade.DD;
		}
		if (key.equalsIgnoreCase("FD")) {
			return LetterGrade.FD;
		}
		return LetterGrade.FF;
	}

	private LectureHour[][] intToLectureHours(int[][] array) {
		LectureHour[][] result = new LectureHour[7][10];
		for (int i = 0; i < 7; i++) {
			for (int j = 0; j < 10; j++) {
				int current = array[i][j];
				if (current == 1) {
					result[i][j] = LectureHour.YES;
					continue;
				}
				result[i][j] = LectureHour.NO;
			}
		}
		return result;
	}
}
