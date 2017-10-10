/**
 * 
 */
package comp303.solitaire.cards;

import java.util.Stack;
import comp303.solitaire.cards.Card.Rank;
import comp303.solitaire.cards.Card.Suit;

/**
 * This should be a well-encapsulated class to represent "suit stacks". 
 * A "suit stack" is a stack where players accumulate finished sequences of cards of a same suit, 
 * with the Ace at the bottom and subsequent cards on top of it in strictly increasing order of rank.
 * @author Halil Murat
 */
public class SuitStack 
{
	/**
	 * @author Halil Murat
	 */
	private static final int MAX_SIZE = 13;
	private static final int KING     = 12;
	private final Stack<Card> aStack;
	
	/**
	 * Constructor: Initializes a new suit stack.
	 * @param pSuit		suit of the suit stack
	 */
	SuitStack( Suit pSuit ) 
	{
		aStack = new Stack<Card>();
	}
	
	/**
	 * @return	true if the suit stack is empty, false otherwise
	 */
	boolean isEmpty()
	{
		return aStack.isEmpty();
	}
	
	/**
	 * @return	true if the stack is full
	 */
	boolean isFull()
	{
		if( aStack.size() == MAX_SIZE && aStack.peek().getRank().ordinal() == KING )
		{
			return true;
		}
		return false;
	}
	
	/**
	 * @return	The number of cards in the suit stack
	 */
	int getScore()
	{
		return aStack.size();
	}
	
	/**
	 * @return	The card on the top of the suit stack
	 */
	Card peek()
	{
		assert !aStack.isEmpty();
		return aStack.peek();
	}
	/**
	 * @param  pCard	The card to test
	 * @return true if pCard can be moved to the top of its suit stack.
	 * This is only possible if its rank is immediately superior to that of the card currently on top of the suit stack.
	 * 
	 * Maybe it's better if this is in class Card?
	 */
	boolean canMoveTo( Card pCard )
	{
		assert pCard != null;
		if( this.isEmpty() )
		{
			return pCard.getRank() == Rank.ACE;
		}
		else
		{
			return pCard.getSuit() == this.peek().getSuit() &&
				   pCard.getRank().ordinal() == peek().getRank().ordinal() + 1;
		}
	}
	
	/**
	 * Push pCard onto the suit stack.
	 * @param pCard		The card to push
	 */
	void push( Card pCard )
	{
		assert canMoveTo(pCard);
		aStack.push(pCard);
	}
	
	/**
	 * Pop the card on the top of the stack.
	 * @return	Popped card
	 */
	Card pop()
	{
		assert !isEmpty();
		return aStack.pop();
	}
	
	/**
	 * @return	The number of cards in the suit stack.
	 */
	int size()
	{
		return aStack.size();
	}
}