package com.jamesball.texasholdem;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class PlayingCardDeck {
    private final List<PlayingCard> cards;
    private int nextCard;

    public PlayingCardDeck() {
        cards = new ArrayList<>();
        for (PlayingCardSuit suit : PlayingCardSuit.values()) {
            for (PlayingCardRank rank : PlayingCardRank.values()) {
                cards.add(new PlayingCard(suit, rank));
            }
        }
        nextCard = 0;
    }

    public PlayingCardDeck(List<PlayingCard> cards) {
        this.cards = cards;
        nextCard = 0;
    }

    public List<PlayingCard> cards() {
        return cards;
    }

    public PlayingCard next() {
        return cards.get(nextCard++);
    }

    @Override
    public PlayingCardDeck clone() {
        List<PlayingCard> copiedCards = new ArrayList<>();
        for (PlayingCard card : cards) {
            copiedCards.add(card.clone());
        }
        return new PlayingCardDeck(copiedCards);
    }

    @Override
    public boolean equals(Object otherObject) {
        if (this == otherObject) {
            return true;
        }

        if (otherObject == null) {
            return false;
        }

        if (getClass() != otherObject.getClass()) {
            return false;
        }

        final PlayingCardDeck otherDeck = (PlayingCardDeck) otherObject;

        return cards.equals(otherDeck.cards);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cards);
    }
}
