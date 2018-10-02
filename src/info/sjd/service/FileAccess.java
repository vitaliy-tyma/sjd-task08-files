package info.sjd.service;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import info.sjd.AppRunner;
import info.sjd.model.LogRec;

public class FileAccess extends Thread {

	protected final static String LINE_SEP = System.getProperty("line.separator");
	private String file_name;
	private int size_of_collection = 10;
	private int pause_length = 3 * 60 * 1000;

	public FileAccess(String file_name, int size_of_collection) {
		this.file_name = file_name;
		this.size_of_collection = size_of_collection;
	}

	public void run() {
		// DEBUG		pause_length = 1 * 1 * 1000;
		for (int i = 0; i < 3; i++) {
			appendFile(file_name, size_of_collection);

			try {
				Thread.sleep(pause_length);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			Logger logger = Logger.getLogger(AppRunner.class.getName());
			logger.info("END OF THREAD # " + i + " PROCESSING.");
		}

	}

	public synchronized static void appendFile(String file_name, int size_of_collection) {

		/** GET SEED */
		int seed = (int) Get_SHA512.curTime();

		/** Create list of 10 Strings. */
		List<LogRec> log_rec_10 = new ArrayList<LogRec>(size_of_collection);

		for (int i = 0; i < size_of_collection; i++) {
			LogRec log_rec = new LogRec(Get_SHA512.curTime(), Get_SHA512.randomSession9dec(seed + i),
					Get_SHA512.randomIPhex(seed + i));
			log_rec_10.add(log_rec);

			/** Append 1 record to the log-file. */
			FileAccess.saveToFile(file_name, log_rec, Boolean.TRUE);
		}

	}

	/** saveToFile */
	protected static boolean saveToFile(String file_name, LogRec log_rec, boolean append) {

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

	/** Delete old records. */
	public static void delOldRecords(String file_name) {

		long curr_time = Get_SHA512.curTime();
		long three_days_ago = curr_time - 3 * 24 * 60 * 60 * 1000;
		boolean rewrite_file = Boolean.FALSE;

		List<LogRec> log_recs = FileAccess.readFromFile(file_name);
		for (LogRec log_rec : log_recs) {
			if (log_rec.getTime_stamp() > three_days_ago) {
				FileAccess.saveToFile(file_name, log_rec, rewrite_file);
				rewrite_file = Boolean.TRUE;
			}

		}

	}

	/** Append new records. */

}
