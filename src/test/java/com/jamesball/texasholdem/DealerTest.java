package com.jamesball.texasholdem;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class DealerTest {

    private Dealer dealer;

    @BeforeEach
    public void beforeEach() {
        dealer = new Dealer();
    }

    @Test
    public void whenShuffle_thenInstantiateNewDeckThatIsShuffledIntoRandomOrder() {
        final PlayingCardDeck deck = new PlayingCardDeck();
        final PlayingCardDeck shuffledDeck = dealer.shuffle(deck);
        assertNotEquals(deck, shuffledDeck);
    }
}
