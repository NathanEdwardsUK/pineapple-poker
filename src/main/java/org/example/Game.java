package org.example;

import java.util.ArrayList;

public class Game {

    private Deck deck;
    private Board board;
    private ArrayList<Player> players;

    public Game(int numPlayers) {

        for (int i = 0; i < numPlayers; i++) {
            players.add(new Player());
        }
    }
}
