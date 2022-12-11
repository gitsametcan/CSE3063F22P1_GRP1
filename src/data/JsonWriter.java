package data;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JsonWriter {
	private File file;

	public JsonWriter(String path) {
		this.file = new File(path);
	}

	public JsonWriter(File file) {
		this.file = file;
	}

	// A method for writing json files
	public <T> void writeJsonFile(T element) {
		FileOutputStream fStream = null;

		try {
			fStream = new FileOutputStream(file.getAbsolutePath());
		} catch (FileNotFoundException e) {
			System.err.println("ERROR Could not open file: " + file.getAbsolutePath());
			return;
		}

		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String contents = gson.toJson(element);

		try {
			fStream.write(contents.getBytes());
		} catch (IOException e) {
			System.err.println("ERROR Could not write to file: " + file.getAbsolutePath());
			return;
		}

		try {
			fStream.close();
		} catch (IOException e) {
			System.err.println("ERROR Could not close file: " + file.getAbsolutePath());
			return;
		}
	}

}
