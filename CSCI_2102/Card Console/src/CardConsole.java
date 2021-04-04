import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;

import CardGames.Card;
import CardGames.Deck;
import CardGames.Suit;
import CardGames.Value;

public class CardConsole {
	
	// Set trials to 1000000 once you get it figured out
	private static final int trials = 1000000;
	
	// Increment these values as each event occurs
	private static int fourOfAKind = 0;
	private static int flush = 0;
	private static int straight = 0;
	private static int fullHouse = 0;
	public static final String ANSI_GREEN = "\u001B[32m";
	
	static int getCount(ArrayList<String> list) {
	// returns most repeated list item
		int maxCount = 0;
	        for (int i = 0; i < list.size(); i++) {
	            int count = 0;
	            for (int j = 0; j < list.size(); j++) {
	                if (list.get(j) == list.get(i))
	                    count++;
	            }
	            if (count > maxCount) {
	                maxCount = count;
	            }
	        }
	     return maxCount;
	}
	
	 
	public static int converter(String n) {
	// Method to convert String Values in hand	
		if (n == "J")
			return 11;
		if (n == "Q")
			return 12;
		if (n == "K")
			return 13;
		if (n == "A")
			return 14;
		else {
			int x = Integer.parseInt(n);
			return x;
		}
	}
	
	
	public static int isStraight(ArrayList<Integer> list) {
	// if count = 4, the list increments each element
		
		int count = 0;
		int test = 1;
		int y = list.get(0);
		for (int x : list) {
			if (x - y == test) {
				count++;
				test++;
			}
		}
		return count;
	}
	
	
	public static int ofAKind(ArrayList<Integer> list) {
	// finds most repeated list element
		
		int maxCount = 0;
        for (int i = 0; i < list.size(); i++) {
            int count = 0;
            for (int j = 0; j < list.size(); j++) {
                if (list.get(j) == list.get(i))
                    count++;
            }
            if (count > maxCount) {
                maxCount = count;
            }
        }
        return maxCount;
	}
	
	public static int twoOfAKind(ArrayList<Integer> list) {
	// finds element repeated < 3 times	
		
		int maxCount = 3;
        for (int i = 0; i < list.size(); i++) {
            int count = 0;
            for (int j = 0; j < list.size(); j++) {
                if (list.get(j) == list.get(i))
                    count++;
            }
            if (count < maxCount) {
                maxCount = count;
            }
        }

        return maxCount;
	}
	public static void main(String[] args) {
	// This method is complete, focus on implementing playOneHand()
		
		for (int i=0; i<trials; i++) {
			playOneHand();
		}
		
		System.out.println("After " + trials + " trials, the following occurrences were observed.\n");
		System.out.println("4 of a Kind:\t" + fourOfAKind + " times\t(" + (((double) fourOfAKind / trials) * 100) + "%)");
		System.out.println("Flush:      \t" + flush + " times\t(" + (((double) flush / trials) * 100) + "%)");
		System.out.println("Straight:   \t" + straight + " times\t(" + (((double) straight / trials) * 100) + "%)");
		System.out.println("Full House: \t"+ fullHouse + " times\t(" + (((double) straight / trials) * 100) + "%)");

	}
	
	public static void playOneHand() {
		
		// Create a deck object
		Deck deck = new Deck();

		// Simulate drawing a random 5 card Poker hand
		for (int i=0; i<5; i++) {
			deck.drawCard();
		}
		
		// Add the cards to your hand
		ArrayList<Card> hand = deck.getDiscardPile();
		
		// lists of current hand's values, suits
		ArrayList<String> handValues = new ArrayList<>();
		ArrayList<String> handSuits = new ArrayList<>();
		ArrayList<Integer> linear = new ArrayList<>();
		boolean matchFound = false;
		
		// Examine each card in the hand
		for (Card card : hand) {
			String x = card.getValue();
			String y = card.getSuit();
				
			handValues.add(x);
			handSuits.add(y);
		}
		
		for (String val : handValues) {
			linear.add(converter(val));
			
		}
		
		// Int values of each card in hand
		Collections.sort(linear);

		
		// if 4-of-a-kind 
		if(getCount(handValues) == 4) {
			System.out.println(ANSI_GREEN+"4 of a Kind: \t\t"+hand+ANSI_GREEN);
			matchFound = true;
			fourOfAKind++;
		}
		// if flush
		if (getCount(handSuits) == 5) {
			System.out.println("Flush: \t\t\t"+hand);
			matchFound = true;
			flush++;
		}
		// if straight
		if (isStraight(linear) == 4) {
			System.out.println("Straight: \t\t"+hand);
			matchFound = true;
			straight++;
		}
		// if full house
		if (ofAKind(linear) == 3 && twoOfAKind(linear) == 2) {
			System.out.println("Full House: \t\t"+hand);
			matchFound = true;
			fullHouse++;
		}
	
	}
	
 }


