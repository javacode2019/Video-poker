import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;

public class Deck {

    private Card[] cards;
    private int top; // the index of the top of the deck

    public Deck() {

        int deckPosition = 0;
        cards = new Card[52];

        for (int i = 0; i < 4; i++) { // for the 4 suits
            for (int j = 0; j < 13; j++) { // for the 13 ranks
                cards[deckPosition] = new Card(i, j); // create new card
                deckPosition++;
            }
        }
        shuffle();
        top = 0;
    }

    public void shuffle() {
        for (int i = 0; i < 52; i++) {
            Collections.shuffle(Arrays.asList(cards));
        }
    }

    public Card deal() {
        if (top == 51) {
            shuffle();
            top = 0;
        }
        return cards[top++];
    }
}
