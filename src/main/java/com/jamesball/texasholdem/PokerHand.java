package com.jamesball.texasholdem;

import java.util.Objects;
import java.util.Set;

public final class PokerHand implements Comparable<PokerHand> {

    private final PokerHandType type;
    private final Set<PlayingCard> cards;

    public PokerHand(PokerHandType type, Set<PlayingCard> cards) {
        this.type = type;
        this.cards = cards;
    }

    public PokerHandType type() {
        return type;
    }

    public Set<PlayingCard> cards() {
        return cards;
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

        final PokerHand otherHand = (PokerHand) otherObject;

        return cards.equals(otherHand.cards());
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, cards);
    }

    // TODO: add unit tests
    @Override
    public int compareTo(PokerHand otherHand) {
        final int comparison = Integer.compare(type.value(), otherHand.type.value());

        if (comparison == 0) {
            final int score = cards.stream()
                    .map(PlayingCard::rank)
                    .mapToInt(PlayingCardRank::value)
                    .sum();

            final int otherHandScore = otherHand.cards.stream()
                    .map(PlayingCard::rank)
                    .mapToInt(PlayingCardRank::value)
                    .sum();

            return Integer.compare(score, otherHandScore);
        }

        return comparison;
    }
}
