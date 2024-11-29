import java.util.Scanner;

public class WarGame {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in); 
        System.out.println("Please enter the first player's name: ");
        String player1Name = input.nextLine();
        System.out.println("Please enter the second player's name: ");  
        String player2Name = input.nextLine();
        
        Player player1 = new Player(player1Name);
        Player player2 = new Player(player2Name);


         Deck gameDeck = new Deck();
         gameDeck.shuffle();
         gameDeck.shuffle();
         gameDeck.shuffle();
         gameDeck.shuffle();
         gameDeck.shuffle();

         for(int i = 0, j = 1; i < 54 && j < 54; i+=2, j+=2){
            gameDeck.dealCard(i);
            player1.getPlayerDeck().addToDeck(gameDeck.dealCard(i));
            gameDeck.dealCard(j);
            player2.getPlayerDeck().addToDeck(gameDeck.dealCard(j));
        }

        System.out.println("This is " + player1.getName() + "'s deck: ");
        player1.getPlayerDeck().printDeck();
        System.out.println("");
        System.out.println("This is " + player2.getName() + "'s deck: ");
        player2.getPlayerDeck().printDeck();
        System.out.println("");

        for(int i = player1.getPlayerDeck(), int j =0; )
    }
}