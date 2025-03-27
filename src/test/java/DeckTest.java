import org.example.Card;
import org.example.Deck;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

class DeckTest {

    Deck deck = new Deck();
    ArrayList<Card> cards = deck.getCards();
    HashSet<Integer> set = new HashSet<>();

    @Test
    void testDeckHas52UniqueCards() {
        assertEquals(52, cards.size());

        HashSet<Integer> set = new HashSet<>();
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (Card card : cards) {
            int id = card.id;
            set.add(id);
            min = Math.min(min, id);
            max = Math.max(max, id);
        }

        // Assert that there are 52 cards after removing duplicates
        assertEquals(52, set.size());

        // Assert that the card ids are between 1 and 52
        assertEquals(1, min);
        assertEquals(52, max);
    }
}