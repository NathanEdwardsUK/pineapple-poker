package org.example;

import java.util.ArrayList;

public class Game {

    private Deck deck;
    private Board board;
    private ArrayList<Player> players;

    public Game() {
        addPlayer("player1", 100);
        addPlayer("robot", 100);
    }

    public void addPlayer(String name, int chips) {
        this.players.add(new Player(name, chips));
    }
}
