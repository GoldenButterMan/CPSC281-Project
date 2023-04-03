package Display;

import src.Card;
import src.Deck;
import Player.Player;
import java.util.function.Consumer;
import java.util.Collections;
import java.util.Stack;
/**Register involving the player's hand display
 * 
 * @author Spencer Peterson
 * Student Number: 230157543
 *
 */
public class CardDisplayRegister{
	private Stack<Card> discardStack = new Stack<>();
	private Card discarded;
	private Card drawn;
	//Register myRegister = new Register();
	Player user = new Player();
	private String output = "";
	private Consumer<String> sink;
	private Deck deck = new Deck();
	
	public CardDisplayRegister() {
		user.setHand(deck);
		setRegisterListener((s) -> {});
	}
	
	public void setRegisterListener(Consumer<String> input) {
		this.sink = input;
	}
	
	private void update() {
		sink.accept(getDisplayText());
	}
	
	public String getDisplayText() {
		getDisplayHand();
		return output;
	}
	//getter for the player's hand
	private void getDisplayHand() {
		int size = user.getHand().size();
		String card = "";
		for(int i = 0; i < size; i++) {
			card += user.getHand().get(i).toString();
			output = card;
		}
		
	}
	//discards card from hand
	public void discardedCard(int i) {
		if(i < 0) {
			i = 1;
		}
		discardStack.push(user.getHand().get(i));
		discarded = user.getHand().get(i);
		user.discard(i);
		drawn = deck.getShuffledDeck().pop();
		user.getHand().add(drawn);
		Collections.sort(user.getHand());
		update();
		
	}
	//getter for most recently discarded card
	public Card getDiscarded() {
		return discarded;
	}
	
	public Card getDrawn() {
		return drawn;
	}
	
	public Player getPlayer() {
		return user;
	}
	
}
