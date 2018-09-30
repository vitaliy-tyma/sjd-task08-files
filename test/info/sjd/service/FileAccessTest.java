package info.sjd.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;

import info.sjd.model.LogRec;

class FileAccessTest {
	private static final String SEP = System.getProperty("file.separator");
	private static final String DIR_NAME = "log" + SEP;
	private static final String FILE_NAME = DIR_NAME + "task08.txt";
	private static String textInFile;

	@BeforeClass
	public static void setBeforeClass() {
		List<LogRec> log_recs = FileAccess.readFromFile(FILE_NAME);
		String text = "";
		for (LogRec log_rec : log_recs) {
			text += log_rec.toString();
		}
		textInFile = text;

	}

	@Test
	void testWriteAndRead() {
		LogRec log_rec = new LogRec(1538156261425L, "598896482", "113.237.192.191");

		FileAccess.saveToFile(FILE_NAME, log_rec, Boolean.FALSE);
		List<LogRec> log_recs = FileAccess.readFromFile(FILE_NAME);

		assertTrue(!log_recs.isEmpty());
		assertEquals(log_recs.get(0).getSession(), "598896482");

	}

	@AfterClass
	public static void setAfterClass() {
		for (String line : textInFile.split("\n")) {
			String[] words = line.split(" ");
			LogRec log_rec = new LogRec(
										Long.parseLong(words[0]),
										words[1],
										words[2]);
			FileAccess.saveToFile(FILE_NAME, log_rec, Boolean.TRUE);
		}
	}
}
