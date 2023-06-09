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
	private int counter = 1;
	private int playerBet;
	private int potTotal = 0;
	private String output = "";
	private Player user = new Player();
	private int bet = user.getTotal();
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
		if(counter >= 3) {
			return output;
		}
		potTotal += bet;
		output = Integer.toString(potTotal);
		return output;
	}
	//Clear's pot if the counter is ≥ 3.
	public void clearPot() {
		counter++;
		if(counter >= 3) {
			potTotal = 0;
			output = Integer.toString(potTotal);
			update();
		}
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
	

}
