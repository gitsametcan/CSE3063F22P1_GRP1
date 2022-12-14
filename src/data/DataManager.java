// Kadir Berk Yagar 150120016

package data;

import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import Debt_LRA_Transcript.Debt;
import Debt_LRA_Transcript.LectureRegistrationApplication;
import Debt_LRA_Transcript.Transcript;
import Enums.FilterType;
import Enums.InstructorType;
import Enums.LectureHour;
import Enums.LectureType;
import Enums.LetterGrade;
import Enums.SessionType;
import IDs.InstructorID;
import IDs.LectureID;
import IDs.SessionID;
import IDs.StudentID;
import data.json.MetaData;
import data.json.NamePool;
import lecture.Lecture;
import lecture.LectureSession;
import lecture.Schedule;
import lecture.Semester;
import person.Advisor;
import person.Instructor;
import person.Person;
import person.Student;

public class DataManager {

	private static DataManager singleInstance = null;
	private List<Lecture> listOfLectures;
	private List<Person> listOfPeople;
	private LinkedList<Person> cacheList;
	private JsonOperator jsonOperator;

	private DataManager() {
		listOfLectures = new ArrayList<Lecture>();
		listOfPeople = new ArrayList<Person>();
		cacheList = new LinkedList<Person>();
		jsonOperator = new JsonOperator();
		
		MetaData metaData = jsonOperator.getMetaData();
		
		Set<String> studentFiles = listFiles(metaData.getStudentsPath());
		Set<String> advisorFiles = listFiles(metaData.getAdvisorsPath());
		Set<String> lectureFiles = listFiles(metaData.getLecturesPath());
		
		
		for (String name : studentFiles) {
			jsonOperator.readStudentJSON(name);
		}
		
		for (String name : advisorFiles) {
			jsonOperator.readAdvisorJSON(name);
		}
		
		for (String name : lectureFiles) {
			jsonOperator.readLectureJSON(name);
		}
		
		jsonOperator.generateObjects();

		listOfLectures.addAll(jsonOperator.getReadLectures());
		listOfPeople.addAll(jsonOperator.getReadAdvisors());
		listOfPeople.addAll(jsonOperator.getReadStudents());
		
	}

	public static DataManager getInstance() {
		if (singleInstance == null) {
			singleInstance = new DataManager();
		}
		return singleInstance;
	}

	public void saveObjectAsJson() {
		JsonGenerator jsonGenerator = jsonOperator.getJsonGenerator();

		for (Lecture l : listOfLectures) {
			jsonGenerator.generateLecture(l);
		}

		for (int i = 0; i < listOfPeople.size(); i++) {
			Person p = listOfPeople.get(i);
			if (p instanceof Student) {
				Student s = (Student) p;
				jsonGenerator.generateStudent(s);
				jsonGenerator.generateTranscript(s.getTranscript());
			}
			if (p instanceof Advisor) {
				Advisor a = (Advisor) p;
				jsonGenerator.generateAdvisor(a);
			}
		}

		jsonGenerator.writeJsons();
	}

	public Optional<Lecture> findLecture(String key, FilterType filterType) {
		for (Lecture l : listOfLectures) {
			if ((filterType == FilterType.ID && l.getID().equalsIgnoreCase(key))
					|| (filterType == FilterType.Name && l.getName().equalsIgnoreCase(key))) {
				return Optional.of(l);
			}
		}
		return Optional.empty();
	}
 
	public Optional<Student> findStudent(String key, FilterType filterType) {
		for (Person p : cacheList) {
			if (!(p instanceof Student)) {
				continue;
			}
			Student s = (Student) p;
			if ((filterType == FilterType.ID && s.getID().equalsIgnoreCase(key))
					|| (filterType == FilterType.Name && s.getFullName().equalsIgnoreCase(key))) {
				cacheList.remove(p);
				cacheList.addFirst(p);
				return Optional.of(s);
			}
		}

		for (Person p : listOfPeople) {
			if (!(p instanceof Student)) {
				continue;
			}
			Student s = (Student) p;
			if ((filterType == FilterType.ID && s.getID().equalsIgnoreCase(key))
					|| filterType == FilterType.Name && s.getFullName().equalsIgnoreCase(key)) {
				cacheList.addFirst(p);
				fixCache();
				return Optional.of(s);
			}
		}
		return Optional.empty();
	}

	public Optional<Instructor> findInstructor(String key, FilterType filterType) {
		for (Person p : cacheList) {
			if (!(p instanceof Instructor)) {
				continue;
			}
			Instructor i = (Instructor) p;
			if ((filterType == FilterType.ID && i.getID().equalsIgnoreCase(key))
					|| (filterType == FilterType.Name && i.getFullName().equalsIgnoreCase(key))) {
				cacheList.remove(p);
				cacheList.addFirst(p);
				return Optional.of(i);
			}
		}

		for (Person p : listOfPeople) {
			if (!(p instanceof Instructor)) {
				continue;
			}
			Instructor i = (Instructor) p;
			if ((filterType == FilterType.ID && i.getID().equalsIgnoreCase(key))
					|| filterType == FilterType.Name && i.getFullName().equalsIgnoreCase(key)) {
				cacheList.addFirst(p);
				fixCache();
				return Optional.of(i);
			}
		}
		return Optional.empty();
	}

