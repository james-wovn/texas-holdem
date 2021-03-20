package com.jamesball.texasholdem;

import java.util.Objects;

public final class PlayingCard implements Comparable<PlayingCard> {
    private final PlayingCardSuit suit;
    private final PlayingCardRank rank;

    public PlayingCard(PlayingCardSuit suit, PlayingCardRank rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public PlayingCardSuit suit() {
        return suit;
    }

    public PlayingCardRank rank() {
        return rank;
    }

    @Override
    public PlayingCard clone() {
        return new PlayingCard(suit, rank);
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

        final PlayingCard otherCard = (PlayingCard) otherObject;

        return suit == otherCard.suit && rank == otherCard.rank;
    }

    @Override
    public int hashCode() {
        return Objects.hash(suit, rank);
    }

    @Override
    public int compareTo(PlayingCard otherCard) {
        return Integer.compare(rank.value(), otherCard.rank.value());
    }
}
