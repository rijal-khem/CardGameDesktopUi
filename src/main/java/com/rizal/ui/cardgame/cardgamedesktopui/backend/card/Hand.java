package com.rizal.ui.cardgame.cardgamedesktopui.backend.card;

import java.util.List;

public interface Hand {void addCardtoHand(Card card);

    List<Card> getCards();

    void sort();

    boolean isPair();
    public Card.Face pairReturn();
    boolean isSameColor();
    boolean isRun();
    boolean isDoubleRun();
    boolean isTrail();
    boolean isTop();
}
