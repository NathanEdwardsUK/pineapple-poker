import org.example.Card;
import org.example.HandEvaluator;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class HandEvaluatorTest {

    HandEvaluator HEv = new HandEvaluator();
    ArrayList<Card> cards;

    @Test
    void testStringToCards() {
        cards = HEv.stringToCards("As,5c,3d,Th,9c");
        assertEquals("As", cards.get(0).code);
        assertEquals("5c", cards.get(1).code);
        assertEquals("3d", cards.get(2).code);
        assertEquals("Th", cards.get(3).code);
        assertEquals("9c", cards.get(4).code);
    }

    // 10
    @Test
    void testRoyalFlush() {
        cards = HEv.stringToCards("As,Ks,Qs,Js,Ts");
        assertArrayEquals(new int[] {10}, HEv.fiveCardStrength(cards));

        cards = HEv.stringToCards("Qd,Td,Ad,Jd,Kd");
        assertArrayEquals(new int[] {10}, HEv.fiveCardStrength(cards));

        cards = HEv.stringToCards("Th,Kh,Jh,Ah,Qh");
        assertArrayEquals(new int[] {10}, HEv.fiveCardStrength(cards));
    }

    // 9
    @Test
    void testStraightFlush() {
        cards = HEv.stringToCards("As,2s,3s,4s,5s");
        assertArrayEquals(new int[] {9, 5}, HEv.fiveCardStrength(cards));

        cards = HEv.stringToCards("9c,8c,7c,6c,5c");
        assertArrayEquals(new int[] {9, 9}, HEv.fiveCardStrength(cards));

        cards = HEv.stringToCards("Qd,Td,9d,Jd,Kd");
        assertArrayEquals(new int[] {9, 13}, HEv.fiveCardStrength(cards));

        cards = HEv.stringToCards("3h,6h,4h,7h,5h");
        assertArrayEquals(new int[] {9, 7}, HEv.fiveCardStrength(cards));
    }

    // 8
    @Test
    void testQuads() {
        cards = HEv.stringToCards("As,Ah,Ac,Ad,Ts");
        assertArrayEquals(new int[] {8, 14, 10}, HEv.fiveCardStrength(cards));

        cards = HEv.stringToCards("3s,3c,3d,3h,Qs");
        assertArrayEquals(new int[] {8, 3, 12}, HEv.fiveCardStrength(cards));
    }

    // 7
    @Test
    void testFullHouse() {
        cards = HEv.stringToCards("As,Ac,4s,4d,4h");
        assertArrayEquals(new int[] {7, 4, 14}, HEv.fiveCardStrength(cards));

        cards = HEv.stringToCards("Ts,As,Tc,Th,Ad");
        assertArrayEquals(new int[] {7, 10, 14}, HEv.fiveCardStrength(cards));

        cards = HEv.stringToCards("3d,8d,3c,3s,8s");
        assertArrayEquals(new int[] {7, 3, 8}, HEv.fiveCardStrength(cards));
    }

    // 6
    @Test
    void testFlush() {
        cards = HEv.stringToCards("As,2s,Qs,Js,Ts");
        assertArrayEquals(new int[] {6, 14, 12, 11, 10, 2}, HEv.fiveCardStrength(cards));

        cards = HEv.stringToCards("Th,2h,8h,9h,Qh");
        assertArrayEquals(new int[] {6, 12, 10, 9, 8, 2}, HEv.fiveCardStrength(cards));

        cards = HEv.stringToCards("5c,9c,Kc,Ac,6c");
        assertArrayEquals(new int[] {6, 14, 13, 9, 6, 5}, HEv.fiveCardStrength(cards));
    }

    // 5
    @Test
    void testStraight() {
        cards = HEv.stringToCards("As,Kc,Qh,Js,Ts");
        assertArrayEquals(new int[] {5, 10}, HEv.fiveCardStrength(cards));

        cards = HEv.stringToCards("3s,7s,4s,6s,5h");
        assertArrayEquals(new int[] {5, 3}, HEv.fiveCardStrength(cards));

        cards = HEv.stringToCards("Qd,Td,9s,Jd,Kh");
        assertArrayEquals(new int[] {5, 9}, HEv.fiveCardStrength(cards));
    }

    // 4
    @Test
    void testTrips() {
        cards = HEv.stringToCards("As,Ac,Ad,Js,Ts");
        assertArrayEquals(new int[] {4, 14, 11, 10}, HEv.fiveCardStrength(cards));

        cards = HEv.stringToCards("8s,2d,8d,Ks,8c");
        assertArrayEquals(new int[] {4, 8, 13, 2}, HEv.fiveCardStrength(cards));
    }

    // 3
    @Test
    void testTwoPair() {
        cards = HEv.stringToCards("As,Js,2c,Ah,Jd");
        assertArrayEquals(new int[] {3, 14, 11, 2}, HEv.fiveCardStrength(cards));

        cards = HEv.stringToCards("2d,Qc,2s,3s,Qs");
        assertArrayEquals(new int[] {3, 12, 2, 3}, HEv.fiveCardStrength(cards));
    }

    // 2
    @Test
    void testPair() {
        cards = HEv.stringToCards("As,Kc,Qs,Ah,Ts");
        assertArrayEquals(new int[] {2, 14, 13, 12, 10}, HEv.fiveCardStrength(cards));

        cards = HEv.stringToCards("Ts,8s,Jh,8c,Qh");
        assertArrayEquals(new int[] {2, 8, 12, 11, 10}, HEv.fiveCardStrength(cards));

        cards = HEv.stringToCards("2d,Td,2c,Js,Kh");
        assertArrayEquals(new int[] {2, 2, 13, 11, 10}, HEv.fiveCardStrength(cards));
    }

    // 1
    @Test
    void testHighCard() {
        cards = HEv.stringToCards("As,Kh,9s,Js,Ts");
        assertArrayEquals(new int[] {1, 14, 13, 11, 10, 9}, HEv.fiveCardStrength(cards));

        cards = HEv.stringToCards("2c,5h,9d,Ks,Qs");
        assertArrayEquals(new int[] {1, 13, 12, 9, 5, 2}, HEv.fiveCardStrength(cards));
    }
}