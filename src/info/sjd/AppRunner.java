package info.sjd;

import java.util.List;
import info.sjd.model.LogRec;
import info.sjd.service.FileAccess;

public class AppRunner {

	private static final String SEP = System.getProperty("file.separator");
	private static final String DIR_NAME = "log" + SEP;
	private static final String FILE_NAME = DIR_NAME + "task08.txt";
	private static int size_of_collection = 10;
	
	/* MAIN ****************************************/
	public static void main(String[] args) {



		/** (VOID) Save logs to file. */
		//FileAccess.appendFile(FILE_NAME, size_of_collection);

		/** (List<LogRec>) Read logs from log-file. */
		//List<LogRec> lines = FileAccess.readFromFile(FILE_NAME);


		/** (VOID) Delete more then 3 days old records from the log-file. */
		//FileAccess.delOldRecords(FILE_NAME);
		
		/** Multithreading - 10*3*3 = 90. */
		for (int i = 0 ; i < 3; i++) {
			new FileAccess(FILE_NAME, size_of_collection).start();
		}



	}

}
