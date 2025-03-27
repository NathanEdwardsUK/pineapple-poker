package org.example;

import java.util.ArrayList;
import java.util.List;

public class Board {

    private ArrayList<Card> cards = new ArrayList<>();

    public void addCards(Card[] newCards) {
        this.cards.addAll(List.of(newCards));

        if (this.cards.size() > 5) {
            this.print();
            throw new IllegalStateException("Board cannot contain more than 5 cards");
        }
    }

    public ArrayList<Card> getCards () {
        return this.cards;
    }

    public void print() {
        System.out.println("Board:");

        for (int i = 0; i < this.cards.size(); i++) {
            System.out.println(i + ": " + this.cards.get(i).toString());
        }
    }
}
