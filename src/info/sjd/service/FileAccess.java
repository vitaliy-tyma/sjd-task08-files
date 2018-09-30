package info.sjd.service;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import info.sjd.model.LogRec;

public class FileAccess {

	protected final static String LINE_SEP = System.getProperty("line.separator");

	/** saveToFile */
	public static boolean saveToFile(String file_name, LogRec log_rec, boolean append) {
		
		try (FileWriter writer = new FileWriter(file_name, append)) {
			writer.write(log_rec.getString() + LINE_SEP);
			writer.flush();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/** readFromFile */
	public static List<LogRec> readFromFile(String file_name) {

		List<LogRec> log_recs = new ArrayList<LogRec>();
		List<String> lines = new ArrayList<String>();
		
		try {
			lines = Files.readAllLines(Paths.get(file_name), StandardCharsets.UTF_8);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		for (String line : lines) {
			String[] words = line.split(" ");
			LogRec log_rec = new LogRec(Long.parseLong(words[0]), words[1], words[2]);
			log_recs.add(log_rec);
		}
		
		return log_recs;
	}

	/** Del old records.*/
	public static void delOldRecords(String file_name) {

		long curr_time = Get_SHA512.curTime();
		long three_days_ago = curr_time - 3 * 24 * 60 * 60 * 1000;
		boolean rewrite_file = Boolean.FALSE;

		//List<LogRec> new_lines = new ArrayList<LogRec>();

		List<LogRec> log_recs = FileAccess.readFromFile(file_name);
		for (LogRec log_rec : log_recs) {
			if (log_rec.getTime_stamp() > three_days_ago) {
				FileAccess.saveToFile(file_name, log_rec, rewrite_file);
				rewrite_file = Boolean.TRUE;
			}

		}

	}
	
	
	
	/** Append new records.*/
	public static void appendFile(String file_name, int size) {

		/** GET SEED */
		int seed = (int) Get_SHA512.curTime();

		/** Create list of 10 Strings. */
		List<LogRec> log_rec_10 = new ArrayList<LogRec>(size);

		for (int i = 0; i < size; i++) {
			LogRec log_rec = new LogRec(Get_SHA512.curTime(), Get_SHA512.randomSession9dec(seed + i),
					Get_SHA512.randomIPhex(seed + i));
			log_rec_10.add(log_rec);

			/** Append 1 record to the log-file. */
			FileAccess.saveToFile(file_name, log_rec, Boolean.TRUE);
		}

	}
}
