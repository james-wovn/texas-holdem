package com.jamesball.texasholdem;

public enum PokerHandType {
    HIGH_CARD(1),
    ONE_PAIR(2),
    TWO_PAIR(3),
    THREE_OF_A_KIND(4),
    STRAIGHT(5),
    FULL_HOUSE(6),
    FOUR_OF_A_KIND(7);

    private final int value;

    PokerHandType(int value) {
        this.value = value;
    }

    public int value() {
        return value;
    }
}
