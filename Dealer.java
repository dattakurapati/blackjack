import java.util.Collection;

//(c) A+ Computer Science
//www.apluscompsci.com

public class Dealer extends Player
{
	//define a deck of cards
	private Deck deck;

	public Dealer() {
		deck = new Deck();
	}

	public void  shuffle()
	{
	   //shuffle the deck
	   deck.shuffle();
	}

	public Card  deal(){
	   return deck.nextCard();
	}
	
	public int numCardsLeftInDeck()
	{
		return deck.size();
	}

	public boolean hit()
	{
		if(this.getHandValue() < 17) {
			return true;
		} else {
			return false;
		}
    }
}








