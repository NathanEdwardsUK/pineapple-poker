package org.example;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {

    private ArrayList<Card> cards = new ArrayList<>();

    public Deck() {
        for (Card.Suit suit : Card.Suit.values()) {
            for (Card.Value value : Card.Value.values()) {
                cards.add(new Card(value, suit));
            }
        }

        this.cards = cards;
        this.shuffle();
    }

    public void shuffle() {
        Collections.shuffle(this.cards);
    }

    public Card[] deal(int numCards) {
        Card[] dealtCards = new Card[numCards];

        for (int i = 0; i < numCards; i++) {
            dealtCards[i] = this.cards.removeLast();
        }

        /* This will never happen in conventional poker games
        but I could add logic to handle dealing all cards in deck */

        return dealtCards;
    }

    public void print() {
        for (int i = 0; i < this.cards.size(); i++) {
            System.out.println(i + ": " + this.cards.get(i).toString());
        }
    }
}
