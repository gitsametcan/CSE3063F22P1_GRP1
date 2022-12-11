// Kadir Berk Yagar 150120016

package data;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import Enums.FilterType;
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
	
	private void fixCache() {
		while (cacheList.size() > 50) {
			cacheList.removeLast();
		}
	}

}
