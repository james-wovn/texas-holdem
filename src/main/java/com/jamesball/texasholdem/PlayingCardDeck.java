package com.jamesball.texasholdem;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class PlayingCardDeck {
    private final List<PlayingCard> cards;

    public PlayingCardDeck() {
        cards = new ArrayList<>();
        for (PlayingCardSuit suit : PlayingCardSuit.values()) {
            for (PlayingCardRank rank : PlayingCardRank.values()) {
                cards.add(new PlayingCard(suit, rank));
            }
        }
    }

    public PlayingCardDeck(List<PlayingCard> cards) {
        this.cards = cards;
    }

    public List<PlayingCard> cards() {
        return cards;
    }

    @Override
    public PlayingCardDeck clone() {
        List<PlayingCard> copiedCards = new ArrayList<>();
        for (PlayingCard card : cards) {
            copiedCards.add(new PlayingCard(card.suit(), card.rank()));
        }
        return new PlayingCardDeck(copiedCards);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlayingCardDeck deck = (PlayingCardDeck) o;
        return cards.equals(deck.cards);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cards);
    }
}
