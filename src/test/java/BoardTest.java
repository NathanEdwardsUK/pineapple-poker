import org.example.Board;
import org.example.Deck;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

    Board board = new Board();
    Deck deck = new Deck();

    @Test
    void testBoardGetCards() throws Exception {
        board.addCards(deck.deal(3));
        assertEquals(3, board.getCards().size());
    }

    @Test
    void testBoardThrowsException() throws Exception {
        Exception e = assertThrows(IllegalStateException.class, () -> board.addCards(deck.deal(6)));
        assertEquals("Board cannot contain more than 5 cards", e.getMessage());
    }
}