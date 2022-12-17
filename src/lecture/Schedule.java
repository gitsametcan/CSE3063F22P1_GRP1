package lecture;

import java.util.ArrayList;
import java.util.List;

import Enums.LectureHour;
import Enums.Term;
import Enums.TermYear;
import person.Person;
import logger.Logger;

public class Schedule {
	Logger log = Logger.getLogger("logs");
	private Person person;
	private List<LectureSession> listOfLectureSessions;
	private Term term;
	private TermYear termYear;

	public Schedule(Person person, Term term, TermYear termYear) {
		listOfLectureSessions = new ArrayList<LectureSession>();
		this.person = person;
		this.term = term;
		this.termYear = termYear;
	}

	public void showSchedule() {
		List<LectureSession> lectureSessions = this.getListOfLectureSessions();
		if (lectureSessions.size() == 0) {
			log.info("You dont have any lecture to be shown.");
			return;
		}
		int lecturePlaceX = 0;
		int lecturePlaceY = 1;
		String a = "";
		for (int y = 1; y < 42; y++) {
			for (int x = 1; x < 79; x++) {
				if (y == 1 || y == 41) {
					a+="_";
					if ((x == 78 && y == 1)) {
						log.info(a);
						a="";
					}
					a = null;
				} else if ((((x - 2) % 11) == 0) && (((y - 3) % 4) == 0)) {

					if (lecturePlaceX == 7) {
						lecturePlaceX = 1;
						lecturePlaceY++;
					} else {
						lecturePlaceX++;
					}

					boolean thereIsLecture = false;
					for (LectureSession ls : lectureSessions) {
						if (ls.getSessionHours()[lecturePlaceX - 1][lecturePlaceY - 1] == LectureHour.YES) {
							String lectureSessionName = ls.getLecture().getID() + "." + ls.getSessionID();
							a+=(lectureSessionName);
							x = x + (lectureSessionName.length()) - 1;
							thereIsLecture = true;
							break;
						}
					}

					if (thereIsLecture == false) {
						a+=" ";
					}

				} else if (x == 1 || x == 78) {
					a+="|";
					if (x == 78) {
						log.info(a);
					}
				} else if ((y - 1) % 4 == 0) {
					a+="_";
				} else if ((x - 1) % 11 == 0) {
					a+="|";
				} else {
					a+=" ";
				}
			}
		}

		log.info(a);
		a="";
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public List<LectureSession> getListOfLectureSessions() {
		return listOfLectureSessions;
	}

	public void setListOfLectureSessions(List<LectureSession> listOfLectureSessions) {
		this.listOfLectureSessions = listOfLectureSessions;
	}

	public Term getTerm() {
		return term;
	}

	public void setTerm(Term term) {
		this.term = term;
	}

	public TermYear getTermYear() {
		return termYear;
	}

	public void setTermYear(TermYear termYear) {
		this.termYear = termYear;
	}
}
