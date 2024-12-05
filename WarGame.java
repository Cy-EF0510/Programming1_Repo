import java.util.Scanner;

public class WarGame {
    public static void main(String[] args) {
        int player1Wins = 0;
        int player2Wins = 0;
        int count = 0;

        //Asks user to input players
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter the first player's name: ");
        String player1Name = input.nextLine();
        System.out.println("Please enter the second player's name: ");
        String player2Name = input.nextLine();
        System.out.println("");

        //Creates the users
        Player player1 = new Player(player1Name);
        Player player1CardsWon = new Player(player1Name);
        Player player2 = new Player(player2Name);
        Player player2CardsWon = new Player(player2Name);

        //Shuffles deck
        Deck gameDeck = new Deck();
        gameDeck.shuffle();
        gameDeck.shuffle();
        gameDeck.shuffle();
        gameDeck.shuffle();
        gameDeck.shuffle();
        gameDeck.shuffle();
        gameDeck.shuffle();
        gameDeck.shuffle();
        gameDeck.shuffle();
        gameDeck.shuffle();

        //Split deck between two players
        for (int i = 0, j = 1; i < 54 && j < 54; i += 2, j += 2) {
            gameDeck.dealCard(i);
            player1.getPlayerDeck().addToDeck(gameDeck.dealCard(i));
            gameDeck.dealCard(j);
            player2.getPlayerDeck().addToDeck(gameDeck.dealCard(j));
        }
        
        //While loop checks if a player no longer has a card in their deck
        while(player1.getPlayerDeck().dealCard(count) != null || player2.getPlayerDeck().dealCard(count) != null ){
                
            //Shows what each player plays
            System.out.println("Round " + (count + 1));
            System.out.print("Player 1 Please press \"Enter\" to deal a card: ");
            input.nextLine();
            System.out.println("Player 1 deals " + player1.getPlayerDeck().dealCard(count));

            System.out.print("Player 2 Please press \"Enter\" to deal a card: ");
            input.nextLine();
            System.out.println("Player 2 deals " + player2.getPlayerDeck().dealCard(count));

            //If player 1 wins, we take their winning card and player 2's losing card and add it to a new deck
            if (player1.getPlayerDeck().dealCard(count).value > player2.getPlayerDeck().dealCard(count).value) {
                player1Wins++;
                System.out.println("Player 1 won. He currently has " + player1Wins + " wins");

                //Adds player1's won cards to a new deck
                Card card1 = player1.getPlayerDeck().dealCard(count);
                Card card2 = player2.getPlayerDeck().dealCard(count);
                player1CardsWon.getPlayerDeck().addToDeck(card1);
                player1CardsWon.getPlayerDeck().addToDeck(card2);
            }

            //If player 2 wins, we take their winning card and player 1's losing card and add it to a new deck
            else if (player2.getPlayerDeck().dealCard(count).value > player1.getPlayerDeck().dealCard(count).value) {
                player2Wins++;
                System.out.println("Player 2 won. He currently has " + player2Wins + " wins");

                //Adds player2's won cards to a new deck
                Card card1 = player1.getPlayerDeck().dealCard(count);
                Card card2 = player2.getPlayerDeck().dealCard(count);
                player2CardsWon.getPlayerDeck().addToDeck(card1);
                player2CardsWon.getPlayerDeck().addToDeck(card2);
            }
            System.out.println("");
            count++;
        }
        
        //Checks who wins the round
        if(player1Wins > player2Wins){
            System.out.println(player1.getName() + " has won\n");
        }
        else if(player2Wins > player1Wins){
            System.out.println(player2.getName() + " has won\n");
        }
        else{
            System.out.println("No one won");
        }

        //Prints out all the cards the player has won
        System.out.println("This is " + player1.getName() + "'s deck: ");
        player1CardsWon.getPlayerDeck().printDeck();
        System.out.println("");
        System.out.println("This is " + player2.getName() + "'s deck: ");
        player2CardsWon.getPlayerDeck().printDeck();
        System.out.println("");
    }
}
