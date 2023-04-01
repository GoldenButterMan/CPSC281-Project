package Player;

import java.util.ArrayList;
import java.util.Stack;
import java.util.Random;
import src.Card;
import src.Deck;
import java.util.Collections;
/**
 * Class for the player actions.
 * 
 * @author Spencer Peterson
 * Student Number: 230157543
 *
 */
public class Player {
	private int total;
	private ArrayList<Card> hand;
	private Random rand = new Random();
	
	public Player() {
		total = 10000000;
		hand = new ArrayList<>();
		
		this.sortHand();
		
	}
	//How much the player is betting
	public int bet(int wager) throws IllegalArgumentException{
		if(wager > total || wager < 0) {
			throw new IllegalArgumentException("This wager is invalid, please enter a different amount");
		}
		else {
			//Subtract bet from total
			total -= wager;
			return wager;
		}
	}
	//Set the player's hand
	public void setHand(Deck deck) {
		for(int i = 0; i < 5; i++) {
			this.hand.add(deck.getShuffledDeck().pop());
			
		}
		this.sortHand();
	}
	//Get the player's hand
	public ArrayList<Card> getHand() {
		return this.hand;
	}
	//Get the total a player has.
	public int getTotal() {
		return total;
	}
	//Set the total the player has
	public void setTotal(int earn) {
		total += earn;
	}
	

	//Discard a card
	public void discard(int card) {
		hand.remove(card);
	}
	//Fold player's hand
	public void fold() {
		hand.removeAll(hand);
	}
	//Draw a card
	public void drawCard(Card card) {
		hand.add(card);
	}
	
	/**
     * Sorts hand from smallest card to largest card.
     */
    public void sortHand(){

        Collections.sort(hand);

    }
	
	
}

