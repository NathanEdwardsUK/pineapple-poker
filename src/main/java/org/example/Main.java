package org.example;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {

//        Card card = new Card(Card.Value.JACK, Card.Suit.HEARTS);
//        System.out.println(card.toString());
//        System.out.println(card.intValue);
//        System.out.println(card.code);
//
        Deck deck = new Deck();
        deck.print();
//
        for (Card crd : deck.deal(52)) {
            System.out.println(crd.intValue);
        }
//
//        deck.print();

//        Board board = new Board();
//        board.addCards(deck.deal(3));
//        board.print();
//        deck.print();
//        board.addCards(deck.deal(2));
//        board.print();
//        board.addCards(deck.deal(3));
//        board.print();

    }
}