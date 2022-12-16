// Kadir Berk Yagar 150120016

package data;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import Debt_LRA_Transcript.Transcript;
import Enums.FilterType;
import Enums.InstructorType;
import Enums.LectureHour;
import Enums.LectureType;
import Enums.LetterGrade;
import Enums.SessionType;
import Enums.Term;
import Enums.TermYear;
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
		
		jsonOperator.readMetaData();
		
		MetaData metaData = jsonOperator.getMetaData();
		
		List<String> studentFiles = listFiles(metaData.getStudentsPath());
		List<String> advisorFiles = listFiles(metaData.getAdvisorsPath());
		List<String> lectureFiles = listFiles(metaData.getLecturesPath());
		
		this.writeExamples();
		
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
	
	public List<Lecture> searchLecture(Term term, TermYear termYear){
		List<Lecture> result = new ArrayList<Lecture>();
		for (Lecture l : listOfLectures) {
			if (term == l.getTerm() && termYear == l.getTermYear())
				result.add(l);
		}
		
		return result;
	}
	
	private List<Lecture> searchLecture(int term){
		List<Lecture> result = new ArrayList<Lecture>();
		switch (term) {
			case 0:
				result = searchLecture(Term.Fall,TermYear.Freshman);
				break;
			case 1:
				result = searchLecture(Term.Spring,TermYear.Freshman);
				break;
			case 2:
				result = searchLecture(Term.Fall,TermYear.Sophomore);
				break;
			case 3:
				result = searchLecture(Term.Spring,TermYear.Sophomore);
				break;
			case 4:
				result = searchLecture(Term.Fall,TermYear.Junior);
				break;
			case 5:
				result = searchLecture(Term.Spring, TermYear.Junior);
				break;
			case 6:
				result = searchLecture(Term.Fall,TermYear.Senior);
				break;
			case 7:
				result = searchLecture(Term.Spring,TermYear.Senior);
				break;
		}
		
		return result;
	}
	
	public List<Lecture> searchLectureUntilTerm(Term term, TermYear termYear){
		List<Lecture> result = new ArrayList<Lecture>();
		Map<String, Integer> termAndYear = new HashMap<String, Integer>();
		termAndYear.put("FallFreshman", 0);
		termAndYear.put("SpringFreshman", 1);
		termAndYear.put("FallSophomore", 2);
		termAndYear.put("SpringSophomore", 3);
		termAndYear.put("FallJunior", 4);
		termAndYear.put("SpringJunior", 5);
		termAndYear.put("FallSenior", 6);
		termAndYear.put("SpringSenior", 7);
		String termAndYearS = term + "" + termYear;
		
		for(int i = 0; i<=termAndYear.get(termAndYearS); i++) {
			result.addAll(searchLecture(i));
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

		Lecture tempLecture = new Lecture(lectureID, name, lectureType, credits, lectureSessions, null, quota, Term.Fall, TermYear.Senior);
		tempLectureSession.setLecture(tempLecture);

		StudentID studentID = new StudentID("150156156");
		Calendar dateOfEntry = new GregorianCalendar(2015, 10, 3);
		Student tempStudent = new Student("İsim Örnek", "Soyisim Örnek", studentID, new Schedule(null, Term.Fall, TermYear.Senior), null, dateOfEntry);
		tempStudent.getSchedule().setPerson(tempStudent);

		InstructorID tempInstructorID = new InstructorID("165164");
		InstructorType instructorType = InstructorType.Instructor;
		Calendar dateOfEntrys = new GregorianCalendar(2015, 10, 3);

		Advisor tempAdvisor = new Advisor("Örnek İsim", "Örnek Soyisim", tempInstructorID, dateOfEntrys, null, null,
					instructorType, new Schedule(null, Term.Fall, TermYear.Senior));
		tempAdvisor.getSchedule().setPerson(tempAdvisor);
		
		tempLectureSession.setInstructor(tempAdvisor);
		HashMap<Lecture, LetterGrade> listOfLecturesTaken = new HashMap<Lecture, LetterGrade>();
		listOfLecturesTaken.put(tempLecture, LetterGrade.AA);
		Semester semester = new Semester(listOfLecturesTaken);
		List<Semester> listOfSemesters = new ArrayList<Semester>();
		listOfSemesters.add(semester);
		Transcript tempTranscript = new Transcript(tempStudent, listOfSemesters);
		tempStudent.setTranscript(tempTranscript);
		tempStudent.setAdvisor(tempAdvisor);

		tempStudent.getSchedule().setPerson(tempStudent);
		tempStudent.getSchedule().setListOfLectureSessions(lectureSessions);

		tempAdvisor.getListOfStudents().add(tempStudent);
		
		jsonGenerator.generateAdvisor(tempAdvisor);
		jsonGenerator.generateLecture(tempLecture);
		jsonGenerator.generateStudent(tempStudent);
		jsonGenerator.generateTranscript(tempTranscript);
		jsonGenerator.writeJsons();
	}

	public void addStudents(List<Student> studentList) {
		listOfPeople.addAll(studentList);
	}
	
	private void fixCache() {
		while (cacheList.size() > 50) {
			cacheList.removeLast();
		}
	}
	
	private List<String> listFiles(String dir) {
	    File directory = new File(dir);
		File[] matchingFiles = directory.listFiles(new FilenameFilter() {
				@Override
    			public boolean accept(File dir, String name) {
        			return name.endsWith(".JSON");
    			}
			}
		);
		
		List<String> result = new ArrayList<String>();

		for (File f : matchingFiles) {
			result.add(f.getName());
		}

		return result;

	}

}
