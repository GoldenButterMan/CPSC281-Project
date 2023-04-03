package CommandLine;
//import javafx.scene.image.Image;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;

public class Deck {

    private ArrayList<Card> deck;
    public Stack<Card> shuffledDeck = new Stack<Card>();
    private int size = 52;
    //private Image backOfCard;

    /**
     * Constructor for an arraylist of Card objects
     * @param deck
     */
    public Deck(ArrayList<Card> deck){
        this.deck = deck;
        //backOfCard = new Image("./images/backofcard-Recovered.png");
    }

    public Deck(){
        //Grab suits
        List<String> suits = Card.getSuitCheck();
        //Grab card names
        List<String> faceNames = Card.getNameCheck();

        //This for loop is to initialize a deck and fill that deck with each card with valid card names
        //and each valid card name has its own suit.
        //TODO: Make this shuffle the deck upon intialization. Either here, or in its own method
        deck = new ArrayList<>();
        for (String suit:suits){
            for (String faceName:faceNames){
                deck.add(new Card(faceName, suit));
            }
        }



        Random randy = new Random();
        //random number between 0-51
        int brandy = 52;
        int anyCard;
        //loop to shuffle the deck
        for (int i = 0; i < 52; i++){

            //pick a random number from the available indices
            anyCard = randy.nextInt(brandy);
            //find it in the deck arraylist and stick it in shuffledDeck
            shuffledDeck.push(deck.get(anyCard));
            //delete it from the unshuffled deck
            deck.remove(anyCard);
            //decrement brandy
            brandy--;

        }
        //backOfCard = new Image("./images/backofcard-Recovered.png");

    }

    public Stack<Card> getShuffledDeck(){
        return shuffledDeck;
    }

    /**
     * Method to take a card off the top of the shuffled deck.
     * This will be used to to fill the hands of both the player and the ai
     * @return a card to be placed in the hand of the player or the ai
     */
    //I will not need this method.
    public Card cardFromTop(){

        //Reference to the deck
        Card givenCard = shuffledDeck.get(size);
        //take the card off the top
        shuffledDeck.remove(size);
        //decrement
        size--;
        //send the card
        return givenCard;

    }





}
