package src;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class Card {

    private String name, suit;
    //private Image image;

    public Card(String name, String suit){
        setName(name);
        setSuit(suit);
    }

    public String getName(){ return name; }

    public String getSuit(){ return suit; }


    /**
     * This method valdates the argument and sets
     * the instant variable to that name
     * @param name 2, 3, 4, 5, 6, 7, 8, 9, 10, jack, queen, king, ace
     */
    public void setName(String name){

        List<String> nameCheck = getNameCheck();
        name = name.toLowerCase();

        if(nameCheck.contains(name)){
            this.name = name;
        } else {
            throw new IllegalArgumentException("Invalid card name. Valid card names: " + nameCheck);
        }
    }



    /**
     * This method validates the argument and sets
     * the instant variable to that name
     * @param suit spades, hearts, club, diamonds
     */
    public void setSuit(String suit){
        List<String> suitCheck = getSuitCheck();
        suit = suit.toLowerCase();

        if(suitCheck.contains(suit)){
            this.suit = suit;
        } else {
            throw new IllegalArgumentException("Invalid suit name. Valid suit names: " + suitCheck);
        }
    }

    /**
     * Initialize a list of valid names of the cards
     * @return list containing 2, 3, 4, 5, 6, 7, 8, 9, 10, jack, queen, king, ace
     */
    public static List<String> getNameCheck(){

        return Arrays.asList("2","3","4","5","6","7","8","9","10","jack","queen","king","ace");

    }

    /**
     * Initialize a list of valid names of the cards
     * @return list containing spades, hearts, clubs, diamonds
     */
    public static List<String> getSuitCheck(){

        return Arrays.asList("spades", "hearts", "clubs", "diamonds");

    }
    
    @Override
    public String toString() {
    	String nameDisplay = "";
    	String suitDisplay = "";
    	switch(name) {
    		case "ace":
    			nameDisplay = "A";
    			break;
    		case "2":
    			nameDisplay = "2";
    			break;
    		case "3":
    			nameDisplay = "3";
    			break;
    		case "4":
    			nameDisplay = "4";
    			break;
    		case "5":
    			nameDisplay = "5";
    			break;
    		case "6":
    			nameDisplay = "6";
    			break;
    		case "7":
    			nameDisplay = "7";
    			break;
    		case "8":
    			nameDisplay = "8";
    			break;
    		case "9":
    			nameDisplay = "9";
    			break;
    		case "10":
    			nameDisplay = "\u2469";
    			break;
    		case "jack":
    			nameDisplay = "J";
    			break;
    		case "queen":
    			nameDisplay = "Q";
    			break;
    		case "king":
    			nameDisplay = "K";
    	}
    	switch(suit) {
    		case "spades":
    			suitDisplay = "\u2660";
    			break;
    		case "hearts":
    			suitDisplay = "\u2661";
    			break;
    		case "clubs":
    			suitDisplay = "\u2663";
    			break;
    		case "diamonds":
    			suitDisplay = "\u2662";
    			break;
    	}
    	return nameDisplay + suitDisplay;
    }




}
