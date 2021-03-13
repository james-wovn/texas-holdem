package com.jamesball.texasholdem;

import java.util.Objects;

public final class PlayingCard {
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlayingCard that = (PlayingCard) o;
        return suit == that.suit && rank == that.rank;
    }

    @Override
    public int hashCode() {
        return Objects.hash(suit, rank);
    }
}
