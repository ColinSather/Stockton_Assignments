package CardGames;

// This is a helper class provided to you. Its use is not required, but it may help you.

public class Suit {

	String suit;
	int count;
	
	public Suit(String suit) {
		this.suit = suit;
		count = 0;
	}
	
	public String getSuit() {
		return suit;
	}
	
	public String toString() {
		return suit;
	}
	
	public int getCount() {
		return count;
	}
	
	public void increment() {
		count++;
	}
	
}
