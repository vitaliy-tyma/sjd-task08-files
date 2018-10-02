package info.sjd.service;

import java.util.logging.Logger;

import info.sjd.AppRunner;

public class AppendInThreeThreads {

	
	public AppendInThreeThreads(){}
	
	
	public AppendInThreeThreads(String file_name, int size_of_collection){
		Logger logger = Logger.getLogger(AppRunner.class.getName());
		
		for (int i = 0 ; i < 3; i++) {
			new FileAccess(file_name, size_of_collection).start();
			logger.info("END OF AppendInThreeThreads # " + i + ".");
		}

		logger.info("END OF AppendInThreeThreads");
	}
	
}
