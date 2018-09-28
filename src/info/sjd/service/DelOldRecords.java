package info.sjd.service;

import java.util.ArrayList;
import java.util.List;


public class DelOldRecords {
	public static void delOldRecords(String FILE_NAME) {



		long curr_time = Get_SHA512.curTime();
		long three_days_ago = curr_time - 3 * 24 * 60 * 60 * 1000;

		List<LogRec> new_lines = new ArrayList<LogRec>();

		List<String> lines = FileAccess.readFromFile(FILE_NAME);
		for (String line : lines) {
			String[] words = line.split(" ");

			/** Compare if the line's timestamp younger then three days. */
			if (Long.parseLong(words[0]) > three_days_ago) {
				LogRec log_rec = new LogRec(line);
				new_lines.add(log_rec);
			}
		}
		
		/** Save logs to the new file (rewrite with new records). */
		FileAccess.saveToFile(FILE_NAME, new_lines, false);
	}
}
