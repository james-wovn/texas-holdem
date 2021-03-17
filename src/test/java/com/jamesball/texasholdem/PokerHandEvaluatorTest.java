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
    public void whenHandHasNoCombinationOfCards_thenHighCard() {
        hand.add(new PlayingCard(PlayingCardSuit.DIAMONDS, PlayingCardRank.KING));
        hand.add(new PlayingCard(PlayingCardSuit.DIAMONDS, PlayingCardRank.QUEEN));
        hand.add(new PlayingCard(PlayingCardSuit.SPADES, PlayingCardRank.SEVEN));
        hand.add(new PlayingCard(PlayingCardSuit.SPADES, PlayingCardRank.FOUR));
        hand.add(new PlayingCard(PlayingCardSuit.HEARTS, PlayingCardRank.THREE));

        assertEquals(PokerHand.HIGH_CARD, evaluator.evaluate(hand));
    }

    @Test
    public void whenHandContainsTwoCardsOfOneRank_thenOnePair() {
        hand.add(new PlayingCard(PlayingCardSuit.SPADES, PlayingCardRank.TEN));
        hand.add(new PlayingCard(PlayingCardSuit.HEARTS, PlayingCardRank.TEN));
        hand.add(new PlayingCard(PlayingCardSuit.SPADES, PlayingCardRank.EIGHT));
        hand.add(new PlayingCard(PlayingCardSuit.HEARTS, PlayingCardRank.SEVEN));
        hand.add(new PlayingCard(PlayingCardSuit.CLUBS, PlayingCardRank.FOUR));

        assertEquals(PokerHand.ONE_PAIR, evaluator.evaluate(hand));
    }

    @Test
    public void wheHandContainsTwoCardsOfOneRankAndTwoCardsOfAnotherRank_thenTwoPair() {
        hand.add(new PlayingCard(PlayingCardSuit.HEARTS, PlayingCardRank.JACK));
        hand.add(new PlayingCard(PlayingCardSuit.SPADES, PlayingCardRank.JACK));
        hand.add(new PlayingCard(PlayingCardSuit.CLUBS, PlayingCardRank.THREE));
        hand.add(new PlayingCard(PlayingCardSuit.SPADES, PlayingCardRank.THREE));
        hand.add(new PlayingCard(PlayingCardSuit.HEARTS, PlayingCardRank.TWO));

        assertEquals(PokerHand.TWO_PAIR, evaluator.evaluate(hand));
    }

    @Test
    public void whenHandContainsThreeCardsOfOneRank_thenThreeOfAKind() {
        hand.add(new PlayingCard(PlayingCardSuit.CLUBS, PlayingCardRank.QUEEN));
        hand.add(new PlayingCard(PlayingCardSuit.SPADES, PlayingCardRank.QUEEN));
        hand.add(new PlayingCard(PlayingCardSuit.HEARTS, PlayingCardRank.QUEEN));
        hand.add(new PlayingCard(PlayingCardSuit.HEARTS, PlayingCardRank.NINE));
        hand.add(new PlayingCard(PlayingCardSuit.SPADES, PlayingCardRank.TWO));

        assertEquals(PokerHand.THREE_OF_A_KIND, evaluator.evaluate(hand));
    }

    @Test
    public void whenHandContainsThreeCardsOfOneRankAndTwoCardsOfAnotherRank_thenFullHouse() {
        hand.add(new PlayingCard(PlayingCardSuit.SPADES, PlayingCardRank.SIX));
        hand.add(new PlayingCard(PlayingCardSuit.HEARTS, PlayingCardRank.SIX));
        hand.add(new PlayingCard(PlayingCardSuit.DIAMONDS, PlayingCardRank.SIX));
        hand.add(new PlayingCard(PlayingCardSuit.CLUBS, PlayingCardRank.KING));
        hand.add(new PlayingCard(PlayingCardSuit.HEARTS, PlayingCardRank.KING));

        assertEquals(PokerHand.FULL_HOUSE, evaluator.evaluate(hand));
    }

    @Test
    public void whenHandContainsFourCardsOfOneRank_thenFourOfAKind() {
        hand.add(new PlayingCard(PlayingCardSuit.CLUBS, PlayingCardRank.FIVE));
        hand.add(new PlayingCard(PlayingCardSuit.DIAMONDS, PlayingCardRank.FIVE));
        hand.add(new PlayingCard(PlayingCardSuit.HEARTS, PlayingCardRank.FIVE));
        hand.add(new PlayingCard(PlayingCardSuit.SPADES, PlayingCardRank.FIVE));
        hand.add(new PlayingCard(PlayingCardSuit.DIAMONDS, PlayingCardRank.TWO));

        assertEquals(PokerHand.FOUR_OF_A_KIND, evaluator.evaluate(hand));
    }
}
