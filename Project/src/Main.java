package src;

import Display.*;
import Player.Player;

public class Main {
	private static void start() {
		PokerFrame frame = new PokerFrame();
	}
    public static void main (String[] args){
    	javax.swing.SwingUtilities.invokeLater(() -> start());
        Deck deck = new Deck();
        Player player = new Player();
        player.setHand(deck);
        System.out.println(player.getHand());
    }



}
