package Display;

import src.Card;
import src.Deck;
import Player.Player;
import java.util.function.Consumer;
/**Register involving the player's hand display
 * 
 * @author Spencer Peterson
 * Student Number: 230157543
 *
 */
public class CardDisplayRegister {
	private Card discarded;
	Register myRegister = new Register();
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
		discarded = user.getHand().get(i);
		user.discard(i);
		user.getHand().add(deck.getShuffledDeck().pop());
		user.sortHand();
		update();
		
	}
	//getter for most recently discarded card
	public Card getDiscarded() {
		return discarded;
	}
	
	public Player getPlayer() {
		return user;
	}
}
