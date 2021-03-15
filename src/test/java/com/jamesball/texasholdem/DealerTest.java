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
        final List<PlayingCard> expectedPlayer1Hand = new ArrayList<>();
        expectedPlayer1Hand.add(deck.cards().get(0));
        expectedPlayer1Hand.add(deck.cards().get(3));

        final List<PlayingCard> expectedPlayer2Hand = new ArrayList<>();
        expectedPlayer2Hand.add(deck.cards().get(1));
        expectedPlayer2Hand.add(deck.cards().get(4));

        final List<PlayingCard> expectedPlayer3Hand = new ArrayList<>();
        expectedPlayer3Hand.add(deck.cards().get(2));
        expectedPlayer3Hand.add(deck.cards().get(5));

        final List<Player> players = new ArrayList<>();
        players.add(new Player());
        players.add(new Player());
        players.add(new Player());

        dealer.dealHand(deck, players);

        assertEquals(expectedPlayer1Hand, players.get(0).hand());
        assertEquals(expectedPlayer2Hand, players.get(1).hand());
        assertEquals(expectedPlayer3Hand, players.get(2).hand());
    }
}
