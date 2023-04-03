package CommandLine;
//import javafx.scene.image.Image;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;

/** I want it to be known that I intend on making this ai as stupid as possible.
 * All of its decisions are random and have no logic at all.
 * Though, this might make it the smartest poker player, the logic behind it is extremely smooth brained.
 */

public class TheEnemy {

    //The ai's hand
    private ArrayList<Card> hand;
    //the ai's money. This is the total amount of money the ai has, and the win-con is when the ai's stack = 0
    public int stack;

    public Deck deckRef;

    public Random randy = new Random();

    public TheEnemy(Deck deck){
        //start with $100. we can change this later on
        deckRef = deck;
        this.stack = 100;
        this.hand = hand;
    }

    /**
     * To bet in poker, whoever's turn it is must either put in the same amount of money as was previously bet,
     * raise to a higher bet, or fold the hand.
     *
     * In poker, there are 3 primary cases for betting
     * 1. Check:
     *      If nobody has raised, the minbet is 0. Checking is technically a call but for $0.
     * 2. Call:
     *      The opponent raised, thus the minbet is now more than 0. In order to stay in the game the minbet has to be
     *      matched. For example, if the player raises $7, the player must fold, match this amount, or.....
     * 3. Raise:
     *      Raising in poker is stupid and dumb. So we're just making it so that you can raise by however much you want.
     *
     * @param minBet if this is not 0, my life gets harder.
     * @return the amount of money to be added to the pot.
     */
    public int bet(int minBet){

        //Random number to determine ai actions

        int decision;
        int raiseAmount;

        //base case, minBet = 0;
        decision = randy.nextInt(2);
        if (decision == 0){
            if (minBet == 0){
                System.out.println("The AI checks");
            }else {
                System.out.println("The AI calls");
            }

            return minBet;

        } else {
            //Raise

            raiseAmount = randy.nextInt(stack);
            System.out.println("The AI raises by " + raiseAmount);
            return raiseAmount;

        }

    }

    public void iniHand(){
        for (int i = 0; i == 4; i++){
            hand.add(deckRef.cardFromTop());
        }
    }

    /**
     * Not sure if this will stay as void. Might end up needing to return a card here instead. Or an arraylist.
     * I actually have no idea how I'm gonna handle this.
     */
    public void tradeIn(){

        int tradeAmount = randy.nextInt(3);

    }


}

