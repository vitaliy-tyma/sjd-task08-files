package info.sjd;

import java.util.List;
import java.util.logging.Logger;

public class ReadFile {

	public static void readFile(String FILE_NAME) {
		Logger logger = Logger.getLogger(AppRunner.class.getName());
		logger.info("MODE 2 = READ FILE.");

		List<String> lines = FileAccess.readFromFile(FILE_NAME);
		for (String line : lines) {
			logger.info(line);
		}
	}
	
}
