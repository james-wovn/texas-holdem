package com.jamesball.texasholdem;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private List<PlayingCard> hand;

    public Player() {
        hand = new ArrayList<>();
    }

    public List<PlayingCard> hand() {
        return hand;
    }

    public void addToHand(PlayingCard card) {
        hand.add(card);
    }
}
