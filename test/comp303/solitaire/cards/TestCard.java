package comp303.solitaire.cards;

import org.junit.Test;
import comp303.solitaire.cards.Card;
import comp303.solitaire.cards.Card.Rank;
import comp303.solitaire.cards.Card.Suit;
import static org.junit.Assert.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

public class TestCard
{
	@Test
	public void testInit() throws Exception
	{
		Constructor<Card> constructor = Card.class.getDeclaredConstructor();
		assertTrue(Modifier.isPrivate(constructor.getModifiers()));
		constructor.setAccessible(true);
		Card c = constructor.newInstance(Rank.ACE, Suit.SPADES);
		
	}
}
