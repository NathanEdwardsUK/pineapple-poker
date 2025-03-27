package org.example;

public class Player {

    private int chips;
    private String name;

    public Player(String name, int chips) {
        this.name = name;
        this.chips = chips;
    }

    public String getName() {return this.name;}

    public int getChips() {return this.chips;}

    public void adjustChips(int change) {
        this.chips = Math.max(0, this.chips + change);
    }
}
