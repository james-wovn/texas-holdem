package com.jamesball.texasholdem;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class PlayingCardTest {

    private PlayingCard card;

    @BeforeEach
    public void beforeEach() {
        card = new PlayingCard(PlayingCardSuit.CLUBS, PlayingCardRank.ACE);
    }

    @Test
    public void whenCloned_thenInstantiateAnIdenticalObject() {
        final PlayingCard clonedCard = card.clone();
        assertEquals(card, clonedCard);
    }

    @Test
    public void whenPlayingCardsHaveDifferentSuitAndDifferentRank_thenEqual() {
        final PlayingCard cardToCompare = new PlayingCard(PlayingCardSuit.DIAMONDS, PlayingCardRank.TWO);
        assertNotEquals(cardToCompare, card);
    }

    @Test
    public void whenPlayingCardsHaveDifferentSuitAndSameRank_thenNotEqual() {
        final PlayingCard cardToCompare = new PlayingCard(PlayingCardSuit.DIAMONDS, PlayingCardRank.ACE);
        assertNotEquals(cardToCompare, card);
    }

    @Test
    public void whenPlayingCardsHaveSameSuitAndDifferentRank_thenNotEqual() {
        final PlayingCard cardToCompare = new PlayingCard(PlayingCardSuit.CLUBS, PlayingCardRank.TWO);
        assertNotEquals(cardToCompare, card);
    }

    @Test
    public void whenPlayingCardsHaveSameSuitAndSameRank_thenEqual() {
        final PlayingCard cardToCompare = new PlayingCard(PlayingCardSuit.CLUBS, PlayingCardRank.ACE);
        assertEquals(cardToCompare, card);
    }

    @Test
    public void whenTwoPlayingCardsAreCompared_thenTheRankOfEachPlayingCardIsComparedForOrder() {
        final int lessThan = -1;
        final int equalTo = 0;
        final int greaterThan = 1;

        final PlayingCard twoOfClubs = new PlayingCard(PlayingCardSuit.CLUBS, PlayingCardRank.TWO);
        final PlayingCard sevenOfDiamonds = new PlayingCard(PlayingCardSuit.DIAMONDS, PlayingCardRank.SEVEN);
        final PlayingCard sevenOfHearts = new PlayingCard(PlayingCardSuit.HEARTS, PlayingCardRank.SEVEN);
        final PlayingCard aceOfSpades = new PlayingCard(PlayingCardSuit.SPADES, PlayingCardRank.ACE);

        // ♣2 is less than ♦7
        assertEquals(lessThan, twoOfClubs.compareTo(sevenOfDiamonds));
        // ♣2 is less than ♥7
        assertEquals(lessThan, twoOfClubs.compareTo(sevenOfHearts));
        // ♣2 is less than ♠A
        assertEquals(lessThan, twoOfClubs.compareTo(aceOfSpades));

        // ♦7 is greater than ♣2
        assertEquals(greaterThan, sevenOfDiamonds.compareTo(twoOfClubs));
        // ♦7 is equal to ♥7
        assertEquals(equalTo, sevenOfDiamonds.compareTo(sevenOfHearts));
        // ♦7 is less than ♠A
        assertEquals(lessThan, sevenOfDiamonds.compareTo(aceOfSpades));

        // ♠7 is greater than ♣2
        assertEquals(greaterThan, sevenOfHearts.compareTo(twoOfClubs));
        // ♠7 is equal to ♦7
        assertEquals(equalTo, sevenOfHearts.compareTo(sevenOfDiamonds));
        // ♠7 is less than ♠A
        assertEquals(lessThan, sevenOfHearts.compareTo(aceOfSpades));

        // ♠A is greater than ♣2
        assertEquals(greaterThan, aceOfSpades.compareTo(twoOfClubs));
        // ♠A is greater than ♦7
        assertEquals(greaterThan, aceOfSpades.compareTo(sevenOfDiamonds));
        // ♠A is greater than ♥7
        assertEquals(greaterThan, aceOfSpades.compareTo(sevenOfHearts));
    }
}
