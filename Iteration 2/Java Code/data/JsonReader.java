package data;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import com.google.gson.Gson;

import logger.Logger;

public class JsonReader {

	private File file;

	public JsonReader(String path) {
		this.file = new File(path);
	}

	public JsonReader(File file) {
		this.file = file;
	}

	// A method for reading json files
	public <T> T readJsonFile(Class<T> type) {
		Scanner scanner = null;
		try {
			scanner = new Scanner(file);
		} catch (FileNotFoundException e) {
			Logger.getLogger("logs").error("File is not found: %s", file.getAbsolutePath());
			return null;
		}
		String contents = "";

		while (scanner.hasNextLine()) {
			contents += scanner.nextLine() + "\n";
		}

		scanner.close();

		Gson gson = new Gson();
		T t = gson.fromJson(contents, type);

		return t;
	}

}
