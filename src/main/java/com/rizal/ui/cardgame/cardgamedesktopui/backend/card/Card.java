package com.rizal.ui.cardgame.cardgamedesktopui.backend.card;


/*
* Card object is a comparable object based on its face value which helps in sorting and comparing
* later in the game and basic building block of Card Game
* Author @Rizal
* */

public class Card implements Comparable<Card>{



    public enum Face{
       TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7), EIGHT(8), NINE(9),
        TEN(10), JACK(11), QUEEN(12), KING(13), ACE(14);
       public int val;
       Face(int val){
           this.val = val;
       }
    }

    public enum Suits{
        CLUBS,
        HEARTS,
        SPADES,
        DIAMONDS
    }


    private Face face;
    private Suits suits;

    public Card(Face face, Suits suits){
        this.face = face;
        this.suits = suits;
    }


    public Face getFace(){
        return face;
    }

    public Suits getSuits(){
        return suits;
    }


    /*
    * This implementation of comparable is for descending order, higher value card will come first
    * in the Collection.sort() method.
    * */
    @Override
    public int compareTo(Card otherCard) {
        //Integer.compares the list in natural order ascending but we need to make it descending order
        //so reversing the inputs to get descending order.

       return Integer.compare(otherCard.face.val, this.face.val);
    }


    @Override
    public String toString(){
        return "{" + face.toString() + ", "  + suits.toString() +"}" ;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
