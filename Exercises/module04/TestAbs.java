/**
 * 
 */
package module04;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * @author Halil Murat
 * Exercise #1a
 * Unit tests for the Java Math.abs()
 */
public class TestAbs
{
	@Test
	public void testAbsZero()
	{
		assertEquals(0, Math.abs(0));
	}
	
	@Test
	public void testAbsPositive()
	{
		assertEquals(5, Math.abs(5));
	}
	
	@Test
	public void testAbsNegative()
	{
		assertEquals(5, Math.abs(-5));
	}
	
	@Test
	public void testAbsMax()
	{
		assertEquals(Integer.MAX_VALUE, Math.abs(Integer.MIN_VALUE));
	}	
}
