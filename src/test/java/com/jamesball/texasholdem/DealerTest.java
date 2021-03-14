package com.jamesball.texasholdem;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
}
