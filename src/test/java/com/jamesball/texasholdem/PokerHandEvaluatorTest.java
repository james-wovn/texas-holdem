package com.jamesball.texasholdem;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PokerHandEvaluatorTest {

    private PokerHandEvaluator evaluator;
    private List<PlayingCard> hand;

    @BeforeEach
    public void beforeEach() {
        evaluator = new PokerHandEvaluator();
        hand = new ArrayList<>();
    }

    @Test
    public void whenHandHasTwoPlayingCardsWithSameRank_thenOnePair() {
        hand.add(new PlayingCard(PlayingCardSuit.SPADES, PlayingCardRank.TEN));
        hand.add(new PlayingCard(PlayingCardSuit.HEARTS, PlayingCardRank.TEN));
        hand.add(new PlayingCard(PlayingCardSuit.SPADES, PlayingCardRank.EIGHT));
        hand.add(new PlayingCard(PlayingCardSuit.HEARTS, PlayingCardRank.SEVEN));
        hand.add(new PlayingCard(PlayingCardSuit.CLUBS, PlayingCardRank.FOUR));

        assertEquals(PokerHand.ONE_PAIR, evaluator.evaluate(hand));
    }

    @Test
    public void whenHandHasTwoSetsOfPlayingCardsWithSameRank_thenTwoPair() {
        hand.add(new PlayingCard(PlayingCardSuit.HEARTS, PlayingCardRank.JACK));
        hand.add(new PlayingCard(PlayingCardSuit.SPADES, PlayingCardRank.JACK));
        hand.add(new PlayingCard(PlayingCardSuit.CLUBS, PlayingCardRank.THREE));
        hand.add(new PlayingCard(PlayingCardSuit.SPADES, PlayingCardRank.THREE));
        hand.add(new PlayingCard(PlayingCardSuit.HEARTS, PlayingCardRank.TWO));

        assertEquals(PokerHand.TWO_PAIR, evaluator.evaluate(hand));
    }

    @Test
    public void whenNoPokerHand_thenHighCard() {
        hand.add(new PlayingCard(PlayingCardSuit.DIAMONDS, PlayingCardRank.KING));
        hand.add(new PlayingCard(PlayingCardSuit.DIAMONDS, PlayingCardRank.QUEEN));
        hand.add(new PlayingCard(PlayingCardSuit.SPADES, PlayingCardRank.SEVEN));
        hand.add(new PlayingCard(PlayingCardSuit.SPADES, PlayingCardRank.FOUR));
        hand.add(new PlayingCard(PlayingCardSuit.HEARTS, PlayingCardRank.THREE));

        assertEquals(PokerHand.HIGH_CARD, evaluator.evaluate(hand));
    }
}
