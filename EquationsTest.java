package assignment;

import static org.junit.Assert.*;

import org.junit.Test;

public class EquationsTest {

	@Test
	public void testLinearEquation() {
		assertEquals(2.00, Equations.round(2,2));
		assertNotEquals(2.00, Equations.round(2,2));
	}

}
