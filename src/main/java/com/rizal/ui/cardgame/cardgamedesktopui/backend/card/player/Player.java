package com.rizal.ui.cardgame.cardgamedesktopui.backend.card.player;


import com.rizal.ui.cardgame.cardgamedesktopui.backend.card.FlushHandComparator;
import com.rizal.ui.cardgame.cardgamedesktopui.backend.card.Hand;
import javafx.collections.ObservableList;
import javafx.scene.image.ImageView;

import java.util.Collections;
import java.util.List;

/**
 * Player object is a player which plays in this game;
 *
 * */
public class Player implements Comparable<Player> {

    private String name;
    private int score;
    private List<ImageView> listCardsImageView;
    private Hand hand;

    private int balanceAmount;

    public Player(String name){
        this.name = name;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public List<ImageView> getListImageView() {
        return listCardsImageView;
    }

    public void setListImageView(List<ImageView> listImageView) {
        this.listCardsImageView = listImageView;
    }

    public Hand getHand() {
        return hand;
    }

    public void setHand(Hand hand) {
        this.hand = hand;
    }
    public void sortHand(){
        Collections.sort(hand.getCards());
    }


    public int getBalanceAmount() {
        return balanceAmount;
    }

    public void setBalanceAmount(int balanceAmount) {
        this.balanceAmount = balanceAmount;
    }

    @Override
    public int compareTo(Player player) {
        FlushHandComparator comparator = new FlushHandComparator();
        return comparator.compare(this.hand, player.hand);
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", score=" + score +
                ", listCardsImageView=" + listCardsImageView +
                ", hand=" + hand.toString() +
                '}';
    }
}
