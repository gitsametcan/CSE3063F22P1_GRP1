package data.json;

public class MetaData {

	private String studentsPath;
	private String advisorsPath;
	private String transcriptsPath;
	private String lecturesPath;
	private String namePoolPath;

	public MetaData(String studentsPath, String advisorsPath, String transcriptsPath, String lecturesPath,
			String namePoolPath) {
		super();
		this.studentsPath = studentsPath;
		this.advisorsPath = advisorsPath;
		this.transcriptsPath = transcriptsPath;
		this.lecturesPath = lecturesPath;
		this.namePoolPath = namePoolPath;
	}

	public String getStudentsPath() {
		return studentsPath;
	}

	public void setStudentsPath(String studentsPath) {
		this.studentsPath = studentsPath;
	}

	public String getAdvisorsPath() {
		return advisorsPath;
	}

	public void setAdvisorsPath(String advisorsPath) {
		this.advisorsPath = advisorsPath;
	}

	public String getTranscriptsPath() {
		return transcriptsPath;
	}

	public void setTranscriptsPath(String transcriptsPath) {
		this.transcriptsPath = transcriptsPath;
	}

	public String getLecturesPath() {
		return lecturesPath;
	}

	public void setLecturesPath(String lecturesPath) {
		this.lecturesPath = lecturesPath;
	}

	public String getNamePoolPath() {
		return namePoolPath;
	}

	public void setNamePoolPath(String namePoolPath) {
		this.namePoolPath = namePoolPath;
	}

}
