package org.example;

import java.util.Arrays;

public class Card {
    public enum Suit {
        CLUBS, DIAMONDS, HEARTS, SPADES
    }

    public enum Value {
        ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING;
    }

    public final Suit suit;
    public final Value value;
    public final int intValue;
    public final String code;
    public final int id;

    public Card(Value value, Suit suit) {
        this.suit = suit;
        this.value = value;
        this.intValue = valueToInt(value);
        this.code = code();
        this.id = id();
    }
    public Card(String code) {
        if (code == null || code.length() != 2) {
            throw new IllegalArgumentException("Card code string must be exactly length 2 e.g. Ac, 2h, Ts, 5d");
        }

        this.suit = Suit.values()["cdhs".indexOf(code.charAt(1))];
        this.value = Value.values()["A23456789TJQK".indexOf(code.charAt(0))];;
        this.intValue = valueToInt(value);
        this.code = code;
        this.id = id();
    }

    @Override
    public String toString() {
        return this.value + " " + this.suit.toString();
    }

    private int valueToInt(Value value) {
        return Arrays.stream(Value.values()).toList().indexOf(value) + 1;
    }

    private String code() {
        String suitCode = ("" + this.suit.name().charAt(0)).toLowerCase();
        String valueCode;

        if (this.value == Value.ACE
                || this.value == Value.KING
                || this.value == Value.QUEEN
                || this.value == Value.JACK
                || this.value == Value.TEN) {
            valueCode = "" + this.value.name().charAt(0);
        }
        else {
            valueCode = "" + this.intValue;
        }

        return valueCode + suitCode;
    }

    private int id() {
        /*
        Give each card a unique id between 1 and 52.
        ACE CLUBS = 1, TWO CLUBS = 2, ... KING CLUBS = 13, ACE DIAMONDS = 14 ... KINGS SPADES = 52
         */
        int suitValue = Arrays.stream(Suit.values()).toList().indexOf(suit) * 13;
        return this.intValue + suitValue;
    }
}
