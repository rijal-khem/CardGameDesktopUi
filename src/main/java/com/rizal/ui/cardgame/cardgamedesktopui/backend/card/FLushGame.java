package com.rizal.ui.cardgame.cardgamedesktopui.backend.card;

import com.rizal.ui.cardgame.cardgamedesktopui.backend.card.player.Player;

import java.util.Collections;
import java.util.List;

public class FLushGame {

    final List<Player> players;
    final Dealer dealer;


    public FLushGame(List<Player> players){
        this.players = players;
        dealer = new Dealer(Deck.getNewDeck(), this.players);
        setPlayersHand();
    }

    public void  shuffleDeck(){
        dealer.shuffleCurrentDeck();
    }


    public void dealCardsToPlayers() {
        dealer.dealCardsToPlayers();
    }


    public void setPlayersHand(){
        for(Player player:players){
            player.setHand(new FlushHand());
        }
    }

    public Player getWinner(){
        return  evaluateHand().get(0);
    }


    /**
     * this evaluate retrun the modified list after sorting, it
     *is based on sorting of playerlist based on their hands ranking.
     * Players needs to be comparable object
     * and must have comparing implementaion. for flush please look in to FlushHandComparator Class.
     * */
    private List<Player> evaluateHand(){
        //this evaluation is purely based on sorting of players card in descending order
        for(Player player:players){
            Collections.sort(player.getHand().getCards());
        }
        //now sorting the players list based on high hand. Whoever comes in 0th index of list has a high cards.
        //this sorting is based on Hand
        Collections.sort(players);
        return players;
    }

    public void updateScore(Player winner){
        winner.setScore(winner.getScore()+1);
    }

    public void clearPreviousCardsfromPlayers() {
        dealer.clearPreviousCardsFromPlayer();
    }
}
