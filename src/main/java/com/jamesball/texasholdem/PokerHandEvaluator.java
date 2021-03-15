package com.jamesball.texasholdem;

import java.util.List;
import java.util.stream.Collectors;

public class PokerHandEvaluator {

    private static final long CARDS_WITH_MATCHING_RANK_IN_ONE_PAIR = 2;

    public PokerHand evaluate(List<PlayingCard> hand) {
        if (isOnePair(hand)) {
            return PokerHand.ONE_PAIR;
        }
        return PokerHand.HIGH_CARD;
    }

    private boolean isOnePair(List<PlayingCard> hand) {
        return hand.stream()
                .collect(Collectors.groupingBy(PlayingCard::rank, Collectors.counting()))
                .containsValue(CARDS_WITH_MATCHING_RANK_IN_ONE_PAIR);
    }
}
