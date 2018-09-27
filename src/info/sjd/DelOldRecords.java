package info.sjd;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class DelOldRecords {
	public static void delOldRecords(String FILE_NAME) {
		Logger logger = Logger.getLogger(AppRunner.class.getName());
		logger.info("MODE 3 = DELETE OLD.");

		long curr_time = Get_SHA512.curTime();
		long three_days_ago = curr_time - 3 * 24 * 60 * 60 * 100;

		List<LogRec> new_lines = new ArrayList<LogRec>();

		List<String> lines = FileAccess.readFromFile(FILE_NAME);
		for (String line : lines) {
			String[] words = line.split(" ");

			/** Compare if the line timestamp younger then three days. */
			if (Long.parseLong(words[0]) > three_days_ago) {
				LogRec log_rec = new LogRec(line);
				new_lines.add(log_rec);
			}
		}
		/** Save logs to the new file. */
		if (FileAccess.saveToFile(FILE_NAME, new_lines, false)) {
			logger.info("MAIN: NEW FILE HAS BEEN SAVED.");
		} else {
			logger.info("MAIN: NEW FILE HAS NOT BEEN SAVED.");
		}
	}
}
