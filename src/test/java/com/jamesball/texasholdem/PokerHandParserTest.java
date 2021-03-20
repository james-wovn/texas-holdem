package com.jamesball.texasholdem;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PokerHandParserTest {

    private Dealer dealer;
    private PlayingCardDeck deck;
    private PokerHandParser parser;

    @BeforeEach
    public void beforeEach() {
        dealer = new Dealer();
        deck = dealer.shuffle(new PlayingCardDeck());
        parser = new PokerHandParser();
    }

    @RepeatedTest(1000)
    public void when2HoleCardsAnd3CommunityCards_thenParse1Combination() {
        final List<PlayingCard> startingHand = deal(deck, 2);
        final List<PlayingCard> communityCards = deal(deck, 3);

        final Set<Set<PlayingCard>> hands = parser.parse(startingHand, communityCards);

        assertEquals(1, hands.size());
    }

    @RepeatedTest(1000)
    public void when2HoleCardsAnd4CommunityCards_thenParse2Combinations() {
        final List<PlayingCard> startingHand = deal(deck, 2);
        final List<PlayingCard> communityCards = deal(deck, 4);

        final Set<Set<PlayingCard>> hands = parser.parse(startingHand, communityCards);

        assertEquals(6, hands.size());
    }

    @RepeatedTest(1000)
    public void when2HoleCardsAnd5CommunityCards_thenParse21Combinations() {
        final List<PlayingCard> startingHand = deal(deck, 2);
        final List<PlayingCard> communityCards = deal(deck, 5);

        final Set<Set<PlayingCard>> hands = parser.parse(startingHand, communityCards);

        assertEquals(21, hands.size());
    }

    private List<PlayingCard> deal(PlayingCardDeck deck, int numberOfCardsToDeal) {
        final List<PlayingCard> cards = new ArrayList<>();
        for (int i = 0; i < numberOfCardsToDeal; i++) {
            cards.add(dealer.deal(deck));
        }
        return cards;
    }
}
