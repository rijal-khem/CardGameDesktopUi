package com.rizal.ui.cardgame.cardgamedesktopui.controller;

import com.rizal.ui.cardgame.cardgamedesktopui.backend.card.CardShowUtility;
import com.rizal.ui.cardgame.cardgamedesktopui.backend.card.Constants;
import com.rizal.ui.cardgame.cardgamedesktopui.backend.card.FLushGame;
import com.rizal.ui.cardgame.cardgamedesktopui.backend.card.player.Player;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;


public class GameViewController implements Initializable {

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

    private Label  gameAmount;

    FLushGame fLushGame;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setGame();
        showData();
    }




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
        fLushGame= new FLushGame(players);
        imageViewUtility();
    }

    private void showFaceDownCard(){
       Image faceDownImg = CardShowUtility.cardShowforLocationString(Constants.IMAGE_LOCATION_PATH+Constants.LINUX_PATH_SEPARATOR+Constants.FACE_DOWN_CARD);

        System.out.println();
       for(Player player:players){
           player.getListImageView().forEach(imageView -> imageView.setImage(faceDownImg));
       }

    }

    public void play() {
        enableAllButton();
        clearPreviousCardsFromPlayers();
        play.setDisable(true);
        roundCountInt = roundCountInt+1;

        fLushGame.shuffleDeck();
        fLushGame.dealCardsToPlayers();
        showFaceDownCard();

    }

    private void enableAllButton() {
        showButtonPlayer.setDisable(false);
        blindButtonPlayer.setDisable(false);
        raisePlayerButton.setDisable(false);
        seeButtonPlayer.setDisable(false);
    }

    private void clearPreviousCardsFromPlayers() {
        fLushGame.clearPreviousCardsfromPlayers();
    }


    public void see(){
        cardViewForPlayer(userPlayer);
        blindButtonPlayer.setDisable(true);
    }

    public void show(){
        players.forEach(Player::sortHand);
        players.forEach(player->cardViewForPlayer(player));
        Player winnerPlayer = fLushGame.getWinner();
        fLushGame.updateScore(winnerPlayer);
        winnerName.setText(winnerPlayer.getName());
        showData();
        play.setDisable(false);

    }

    public void raise(){

        System.out.println("raise button hit");

    }

    public void fold(){
        showButtonPlayer.setDisable(true);
        blindButtonPlayer.setDisable(true);
        raisePlayerButton.setDisable(true);
        seeButtonPlayer.setDisable(true);
        winnerName.setText(computerPlayer.getName());
        computerPlayer.setScore(computerPlayer.getScore()+1);
        showData();
        play.setDisable(false);

        System.out.println("fold button hit");

    }

    public void blind(){
        System.out.println("blind button hit");

    }



    public void disPlayCards(){

    }


    private void  cardViewForPlayer(Player player){
        for(int i= 0; i<player.getHand().getCards().size();i++){
            player.getListImageView().get(i).setImage(CardShowUtility.cardShowforLocationString(player.getHand().getCards().get(i).getImageLocation()));
        }
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
