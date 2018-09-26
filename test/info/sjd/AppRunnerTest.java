package info.sjd;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AppRunnerTest {

	@Test
	void testCurTime() {
		assertNotNull(AppRunner.curTime());
	}
	
	@Test
	void testRandom9dec() {
		assertNotNull(AppRunner.random9dec());
	}
	

}
