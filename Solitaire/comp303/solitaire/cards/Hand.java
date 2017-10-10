package comp303.solitaire.cards;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import comp303.solitaire.cards.Card.Rank;
 
/**
 * @author Halil Murat
 * Exercise #1
 */
public class Hand implements Iterable<Card>, Comparable<Hand>, Comparator<Hand>
{
    private final List<Card> aCards = new ArrayList<>();
    private final int aMaxNumberOfCards;
     
    /** Creates a new empty hand which can hold a maximum of pMaxNumberOfCards.
     *  @param pMaxNumberOfCards	The maximum number of cards in a hand
     *  @pre pMaxNumberOfCards > 0
     *  */
    public Hand( int pMaxNumberOfCards)
    {
        assert pMaxNumberOfCards > 0;
        aMaxNumberOfCards = pMaxNumberOfCards;
    }
     
    /** @pre pCard != null && !isFull()
     * @param pCard the card that is being added to the hand
     */
    public void add( Card pCard )
    {
        assert pCard != null && !isFull();
        aCards.add(pCard);
    }
     
    /** @pre !isEmpty && pCard != null
     * @param pCard card that is being removed
     */
    public void remove( Card pCard )
    {
        assert !isEmpty() && pCard != null;
        aCards.remove(pCard);
    }
   
    /**
	 * @param pCard A card to check for containment.
	 * @return True if pCard is a card in this hand.
	 * @pre pCard != null
	 */
    public boolean contains( Card pCard )
    {
        assert !isEmpty() && pCard != null;
        if( aCards.contains(pCard))
        {
            return true;
        }
        return false;
    }
     
    /**
	 * @return True if there are no cards in this hand.
	 */
    public boolean isEmpty()
    {
        if( aCards.isEmpty() )
        {
            return true;
        }
        return false;
    }
     
    /**
	 * @return True if the number of cards in the hand
	 * is the maximum number of cards allowable, as specified
	 * in the constructor.
	 */
    public boolean isFull()
    {
        assert aCards.size() <= aMaxNumberOfCards;
         
        if( aCards.size() == aMaxNumberOfCards )
        {
            return true;
        }
        return false;
    }
 
    @Override
    /**
     * This method is meant as a way to provide access to the cards in the hand without breaking encapsulation.
     */
    public Iterator<Card> iterator() 
    {
        return aCards.iterator();
    }
 
    /**
     * Exercise #2
     * Sort hands by increasing number of cards in the hand
     * e.g. 
     * 0. a hand of 0 cards
     * 1. a hand of 5 cards
     * 2. a hand of 7 cards
     * :
     * :
     */
    @Override
    public int compareTo(Hand pHand) 
    {
        if( aCards.size() > pHand.aCards.size() )
        {
            return 1;
        }
        else if( aCards.size() < pHand.aCards.size() )
        {
            return -1;
        }
        return 0;
         
        //return aCards.size() - pHand.aCards.size();
    }
    
    /**
     * Factory method: Creates a comparator that compares hands in terms of ascending number of card of rank pRank in the hand.
     * @param pRank The rank of which cards the comparator compares
     * @return A new comparator instance that compares the card of pRank by their number
     */
    public static Comparator<Hand> createByRankComparator( Rank pRank )
    {
    	assert pRank != null;
    	
    	return new Comparator<Hand>()
    	{
    		@Override
    		public int compare( Hand pHand1, Hand pHand2 )
    		{
    			assert !pHand1.isEmpty() && !pHand2.isEmpty();
    			return countCards( pHand1, pRank ) - countCards( pHand2, pRank );
    		}
    		
    		private int countCards( Hand pHand, Rank pRank )
    		{
    			int count = 0;
    			for( Card card : pHand )
    			{
    				if( card.getRank() == pRank )
    				{
    					count++;
    				}
    			}
    			return count;
    		}
    	};
    }
    
    @Override
    /**
     * Added this so Eclipse won't complain.
     */
	public int compare(Hand pHand1, Hand pHand2)
	{
		// TODO Auto-generated method stub
		return 0;
	}
    
    /** 
     * Driver program to test compareTo().
     * @param args Just the regular Java args
     */
    /*public static void main( String[] args )
    {
        Deck aDeck = new Deck();
        aDeck.shuffle();
        Hand aHand1 = new Hand(2);
        Hand aHand2 = new Hand(2);
         
        aHand1.add(aDeck.draw());
        aHand1.add(aDeck.draw());
        aHand2.add(aDeck.draw());
        aHand2.add(aDeck.draw());
 
        int aResult = aHand1.compareTo(aHand2);
        System.out.println(aResult);
    }*/
}