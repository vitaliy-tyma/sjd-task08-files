package info.sjd.service;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileAccess {

	
	
	/** saveToFile */
	public static boolean saveToFile(String file_name, LogRec log_rec, boolean append) {
		final String LINE_SEP = System.getProperty("line.separator");

		try (FileWriter writer = new FileWriter(file_name, append)) {
			//for (LogRec log : log_rec_10) {
				writer.write(log_rec.getString() + LINE_SEP);
			//}
			writer.flush();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	
	
	
	/** readFromFile */
	public static List<String> readFromFile(String file_name) {
		
		List<String> lines = new ArrayList<String>();
			try {
				lines = Files.readAllLines(Paths.get(file_name), StandardCharsets.UTF_8);
			} catch (IOException e) {
				e.printStackTrace();
			}
		return lines;
	}

}
