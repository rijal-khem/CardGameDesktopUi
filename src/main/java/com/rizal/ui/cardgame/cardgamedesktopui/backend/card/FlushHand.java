package com.rizal.ui.cardgame.cardgamedesktopui.backend.card;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This is type of hand in card game where each player gets 3 cards and has its own comparision to
 * see who wins.
 *
 *
 * */
public class FlushHand implements Hand{

    private int numberOfCardsInFlushHand =3;
    List<Card> cards = new ArrayList<>(3);


    public void addCardtoHand(Card card){
        cards.add(card);
    }


    @Override
    public List<Card> getCards(){
        return cards;
    }

    @Override
    public void sort() {
        Collections.sort(cards);
    }



    public boolean isTrail(){
        if(cards.get(0).getFace() == cards.get(1).getFace() && cards.get(0).getFace() == cards.get(2).getFace())
            return true;
        return false;
    }
    public boolean isDoubleRun(){
        if(isRun()){
            if(isSameColor())
                return true;
        }
        return false;
    }

    public boolean isRun(){
        //sorting if it has not been already sorted (Ascending order)
        Collections.sort(cards);
        if(!isPair()){
            if(cards.get(0).getFace() == Card.Face.ACE){
                if((cards.get(1).getFace() == Card.Face.TWO && cards.get(2).getFace()== Card.Face.THREE) || (cards.get(1).getFace() == Card.Face.KING && cards.get(2).getFace()== Card.Face.QUEEN))
                    return true;
            }
            if(cards.get(0).getFace().val-1 == cards.get(1).getFace().val && cards.get(1).getFace().val-1 == cards.get(2).getFace().val)
                return true;
        }
        return false;
    }

    public boolean isSameColor(){
        if(cards.get(0).getSuits().equals(cards.get(1).getSuits())&& cards.get(0).getSuits().equals(cards.get(2).getSuits()))
            return true;
        return false;
    }


    public boolean isPair(){
        if(!isTrail()){
            if(cards.get(0).getFace()==cards.get(1).getFace() || cards.get(0).getFace()==cards.get(2).getFace() || cards.get(1).getFace()==cards.get(2).getFace())
                return true;
        }
        return false;
    }

    public Card.Face pairReturn(){
            if(cards.get(0).getFace()==cards.get(1).getFace()){
                return cards.get(0).getFace();
            }else{
               return cards.get(1).getFace();
            }

    }

    public boolean isTop(){
        if(!isTrail()&&!isDoubleRun()&&!isRun()&&!isSameColor()&&!isPair())
            return true;
        return false;
    }


}
