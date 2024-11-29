

public class Joker extends Card{
    public Joker(int value, int suit){
        super(value, suit);
    }    

    public String getSuitAsString(){
        return "Joker";
    }

    public String getValueAsString(){
        return "" + value;
    }
}
