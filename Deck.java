/* Colby Fostokjian
   6302213 */

public class Deck {

    private int numCards; //Card counter
    private Card[] deck;

    // Default constructor
    public Deck() {
        deck = new Card[54];
        numCards = 54;

        int indexCount = 0;

        // Add standard cards
        for (int i = 1; i <= 4; i++) { // Suits
            for (int j = 1; j <= 13; j++) { // Values
                deck[indexCount++] = new Card(j,i);
            }
        }

        // Add Jokers
        deck[52] = new Joker(14, 1); // Joker 1
        deck[53] = new Joker(14, 2); // Joker 2
    }

    // Parameterized constructor
    public Deck(int size) {
        deck = new Card[size];
        numCards = 0;
    }

    // Shuffle the deck
    public void shuffle() {
        for (int i = numCards - 1; i > 0; i--) {
            int rand = (int) (Math.random() * (i + 1));
            Card temp = deck[i];
            deck[i] = deck[rand];
            deck[rand] = temp;
        }
    }

    // Add a card to the deck
    public void addToDeck(Card card) {
        if (numCards < deck.length) {
            deck[numCards++] = card;
        } else {
            System.out.println("Deck is full");
        }
    }

    // Deal a card from the top of the deck
    public Card dealCard() {
        if (numCards > 0) {
            return deck[--numCards]; // Return the top card and decrease numCards
        } else {
            System.out.println("Deck is empty");
            return null;
        }
    }
    
    public Card dealCard(int index){
        if(index >= 0 && index < deck.length){
            return deck[index];
        } 
        return null;
    }

    // Print all cards in the deck
    public void printDeck() {
        if(numCards == 0){
            System.out.println("Empty Deck");
        }else{
            for (int i = 0; i < numCards; i++) {
                System.out.println(deck[i]);
            }
        }
    }
}