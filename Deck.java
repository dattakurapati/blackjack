//(c) A+ Computer Science
//www.apluscompsci.com

import java.util.ArrayList;
import java.util.Collections;

public class Deck
{
	public static final int NUMFACES = 13;
	public static final int NUMSUITS = 4;
	public static final int NUMCARDS = 52;

	public static final String SUITS[] = {"CLUBS","SPADES","DIAMONDS","HEARTS"};

	private int topCardIndex;
	private ArrayList<Card> stackOfCards;

	public Deck ()
	{
		//initialize data - stackOfCards - topCardIndex
		topCardIndex = NUMCARDS - 1;
		stackOfCards = new ArrayList<Card>();
		
		//loop through suits
			//loop through faces
				//add in a new card
		for(int x = 0; x < NUMSUITS; x++) {
			for(int y = 1; y <= NUMFACES; y++) {
				stackOfCards.add(new BlackJackCard(y, SUITS[x]));
			}
		}
		
	}

	//modifiers
   public void shuffle ()
	{
		//shuffle the deck
		//reset variables as needed
		Collections.shuffle(stackOfCards);
		topCardIndex = NUMCARDS - 1;
	}

   //accessors
	public int  size ()
	{
		return topCardIndex + 1;
	}

	public int numCardsLeft()
	{
		return topCardIndex + 1;
	}

	public Card nextCard()
	{
		return stackOfCards.get(topCardIndex--);
	}

	public String toString()
	{
		return stackOfCards + "   topCardIndex = " + topCardIndex;
	} 
}