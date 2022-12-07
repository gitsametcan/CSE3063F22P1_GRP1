package lecture;

import java.util.List;

import Enums.LectureHour;
import person.Student;

public class Schedule {
	
	private Student student;
	private List<LectureSession> listOfLectureSessions;
	
	public Schedule(Student student) {
		this.student = student;
	}
	
	public void showSchedule() {
		List<LectureSession> lectureSessions = student.getListOfLectureSessions();
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
	
	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public List<LectureSession> getListOfLectureSessions() {
		return listOfLectureSessions;
	}

	public void setListOfLectureSessions(List<LectureSession> listOfLectureSessions) {
		this.listOfLectureSessions = listOfLectureSessions;
	}

	
}
