package info.sjd;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class AppendFile {

	public static void appendFile(String FILE_NAME) {
		Logger logger = Logger.getLogger(AppRunner.class.getName());
		
		logger.info("MODE 1 = APPEND FILE.");
		/** GET SEED */
		int seed = (int) Get_SHA512.curTime();

		/** Create list of 10 Strings. */
		List<LogRec> log_rec_10 = new ArrayList<LogRec>(10);

		for (int i = 0; i < 10; i++) {
			LogRec log_rec = new LogRec(Get_SHA512.curTime(), Get_SHA512.randomSession9dec(seed + i),
					Get_SHA512.randomIPhex(seed + i));
			log_rec_10.add(log_rec);
		}

		if (FileAccess.saveToFile(FILE_NAME, log_rec_10, true)) {
			logger.info("MAIN: FILE HAS BEEN SAVED.");
		} else {
			logger.info("MAIN: FILE HAS NOT BEEN SAVED.");
		}
	}
}
