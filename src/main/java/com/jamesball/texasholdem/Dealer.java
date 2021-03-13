package com.jamesball.texasholdem;

import java.util.Collections;

public final class Dealer {

    public PlayingCardDeck shuffle(PlayingCardDeck deck) {
        final PlayingCardDeck shuffledDeck = deck.clone();
        Collections.shuffle(shuffledDeck.cards());
        return shuffledDeck;
    }
}
