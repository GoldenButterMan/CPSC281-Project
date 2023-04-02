package Display;

import Player.Player;
import src.Deck;
import java.util.function.Consumer;
import src.Main;
import Display.CardDisplayRegister;
import Display.PokerFrame;
/**
 * Primary register for the main text input.
 * 
 * @author Spencer Peterson
 * Student number: 230157543
 *
 */
public class Register {
	private int counter = 1;
	private String output = "";
	private CardDisplayRegister cardRegister = new CardDisplayRegister();
	private Player user = cardRegister.getPlayer();
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
		
		int counter = cardRegister.getCounter();
		int result = Main.rankPlayerHand(user);
		
		if(counter <= 3) {
			output = "";
		}
		else {
			if(result == 1000) {
				output = "You got a royal flush";
			}
			
			else if(result >= 840 && result < 900) {
				output = "You got four of a kind";
			}
			
			else if(result >= 900 && result < 1000) {
				output = "You got a straight";
			}
			
			else if(result >= 785 && result < 840) {
				output = "You got three of a kind";
			}
			
			else if(result >= 732 && result < 785) {
				output = "You got a flush";
			}
			
			else if(result >= 679 && result < 732) {
				output = "You got three of a kind";
			}
			
			else if(result >= 520 && result < 679) {
				output = "You got pairs";
			}
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
	
	public void increment() {
		counter++;
	}
	

}
