package com.rizal.ui.cardgame.cardgamedesktopui.backend.card;

import java.util.Comparator;

/**
 * This is for comparing flush hands of player
 * */
public class FlushHandComparator implements Comparator<Hand> {
    @Override
    public int compare(Hand o1, Hand o2) {

        if(o1.isTrail() && o2.isTrail()){
            return trailCompare(o1,o2);
        }else if(o1.isDoubleRun() && o2.isDoubleRun()){
            return doubleRunCompare(o1, o2);
        }else if (o1.isRun() && o2.isRun() && !o1.isDoubleRun() && !o2.isDoubleRun() ){
            return runCompare(o1,o2);
        }else if(o1.isSameColor() && o2.isSameColor() && !o1.isRun() && !o2.isRun()){
            return colorCompare(o1,o2);
        }else if (o1.isPair() && o2.isPair()){
           return  pairCompare(o1, o2);
        }
        else if(o1.isTop() && o2.isTop()){
            return topCompare(o1,o2);
        }else if (o1.isTrail() && !o2.isTrail()){
            return -1;
        }else if(o1.isDoubleRun() && !o2.isTrail() && !o2.isDoubleRun()){
            return -1;
        }else if(o1.isRun()&& !o2.isTrail() && !o2.isDoubleRun() && !o2.isRun()){
            return -1;
        }else if(o1.isSameColor() && !o2.isTrail() && !o2.isDoubleRun() && !o2.isRun() && !o2.isSameColor()){
            return -1;
        }else if (o1.isPair() && !o2.isTrail() && !o2.isDoubleRun() && !o2.isRun() && !o2.isSameColor() && !o2.isPair()){
            return -1;
        }
        return 1;
    }

    public int trailCompare(Hand o1, Hand o2){
        if(o1.getCards().get(0).getFace().ordinal()>o2.getCards().get(1).getFace().ordinal())
            return -1;
        return 1;
    }

    public int doubleRunCompare(Hand o1, Hand o2){
        if(o1.getCards().get(2).getFace().ordinal() > o2.getCards().get(2).getFace().ordinal())
            return -1;
        else if(o1.getCards().get(2).getFace().ordinal() == o2.getCards().get(2).getFace().ordinal() && o1.getCards().get(2).getSuits().equals(Card.Suits.SPADES))
            return -1;
        else if(o1.getCards().get(2).getFace().ordinal() == o2.getCards().get(2).getFace().ordinal() && !o1.getCards().get(2).getSuits().equals(Card.Suits.SPADES) && !o1.getCards().get(2).getSuits().equals(Card.Suits.SPADES))
            return 0;
        return 1;
    }

    public int runCompare(Hand o1, Hand o2){
        if(o1.getCards().get(2).getFace().ordinal() > o2.getCards().get(2).getFace().ordinal()){
            return -1;
        }else if(o1.getCards().get(2).getFace().ordinal() == o2.getCards().get(2).getFace().ordinal()){
            return 0;
        }
        return 1;
    }

    public int colorCompare(Hand o1, Hand o2){
        if(o1.getCards().get(2).getFace().ordinal()>o2.getCards().get(2).getFace().ordinal()){
            return -1;
        }else if(o1.getCards().get(2).getFace().ordinal()==o2.getCards().get(2).getFace().ordinal()){
            if(o1.getCards().get(1).getFace().ordinal()==o2.getCards().get(1).getFace().ordinal()){
                if(o1.getCards().get(0).getFace().ordinal()==o2.getCards().get(1).getFace().ordinal()){
                    if(o1.getCards().get(2).getSuits().equals(Card.Suits.SPADES)){
                        return -1;
                    }else if(o2.getCards().get(2).getSuits().equals(Card.Suits.SPADES)){
                        return 1;
                    }else return 0;

                }else if(o1.getCards().get(0).getFace().ordinal()>o2.getCards().get(1).getFace().ordinal()){
                    return -1;
                } else  return 1;
            } else if(o1.getCards().get(1).getFace().ordinal()>o2.getCards().get(1).getFace().ordinal()){
                return -1;
            } else  return 1;
        }

        return 1;
    }

    public int pairCompare(Hand o1, Hand o2){

        if(o1.pairReturn().val>o2.pairReturn().val){
            return -1;
        }else if(o1.pairReturn().val == o2.pairReturn().val){
            return equalPairCompareHighTop(o1,o2);
        }
        return 1;

    }


    public int topCompare(Hand o1, Hand o2) {

        for(int i=0;i<3;i++){
            if(o1.getCards().get(i).getFace().val>o2.getCards().get(i).getFace().val){
                return -1;
            }
        }
        return 1;
    }

    public int equalPairCompareHighTop(Hand o1, Hand o2){

        for(int i=0;i<3;i++){
            if(o1.getCards().get(i).getFace().val>o2.getCards().get(i).getFace().val){
                return -1;
            }
        }
        return 1;
    }
}
