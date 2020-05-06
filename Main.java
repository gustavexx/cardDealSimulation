package cardSimulation;

import java.util.Scanner;


/**
 * Implementation of a card dealing simulation, where the user will be able to pick options from a menu
 * in order to perform actions, shuffling, dealing, and dealing 100000 times
 * @author Gustavo Marcano,
 */
public class Main {

    public static void main(String[] args) {

        /**
         * Scanner object to read input from the user
         * **/
        Scanner input = new Scanner(System.in);

        /**
         * rank variable that will hold the rank of the card to be read input from the user
         * **/
        int rank;

        /**
         * suit variable that will hold the rank of the card to be read input from the user
         * **/
        int suit;

        /**
         * flag variable that will change to false inside the menu loop if user selects option 4
         * **/
        boolean flag = true;

        /**
         * option variable that will change to false inside the menu loop if user selects option 4
         * **/
        int option;

        /**
         * n variable that will change to false inside the menu loop if user selects option 4
         * **/
        int n;

        System.out.println();


        System.out.print("How many suits? ");
        suit = input.nextInt(); //Initialize value suit

        System.out.print("How many ranks? ");
        rank = input.nextInt(); //Initialize value rank


        DeckOfCards cardArray = new DeckOfCards(rank,suit); //Initialize object DeckOfCard suit
        System.out.println();


        /**
         * Loop to display menu options to the user
         * **/
        while(flag) {


            /**
             * Menu message to display menu options to user
             * **/
            System.out.println("Deck of " + cardArray.getSizeOfDeck() + " cards: " +
                    "low " + cardArray.getMinOfCards() + " high = " +  cardArray.getMaxOfCards() +
                    " top = " + cardArray.getTopCard());
            System.out.print("Option 1 = \"shuffle\"; Option 2 = \"deal one hand\"; Option 3 = \"deal 100000 times\"; " +
                    "Option 4 = \"quit\": ");

            /**
             * Option selected to the user
             * **/
            option = input.nextInt();

            /**
             * Menu options
             * **/
            switch (option) {

                case 1:
                    cardArray.shuffle();
                    break;

                case 2:
                    System.out.print("How many cards? ");
                    n = input.nextInt();
                    System.out.println();
                    for(int i = 0; i < cardArray.dealCards(n).length ; i++ ) {
                        System.out.print("Card S" + cardArray.dealCards(n)[i].getSuit() + "R" +
                                cardArray.dealCards(n)[i].getRank() + " " );
                    }
                    System.out.println();
                    break;

                case 3:
                    System.out.print("How many cards? ");
                    n = input.nextInt();
                    System.out.println();
                    System.out.print(cardArray.histogram(n));
                    break;

                case 4:
                    flag = false;
                    System.out.println("Bye!!");
                    break;
            }


            System.out.println();

        }


    }
}
