package Display;

import Player.Player;
import src.Deck;
import java.util.function.Consumer;

public class Register {
	private String output = "";
	private Player user = new Player();
	private int bet = user.getTotal();
	private Deck deck = new Deck();
	private Consumer<String> sink;
	
	public Register() {
		setRegisterListener((s) -> {});
	}
	
	public void setRegisterListener(Consumer<String> input) {
		this.sink = input;
	}
	
	private void update() {
		sink.accept(getDisplayText());
	}
	
	public String getDisplayText() {
		if(output.toLowerCase().equals("draw")) {
			output = "You drew a card";
		}
		if(output.toLowerCase().equals("fold")) {
			output = "You fold your hand";
		}
		return output;
	}
	
	public void setInput(String in) {
		output = in;
		update();
	}
	
	public void setBet(int wager) {
		user.setTotal(user.getTotal() - wager);
		bet = wager;
		update();
	}
	

}