	public Optional<Advisor> findAdvisor(String key, FilterType filterType) {
		for (Person p : cacheList) {
			if (!(p instanceof Advisor)) {
				continue;
			}
			Advisor a = (Advisor) p;
			if ((filterType == FilterType.ID && a.getID().equalsIgnoreCase(key))
					|| (filterType == FilterType.Name && a.getFullName().equalsIgnoreCase(key))) {
				cacheList.remove(p);
				cacheList.addFirst(p);
				return Optional.of(a);
			}
		}

		for (Person p : listOfPeople) {
			if (!(p instanceof Advisor)) {
				continue;
			}
			Advisor a = (Advisor) p;
			if ((filterType == FilterType.ID && a.getID().equalsIgnoreCase(key))
					|| filterType == FilterType.Name && a.getFullName().equalsIgnoreCase(key)) {
				cacheList.addFirst(p);
				fixCache();
				return Optional.of(a);
			}
		}
		return Optional.empty();
	}

	public List<Lecture> searchLecture(String key, FilterType filterType) {
		List<Lecture> result = new ArrayList<Lecture>();
		for (Lecture l : listOfLectures) {

			if ((filterType == FilterType.ID && l.getID().toLowerCase().contains(key.toLowerCase()))
					|| (filterType == FilterType.Name && l.getName().toLowerCase().contains(key.toLowerCase()))) {
				result.add(l);
			}
		}
		return result;
	}

	public List<Student> searchStudent(String key, FilterType filterType) {
		List<Student> result = new ArrayList<Student>();
		for (Person p : listOfPeople) {
			if (!(p instanceof Student)) {
				continue;
			}
			Student s = (Student) p;
			if ((filterType == FilterType.ID && s.getID().toLowerCase().contains(key.toLowerCase()))
					|| (filterType == FilterType.Name && s.getFullName().toLowerCase().contains(key.toLowerCase()))) {
				result.add(s);
			}
		}
		return result;
	}

	public List<Instructor> searchInstructor(String key, FilterType filterType) {
		List<Instructor> result = new ArrayList<Instructor>();
		for (Person p : listOfPeople) {
			if (!(p instanceof Instructor)) {
				continue;
			}
			Instructor i = (Instructor) p;
			if ((filterType == FilterType.ID && i.getID().toLowerCase().contains(key.toLowerCase()))
					|| (filterType == FilterType.Name && i.getFullName().toLowerCase().contains(key.toLowerCase()))) {
				result.add(i);
			}
		}
		return result;
	}

	public List<Advisor> searchAdvisor(String key, FilterType filterType) {
		List<Advisor> result = new ArrayList<Advisor>();
		for (Person p : listOfPeople) {
			if (!(p instanceof Advisor)) {
				continue;
			}
			Advisor a = (Advisor) p;
			if ((filterType == FilterType.ID && a.getID().toLowerCase().contains(key.toLowerCase()))
					|| (filterType == FilterType.Name && a.getFullName().toLowerCase().contains(key.toLowerCase()))) {
				result.add(a);
			}
		}
		return result;
	}
	
	public Optional<NamePool> getNamePool() {
		return jsonOperator.getNamePool();
	}

	//Silinecek
	public void writeExamples() {
		JsonGenerator jsonGenerator = jsonOperator.getJsonGenerator();

		LectureID lectureID = new LectureID("CSE1502");
		String name = "Lecture Name";
		LectureType lectureType = LectureType.MANDATORY;
		int credits = 5;
		int quota = 50;

		List<LectureSession> lectureSessions = new ArrayList<LectureSession>();

		SessionID tempSessionID = new SessionID(1);
		LectureHour[][] sessionHours = new LectureHour[7][10];

		SessionType sessionType = SessionType.Theorytical;

		LectureSession tempLectureSession = new LectureSession(tempSessionID, null, sessionHours, sessionType, null,
			null, null);
		lectureSessions.add(tempLectureSession);

		Lecture tempLecture = new Lecture(lectureID, name, lectureType, credits, lectureSessions, null, quota);


		StudentID studentID = new StudentID("150156156");
		Calendar dateOfEntry = new GregorianCalendar(2015, 10, 3);
		Student tempStudent = new Student("İsim Örnek", "Soyisim Örnek", studentID, new Schedule(null), null, dateOfEntry);
		tempStudent.getSchedule().setPerson(tempStudent);

		InstructorID tempInstructorID = new InstructorID("165164");
		InstructorType instructorType = InstructorType.Instructor;
		Calendar dateOfEntrys = new GregorianCalendar(2015, 10, 3);

		Advisor tempAdvisor = new Advisor("Örnek İsim", "Örnek Soyisim", tempInstructorID, dateOfEntrys, null, null,
					instructorType, new Schedule(null));

		HashMap<Lecture, LetterGrade> listOfLecturesTaken = new HashMap<Lecture, LetterGrade>();
		listOfLecturesTaken.put(tempLecture, LetterGrade.AA);
		Semester semester = new Semester(listOfLecturesTaken);
		List<Semester> listOfSemesters = new ArrayList<Semester>();
		listOfSemesters.add(semester);
		Transcript tempTranscript = new Transcript(tempStudent, listOfSemesters);

		jsonGenerator.generateAdvisor(tempAdvisor);
		jsonGenerator.generateLecture(tempLecture);
		jsonGenerator.generateMetaData();
		jsonGenerator.generateNamePool();
		jsonGenerator.generateStudent(tempStudent);
		jsonGenerator.generateTranscript(tempTranscript);
	}

	public void addStudents(List<Student> studentList) {
		listOfPeople.addAll(studentList);
	}
	
	private void fixCache() {
		while (cacheList.size() > 50) {
			cacheList.removeLast();
		}
	}
	
	private Set<String> listFiles(String dir) {
	    return Stream.of(new File(dir).listFiles())
	      .filter(file -> !file.isDirectory())
	      .map(File::getName)
	      .collect(Collectors.toSet());
	}

}
