package com.jamesball.texasholdem;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PokerHandEvaluator {

    private static final int NUMBER_OF_CARDS_IN_A_PAIR = 2;
    private static final int NUMBER_OF_CARDS_IN_THREE_OF_A_KIND = 3;
    private static final int NUMBER_OF_CARDS_IN_FOUR_OF_A_KIND = 4;

    private final PlayingCardComparator comparator;

    public PokerHandEvaluator() {
        comparator = new PlayingCardComparator();
    }

    public PokerHand evaluate(List<PlayingCard> hand) {
        final Map<PlayingCardRank, List<PlayingCard>> ranks = parseRanks(hand);

        final int pairs = pairs(ranks);
        final int trips = trips(ranks);
        final int quads = quads(ranks);

        if (quads == 1) {
            return PokerHand.FOUR_OF_A_KIND;
        } else if (trips == 1) {
            if (pairs == 1) {
                return PokerHand.FULL_HOUSE;
            }
            return PokerHand.THREE_OF_A_KIND;
        } else if (pairs == 2) {
            return PokerHand.TWO_PAIR;
        } else if (pairs == 1) {
            return PokerHand.ONE_PAIR;
        }
        return PokerHand.HIGH_CARD;
    }

    private int pairs(Map<PlayingCardRank, List<PlayingCard>> ranks) {
        return countCombinationsOfSameRank(ranks, NUMBER_OF_CARDS_IN_A_PAIR);
    }

    private int trips(Map<PlayingCardRank, List<PlayingCard>> ranks) {
        return countCombinationsOfSameRank(ranks, NUMBER_OF_CARDS_IN_THREE_OF_A_KIND);
    }

    private int quads(Map<PlayingCardRank, List<PlayingCard>> ranks) {
        return countCombinationsOfSameRank(ranks, NUMBER_OF_CARDS_IN_FOUR_OF_A_KIND);
    }

    private int countCombinationsOfSameRank(Map<PlayingCardRank, List<PlayingCard>> ranks, int cardsOfSameRank) {
        return (int) ranks.values().stream()
                .filter(playingCards -> playingCards.size() == cardsOfSameRank)
                .count();
    }

    private Map<PlayingCardRank, List<PlayingCard>> parseRanks(List<PlayingCard> hand) {
        return hand.stream()
                .collect(Collectors.groupingBy(PlayingCard::rank));
    }
}
