package com.jamesball.texasholdem;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlayingCardTest {

    private PlayingCard card;

    @BeforeEach
    public void beforeEach() {
        card = new PlayingCard(PlayingCardSuit.SPADES, PlayingCardRank.ACE);
    }

    @Test
    public void whenCloned_thenInstantiateAnIdenticalObject() {
        final PlayingCard clonedCard = card.clone();
        assertEquals(card, clonedCard);
    }
}
