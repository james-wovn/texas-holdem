package com.jamesball.texasholdem;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class PokerHandParser {
    private static final int HAND_SIZE = 5;

    public Set<Set<PlayingCard>> parse(List<PlayingCard> startingHand, List<PlayingCard> communityCards) {
        final Set<Set<PlayingCard>> pokerHands = new HashSet<>();
        final Set<PlayingCard> cards = Stream.concat(startingHand.stream(), communityCards.stream()).collect(Collectors.toCollection(HashSet::new));
        findPokerHands(pokerHands, new HashSet<>(), cards);
        return pokerHands;
    }

    private void findPokerHands(Set<Set<PlayingCard>> pokerHands, Set<PlayingCard> currentPokerHand, Set<PlayingCard> cards) {
        if (currentPokerHand.size() == HAND_SIZE) {
            pokerHands.add(currentPokerHand);
        } else {
            for (PlayingCard card : freeCards(currentPokerHand, cards)) {
                final Set<PlayingCard> pokerHand = new HashSet<>(currentPokerHand);
                pokerHand.add(card);
                findPokerHands(pokerHands, pokerHand, cards);
            }
        }
    }

    private List<PlayingCard> freeCards(Set<PlayingCard> pokerHand, Set<PlayingCard> cards) {
        return cards.stream()
                .filter(card -> !pokerHand.contains(card))
                .collect(Collectors.toCollection(ArrayList::new));
    }
}
