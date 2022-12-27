# package: person

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import logger.Logger;

import Debt_LRA_Transcript.Debt;
import Debt_LRA_Transcript.LectureRegistrationApplication;
import Debt_LRA_Transcript.Transcript;
import Enums.ApprovalState;
import Enums.FilterType;
import Enums.LetterGrade;
import IDs.StudentID;
import data.DataManager;
import lecture.Lecture;
import lecture.LectureSession;
import lecture.Schedule;
import lecture.Semester;

class Student(Person):