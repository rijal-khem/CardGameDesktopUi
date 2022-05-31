package com.rizal.ui.cardgame.cardgamedesktopui.backend.card;


import com.rizal.ui.cardgame.cardgamedesktopui.backend.card.player.Player;

import java.util.Collections;
import java.util.List;

/**
 * Dealer is a object which Shuffles and Deals  evaluates winner cards the card in a game.
 * */

public class Dealer {

    List<Card> newDeck;

    List<Player> players;
    List<Card>  currentDeck;

    public Dealer(List<Card> newDeck, List<Player> players){
        this.newDeck = newDeck;
        this.players = players;
    }

    public List<Card> getCurrentDeck(){
        return currentDeck;
    }

    public void shuffleCurrentDeck(){
        if(currentDeck==null){
            currentDeck = newDeck;
            //generating the random int to shuffles that many times.
            int shuffleparam = (int) Math.floor(Math.random()*9);
            for(int i=0;i<shuffleparam;i++){
                Collections.shuffle(currentDeck);
            }
        }
    }

    public Card dealCardFromCurrentDeck(){
       if(currentDeck!=null){
         return currentDeck.get(0);
       }
       return null;
    }

    public void dealCardsToPlayer(){

    }


}
