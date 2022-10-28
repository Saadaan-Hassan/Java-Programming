/**
 * Card
 */
public class Card {

    private String ranks;
    private String suits;

    Card(String ranks, String suits){
        this.ranks = ranks;
        this.suits = suits;
    }

    public String getRanks() {
        return ranks;
    }

    public String getSuits() {
        return suits;
    }

    
    public String toString() {
        return ranks + " of " + suits;
    }
}