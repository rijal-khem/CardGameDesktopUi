package com.rizal.ui.cardgame.cardgamedesktopui.backend.card;


import java.util.ArrayList;
import java.util.List;

/**
 *Deck has exactly 52 cards  with combination of Faces and Suits.
 */
public class Deck {

    public static List<Card>  getNewDeck(){
        List<Card> cards = new ArrayList<>(52);
        for(Card.Suits suits: Card.Suits.values()){
            for(Card.Face face : Card.Face.values()){
                Card card = new Card(face, suits);
                cards.add(card);
            }
        }
        return cards;
    }


}
