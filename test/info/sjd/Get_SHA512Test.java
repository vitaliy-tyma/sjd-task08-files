package info.sjd;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Get_SHA512Test {

	@Test
	void testCurTime() {
		assertNotNull(Get_SHA512.curTime());
		assertTrue(Get_SHA512.curTime() > 0);
	}
	
	@Test
	void testRandomSession9dec() {
		assertNotNull(Get_SHA512.randomSession9dec(123456789));
		assertNotNull(Get_SHA512.randomSession9dec(0));
		
		assertEquals(9,Get_SHA512.randomSession9dec(123456789).length());
		assertEquals(9,Get_SHA512.randomSession9dec(0).length());
	}
	
	@Test
	void testRandomIPhex() {
		assertNotNull(Get_SHA512.randomIPhex(123456789));
		assertNotNull(Get_SHA512.randomIPhex(0));
		
		assertTrue(Get_SHA512.randomIPhex(123456789).length() > 4);
		assertTrue(Get_SHA512.randomIPhex(0).length() > 4);
	}

}
