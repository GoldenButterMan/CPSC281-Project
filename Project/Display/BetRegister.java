package Display;

import Player.Player;
import src.Deck;
import java.util.function.Consumer;

public class BetRegister {
	private int potTotal = 0;
	private String output = "";
	private Player user = new Player();
	private int bet = user.getTotal();
	private Deck deck = new Deck();
	private Consumer<String> sink;
	
	public BetRegister() {
		setRegisterListener((s) -> {});
	}
	
	public void setRegisterListener(Consumer<String> input) {
		this.sink = input;
	}
	
	private void update() {
		sink.accept(getDisplayText());
	}
	
	public String getDisplayText() {
		potTotal += bet;
		output = Integer.toString(potTotal);
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
