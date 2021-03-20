package com.jamesball.texasholdem;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class DealerTest {

    private Dealer dealer;
    private PlayingCardDeck deck;

    @BeforeEach
    public void beforeEach() {
        dealer = new Dealer();
        deck = new PlayingCardDeck();
    }

    @Test
    public void whenShuffle_thenInstantiateNewDeckThatIsShuffledInRandomOrder() {
        final PlayingCardDeck shuffledDeck = dealer.shuffle(deck);
        assertNotEquals(deck, shuffledDeck);
    }

    @Test
    public void whenDealHand_thenDealTwoCardsOneAtATimeToEachPlayer() {
        final List<PlayingCard> expectedPlayer1HoleCards = new ArrayList<>();
        expectedPlayer1HoleCards.add(deck.cards().get(0));
        expectedPlayer1HoleCards.add(deck.cards().get(3));

        final List<PlayingCard> expectedPlayer2HoleCards = new ArrayList<>();
        expectedPlayer2HoleCards.add(deck.cards().get(1));
        expectedPlayer2HoleCards.add(deck.cards().get(4));

        final List<PlayingCard> expectedPlayer3HoleCards = new ArrayList<>();
        expectedPlayer3HoleCards.add(deck.cards().get(2));
        expectedPlayer3HoleCards.add(deck.cards().get(5));

        final List<Player> players = new ArrayList<>();
        players.add(new Player());
        players.add(new Player());
        players.add(new Player());

        dealer.dealStartingHands(deck, players);

        assertEquals(expectedPlayer1HoleCards, players.get(0).holeCards());
        assertEquals(expectedPlayer2HoleCards, players.get(1).holeCards());
        assertEquals(expectedPlayer3HoleCards, players.get(2).holeCards());
    }
}
