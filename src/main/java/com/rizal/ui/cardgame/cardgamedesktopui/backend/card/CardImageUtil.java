package com.rizal.ui.cardgame.cardgamedesktopui.backend.card;

import java.util.Locale;

public class CardImageUtil {

    public static String getCardLocation(Card.Face face, Card.Suits suits){
        return  Constants.IMAGE_LOCATION_PATH
                + Constants.LINUX_PATH_SEPARATOR
                + getStringRepofCard(face, suits)
                +Constants.IMAGE_EXTENSION;
    }

    public static String getStringRepofCard(Card.Face face, Card.Suits suits){

        if(face.val<11){
            return face.val + Constants.CARD_NAME_SEPARATOR + suits.toString().toLowerCase(Locale.ROOT);
        }
        return face.toString().toLowerCase(Locale.ROOT) + Constants.CARD_NAME_SEPARATOR + suits.toString().toLowerCase(Locale.ROOT);
    }
}
