package Display;

import Player.Player;
import src.Deck;
import java.util.function.Consumer;
/**
 * Register for what the player is betting. Also is for what will be in the pot.
 * 
 * @author Spencer Peterson
 * Student Number: 230157543
 *
 */
public class BetRegister {
	private int playerBet;
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
	//Returns the display text
	public String getDisplayText() {
		potTotal += bet;
		output = Integer.toString(potTotal);
		return output;
	}
	//Sets the input
	public void setInput(String in) {
		output = in;
		update();
	}
	//Sets how much the bet is and subtracts from user's total.
	public void setBet(int wager) throws IllegalArgumentException{
		if(wager < 0 || wager > user.getTotal()) {
			throw new IllegalArgumentException("Invalid bet, please enter a different amount");
		}
		playerBet = user.bet(wager);
		user.setTotal(user.getTotal() - playerBet);
		bet = wager;
		update();
	}
	//Announces how much was bet.
	public String betAnnounce() throws IllegalArgumentException{
		if(playerBet < 0 || playerBet > user.getTotal()) {
			throw new IllegalArgumentException("Invalid bet, please enter a different amount");
		}
		return "You bet " + playerBet;
	}
	

}
