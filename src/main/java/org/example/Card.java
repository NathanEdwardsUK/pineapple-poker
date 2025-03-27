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

    public Card(Value value, Suit suit) {
        this.suit = suit;
        this.value = value;
        this.intValue = valueToInt(value);
        this.code = code();
    }

    @Override
    public String toString() {
        return this.value + " " + this.suit.toString();
    }

    private int valueToInt(Value value) {
        return Arrays.stream(Value.values()).toList().indexOf(value) + 1;
    }

    public String code() {
        String suitCode = ("" + this.suit.name().charAt(0)).toLowerCase();
        String valueCode;

        if (this.value == Value.ACE || this.value == Value.KING
                || this.value == Value.QUEEN || this.value == Value.JACK) {
            valueCode = "" + this.value.name().charAt(0);
        }
        else {
            valueCode = "" + this.intValue;
        }

        return valueCode + suitCode;
    }
}
