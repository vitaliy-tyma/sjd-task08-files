package info.sjd.service;

import java.util.ArrayList;
import java.util.List;


public class AppendFile {

	public static void appendFile(String FILE_NAME, int size) {
		

		/** GET SEED */
		int seed = (int) Get_SHA512.curTime();

		/** Create list of 10 Strings. */
		List<LogRec> log_rec_10 = new ArrayList<LogRec>(size);

		for (int i = 0; i < size; i++) {
			LogRec log_rec = new LogRec(Get_SHA512.curTime(), Get_SHA512.randomSession9dec(seed + i),
					Get_SHA512.randomIPhex(seed + i));
			log_rec_10.add(log_rec);
			
			
			/** Append 1 record to the log-file.*/
			FileAccess.saveToFile(FILE_NAME, log_rec, true);
		}


	}
}
