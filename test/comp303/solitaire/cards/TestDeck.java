package comp303.solitaire.cards;

import static org.junit.Assert.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;

public class TestDeck
{
	private Method aReset;
	private Deck aDeck;
	
	@Before
	public void setup() throws Exception
	{
		aReset = Deck.class.getDeclaredMethod("reset");
		aReset.setAccessible(true);
		aDeck = new Deck();
	}
	
	@Test
	public void testReset()
	{
		aDeck.draw();
		aDeck.draw();
		try
		{
			aReset.invoke(aDeck);
			assertEquals(52, aDeck.size());
		}
		catch( InvocationTargetException | IllegalAccessException pException )
		{
			TestCase.fail();
		}
	}
	
	@Test
	public void testShuffle()
	{
		
	}
}
