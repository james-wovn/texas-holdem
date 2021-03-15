package com.jamesball.texasholdem;

import java.util.Collections;
import java.util.List;

public final class Dealer {

    private static final int HAND_SIZE = 2;

    public PlayingCardDeck shuffle(PlayingCardDeck deck) {
        final PlayingCardDeck shuffledDeck = deck.clone();
        Collections.shuffle(shuffledDeck.cards());
        return shuffledDeck;
    }

    public void dealHand(PlayingCardDeck deck, List<Player> players) {
        for (int i = 0; i < HAND_SIZE; i++) {
            for (Player player : players) {
                player.addToHand(deck.next());
            }
        }
    }
}
