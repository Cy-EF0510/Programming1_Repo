/* Colby Fostokjian
   6302213 */

import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Please enter Player 1's name:"); 
        Player playerOne = new Player(input.nextLine()); //Creates playerOne

        System.out.println("Please enter Player 2's name:");
        Player playerTwo = new Player(input.nextLine()); //Creates playerTwo

       
        Deck mainDeck = new Deck(); //Default constructor
        

        for (int i = 0; i < 27; i++) { //Loop to distribute cards
            Card cardForPlayerOne = mainDeck.dealCard(); //cardForPlayerOne takes the value of a random card
            Card cardForPlayerTwo = mainDeck.dealCard(); //cardForPlayerTwo takes the value of a random card

            if (cardForPlayerOne != null) {
                playerOne.getPlayerDeck().addToDeck(cardForPlayerOne); //playerOne is given the card by cardForPlayerOne
            }

            if (cardForPlayerTwo != null) {
                playerTwo.getPlayerDeck().addToDeck(cardForPlayerTwo); //playerTwo is given the card by cardForPlayerTwo
            }
        }

        System.out.println(playerOne.getName() + "'s deck:\n"); //Print player ones deck
        playerOne.getPlayerDeck().printDeck();

        System.out.println(" "); //Add a line of space for aesthetic purposes

        System.out.println(playerTwo.getName() + "'s deck:\n"); //Print player twos deck
        playerTwo.getPlayerDeck().printDeck();





        for(int i = 0; i<27; i++){ //Loop to transfer deck 1 to deck 2
            Card card = playerOne.getPlayerDeck().dealCard();
            playerTwo.getPlayerDeck().addToDeck(card);
        }

        System.out.println(playerOne.getName() + "'s deck: \n"); //Prints playerOnes deck
        playerOne.getPlayerDeck().printDeck();

        System.out.println(playerTwo.getName() + "'s deck: \n"); //Prints playerTwos deck
        playerTwo.getPlayerDeck().printDeck();




        for(int i = 0; i<54; i++){ //Loop to transfer deck 2 to deck 1
            Card card = playerTwo.getPlayerDeck().dealCard();
            playerOne.getPlayerDeck().addToDeck(card);
        }

        System.out.println(playerOne.getName() + "'s deck:\n "); //Prints playerOnes deck
        playerOne.getPlayerDeck().printDeck();

        System.out.println(playerTwo.getName() + "'s deck: \n"); //Prints playerTwos deck
        playerTwo.getPlayerDeck().printDeck();
    }
}