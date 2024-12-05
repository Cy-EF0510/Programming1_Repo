import java.util.Scanner;

public class WarGame {
    public static void main(String[] args) {
        int player1Wins = 0;
        int player2Wins = 0;

        Scanner input = new Scanner(System.in);
        System.out.println("Please enter the first player's name: ");
        String player1Name = input.nextLine();
        System.out.println("Please enter the second player's name: ");
        String player2Name = input.nextLine();

        Player player1 = new Player(player1Name);
        Player player1CardsWon = new Player(player1Name);
        Player player2 = new Player(player2Name);
        Player player2CardsWon = new Player(player2Name);
        Card card = player1.getPlayerDeck().dealCard();
                    Card card2 = player2.getPlayerDeck().dealCard();

        Deck gameDeck = new Deck();
        gameDeck.shuffle();
        gameDeck.shuffle();
        gameDeck.shuffle();

        for (int i = 0, j = 1; i < 54 && j < 54; i += 2, j += 2) {
            gameDeck.dealCard(i);
            player1.getPlayerDeck().addToDeck(gameDeck.dealCard(i));
            gameDeck.dealCard(j);
            player2.getPlayerDeck().addToDeck(gameDeck.dealCard(j));
        }

        for (int i = 0, j = 1; i < 54 && j < 54; i++, j++) {
            // Player Card
            if(player1.getPlayerDeck().dealCard() != null && player2.getPlayerDeck().dealCard() != null ){
                System.out.print("Player 1: Please press \"Enter\" to deal a card: ");
                input.nextLine();
                System.out.println("Player 1 deals: " + player1.getPlayerDeck().dealCard());
                System.out.println("");
 
                System.out.print("Player 2: Please press \"Enter\" to deal a card: ");
                input.nextLine();
                System.out.println("Player 2 deals: " + player2.getPlayerDeck().dealCard());
                System.out.println("");

                //If player 1 wins, we take their winning card and player 2's losing card and add it to a new deck
                if (player1.getPlayerDeck().dealCard(i).value > player2.getPlayerDeck().dealCard(j).value) {
                    player1Wins++;
                    System.out.println("Player 1 won. He currently has " + player1Wins + " wins\n");

                    
                    player1CardsWon.getPlayerDeck().addToDeck(card);
                    player1CardsWon.getPlayerDeck().addToDeck(card2);
                }

                //If player 2 wins, we take their winning card and player 1's losing card and add it to a new deck
                else if (player2.getPlayerDeck().dealCard(j).value > player1.getPlayerDeck().dealCard(i).value) {
                    player2Wins++;
                    System.out.println("Player 2 won. He currently has " + player2Wins + " wins\n");

              
                    player2CardsWon.getPlayerDeck().addToDeck(card);
                    player2CardsWon.getPlayerDeck().addToDeck(card2);
                }

                else{
                    System.out.println("Error");
                }
            }
            else{
                break;
            }
        }
        
        if(player1Wins > player2Wins){
            System.out.println(player1.getName() + " has won\n");
        }
        else if(player2Wins > player1Wins){
            System.out.println(player2.getName() + " has won\n");
        }
        else{
            System.out.println("No one won");
        }

        System.out.println("This is " + player1.getName() + "'s deck: ");
        player1.getPlayerDeck().printDeck();
        System.out.println("");
        System.out.println("This is " + player2.getName() + "'s deck: ");
        player2.getPlayerDeck().printDeck();
        System.out.println("");
    }
}
