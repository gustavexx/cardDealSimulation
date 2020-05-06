package cardSimulation;

import java.util.Arrays;


/**
 * Implementation of the class DeckOfCards  that will represent the Array of cards object (a deck of cards)
 * @author Gustavo Marcano, Student I.D: 000812644
 **/
public class DeckOfCards {

    /**
     * cardArray instance variable represented by an array of Card object
     * **/
    private Card[] cardArray;

    /**
     * rank instance variable to represent the rank of a card
     * **/
    private int rank;

    /**
     * suit instance variable to represent the suit of a card
     * **/
    private int suit;

    /** Overloaded constructor to initialize int
    * @param maxRank the highest rank passed as parameter
    * @param suit refers to a suit represented by a number 1,2,3,4 (hearts, spades, clubs, diamonds)
     * **/
    public DeckOfCards(int maxRank, int suit) {

        rank = maxRank;
        this.suit = suit;
        cardArray = new Card[rank * this.suit ];
        int index = 0;

        /* Fill the array of objects Cards*/
        for(int i = 0; i < maxRank; i++) {
            for (int j = 0; j < suit; j++) {
                cardArray[index] = new Card(i + 1, j + 1);
                index = index + 1;

            }
        }
    }

    /**
     * void method
     * shuffles the cardArray by swapping sequentially each element with a random position of the same element
     * **/
    public void shuffle() {


        for(int i = 0; i < cardArray.length;  i++) {

            int randomIndex = (int)(Math.random() * (cardArray.length) );  // random number within the range of array size

            /* Validating, keeps creating random number until is different from the index inside the current loop*/
            while (randomIndex == i)
                randomIndex = (int)(Math.random() * (cardArray.length));

            Card temp =  cardArray[i];
            cardArray[i] = cardArray[randomIndex];
            cardArray[randomIndex] = temp;

        }

    }

    /**
     * getter method
     * @return the size of the deck (length of array)
     * **/
    public int getSizeOfDeck(){
        return cardArray.length;
    }


    /**
     * getter method
     * Finds the min card in the cardArray
     * **/
    public int getMinOfCards(){

        int min = cardArray[0].getValue();

        for(int i = 0; i< cardArray.length; i++) {

            if(cardArray[i].getValue() <  min)
                min = cardArray[i].getValue();
        }
        return min;

    }

    /**
     * getter method
     * finds the max card in the cardArray
     * **/
    public int getMaxOfCards(){

        int max = cardArray[0].getValue();

        for(int i = 0; i < cardArray.length; i++) {

            if(cardArray[i].getValue() >  max)
                max = cardArray[i].getValue();
        }

        return max;
    }

    /**
     * getter method
     * get the top card (first element of the array) of the cardArray
     * in String format for readability
     * **/
    public String getTopCard() {
        return "S" + cardArray[0].getSuit() + "R" + cardArray[0].getRank();
    }


    /**
     * dealCards method
     * takes the cardArray instance variable and with the value n, takes the n first elements of the cardArray
     * and returns it.
     * @param n, represents the size of the array of cards to be dealt
     * **/
    public Card[] dealCards (int n) {

        Card[] dealtCards = new Card[n];

        for(int i = 0; i < n; i++ ) {

            dealtCards[i] = new Card(cardArray[i].getRank(), cardArray[i].getSuit());
        }

        return dealtCards;
    }

    /**
     * Overloaded method
     * @return the values the attributes in a String format to make it readable
     * **/
    public String toString(){

        return "Size of deck = " + getSizeOfDeck() + "\n" +
                "Min = " + getMinOfCards() +"\n" +
                "Max = " + getMaxOfCards();
    }

    /**
     * maxSumOfCards method
     * @return the maximum sum possible from the deck of cards (cardArray)
     * @param arrayOfCards an array of cards to calculate the max sum of the array is being received
     * @param n, size of the n highest elements by value of the cardArray
     * **/
    private int maxSumOfCards(Card[] arrayOfCards, int n) {

        int sum = 0;
        int [] temp = new int[arrayOfCards.length]; // creates a temp array of the same size of cardArray

        /**
         * loops the array received from the parameter and "extracts" the value of each card for sorting purposes
         * **/
        for(int i = 0; i <  arrayOfCards.length; i++){
            temp[i] = arrayOfCards[i].getValue();
        }

        /**
         * Sorts the array by value
         * **/
        Arrays.sort(temp);

        /**
         * loops the array and adds the n highest elements to get the maximum value possible from the array
         * **/
        for(int i = temp.length - 1; i > (temp.length - 1) - n; i--) {
            sum = sum + temp[i];
        }

        return sum;
    }



    /**
     * maxSumOfCards method
     * @return String with a histogram of all the sums from random dealt cards
     * @param n, size of the cards to be dealt
     * **/
        public String histogram(int n) {

        int [] countersArray = new int[maxSumOfCards(cardArray,n) + 1]; //plus 1 since element zero  will always be zero

        String output="";

        for(int i = 1; i <= 100_000; i++) {
            shuffle(); // shuffles the deck each loop

            /**
             * increase the counter by one in the position sum i.e countersArray[4] = countersArray[4] + 1
             * the same as => countersArray[4]++
             * **/
            countersArray[(maxSumOfCards(dealCards(n),n)) ] = countersArray[(maxSumOfCards(dealCards(n),n))] + 1;
        }

        /**
         * Concatenates the results to return it in a readable format (String)
         * **/
        for(int i = 1; i < countersArray.length; i++) {
            if(countersArray[i] > 0 ){
                output += (i) +"\t" + countersArray[i] + "\n";
            }
        }
        return output;
    }

}
