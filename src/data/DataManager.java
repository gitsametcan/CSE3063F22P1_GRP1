// Kadir Berk Yagar 150120016

package data;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import Enums.FilterType;
import Enums.Term;
import Enums.TermYear;
import data.json.MetaData;
import data.json.NamePool;
import lecture.Lecture;
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
	}

	public static DataManager getInstance() {
		if (singleInstance == null) {
			singleInstance = new DataManager();
		}
		return singleInstance;
	}

	public void loadFiles() {
		MetaData metaData = jsonOperator.getMetaData();
		jsonOperator.readNamePool();
		
		List<String> studentFiles = listFiles(metaData.getStudentsPath());
		List<String> advisorFiles = listFiles(metaData.getAdvisorsPath());
		List<String> lectureFiles = listFiles(metaData.getLecturesPath());

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
	
	public List<Lecture> searchLecture(int term){
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
	
	public List<Lecture> searchLectureUntilTerm(int term){
		List<Lecture> result = new ArrayList<Lecture>();
		switch (term) {
			case 0:
				result = searchLectureUntilTerm(Term.Fall,TermYear.Freshman);
				break;
			case 1:
				result = searchLectureUntilTerm(Term.Spring,TermYear.Freshman);
				break;
			case 2:
				result = searchLectureUntilTerm(Term.Fall,TermYear.Sophomore);
				break;
			case 3:
				result = searchLectureUntilTerm(Term.Spring,TermYear.Sophomore);
				break;
			case 4:
				result = searchLectureUntilTerm(Term.Fall,TermYear.Junior);
				break;
			case 5:
				result = searchLectureUntilTerm(Term.Spring, TermYear.Junior);
				break;
			case 6:
				result = searchLectureUntilTerm(Term.Fall,TermYear.Senior);
				break;
			case 7:
				result = searchLectureUntilTerm(Term.Spring,TermYear.Senior);
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

	public Optional<MetaData> getMetaData() {
		return Optional.ofNullable(this.jsonOperator.getMetaData());
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
