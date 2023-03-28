package Display;

import src.Deck;
import Player.Player;
import java.util.function.Consumer;

public class CardDisplayRegister {
	Player user = new Player();
	private String output = "";
	private Consumer<String> sink;
	private Deck deck = new Deck();
	
	public CardDisplayRegister() {
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
	
	private void getDisplayHand() {
		user.setHand(deck);
		int size = user.getHand().size() /2;
		String card = "";
		for(int i = 0; i < size; i++) {
			card += user.getHand().get(i).toString();
			output = card;
		}
		
	}
	
	public void discardedCard(int i) {
		output = "";
		user.getHand().remove(i);
		/*for(int j = 0; j < user.getHand().size(); j++) {
			output += user.getHand().get(j).toString();
		}*/
		update();
	}

}
