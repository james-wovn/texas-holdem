package com.jamesball.texasholdem;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlayingCardComparatorTest {

    private PlayingCardComparator comparator;

    @BeforeEach
    public void beforeEach() {
        comparator = new PlayingCardComparator();
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
        assertEquals(lessThan, comparator.compare(twoOfClubs, sevenOfDiamonds));
        // ♣2 is less than ♥7
        assertEquals(lessThan, comparator.compare(twoOfClubs, sevenOfHearts));
        // ♣2 is less than ♠A
        assertEquals(lessThan, comparator.compare(twoOfClubs, aceOfSpades));

        // ♦7 is greater than ♣2
        assertEquals(greaterThan, comparator.compare(sevenOfDiamonds, twoOfClubs));
        // ♦7 is equal to ♥7
        assertEquals(equalTo, comparator.compare(sevenOfDiamonds, sevenOfHearts));
        // ♦7 is less than ♠A
        assertEquals(lessThan, comparator.compare(sevenOfDiamonds, aceOfSpades));

        // ♠7 is greater than ♣2
        assertEquals(greaterThan, comparator.compare(sevenOfHearts, twoOfClubs));
        // ♠7 is equal to ♦7
        assertEquals(equalTo, comparator.compare(sevenOfHearts, sevenOfDiamonds));
        // ♠7 is less than ♠A
        assertEquals(lessThan, comparator.compare(sevenOfHearts, aceOfSpades));

        // ♠A is greater than ♣2
        assertEquals(greaterThan, comparator.compare(aceOfSpades, twoOfClubs));
        // ♠A is greater than ♦7
        assertEquals(greaterThan, comparator.compare(aceOfSpades, sevenOfDiamonds));
        // ♠A is greater than ♥7
        assertEquals(greaterThan, comparator.compare(aceOfSpades, sevenOfHearts));
    }

    @Test
    public void whenHandIsSorted_thenTheOrderOfPlayingCardsIsCorrect() {
        final List<PlayingCard> hand = new ArrayList<>();
        hand.add(new PlayingCard(PlayingCardSuit.DIAMONDS, PlayingCardRank.KING));
        hand.add(new PlayingCard(PlayingCardSuit.DIAMONDS, PlayingCardRank.QUEEN));
        hand.add(new PlayingCard(PlayingCardSuit.SPADES, PlayingCardRank.SEVEN));
        hand.add(new PlayingCard(PlayingCardSuit.SPADES, PlayingCardRank.FOUR));
        hand.add(new PlayingCard(PlayingCardSuit.HEARTS, PlayingCardRank.THREE));

        final List<PlayingCard> expectedOrder = new ArrayList<>();
        expectedOrder.add(new PlayingCard(PlayingCardSuit.HEARTS, PlayingCardRank.THREE));
        expectedOrder.add(new PlayingCard(PlayingCardSuit.SPADES, PlayingCardRank.FOUR));
        expectedOrder.add(new PlayingCard(PlayingCardSuit.SPADES, PlayingCardRank.SEVEN));
        expectedOrder.add(new PlayingCard(PlayingCardSuit.DIAMONDS, PlayingCardRank.QUEEN));
        expectedOrder.add(new PlayingCard(PlayingCardSuit.DIAMONDS, PlayingCardRank.KING));

        assertEquals(expectedOrder, hand.stream()
                .sorted(comparator)
                .collect(Collectors.toCollection(ArrayList::new)));
    }
}
