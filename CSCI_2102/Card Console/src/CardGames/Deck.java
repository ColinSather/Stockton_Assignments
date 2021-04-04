package CardGames;

import java.util.ArrayList;
import java.util.Random;

// This class is complete, but may be worth referring to

public class Deck {

	private ArrayList<Card> activeDeck;
	private ArrayList<Card> discard;
	
	public Deck() {
		activeDeck = new ArrayList<>();
		discard = new ArrayList<>();
		reset();
	}
	
	public Card drawCard() {
		Random g = new Random();
		int draw = g.nextInt(activeDeck.size());
		Card card = activeDeck.get(draw);
		activeDeck.remove(card);
		discard.add(card);
		return card;
	}
	
	public String toString() {
		String activePile = "Active Deck: " + activeDeck.toString();
		String discardPile = "Discard Pile: " + discard.toString();
		return activePile + "\n" + discardPile;
	}
	
	public ArrayList<Card> getDiscardPile() {
		return discard; 
	}
	
	public void reset() {
		String[] suits = {"Clubs", "Diamonds", "Hearts", "Spades"};
		String[] values = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
		
		activeDeck.clear();
		discard.clear();
		
		for (String value : values) {
			for (String suit : suits) {
				activeDeck.add(new Card(value, suit));
			}
		}
	}
	
}
