package CardGames;

// This class is complete, but may be worth referring to

public class Card {
	
	private String value;
	private String suit;
	
	public Card(String value, String suit) {
		this.value = value;
		this.suit = suit;
	}

	public String getValue() {
		return value;
	}

	public String getSuit() {
		return suit;
	}
	
	public String toString() {
		return value + "-" + suit;
	}
		
}
