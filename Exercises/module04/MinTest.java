/**
 * 
 */
package module04;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * @author Halil Murat
 * Exercise 1b:
 * Unit test for the Java Math.min()
 */
public class MinTest
{
	@Test
	public void testFirstIsMin()
	{
		assertEquals(5, Math.min(5, 6));
		assertEquals(-2, Math.min(-2,  1));
		assertEquals(Integer.MIN_VALUE, Math.min(Integer.MIN_VALUE, 0));
	}
	
	@Test
	public void testSecondIsMin()
	{
		assertEquals(4, Math.min(5, 4));
		assertEquals(-6, Math.min(-5, -6));
		assertEquals( Integer.MIN_VALUE, Math.min(0, Integer.MIN_VALUE) );
	}
	
	@Test
	public void testSameNumber()
	{
		assertEquals(5, Math.min(5, 5));
		assertEquals( -5, Math.min(-5, -5) );
		assertEquals( Integer.MIN_VALUE, Math.min(Integer.MIN_VALUE, Integer.MIN_VALUE));
	}
}
