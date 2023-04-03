package CommandLine;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class Card implements Comparable<Card> {

    private int rank, number;
    private String name, suit;
    //private Image image;

    public Card(String name, String suit){
        setName(name);
        setSuit(suit);
        setRank();
        setNumber();
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
     * This method valdates the argument and sets
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

    public int getRank(){ return rank; }

    public void setNumber(){
        if (this.name.equals("2")){
            this.number = 0;
        } else if (this.name.equals("3")){
            this.number = 1;
        } else if (this.name.equals("4")){
            this.number = 2;
        } else if (this.name.equals("5")){
            this.number = 3;
        } else if (this.name.equals("6")){
            this.number = 4;
        } else if (this.name.equals("7")){
            this.number = 5;
        } else if (this.name.equals("8")){
            this.number = 6;
        } else if (this.name.equals("9")){
            this.number = 7;
        } else if (this.name.equals("10")){
            this.number = 8;
        } else if (this.name.equals("jack")){
            this.number = 9;
        } else if (this.name.equals("queen")){
            this.number = 10;
        } else if (this.name.equals("king")){
            this.number = 11;
        } else if (this.name.equals("ace")){
            this.number = 12;
        }
    }

    public int getNumber(){ return number; }

    @Override
    public int compareTo(Card comparing){
        int compareage = ((Card)comparing).getRank();

        return this.rank - compareage;
    }

   //There is probably a better way to do this. This is needed to sort the hand

    public void setRank(){

        if (name.equals("2") && suit.equals("diamonds")){
            this.rank = 0;
        } else if(name.equals("2") && suit.equals("clubs")){
            this.rank = 1;
        } else if(name.equals("2") && suit.equals("hearts")){
            this.rank = 2;
        } else if(name.equals("2") && suit.equals("spades")){
            this.rank = 3;
        } else if(name.equals("3") && suit.equals("diamonds")){
            this.rank = 4;
        } else if(name.equals("3") && suit.equals("clubs")){
            this.rank = 5;
        } else if(name.equals("3") && suit.equals("hearts")){
            this.rank = 6;
        } else if(name.equals("3") && suit.equals("spades")){
            this.rank = 7;
        } else if(name.equals("4") && suit.equals("diamonds")){
            this.rank = 8;
        } else if(name.equals("4") && suit.equals("clubs")){
            this.rank = 9;
        } else if(name.equals("4") && suit.equals("hearts")){
            this.rank = 10;
        } else if(name.equals("4") && suit.equals("spades")){
            this.rank = 11;
        } else if(name.equals("5") && suit.equals("diamonds")){
            this.rank = 12;
        } else if(name.equals("5") && suit.equals("clubs")){
            this.rank = 13;
        } else if(name.equals("5") && suit.equals("hearts")){
            this.rank = 14;
        } else if(name.equals("5") && suit.equals("spades")){
            this.rank = 15;
        } else if(name.equals("6") && suit.equals("diamonds")){
            this.rank = 16;
        } else if(name.equals("6") && suit.equals("clubs")){
            this.rank = 17;
        } else if(name.equals("6") && suit.equals("hearts")){
            this.rank = 18;
        } else if(name.equals("6") && suit.equals("spades")){
            this.rank = 19;
        } else if(name.equals("7") && suit.equals("diamonds")){
            this.rank = 20;
        } else if(name.equals("7") && suit.equals("clubs")){
            this.rank = 21;
        } else if(name.equals("7") && suit.equals("hearts")){
            this.rank = 22;
        } else if(name.equals("7") && suit.equals("spades")){
            this.rank = 23;
        } else if(name.equals("8") && suit.equals("diamonds")){
            this.rank = 24;
        } else if(name.equals("8") && suit.equals("clubs")){
            this.rank = 25;
        } else if(name.equals("8") && suit.equals("hearts")){
            this.rank = 26;
        } else if(name.equals("8") && suit.equals("spades")){
            this.rank = 27;
        } else if(name.equals("9") && suit.equals("diamonds")){
            this.rank = 28;
        } else if(name.equals("9") && suit.equals("clubs")){
            this.rank = 29;
        } else if(name.equals("9") && suit.equals("hearts")){
            this.rank = 30;
        } else if(name.equals("9") && suit.equals("spades")){
            this.rank = 31;
        } else if(name.equals("10") && suit.equals("diamonds")){
            this.rank = 32;
        } else if(name.equals("10") && suit.equals("clubs")){
            this.rank = 33;
        } else if(name.equals("10") && suit.equals("hearts")){
            this.rank = 34;
        } else if(name.equals("10") && suit.equals("spades")){
            this.rank = 35;
        } else if(name.equals("jack") && suit.equals("diamonds")){
            this.rank = 36;
        } else if(name.equals("jack") && suit.equals("clubs")){
            this.rank = 37;
        } else if(name.equals("jack") && suit.equals("hearts")){
            this.rank = 38;
        } else if(name.equals("jack") && suit.equals("spades")){
            this.rank = 39;
        } else if(name.equals("queen") && suit.equals("diamonds")){
            this.rank = 40;
        } else if(name.equals("queen") && suit.equals("clubs")){
            this.rank = 41;
        } else if(name.equals("queen") && suit.equals("hearts")){
            this.rank = 42;
        } else if(name.equals("queen") && suit.equals("spades")){
            this.rank = 43;
        } else if(name.equals("king") && suit.equals("diamonds")){
            this.rank = 44;
        } else if(name.equals("king") && suit.equals("clubs")){
            this.rank = 45;
        } else if(name.equals("king") && suit.equals("hearts")){
            this.rank = 46;
        } else if(name.equals("king") && suit.equals("spades")){
            this.rank = 47;
        } else if(name.equals("ace") && suit.equals("diamonds")){
            this.rank = 48;
        } else if(name.equals("ace") && suit.equals("clubs")){
            this.rank = 49;
        } else if(name.equals("ace") && suit.equals("hearts")){
            this.rank = 50;
        } else if(name.equals("ace") && suit.equals("spades")){
            this.rank = 51;
        }



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
