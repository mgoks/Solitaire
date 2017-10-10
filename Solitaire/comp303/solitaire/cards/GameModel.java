/**
 * Module 03, exercise #5 and #6:
 * Using the Singleton Design Pattern, design a GameMode1 class that is a Singleton.
 * 
 * This class will be responsible for managing all the necessary state for a game of solitaire. 
 * The class should offer the following state-changing services (through methods):  
 * 
 * move(Card, Location) 
 * Moves a card from an assumed legal playing position to the specified location (to be designed); 
 * 
 * discard()
 * Moves a card from the top of the deck to the top of the discard pile. 
 * 
 * In addition, the GameModel should provide all the necessary state-querying services, 
 * including methods to check the state of the deck and the discard pile (empty or nor), 
 * view the cards in the different stacks, etc. 
 * In particular, the GameModel class should provide a method getScore() that returns the cumulative number of cards 
 * in the four suit stacks. A score of 52 indicates a win.
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
	// A static final field keeping a reference to the single instance of the singleton object.
	private static final GameModel INSTANCE = new GameModel();
	
	private static final int NUMBEROFSUITS = 4;
	private static final int NUMBEROFWORKINGSTACKS = 7;
	
	private Deck aDeck = new Deck();
	private SuitStack[] aSuitStacks = new SuitStack[NUMBEROFSUITS];
	private WorkingStack[] aWorkingStacks = new WorkingStack[NUMBEROFWORKINGSTACKS];
	
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
			for( int j = 0; j <= )
		}
	}
	
	/**
	 * 
	 * @param pCard
	 * @param pLocation
	 */
	void move( Card pCard, Stack pLocation)
	{
		
	}
	
	/**
	 * 
	 */
	void discard()
	{
		
	}
	
	/**
	 * 
	 * @return
	 */
	int getScore()
	{
		
	}
}
