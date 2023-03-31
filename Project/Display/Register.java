package Display;

import Player.Player;
import src.Deck;
import java.util.function.Consumer;
/**
 * Primary register for the main text input.
 * 
 * @author Spencer Peterson
 * Student number: 230157543
 *
 */
public class Register {
	private String output = "";
	private Player user = new Player();
	private int bet = user.getTotal();
	private int playerBet;
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
	//Returns the display text for the main display.
	public String getDisplayText() {
		if(output.toLowerCase().equals("draw")) {
			output += "You drew a card \n";
		}
		if(output.toLowerCase().equals("fold")) {
			output += "You fold your hand \n";
		}
		return output;
	}
	//Sets the output text based on input.
	public void setInput(String in) {
		output += in;
		update();
	}
	//Sets how much the player has bet.
	public void setBet(int wager) {
		playerBet = user.bet(wager);
		user.setTotal(user.getTotal() - playerBet);
		update();
	}
	//Announces what the player has bet.
	public void betAnnounce(int wager) {
		output += "You bet " + wager + "\n";
		update();
	}
	

}
