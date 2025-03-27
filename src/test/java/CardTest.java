import org.example.Card;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CardTest {

    Card card1 = new Card(Card.Value.ACE, Card.Suit.HEARTS);
    Card card2 = new Card(Card.Value.THREE, Card.Suit.SPADES);
    Card card3 = new Card(Card.Value.TEN, Card.Suit.DIAMONDS);
    Card card4 = new Card(Card.Value.JACK, Card.Suit.CLUBS);
    Card card5 = new Card(Card.Value.KING, Card.Suit.HEARTS);

    @Test
    void testCardCodes() {
        assertEquals("Ah", card1.code);
        assertEquals("3s", card2.code);
        assertEquals("10d", card3.code);
        assertEquals("Jc", card4.code);
        assertEquals("Kh", card5.code);
    }

    @Test
    void testCardStrings() {
        assertEquals("ACE HEARTS", card1.toString());
        assertEquals("THREE SPADES", card2.toString());
        assertEquals("TEN DIAMONDS", card3.toString());
        assertEquals("JACK CLUBS", card4.toString());
        assertEquals("KING HEARTS", card5.toString());
    }

    @Test
    void testCardIDs() {
        assertEquals(1, new Card(Card.Value.ACE, Card.Suit.CLUBS).id);
        assertEquals(3, new Card(Card.Value.THREE, Card.Suit.CLUBS).id);
        assertEquals(13, new Card(Card.Value.KING, Card.Suit.CLUBS).id);
        assertEquals(14, new Card(Card.Value.ACE, Card.Suit.DIAMONDS).id);
        assertEquals(23, new Card(Card.Value.TEN, Card.Suit.DIAMONDS).id);
        assertEquals(26, new Card(Card.Value.KING, Card.Suit.DIAMONDS).id);
        assertEquals(27, new Card(Card.Value.ACE, Card.Suit.HEARTS).id);
        assertEquals(32, new Card(Card.Value.SIX, Card.Suit.HEARTS).id);
        assertEquals(38, new Card(Card.Value.QUEEN, Card.Suit.HEARTS).id);
        assertEquals(40, new Card(Card.Value.ACE, Card.Suit.SPADES).id);
        assertEquals(48, new Card(Card.Value.NINE, Card.Suit.SPADES).id);
        assertEquals(52, new Card(Card.Value.KING, Card.Suit.SPADES).id);
    }

}