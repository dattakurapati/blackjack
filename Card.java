public class Card
{
	public static final String FACES[] = {"ZERO","ACE","TWO","THREE","FOUR",
			"FIVE","SIX","SEVEN","EIGHT","NINE","TEN","JACK","QUEEN","KING"};

	private String suit;
	private int face;
	private int actualFace;

	//constructors
	public Card() {
		this.suit = " ";
		this.face = 0;
		this.actualFace = 0;
	}  

	public Card(int face, String suit) {
		this.suit = suit;
		this.face = face;
		this.actualFace = face;
	}

	// modifiers
	public void setSuit(String suit) {
		this.suit = suit;
	}

	public void setFace(int x) {
		this.face = x;
		this.actualFace = x;
	}

	//accessors
	public String getSuit() {
		return suit;
	}

  	public int getValue()
  	{
		if((face ==  11 && actualFace != 1) || face == 12 || face == 13) {
			face = 10;
		}
		if (face == 1) {
			face = 11;
		}
  		return face;
  	}

	public boolean equals(Object obj)
	{
		if(this == obj) {
			return true;
		} else {
			return false;
		}
	}

  	//toString
	public String toString() {
		return FACES[actualFace] + " of " + getSuit() + " | value = " + getValue();
	}
   
 }