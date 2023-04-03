package CommandLine;

import java.util.*;
/**
 * This is a command line variation of our project code.
 * 
 */
public class Main {


    public static void main (String[] args){


        //Initialize a scanner that won't be used
        Scanner scanner = new Scanner(System.in);

        //total amount of money in the pot
        int potTotal = 0;
        //Loop condition to keep the game going until one of two win conditions is met
        boolean gameOver = false;
        //Initial amount in the player's money pile
        int newPot = 100000;

        System.out.println("Welcome to the World's Greatest Game of Poker You Will Ever Play!");
        System.out.println("-----------------------------------------------------------------\n");
        //until game over condition is met
        do{

            //Deck needs to be reinitialized for every round of poker. Otherwise, we could run out of cards
            Deck deck = new Deck();
            //initialize a player and sort their hand.
            Player player = new Player(deck);
            player.sortHand();
            player.setTotal(newPot);

            //Create an ai that the player can compare their hand against.
            ArrayList<Card> theEnemy = new ArrayList<Card>();

            for (int i = 0; i < 5; i++){
                theEnemy.add(deck.getShuffledDeck().pop());
            }

            Collections.sort(theEnemy);


            //one round of poker. gives you three chances to exchange cards.
            for (int i = 0; i < 3; i++){

                if (i == 2){
                    System.out.println("Final Turn!");
                }

                System.out.println("Pot: " + potTotal + "\t\t\t\t\t Money Left: " + player.getTotal() + "\n\n");
                System.out.println(player.getHand() + "<-- This is your hand.");
                System.out.println("[ 1,  2,  3,  4,  5 ]");
                System.out.println();
                //Betting phase
                System.out.println("How much would you like to bet: ");

                int bet = getBet(player.getTotal());

                potTotal += bet;

                player.setTotal(player.getTotal() - bet);

                //Card exchange phase
                System.out.println("How many cards would you like to discard?");
                int forTheLoop = getHowMany();

                for (int j = 0; j < forTheLoop; j++){

                    System.out.println(player.getHand() + "<-- This is your hand.");
                    System.out.println("[ 1,  2,  3,  4,  5 ]");
                    System.out.println();
                    System.out.println("Which of these cards would you like to discard?");
                    int whichOfEmUse = whichOfEm(j);
                    player.getHand().remove(whichOfEmUse - 1);


                }

                for (int k = 0; k < forTheLoop; k++){
                    player.getHand().add(deck.getShuffledDeck().pop());
                }
                player.sortHand();

                System.out.println(player.getHand());


            }

            //Once the betting has been completed, rank the hands and compare them.
            if (rankPlayerHand(player.getHand()) > rankPlayerHand(theEnemy)){
                System.out.println("Your Hand:");
                System.out.println(player.getHand());
                System.out.println("Your opponent's hand:");
                System.out.println(theEnemy);
                System.out.println("----------------------");
                System.out.println("|  Y O U  W I N !!!  |");
                System.out.println("----------------------");
                System.out.println();
                newPot = (2 * potTotal) + player.getTotal();

                potTotal = 0;
            } else {
                System.out.println("Your Hand:");
                System.out.println(player.getHand());
                System.out.println("Your opponent's hand:");
                System.out.println(theEnemy);
                System.out.println();

                System.out.println("Better luck next time");
                System.out.println();

                newPot = player.getTotal();
                potTotal = 0;
            }



            if (player.getTotal() <= 0){
                System.out.println("You ran out of money! Better take out a mortgage.");
                gameOver = true;
            } else if (player.getTotal() >= 200000){
                System.out.println("You've successfully doubled your money! Stimulate your local economy!");
                gameOver = true;
            }
        } while (!gameOver);
    }

    /**
     * Determines which card is being discarded
     * @param decrease Very important. If the player wants to discard two cards, they should be able to discard the
     *                 fifth card for the first time, but not the second time. This variable makes sure of that.
     * @return sent   The index of which card is being discarded.
     */
    public static int whichOfEm(int decrease){

        Scanner scanner = new Scanner(System.in);
        int sent;

        while (true){
            while (!scanner.hasNextInt()){

                System.out.println("Please input a valid value: ");
                scanner.next();

            }

            sent = scanner.nextInt();
            //I might not need this next line
            scanner.nextLine();

            if (sent < 1){

                System.out.println("Please pick from the cards available: ");

            } else if (sent > 5 - decrease){
                System.out.println("Please pick from the cards available: ");
            } else {
                return sent;
            }

        }

    }

    /**
     * Determines however many cards the player wants to discard
     * @return  howMany The amount of cards to be discarded.
     */
    public static int getHowMany(){
        Scanner scanner = new Scanner(System.in);
        int howMany;

        while (true){
            while (!scanner.hasNextInt()){

                System.out.println("Please input a valid value: ");
                scanner.next();

            }

            howMany = scanner.nextInt();
            //I might not need this next line
            scanner.nextLine();

            if (howMany < 0){

                System.out.println("Please enter a positive value: ");

            } else if (howMany > 3){
                System.out.println("You may only discard up to three cards. Please try again: ");
            } else {
                return howMany;
            }

        }

    }

    /**
     * Determines how much money the player wants to put into the pot.
     * @param playerTotal   Makes sure that the player can't put more money in the pot than they have.
     * @return bet the amount being bet.
     */
    public static int getBet(int playerTotal){
        Scanner scanner = new Scanner(System.in);
        int bet;

        while (true){
            while (!scanner.hasNextInt()){

                System.out.println("Please input a valid value: ");
                scanner.next();

            }

            bet = scanner.nextInt();
            //I might not need this next line
            scanner.nextLine();

            if (bet < 0){

                System.out.println("Please enter a positive value: ");

            } else if (bet > playerTotal){
                System.out.println("You do not have this much money. Either get a job, or input a different number: ");
            } else {
                return bet;
            }

        }
    }

    /**
     * Ranks the hands. This was a fun one.
     * @param playerHand Not necessarily the player's hand. Just needs a hand to rank
     * @return rank  A value such that hands can be compared.
     */
    public static int rankPlayerHand(ArrayList<Card> playerHand){


        int numOfPairs = 0;
        boolean threeOfKind = false;
        boolean fourOfKind = false;
        boolean isStraight = false;
        boolean isFlush = false;
        //int handRank;

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
