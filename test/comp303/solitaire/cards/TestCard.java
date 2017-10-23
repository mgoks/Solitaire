package comp303.solitaire.cards;

import org.junit.Test;
import comp303.solitaire.cards.Card;
import comp303.solitaire.cards.Card.Rank;
import comp303.solitaire.cards.Card.Suit;
import static org.junit.Assert.*;

public class TestCard
{
	@Test
	public void testSameColorAs() throws Exception
	{
		Card aceOfSpades   = Card.get(Rank.ACE, Suit.SPADES);
		Card aceOfClubs    = Card.get(Rank.ACE, Suit.CLUBS);
		Card aceOfHearts   = Card.get(Rank.ACE, Suit.HEARTS);
		Card aceOfDiamonds = Card.get(Rank.ACE, Suit.DIAMONDS);
		assertEquals(true, aceOfDiamonds.sameColorAs(aceOfHearts));
		assertEquals(true, aceOfHearts.sameColorAs(aceOfDiamonds));
		assertEquals(true, aceOfSpades.sameColorAs(aceOfClubs));
		assertEquals(true, aceOfClubs.sameColorAs(aceOfSpades));
		assertEquals(false, aceOfClubs.sameColorAs(aceOfHearts));
		assertEquals(true, aceOfSpades.sameColorAs(aceOfSpades));
	}
	
	@Test
	public void testToString() throws Exception
	{
		Card c = Card.get(Rank.ACE, Suit.SPADES);
		assertEquals("ACE of SPADES", c.toString());
	}
}
