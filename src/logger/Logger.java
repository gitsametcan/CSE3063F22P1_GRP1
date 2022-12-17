package logger;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import data.DataManager;
import data.json.MetaData;

public class Logger {
	
	private static Map<String, Logger> loggers;
	private RandomAccessFile randomOutputFile;
	private File outputFile;
	
	public static Logger getLogger(String fileNameWithoutExtension){
		if (loggers == null) {
			loggers = new HashMap<String, Logger>();
		}
		if (loggers.containsKey(fileNameWithoutExtension)) {
			return loggers.get(fileNameWithoutExtension);
		}
		Logger tLog = new Logger(fileNameWithoutExtension);
		loggers.put(fileNameWithoutExtension, tLog);
		return tLog;
	}

	private Logger(String fileNameWithoutExtension){
		Optional<MetaData> optMetaData = DataManager.getInstance().getMetaData();
		if (!optMetaData.isPresent()) {
			return;
		}
		MetaData metaData = optMetaData.get();

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm-ss");  
   		LocalDateTime now = LocalDateTime.now();  
		String date = now.format(dtf);

		outputFile = new File(metaData.getLogsPath() + date + "_" +fileNameWithoutExtension + ".txt");
		try {
			randomOutputFile = new RandomAccessFile(outputFile, "rws");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void error(String text) {
		log("[ERROR]", text);
	}

	public void info(String text) {
		log("[INFO]", text);
	}

	public void error(String text, Object... args) {
		String message = String.format(text, args);
		log("[ERROR]", message);
	}

	public void info(String text, Object... args) {
		String message = String.format(text, args);
		log("[INFO]", message);
	}


	private void log(String tag, String text) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
   		LocalDateTime now = LocalDateTime.now();  
   		String currentTime = "[" + dtf.format(now) + "]";
		String message = currentTime + tag + text + '\n';
		
		if (tag.contains("ERROR")) {
			System.err.println(text);
		}
		if (tag.contains("INFO")) {
			System.out.println(text);
		}

		try {
			// Goes to end of file and writes the output there
			randomOutputFile.seek(randomOutputFile.length());
			randomOutputFile.write(message.getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}



}
