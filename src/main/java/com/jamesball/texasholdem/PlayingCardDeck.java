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
