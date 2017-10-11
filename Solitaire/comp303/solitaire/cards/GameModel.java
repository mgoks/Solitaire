/**
 * Module 03, exercise #5 and #6:
 * Using the Singleton Design Pattern, design a GameMode1 class that is a Singleton.
 * This class will be responsible for managing all the necessary state for a game of solitaire. 
 */
package comp303.solitaire.cards;

import java.util.Stack;

import comp303.solitaire.cards.Card.Suit;

/**
 * @author Halil Murat
 *
 */
public final class GameModel
{
	/** A static final field keeping a reference to the single instance of the singleton object. */
	private static final GameModel INSTANCE = new GameModel();
	
	private static final int NUMBEROFSUITS = 4;
	private static final int NUMBEROFWORKINGSTACKS = 7;
	private static final int WINNINGSCORE = 52;
	private Deck aDeck = new Deck();
	private SuitStack[] aSuitStacks = new SuitStack[NUMBEROFSUITS];
	private WorkingStack[] aWorkingStacks = new WorkingStack[NUMBEROFWORKINGSTACKS];
	
	/** Discard pile. */
	private Stack<Card> aDiscard = new Stack<>();
	
	/**
	 * Represents anywhere a card can be placed in Solitaire.
	 */
	public interface Location{}
	
	/**
	 * A private constructor for GameModel.
	 * Initializes the suit stacks and the working stacks
	 * (Should) initialize the suit stacks in the following order:
	 * 0. Clubs
	 * 1. Diamonds
	 * 2. Hearts
	 * 3. Spades
	 */
	private GameModel()
	{
		for( int i = 0; i < NUMBEROFSUITS; i++ )
		{
			aSuitStacks[i] = new SuitStack(Suit.values()[i]);
		}
		
		for( int i = 0; i < NUMBEROFWORKINGSTACKS; i++ )
		{
			aWorkingStacks[i] = new WorkingStack();
		}
	}
	
	/**
	 * The static accessor method.
	 * @return	the unique instance of GameModel
	 */
	public static GameModel instance()
	{
		return INSTANCE;
	}
	
	/**
	 * Initializes a new game by 
	 * 1. clearing all the working stacks
	 * 2. shuffling the deck, and 
	 * 3. placing cards on the working stack according to the rules of solitaire 
	 * @pre aWorkingStacks.length == 7
	 * @pre aSuitStacks.length    == 4
	 */
	void reset()
	{
		assert aWorkingStacks.length == NUMBEROFWORKINGSTACKS && aSuitStacks.length == NUMBEROFSUITS;
		
		// Clear all working stacks
		for( WorkingStack stack : aWorkingStacks )
		{
			if( stack.size() > 0 )
			{
				while( stack.size() > 0 )
				{
					stack.pop();
				}
			}
		}
		
		// Clear all suit stacks
		for( SuitStack stack : aSuitStacks )
		{
			if( stack.size() > 0 )
			{
				while( stack.size() > 0 )
				{
					stack.pop();
				}
			}
		}
		
		// Shuffle the deck
		aDeck.shuffle();
		
		// Place cards on the working stack according to the rules of solitaire
		// (one card on the first stack, two on the second, etc., with the top card of each stack visible).
		for( int i = 0; i < NUMBEROFWORKINGSTACKS; i++ )
		{
			for( int j = 0; j <= i; j++ )
			{
				aSuitStacks[i].push(aDeck.draw());
			}
		}
	}
	
	/**
	 * Moves a card from an assumed legal playing position to the specified location (to be designed).
	 * @param pCard		The card to move
	 * @param pLocation	The stack to move the card to
	 */
	void move( Card pCard, Stack<Card> pLocation )
	{
		// TODO
	}
	
	/**
	 * Moves a card from the top of the deck to the top of the discard pile. 
	 */
	void discard()
	{
		aDiscard.push(aDeck.draw());
	}
	
	/**
	 * Returns the cumulative number of cards in the four suit stacks. A score of 52 indicates a win.
	 * @return	Cumulative number of cards in the four suit stacks
	 */
	int getScore()
	{
		int aNumberOfCards = 0;
		for( SuitStack aStack : aSuitStacks )
		{
			aNumberOfCards += aStack.size();
		}
		if( aNumberOfCards == 52 )
		{
			System.out.println("Congratulations, you won!");
		}
		return aNumberOfCards;
	}
	
	/**
	 * Checks if the deck is empty.
	 * @return	True if aDeck is empty
	 */
	boolean isDeckEmpty()
	{
		return aDeck.size() == 0;
	}
	
	/**
	 * Check if the discard pile is empty.
	 * @return	True if aDiscard is empty
	 */
	boolean isDiscardEmpty()
	{
		return aDiscard.isEmpty();
	}
	
	/**
	 * Shows all cards in the suit stack at index.
	 * @param index	Index of the stack in aSuitStacks
	 * 0. Clubs
	 * 1. Diamonds
	 * 2. Hearts
	 * 3. Spades
	 * @return		String representation of all card in the stack
	 * @pre 0 ≤ pIndex ≤ 3
	 */
	void viewSuitStack( int pIndex )
	{
		assert 0 <= pIndex && pIndex < NUMBEROFSUITS;
		
		SuitStack aStack = aSuitStacks[pIndex];
		for( int i = 0; i < aStack.size(); i++ )
		{
			System.out.println(aStack.getCard(i).toString());
		}
	}
	
	/**
	 * Shows all cards in the working stack at index.
	 * @param index	Index of the stack in aWorkingStacks
	 * @return		String representation of all card in the stack
	 * @pre 0 ≤ pIndex ≤ 6
	 */
	void viewWorkingStack( int pIndex )
	{
		assert 0 <= pIndex && pIndex < NUMBEROFWORKINGSTACKS;
		
		WorkingStack aStack = aWorkingStacks[pIndex];
		for( int i = 0; i < aStack.size(); i++ )
		{
			System.out.println(aStack.getCard(i).toString());
		}
	}
}
