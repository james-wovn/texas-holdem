package com.jamesball.texasholdem;

import java.util.Collections;
import java.util.List;

public final class Dealer {

    private static final int STARTING_HAND_SIZE = 2;

    public PlayingCardDeck shuffle(PlayingCardDeck deck) {
        final PlayingCardDeck shuffledDeck = deck.clone();
        Collections.shuffle(shuffledDeck.cards());
        return shuffledDeck;
    }

    public PlayingCard deal(PlayingCardDeck deck) {
        return deck.next();
    }

    public void dealStartingHands(PlayingCardDeck deck, List<Player> players) {
        for (int i = 0; i < STARTING_HAND_SIZE; i++) {
            for (Player player : players) {
                player.addToStartingHand(deck.next());
            }
        }
    }
}
