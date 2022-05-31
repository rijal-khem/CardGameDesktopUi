package com.rizal.ui.cardgame.cardgamedesktopui.backend.card;

import javafx.scene.image.Image;

public class CardShowUtility {


    public static Image cardShowforFaceDownCard(String string){
        return cardShowforLocationString(string);
    }


    public static Image cardShowforLocationString(String string){
        return new Image(CardShowUtility.class.getResource(string).toString());
    }

}
