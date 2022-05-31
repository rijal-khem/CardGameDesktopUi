package com.rizal.ui.cardgame.cardgamedesktopui.controller;

import com.rizal.ui.cardgame.cardgamedesktopui.backend.card.player.Player;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import java.util.ArrayList;
import java.util.List;


public class GameViewController {

    @FXML
    private Button blindButtonPlayer;

    @FXML
    private Button seeButtonPlayer;

    @FXML
    private Button showButtonPlayer;

    @FXML
    private Button foldButtonPlayer;

    @FXML
    private Button raisePlayerButton;

    @FXML
    private Button play;

    @FXML
    private ImageView deckImage;

    @FXML
    private ImageView playerCard1;

    @FXML
    private ImageView playerCard2;

    @FXML
    private ImageView playerCard3;

    @FXML
    private ImageView computerCard1;

    @FXML
    private ImageView computerCard2;

    @FXML
    private ImageView computerCard3;

    @FXML
    private Label state;

    @FXML
    private Label roundCount;

    @FXML
    private Label playerScore;

    @FXML
    private Label computerScore;

    @FXML
    private Label player2Name;

    @FXML
    private Label player1Name;

    @FXML
    private Label winnerName;

    private int roundCountInt = 0;


    private Player userPlayer;
    private Player computerPlayer;

    private List<Player> players;
    private List<ImageView> playerCardImageViewNames;
    private List<ImageView> computerCardImageViewNames;





    private void showData(){
        roundCount.setText(String.valueOf(roundCountInt));
        playerScore.setText(String.valueOf(userPlayer.getScore()));
        computerScore.setText(String.valueOf(computerPlayer.getScore()));
        player2Name.setText(userPlayer.getName());
        player1Name.setText(computerPlayer.getName());
    }

    private void setGame(){
        userPlayer = new Player("Rizal");
        computerPlayer = new Player("Computer");
        players = new ArrayList<>();
        players.add(userPlayer);
        players.add(computerPlayer);


    }

    private void showFaceDownCard(){



    }

    public void play() {
        roundCountInt = roundCountInt+1;

    }




    public void see(){
        cardViewForPlayer(userPlayer);
        blindButtonPlayer.setDisable(true);
    }

    public void show(){

    }

    public void raise(){

        System.out.println("raise button hit");

    }

    public void fold(){
        System.out.println("fold button hit");

    }

    public void blind(){
        System.out.println("blind button hit");

    }



    public void disPlayCards(){

    }


    private void  cardViewForPlayer(Player player){



    }

    public void imageViewUtility(){
        playerCardImageViewNames= new ArrayList<>();
        playerCardImageViewNames.add(playerCard1);
        playerCardImageViewNames.add(playerCard2);
        playerCardImageViewNames.add(playerCard3);
        userPlayer.setListImageView(playerCardImageViewNames);

        computerCardImageViewNames= new ArrayList<>();
        computerCardImageViewNames.add(computerCard1);
        computerCardImageViewNames.add(computerCard2);
        computerCardImageViewNames.add(computerCard3);
        computerPlayer.setListImageView(computerCardImageViewNames);

    }


}
