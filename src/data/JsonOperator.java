package data;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JsonOperator {

	private static JsonOperator singleInstance = null;

	private JsonOperator() {

	}

	public static JsonOperator getInstance() {
		if (singleInstance == null) {
			singleInstance = new JsonOperator();
		}

		return singleInstance;
	}

	public <T> T readJsonFile(File file, Class<T> type) throws FileNotFoundException {
		Scanner scanner = new Scanner(file);
		String contents = "";

		while (scanner.hasNextLine()) {
			contents += scanner.nextLine() + "\n";
		}

		scanner.close();

		Gson gson = new Gson();
		T t = gson.fromJson(contents, type);

		return t;
	}

	public <T> void writeJsonFile(String path, T element) throws IOException {
		FileOutputStream fStream = new FileOutputStream(path);
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String contents = gson.toJson(element);

		fStream.write(contents.getBytes());
		fStream.close();
	}
}
