package lecture;

import java.util.List;

import Enums.LectureHour;
import Enums.Term;
import Enums.TermYear;
import person.Person;

public class Schedule {

	private Person person;
	private List<LectureSession> listOfLectureSessions;
	private Term term;
	private TermYear termYear;

	public Schedule(Person person, Term term, TermYear termYear) {
		this.person = person;
		this.term = term;
		this.termYear = termYear;
	}

	public void showSchedule() {
		List<LectureSession> lectureSessions = this.getListOfLectureSessions();
		if (lectureSessions.size() == 0) {
			System.out.println("You dont have any lecture to be shown.");
			return;
		}
		int lecturePlaceX = 0;
		int lecturePlaceY = 1;
		for (int y = 1; y < 42; y++) {
			for (int x = 1; x < 79; x++) {
				if (y == 1 || y == 41) {
					System.out.print("_");
					if ((x == 78 && y == 1)) {
						System.out.println();
					}
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
							System.out.print(lectureSessionName);
							x = x + (lectureSessionName.length()) - 1;
							thereIsLecture = true;
							break;
						}
					}

					if (thereIsLecture == false) {
						System.out.print(" ");
					}

				} else if (x == 1 || x == 78) {
					System.out.print("|");
					if (x == 78) {
						System.out.println();
					}
				} else if ((y - 1) % 4 == 0) {
					System.out.print("_");
				} else if ((x - 1) % 11 == 0) {
					System.out.print("|");
				} else {
					System.out.print(" ");
				}
			}
		}

		System.out.println();
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
}
