package com.rizal.ui.cardgame.cardgamedesktopui.backend.card;


import com.rizal.ui.cardgame.cardgamedesktopui.backend.card.player.Player;

import java.util.Collections;
import java.util.List;

/**
 * Dealer is a object which Shuffles and Deals  evaluates winner cards the card in a game.
 * */

public class Dealer {



    List<Player> players;
    List<Card>  currentDeck;

    public Dealer(List<Card> newDeck, List<Player> players){
        this.currentDeck = newDeck;
        this.players = players;
    }

    public List<Card> getCurrentDeck(){
        return currentDeck;
    }

    public void shuffleCurrentDeck(){
        if(currentDeck!=null){
            //generating the random int to shuffles that many times.
            int shuffleparam = (int) Math.floor(Math.random()*9);
            for(int i=0;i<shuffleparam;i++){
                Collections.shuffle(currentDeck);
            }
        }
    }


    public void dealCardsToPlayers(){
        for(int i=0;i<3;i++){
            for(Player player:players){
                player.getHand().addCardtoHand(dealCardFromCurrentDeck());
            }
        }
    }

    private Card dealCardFromCurrentDeck(){
       if(currentDeck!=null){
         return currentDeck.remove(0);
       }
       return null;
    }


    public void clearPreviousCardsFromPlayer() {
        //beforeClearing the cards from player we need to add it back to currentDeck
        for(Player player:players){
            for(Card card: player.getHand().getCards()){
                currentDeck.add(card);
            }
        }

        //clearing the cards from players hand/ be careful in multithreading and  when list is null/cleared garbage coollector might kill the object
        players.forEach(player -> player.getHand().getCards().clear());
    }
}
