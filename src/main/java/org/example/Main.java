package org.example;

public class Main {
    public static void main(String[] args) {

        Card card = new Card(Card.Value.JACK, Card.Suit.HEARTS);
        System.out.println(card.toString());
        System.out.println(card.intValue);
        System.out.println(card.code);

        Deck deck = new Deck();
        deck.print();

        for (Card crd : deck.deal(53)) {
            System.out.println(crd.toString());
        }

        deck.print();
    }
}