package src;

import java.util.ArrayList;

import Display.*;
import Player.Player;

public class Main {
	private static void start() {
		PokerFrame frame = new PokerFrame();
	}
    public static void main (String[] args){
    	javax.swing.SwingUtilities.invokeLater(() -> start());
    }
    
    /**
     * This is a method that ranks the player's hand. Right now, there is a separate method for this and
     * there will be a different method for the ai. I am hoping that I can just stick it all into one.
     * Also, this will probably end up being an int method. I'm leaving it void for now until I'm
     * comfortable that it works.
     *
     * If statement time: Once again, I'm sure there's a better way, but our philosophy for coding this is to get
     * it working, then make it better.
     */
    public static int rankPlayerHand(Player player){

        ArrayList<Card> playerHand = player.getHand();
        int numOfPairs = 0;
        boolean threeOfKind = false;
        boolean fourOfKind = false;
        boolean isStraight = false;
        boolean isFlush = false;

        //Royal Flush
        if (playerHand.get(0).getName().equals("10")){
            String suited = playerHand.get(0).getSuit();

            if (playerHand.get(1).getName().equals("jack")){
                //If suit is the same, continue checking for royal flush
                if (playerHand.get(1).getSuit().equals(suited)){

                    if (playerHand.get(2).getName().equals("queen") && playerHand.get(2).getSuit().equals(suited)
                    && playerHand.get(3).getName().equals("king") && playerHand.get(3).getSuit().equals(suited)
                    && playerHand.get(4).getName().equals("ace") && playerHand.get(4).getSuit().equals(suited)){

                        //if all these conditions are met, we have a royal flush.
                        return 1000;
                    }
                }
            }
        }

        //Flush check
        String suited = playerHand.get(0).getSuit();
        isFlush = playerHand.get(1).getSuit().equals(suited) && playerHand.get(2).getSuit().equals(suited)
                && playerHand.get(3).getSuit().equals(suited) && playerHand.get(4).getSuit().equals(suited);

        //Straight check

        //If first card is an ace
        if (playerHand.get(0).getName().equals("ace") && playerHand.get(1).getName().equals("2")
                && playerHand.get(2).getName().equals("3") && playerHand.get(3).getName().equals("4")
                && playerHand.get(4).getName().equals("5")){
            isStraight = true;
        } else{

            int willItBlend = 0;

            for (int i = 1; i < 5; i++){

                if (playerHand.get(0).getNumber() + i != playerHand.get(0+i).getNumber()){
                    break;
                }else{
                    willItBlend++;
                }


            }

            isStraight = willItBlend == 4;

        }

        //Pair check.

        if (playerHand.get(0).getNumber() == playerHand.get(1).getNumber()){
            //check for three of a kind
            if(playerHand.get(0).getNumber() == playerHand.get(2).getNumber()){
                //check for four of a kind
                if(playerHand.get(0).getNumber() == playerHand.get(3).getNumber()){
                    fourOfKind = true;
                } else {
                    threeOfKind = true;
                    if (playerHand.get(3).getNumber() == playerHand.get(4).getNumber()){
                        numOfPairs++;
                    }
                }
            } else{
                numOfPairs++;
                if (playerHand.get(2).getNumber() == playerHand.get(3).getNumber()){
                    numOfPairs++;
                } else if (playerHand.get(3).getNumber() == playerHand.get(4).getNumber()){
                    numOfPairs++;
                }

            }
        } else if (playerHand.get(1).getNumber() == playerHand.get(2).getNumber()){
            //check for three of a kind
            if(playerHand.get(1).getNumber() == playerHand.get(3).getNumber()){
                //check for four of a kind
                if(playerHand.get(0).getNumber() == playerHand.get(4).getNumber()){
                    fourOfKind = true;
                } else {
                    threeOfKind = true;
                }
            } else {
                numOfPairs++;
                if (playerHand.get(3).getNumber() == playerHand.get(4).getNumber()){
                    numOfPairs++;
                }
            }

        } else if (playerHand.get(2).getNumber() == playerHand.get(3).getNumber()){
            //check for three of a kind
            if (playerHand.get(2).getNumber() == playerHand.get(4).getNumber()){
                threeOfKind = true;
                if (playerHand.get(0).getNumber() == playerHand.get(1).getNumber()){
                    numOfPairs++;
                }
            } else {
                //No need to check for four of a kind
                numOfPairs++;
            }
        } else if (playerHand.get(3).getNumber() == playerHand.get(4).getNumber()){
            numOfPairs++;
        }
        //At the end of this, we'll be out of potential pairs.

        //Now we have to rank our hands.
        //Note: highCardAdd is a variable that is used to break ties. I need to get the highest
        //card that is relevant to the hand. (highest card in the pair, not just the hand)


        int highCardAdd;

        if (isStraight && isFlush) {
            highCardAdd = playerHand.get(4).getRank();
            return 900 + highCardAdd;
        } else if (fourOfKind){

            if (playerHand.get(4).getNumber() == playerHand.get(3).getNumber()){
                highCardAdd = playerHand.get(4).getRank();
            } else{
                highCardAdd = playerHand.get(3).getRank();
            }

            return 840 + highCardAdd;



        } else if (threeOfKind && numOfPairs == 1){

            if (playerHand.get(0).getNumber() == playerHand.get(2).getNumber()){
                highCardAdd = playerHand.get(0).getRank();
            } else {
                highCardAdd = playerHand.get(2).getRank();
            }


            return 785 + highCardAdd;
        } else if (isFlush) {
            highCardAdd = playerHand.get(4).getRank();
            return 732 + highCardAdd;
        }  else if (isStraight){
            highCardAdd = playerHand.get(4).getRank();
            return 679 + highCardAdd;
        } else if (threeOfKind){

            //three possibilities for three of a kind
            if (playerHand.get(4).getNumber() == playerHand.get(3).getNumber()){
                highCardAdd = playerHand.get(4).getRank();
            } else if (playerHand.get(3).getNumber() == playerHand.get(2).getNumber()){
                highCardAdd = playerHand.get(3).getRank();
            } else {
                highCardAdd = playerHand.get(2).getRank();
            }

            return 626 + highCardAdd;

        } else if (numOfPairs == 2){
            //Two Pair
            //TODO: Make sure this logic is sound
            if (playerHand.get(4).getNumber() == playerHand.get(3).getNumber()){
                highCardAdd = playerHand.get(4).getRank();
            } else {
                highCardAdd = playerHand.get(3).getRank();
            }

            return 573 + highCardAdd;

        } else if (numOfPairs == 1){
            //Pair
            if (playerHand.get(4).getNumber() == playerHand.get(3).getNumber()){
                highCardAdd = playerHand.get(4).getRank();
            } else if (playerHand.get(3).getNumber() == playerHand.get(2).getNumber()){
                highCardAdd = playerHand.get(3).getRank();
            } else if (playerHand.get(2).getNumber() == playerHand.get(1).getNumber()){
                highCardAdd = playerHand.get(2).getRank();
            } else {
                highCardAdd = playerHand.get(1).getRank();
            }

            return 520 + highCardAdd;

        } else {
            return playerHand.get(4).getRank();
        }

    }



}