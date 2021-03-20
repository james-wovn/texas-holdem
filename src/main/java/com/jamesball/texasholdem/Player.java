package com.jamesball.texasholdem;

import java.util.ArrayList;
import java.util.List;

public final class Player {

    private List<PlayingCard> startingHand;

    public Player() {
        startingHand = new ArrayList<>();
    }

    public List<PlayingCard> startingHand() {
        return startingHand;
    }

    public void addToStartingHand(PlayingCard card) {
        startingHand.add(card);
    }
}
