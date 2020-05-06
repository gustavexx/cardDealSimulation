package cardSimulation;


/**
 * Implementation of the class Card  that will represent the card object
 * @author Gustavo Marcano, Student I.D: 000812644
**/
public class Card {

    /**
     * rank instance variable to represent the rank of a card
     * **/
    private int rank;

    /**
     * suit instance variable to represent the suit of a card
     * **/
    private int suit;


    /**
     * Overloaded constructor to initialize instance variable
     * @param rank, will represent the rank
     * @param suit will represent the suit
     * **/
    public Card(int rank, int suit) {

        if(rank > 0 && suit > 0) {
            this.rank = rank;
            this.suit = suit;
        }
    }


    /**
     * getter method
     * @return the rank, of the card
     * **/
    public int getRank() {
        return rank;
    }

    /**
     * getter method
     * @return the suit, of the card
     * **/
    public int getSuit() {
        return suit;
    }

    /**
     * getter method
     * @return the value determined by multiplying rank * rank, of the card
     * **/
    public int getValue() {
        return rank * suit;
    }

    /**
     * Overloaded method
     * @return the values the attributes in a String format to make it readable
     * **/
    @Override
    public String toString() {
        return "Cards{" +
                "rank=" + rank +
                ", suit=" + suit +
                '}';
    }
}
