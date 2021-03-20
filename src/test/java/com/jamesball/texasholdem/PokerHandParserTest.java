package com.jamesball.texasholdem;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PokerHandParserTest {

    private PlayingCardDeck deck;
    private PokerHandParser parser;

    @BeforeEach
    public void beforeEach() {
        Dealer dealer = new Dealer();
        deck = dealer.shuffle(new PlayingCardDeck());
        parser = new PokerHandParser();
    }

    @RepeatedTest(100)
    public void whenFiveCards_thenOneCombination() {
        final Set<Set<PlayingCard>> combinations = new HashSet<>();
        final Set<PlayingCard> cards = deal(deck, 5);

        parser.findCombinations(combinations, new HashSet<>(), cards);

        assertEquals(1, combinations.size());
    }

    @RepeatedTest(100)
    public void whenSixCards_thenSixCombinations() {
        final Set<Set<PlayingCard>> combinations = new HashSet<>();
        final Set<PlayingCard> cards = deal(deck, 6);

        parser.findCombinations(combinations, new HashSet<>(), cards);

        assertEquals(6, combinations.size());
    }

    @RepeatedTest(100)
    public void whenSevenCards_thenTwentyOneCombinations() {
        final Set<Set<PlayingCard>> combinations = new HashSet<>();
        final Set<PlayingCard> cards = deal(deck, 7);

        parser.findCombinations(combinations, new HashSet<>(), cards);

        assertEquals(21, combinations.size());
    }

    @Test
    public void whenCardsContainSingleFiveCardSequence_thenParseStraight() {
        final List<PlayingCard> holeCards = new ArrayList<>();
        holeCards.add(new PlayingCard(PlayingCardSuit.CLUBS, PlayingCardRank.SIX));
        holeCards.add(new PlayingCard(PlayingCardSuit.DIAMONDS, PlayingCardRank.EIGHT));

        final List<PlayingCard> communityCards = new ArrayList<>();
        communityCards.add(new PlayingCard(PlayingCardSuit.HEARTS, PlayingCardRank.FIVE));
        communityCards.add(new PlayingCard(PlayingCardSuit.SPADES, PlayingCardRank.TWO));
        communityCards.add(new PlayingCard(PlayingCardSuit.CLUBS, PlayingCardRank.SEVEN));
        communityCards.add(new PlayingCard(PlayingCardSuit.DIAMONDS, PlayingCardRank.ACE));
        communityCards.add(new PlayingCard(PlayingCardSuit.HEARTS, PlayingCardRank.NINE));

        // 5♥ 6♣ 7♣ 8♦ 9♥
        final PokerHand expectedHand = new PokerHand(PokerHandType.STRAIGHT, Set.of(
                new PlayingCard(PlayingCardSuit.CLUBS, PlayingCardRank.SIX),
                new PlayingCard(PlayingCardSuit.DIAMONDS, PlayingCardRank.EIGHT),
                new PlayingCard(PlayingCardSuit.HEARTS, PlayingCardRank.FIVE),
                new PlayingCard(PlayingCardSuit.CLUBS, PlayingCardRank.SEVEN),
                new PlayingCard(PlayingCardSuit.HEARTS, PlayingCardRank.NINE)
        ));

        assertEquals(expectedHand, parser.parse(holeCards, communityCards));
    }

    @Test
    public void whenCardsContainMultipleFiveCardSequence_thenParseHighestStraight() {
        final List<PlayingCard> holeCards = new ArrayList<>();
        holeCards.add(new PlayingCard(PlayingCardSuit.CLUBS, PlayingCardRank.SIX));
        holeCards.add(new PlayingCard(PlayingCardSuit.DIAMONDS, PlayingCardRank.EIGHT));

        final List<PlayingCard> communityCards = new ArrayList<>();
        communityCards.add(new PlayingCard(PlayingCardSuit.HEARTS, PlayingCardRank.FIVE));
        communityCards.add(new PlayingCard(PlayingCardSuit.SPADES, PlayingCardRank.FOUR));
        communityCards.add(new PlayingCard(PlayingCardSuit.CLUBS, PlayingCardRank.SEVEN));
        communityCards.add(new PlayingCard(PlayingCardSuit.DIAMONDS, PlayingCardRank.TEN));
        communityCards.add(new PlayingCard(PlayingCardSuit.HEARTS, PlayingCardRank.NINE));

        // 6♣ 7♣ 8♦ 9♥ 10♦
        final PokerHand expectedHand = new PokerHand(PokerHandType.STRAIGHT, Set.of(
                new PlayingCard(PlayingCardSuit.CLUBS, PlayingCardRank.SIX),
                new PlayingCard(PlayingCardSuit.DIAMONDS, PlayingCardRank.EIGHT),
                new PlayingCard(PlayingCardSuit.CLUBS, PlayingCardRank.SEVEN),
                new PlayingCard(PlayingCardSuit.DIAMONDS, PlayingCardRank.TEN),
                new PlayingCard(PlayingCardSuit.HEARTS, PlayingCardRank.NINE)
        ));

        assertEquals(expectedHand, parser.parse(holeCards, communityCards));
    }

    private Set<PlayingCard> deal(PlayingCardDeck deck, int numberOfCardsToDeal) {
        final Set<PlayingCard> cards = new HashSet<>();
        for (int i = 0; i < numberOfCardsToDeal; i++) {
            cards.add(deck.next());
        }
        return cards;
    }
}
