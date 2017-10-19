/**
 * 
 */
package module04;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.EmptyStackException;
import java.util.Stack;

import org.junit.Test;

/**
 * @author Halil Murat
 * Exercise 2
 * Unit tests for the Java Stack methods pop, push, and peek
 */
public class TestStack
{
	@Test
	public void testPop()
	{
		Stack<Object> aStack = new Stack<Object>();
		Object aObject = new Object();
		aStack.push(aObject);
		assertEquals(aObject, aStack.pop());
		try
		{
			aStack.pop();
			fail();
		}
		catch( EmptyStackException e ){}
	}
	
	@Test
	public void testPush()
	{
		Stack<Object> aStack = new Stack<Object>();
		Object aObject = new Object();
		assertEquals(aObject, aStack.push(aObject));
	}
	
	@Test
	public void testPeek()
	{
		Stack<Object> aStack = new Stack<Object>();
		Object aObject = new Object();
		aStack.push(aObject);
		assertEquals(aObject, aStack.peek());
		aStack.pop();
		try
		{
			aStack.peek();
			fail();
		}
		catch( EmptyStackException e ){}
	}
}
