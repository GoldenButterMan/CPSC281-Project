package CommandLine;

import java.util.*;
import java.util.ArrayList;
import java.util.Stack;
import java.util.Random;
//import Card.Card;
//import src.Deck;

public class Player {
    private int total;
    public ArrayList<Card> hand;
    private Random rand = new Random();


    public Player(Deck deck) {
        this.total = 100000;
        hand = new ArrayList<>();
        for (int i = 0; i < 5; i++){
            hand.add(deck.getShuffledDeck().pop());
        }
    }

    public void bet (int wager) {

        if (wager > total) {
            System.out.println("You do not have enough money to wager");
        }else {
            total -= wager;
        }


    }

    public int getTotal(){ return total; }

    /**
     * Sorts hand from smallest card to largest card.
     */
    public void sortHand(){

        Collections.sort(hand);

    }

    public ArrayList<Card> getHand(){
        return hand;
    }

    public void setTotal (int bet){
        this.total = bet;
    }








}
