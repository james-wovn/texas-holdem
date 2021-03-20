package com.jamesball.texasholdem;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class PokerHandParser {
    private static final int HAND_SIZE = 5;

    public PokerHand parse(List<PlayingCard> holeCards, List<PlayingCard> communityCards) {
        final Set<Set<PlayingCard>> combinations = new HashSet<>();
        final Set<PlayingCard> cards = Stream.concat(holeCards.stream(), communityCards.stream()).collect(Collectors.toCollection(HashSet::new));

        findCombinations(combinations, new HashSet<>(), cards);

        return combinations.stream()
                .filter(this::isStraight)
                .map(combination -> new PokerHand(PokerHandType.STRAIGHT, combination))
                .findFirst()
                .orElseThrow();
    }

    public void findCombinations(Set<Set<PlayingCard>> combinations, Set<PlayingCard> currentCombination, Set<PlayingCard> cards) {
        if (currentCombination.size() == HAND_SIZE) {
            combinations.add(currentCombination);
        } else {
            for (PlayingCard card : freeCards(currentCombination, cards)) {
                final Set<PlayingCard> combination = new HashSet<>(currentCombination);
                combination.add(card);
                findCombinations(combinations, combination, cards);
            }
        }
    }

    private List<PlayingCard> freeCards(Set<PlayingCard> combination, Set<PlayingCard> cards) {
        return cards.stream()
                .filter(card -> !combination.contains(card))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    private boolean isStraight(Set<PlayingCard> combination) {
        final List<PlayingCard> byRank = combination.stream()
                .sorted()
                .collect(Collectors.toCollection(ArrayList::new));

        boolean consecutive = true;
        for (int i = 1; i < byRank.size(); i++) {
            consecutive = byRank.get(i).rank().value() - byRank.get(i - 1).rank().value() == 1;
        }

        return consecutive;
    }
}
