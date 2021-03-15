package com.jamesball.texasholdem;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PokerHandEvaluator {

    public PokerHand evaluate(List<PlayingCard> hand) {
        final Map<PlayingCardRank, List<PlayingCard>> ranks = parseRanks(hand);

        return switch (numberOfPairs(ranks)) {
            case 2 -> PokerHand.TWO_PAIR;
            case 1 -> PokerHand.ONE_PAIR;
            default -> PokerHand.HIGH_CARD;
        };
    }

    private int numberOfPairs(Map<PlayingCardRank, List<PlayingCard>> ranks) {
        return (int) ranks.values().stream()
                .filter(playingCards -> playingCards.size() == 2)
                .count();
    }

    private Map<PlayingCardRank, List<PlayingCard>> parseRanks(List<PlayingCard> hand) {
        return hand.stream()
                .collect(Collectors.groupingBy(PlayingCard::rank));
    }
}
