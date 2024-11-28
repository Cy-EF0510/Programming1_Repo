import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        Deck deck = new Deck();
        Scanner scanner = new Scanner(System.in);
        int tries = 5;

        //deck.shuffle();

        System.out.println("Guess a card (for ex: 'ace of diamonds'): ");
        String guessedCard = scanner.nextLine().trim().toLowerCase();

        while (tries > 0) {
            System.out.println("Pick a card from the deck (0 to 53): ");
            int cardIndex = scanner.nextInt();
            Card pickedCard = deck.dealCard(cardIndex);

            System.out.println("You picked: " + pickedCard);
            
            if (pickedCard.getSuit() == 5 || guessedCard.equals(pickedCard.toString().toLowerCase())) {
                System.out.println("You win!");
                return;
            } else {
                System.out.println("Try again!");
               // deck.shuffle(); // Shuffle the deck after each guess
                tries--;
            }
        }

        System.out.println("You lose! Better luck next time.");
        scanner.close();
    }
}