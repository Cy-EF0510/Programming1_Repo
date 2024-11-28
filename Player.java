/*
 * Sriiman Visuvanathar / 6326687
 */

public class Player {
    private String name;
private Deck playerDeck;
public Player(String Name){
    this.name = Name;
    playerDeck = new Deck(54);
}

public String getName() {
    return name;
}

public Deck getPlayerDeck() {
    return playerDeck;
}


}
