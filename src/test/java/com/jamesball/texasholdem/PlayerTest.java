package com.jamesball.texasholdem;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PlayerTest {

    private Player player;

    @BeforeEach
    public void beforeEach() {
        player = new Player();
    }

    @Test
    public void whenInstantiated_thenHandIsEmpty() {
        assertTrue(player.holeCards().isEmpty());
    }

    @Test
    public void whenDealtCard_thenCardIsAddedToHand() {
        final PlayingCard dealtCard = new PlayingCard(PlayingCardSuit.SPADES, PlayingCardRank.ACE);
        final List<PlayingCard> expectedHand = new ArrayList<>();
        expectedHand.add(dealtCard);

        player.addToHoleCards(dealtCard);

        assertEquals(expectedHand, player.holeCards());
    }
}
