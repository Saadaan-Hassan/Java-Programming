/**
 * Deck
 */
public class Deck {

    private final String RANKS[] = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};
    private final String SUITS[] = {"Hearts", "Clubs", "Diamond", "Spades"};

    private final int CARD_LENGTH = 52;

    private Card deck[];

    Deck(){
       deck = new Card[CARD_LENGTH];

        for (int i = 0; i < deck.length; i++) {
            deck[i] = new Card(RANKS[i % RANKS.length], SUITS[i % SUITS.length]);
        }

        for (int i = 0; i < deck.length; i++) {
            System.out.println(deck[i].getRanks() + " of " + deck[i].getSuits());
        }
    }
}