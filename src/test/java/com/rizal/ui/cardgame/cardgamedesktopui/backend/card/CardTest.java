package com.rizal.ui.cardgame.cardgamedesktopui.backend.card;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CardTest {


    Card card = new Card(Card.Face.THREE, Card.Suits.HEARTS);

    @Test
    public void getFaceTest(){
        Assertions.assertTrue(card.getFace().val==3);
        Assertions.assertTrue(card.getFace().equals(Card.Face.THREE));
    }

    @Test
    public void getSuitsTest(){
        Assertions.assertTrue(card.getSuits().toString().equals("HEARTS"));

    }

    @Test
    public void setImageLocationTest(){
        card.setImageLocation();
        assertTrue(card.getImageLocation()!=null);
    }

    @Test
    public void getImageLocation(){
        assertTrue(card.getImageLocation().toString().equals("/imgs/cardsImgs/3_of_hearts.png"));
    }

}