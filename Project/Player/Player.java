package Player;

import java.util.ArrayList;
import java.util.Stack;
import java.util.Random;
import src.Card;
import src.Deck;

public class Player {
	private int total;
	private ArrayList<Card> hand;
	private Random rand = new Random();
	
	public Player() {
		total = 10000000;
		hand = new ArrayList<>();
	}
	
	public void bet(int wager) throws IllegalArgumentException{
		if(wager > total || wager < 0) {
			throw new IllegalArgumentException("This wager is invalid, please enter a different amount");
		}
		else {
			total -= wager;
		}
	}
	
	public void setHand(Deck deck) {
		for(int i = 0; i < 5; i++) {
			this.hand.add(deck.getShuffledDeck().pop());
		}
	}
	
	public ArrayList<Card> getHand() {
		return this.hand;
	}
	
	public int getTotal() {
		return total;
	}
	
	public void setTotal(int earn) {
		total += earn;
	}
	

	
	public void discard(int card) {
		hand.remove(card);
	}
	
	public void fold() {
		hand.removeAll(hand);
	}
	
	public void drawCard(Card card) {
		hand.add(card);
	}
	
	
}

