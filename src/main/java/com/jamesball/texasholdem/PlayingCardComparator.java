package com.jamesball.texasholdem;

import java.util.Comparator;

public class PlayingCardComparator implements Comparator<PlayingCard> {

    @Override
    public int compare(PlayingCard firstPlayingCard, PlayingCard secondPlayingCard) {
        return Integer.compare(firstPlayingCard.rank().value(), secondPlayingCard.rank().value());
    }
}
