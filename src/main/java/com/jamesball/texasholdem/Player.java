package com.jamesball.texasholdem;

import java.util.ArrayList;
import java.util.List;

public final class Player {

    private List<PlayingCard> holeCards;

    public Player() {
        holeCards = new ArrayList<>();
    }

    public List<PlayingCard> holeCards() {
        return holeCards;
    }

    public void addToHoleCards(PlayingCard card) {
        holeCards.add(card);
    }
}
