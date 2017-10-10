/**
 * 
 */
package comp303.solitaire.cards;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

import comp303.solitaire.cards.Card.Rank;

/**
 * This class manages the state of one of the working stacks in solitaire.
 * As opposed to suit stack, for working stack solve the problem of remembering which card is 
 * visible (face-up), and which card is not.
 * @author Halil Murat
 */
public class WorkingStack
{
	private static final int NUMBEROFCARDSNEEDED = 24;
	private static final int MAXCAPACITY = 7;
	private Stack<Card> aStack;
	private Set<Card> aVisible;
	
	/**
	 * Constructor.
	 */
	public WorkingStack()
	{
		aStack = new Stack<Card>();
		aVisible = new HashSet<Card>();
	}
	
	/**
	 * Fills the working stack by drawing cards from the deck.
	 * Assuming a working stack can contains a max of 7 cards.
	 * @param pDeck	A deck of cards to use to fill the stacks initially
	 * @pre			pDeck != null && pDeck.size() >= 24
	 */
	void initialize(Deck pDeck)
	{
		assert pDeck != null && pDeck.size() >= NUMBEROFCARDSNEEDED;
		aVisible.clear();
		this.aStack.clear();
		for( int i = 0; i < MAXCAPACITY; i++ )
		{
			aStack.add(pDeck.draw());
		}
	}
	
	/**
	 * Determines if it is legal to move pCard on top of the working stack
	 * i.e. if a king is moved to an empty stack or any other rank on a card of 
	 * immediately greater rank but of a different color.
	 * @param pCard	The card to move
	 * @return		True if the move if legal
	 * @pre pCard != null
	 */
	boolean canMoveTo(Card pCard)
	{
		assert pCard != null;
		
		if( aStack.isEmpty() )
		{
			return pCard.getRank() == Rank.KING;
		}
		else
		{
			return !pCard.sameColorAs(aStack.peek()) && pCard.getRank().ordinal() + 1 == aStack.peek().getRank().ordinal();
		}
	}
	
	/**
	 * @return	An array of cards in the stack, where element[0] is the bottom of the stack
	 * Modifying the array has no impact on the state of the object.
	 * @pre aStack != null && !aStack.isEmpty()
	 */
	Card[] getStack()
	{
		assert aStack != null && !aStack.isEmpty();
		
		Card[] aCards = new Card[aStack.size()];
		for( int i = 0; i < aStack.size(); i++ )
		{
			aCards[aStack.size()-i-1] = aStack.pop();
		}
		return aCards;
		
		// if what's above doesn't work try this: return aStack.toArray(new Card[aStack.size()]);
	}
	
	/**
	 * Returns true if moving pCard away reveals the top of the card.
	 * @param pCard The card to test
	 * @return		true if the card above pCard is not visible and pCard is visible.
	 */
	boolean revealsTop(Card pCard)
	{
		assert pCard != null;
		int indexOfpCard = aStack.indexOf(pCard);
		if( indexOfpCard < 1 )
		{
			return false;
		}
		return aVisible.contains(pCard) && !aVisible.contains(aStack.get(indexOfpCard-1));
	}
	
	/**
	 * Move pCard and all the cards below from the current working stack object to working stack pDestination.
	 * @param pDestination	The intended destination of the card.
	 * @param pCard 			The card to move, possibly including all the cards on top of it.
	 */
	void moveCardTo(WorkingStack pDestination, Card pCard)
	{
		assert pCard != null && pDestination != null && this.contains(pCard);
		assert isVisible(pCard);
		
		while( !aStack.peek().equals(pCard) )
		{
			pDestination.push(aStack.pop());
		}
		pDestination.push(aStack.pop());
	}
	
	/**
	 * Returns a sequence of cards starting at pCard and including all cards on top of it.
	 * @param pCard	The bottom card in the stack
	 * @return		An array of cards in the stack. Element 0 is the bottom.
	 */
	public Card[] getSequence(Card pCard)
	{
		assert pCard != null && aStack.get(0).equals(pCard);
		
		List<Card> lReturn = new ArrayList<>();
		boolean aSeen      = false;
		for( Card card : aStack )		// scan the stack from bottom to top
		{
			if( card == pCard )
			{
				aSeen = true;
			}
			if( aSeen )					// when pCard is found
			{
				lReturn.add(card);		// start adding card to the list
			}
		}
		return lReturn.toArray(new Card[lReturn.size()]);		// convert the list to array and return the array
	}
	
	/**
	 * Make the top card of the stack visible.
	 */
	void showTop()
	{
		assert !aStack.isEmpty();
		aVisible.add(aStack.peek());
	}
	
	/**
	 * Make the top card of the stack invisible.
	 */
	void hideTop()
	{
		assert !aStack.isEmpty() && aVisible.contains(aStack.peek());
		aVisible.remove(aStack.peek());
	}
	
	/**
	 * @param pCard	The card to check
	 * @return		True if stack contains pCard
	 */
	boolean contains( Card pCard )
	{
		assert pCard != null;
		return aStack.contains(pCard);
	}
	
	/**
	 * @param pCard	The card to check
	 * @return		True if pCard is visible in the stack
	 */
	boolean isVisible(Card pCard)
	{
		assert pCard != null && this.contains(pCard);
		return aVisible.contains(pCard);
	}
	
	/**
	 * Removes the top card from the stack but does not return it.
	 */
	void pop()
	{
		assert !aStack.isEmpty();
		aVisible.remove(aStack.pop());
	}
	
	/**
	 * Places pCard on top of the stack at pIndex. The card will be be visible by default.
	 * @param pCard	Card to push
	 */
	void push(Card pCard)
	{
		assert pCard != null;
		aStack.push(pCard);
		aVisible.add(pCard);
	}
}
