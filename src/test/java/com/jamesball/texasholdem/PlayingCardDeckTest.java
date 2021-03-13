package com.jamesball.texasholdem;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlayingCardDeckTest {

    private PlayingCardDeck deck;

    @BeforeEach
    public void beforeEach() {
        deck = new PlayingCardDeck();
    }

    @Test
    public void whenInstantiated_thenIsStandard52CardDeck() {
        final int expectedNumberOfCards = 52;
        final Set<PlayingCardSuit> expectedSuits = new HashSet<>(Arrays.asList(PlayingCardSuit.values()));
        final Set<PlayingCardRank> expectedRanks = new HashSet<>(Arrays.asList(PlayingCardRank.values()));

        assertEquals(expectedNumberOfCards, deck.cards().size());

        assertEquals(expectedSuits, deck.cards().stream()
                .map(PlayingCard::suit)
                .collect(Collectors.toCollection(HashSet::new)));

        assertEquals(expectedRanks, deck.cards().stream()
                .map(PlayingCard::rank)
                .collect(Collectors.toCollection(HashSet::new)));

        for (PlayingCardSuit suit : PlayingCardSuit.values()) {
            assertEquals(expectedRanks, deck.cards().stream()
                    .filter(playingCard -> playingCard.suit() == suit)
                    .map(PlayingCard::rank)
                    .collect(Collectors.toCollection(HashSet::new)));
        }
    }

    @Test
    public void whenCloned_thenInstantiateAnIdenticalObject() {
        final PlayingCardDeck clonedDeck = deck.clone();
        assertEquals(deck, clonedDeck);
    }
}
