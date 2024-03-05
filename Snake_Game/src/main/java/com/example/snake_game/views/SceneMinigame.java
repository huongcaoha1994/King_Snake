package com.example.snake_game.views;

import com.example.snake_game.models.Alert;
import com.example.snake_game.models.GetCoin;
import com.example.snake_game.models.UpdateCoin;
import com.example.snake_game.utils.StringPathImage;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class SceneMinigame {
    public static Image getImageBoss(int selectBoss){
        Image boss = null;
        switch (selectBoss){
            case 1 : {
                boss = new Image(StringPathImage.la_jpg());
                break;
            }
            case 2 : {
                boss = new Image(StringPathImage.keo_jpg());
                break;
            }
            case 3 : {
                boss = new Image(StringPathImage.bua_jpg());
                break;
            }
            default: {
                boss = new Image(StringPathImage.hopbian_png());
            }
        }
        return boss ;
    }


    //    public void restart(){
//        coinUser = GetCoin.coin(username);
//
//        selectUser = 0 ;
//        monneyOrder = 0 ;
//    }
    public static String username;
    public static int dataSelectUser ;
    public static int dataSelectBoss;
    public static boolean dataStatusGame;
    public void setData(int selectUser , int selectBoss , boolean statusGame,String username){
        this.dataSelectUser = selectUser ;
        this.dataSelectBoss = selectBoss ;
        this.dataStatusGame = statusGame ;
        this.username = username ;
    }
    public Scene minigame(){
         int width = 1200 ;
         int height = 780;
         int sizeImage = 80 ;
         IntegerProperty coinUser = new SimpleIntegerProperty();
        coinUser.set(GetCoin.coin(username));
         AtomicInteger selectUser = new AtomicInteger(dataSelectUser);
        AtomicInteger selectBoss = new AtomicInteger(dataSelectBoss);
         AtomicInteger monneyOrder = new AtomicInteger();
         AtomicInteger newCoin = new AtomicInteger();
         AtomicBoolean statusGame = new AtomicBoolean(dataStatusGame);
        Random random = new Random();


        String numberCoin = "Coin : "+ coinUser.get() ;

        ImageView optionLa = new ImageView(new Image(StringPathImage.la_jpg()));
        optionLa.setFitWidth(sizeImage);
        optionLa.setFitHeight(sizeImage);

        ImageView optionKeo = new ImageView(new Image(StringPathImage.keo_jpg()));
        optionKeo.setFitWidth(sizeImage);
        optionKeo.setFitHeight(sizeImage);

        ImageView optionBua = new ImageView(new Image(StringPathImage.bua_jpg()));
        optionBua.setFitWidth(sizeImage);
        optionBua.setFitHeight(sizeImage);

        Image backgroundImage = new Image(StringPathImage.minigame_jpg());
        BackgroundImage background = new BackgroundImage(backgroundImage,
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT, new BackgroundSize(width, height, false, false, true, true));

        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(15));
        gridPane.setHgap(0);
        gridPane.setVgap(0);

        Button shop = new Button("Game Oẳn Tù Tì");
        shop.setPrefSize(450, 100);
        shop.setStyle("-fx-font-weight: bold; -fx-font-size: 40; -fx-background-color: transparent; -fx-text-fill: #ffb700;");
        shop.setEffect(new DropShadow());
        gridPane.add(shop, 2, 0);

        Button coin = new Button(numberCoin);
        coin.setPrefSize(350, 100);
        coin.setStyle("-fx-font-weight: bold; -fx-font-size: 20; -fx-background-color: transparent; -fx-text-fill: #c8ff00;");
        coin.setEffect(new DropShadow());
        gridPane.add(coin, 2, 1);

        HBox hBox1 = new HBox();
        // lựa chọn của boss
        Image image1 = getImageBoss(selectBoss.get());
        ImageView imageBoss = new ImageView(image1);
        imageBoss.setFitWidth(sizeImage);
        imageBoss.setFitHeight(sizeImage);


        //label "Boss"
        Button boss = new Button("Boss");
        boss.setPrefSize(150, 100);
        boss.setStyle("-fx-font-weight: bold; -fx-font-size: 40; -fx-background-color: transparent; -fx-text-fill: #c8ff00;");
        boss.setEffect(new DropShadow());

        hBox1.getChildren().addAll(imageBoss,boss);
        gridPane.add(hBox1,3,2);

        Button vs = new Button("VS");
        vs.setPrefSize(150, 100);
        vs.setStyle("-fx-font-weight: bold; -fx-font-size: 40; -fx-background-color: transparent; -fx-text-fill: #c8ff00;");
        vs.setEffect(new DropShadow());
        gridPane.add(vs, 3, 3);

        HBox hBox2 = new HBox();
        //lựa chọn của User
        Image image2 = getImageBoss(selectUser.get());
        ImageView imageUser = new ImageView(image2);
        imageUser.setFitWidth(sizeImage);
        imageUser.setFitHeight(sizeImage);


        //label user
        Button user = new Button("You");
        user.setPrefSize(150, 100);
        user.setStyle("-fx-font-weight: bold; -fx-font-size: 40; -fx-background-color: transparent; -fx-text-fill: #c8ff00;");
        user.setEffect(new DropShadow());

        hBox2.getChildren().addAll(imageUser,user);
        gridPane.add(hBox2,3,4);

        HBox hBox3 = new HBox();
        Button option1 = new Button();
        option1.setGraphic(optionLa);
        option1.setOnAction(event -> {
            //chọn lá
            selectUser.set(1);
            imageUser.setImage(new Image(StringPathImage.la_jpg()));
        });


        Button option2 = new Button();
        option2.setGraphic(optionKeo);
        option2.setOnAction(event -> {
            // chọn kéo
            selectUser.set(2);
            imageUser.setImage(new Image(StringPathImage.keo_jpg()));
        });


        Button option3 = new Button();
        option3.setGraphic(optionBua);
        option3.setOnAction(event -> {
            // chọn búa
            selectUser.set(3);
            imageUser.setImage(new Image(StringPathImage.bua_jpg()));
        });

        hBox3.getChildren().addAll(option1,option2,option3);
        gridPane.add(hBox3,3,5);


        Button order = new Button("Đặt cược");
        order.setPrefSize(200, 100);
        order.setStyle("-fx-font-weight: bold; -fx-font-size: 30; -fx-background-color: transparent; -fx-text-fill: #ff0900;");
        order.setEffect(new DropShadow());
        gridPane.add(order, 3, 6);


        HBox hBox4 = new HBox();
        Button od1000 = new Button("1000");
        od1000.setOnAction(event -> {
            //đặt cược 1000
            if(coinUser.get() < 1000){
                Alert.alert("Not enough money");
            }
            else {
                monneyOrder.set(1000);
            }
        });


        Button od1500 = new Button("1500");
        od1500.setOnAction(event -> {
            // đặt cược 1500
            if(coinUser.get() < 1500){
                Alert.alert("Not enough money");
            }
            else {
                monneyOrder.set(1500);
            }

        });


        Button od2000 = new Button("2000");
        od2000.setOnAction(event -> {
            // đặt cược 2000
            if(coinUser.get() < 2000){
                Alert.alert("Not enough money");
            }
            else {
                monneyOrder.set(2000);
            }
        });

        Button od2500 = new Button("2500");
        od2500.setOnAction(event -> {
            // đặt cược 2500
            if(coinUser.get() < 2500){
                Alert.alert("Not enough money");
            }
            else {
                monneyOrder.set(2500);
            }
        });

        Button od3000 = new Button("3000");
        od3000.setOnAction(event -> {
            // đặt cược 3000
            if(coinUser.get() < 3000){
                Alert.alert("Not enough money");
            }
            else {
                monneyOrder.set(3000);
            }
        });

        Button odAll = new Button("Tất tay");
        odAll.setOnAction(event -> {
            // đặt cược tất tay
            if(coinUser.get() < 1){
                Alert.alert("Not enough money");
            }
            else {
                monneyOrder.set(coinUser.get());
            }
        });

        hBox4.getChildren().addAll(od1000,od1500,od2000,od2500,od3000,odAll);
        gridPane.add(hBox4,3,7);

        Button next = new Button("Back");
        next.setPrefSize(143, 50);
        next.setStyle("-fx-font-weight: bold; -fx-font-size: 23; -fx-background-color: linear-gradient(to right, #fffb00, #00a6ff); -fx-background-radius: 15;");
        next.setEffect(new DropShadow());
        next.setOnAction(actionEvent -> {
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setScene(SceneDisplay.display());
            stage.show();
        });
        gridPane.add(next, 2, 7);

        Button play = null;
            if(statusGame.get()){
                play = new Button("Play");
                play.setPrefSize(143, 50);
                play.setStyle("-fx-font-weight: bold; -fx-font-size: 23; -fx-background-color: linear-gradient(to right, #fffb00, #d51111); -fx-background-radius: 15;");
                play.setEffect(new DropShadow());
                play.setOnAction(actionEvent -> {
                    // xử lý trò chơi
                    if(monneyOrder.get() == 0){
                        Alert.alert("Please order money !");
                    } else if (selectUser.get() == 0) {
                        Alert.alert("Please select option !");
                    } else {
                        selectBoss.set(random.nextInt(3) + 1);
                        imageBoss.setImage(getImageBoss(selectBoss.get()));
                        int rs = result(selectBoss.get(), selectUser.get());
                        switch (rs){
                            case 1 : {
                                Alert.alert("You Win : " + monneyOrder.get());
                                newCoin.set(coinUser.get() + monneyOrder.get());
                                coinUser.set(GetCoin.coin(username));
                                UpdateCoin.updateCoin(username, newCoin.get());
                                break;

                            }
                            case 2 : {
                                Alert.alert("You Lose : " + monneyOrder.get());
                                newCoin.set(coinUser.get() - monneyOrder.get());
                                coinUser.set(GetCoin.coin(username));
                                UpdateCoin.updateCoin(username, newCoin.get());
                                break;
                            }
                            case 3 : {
                                Alert.alert("Hòa !");
                                break;
                            }
                        }
                        statusGame.set(false);
                        SceneMinigame sceneMinigame = new SceneMinigame();
                        sceneMinigame.setData(selectUser.get(),selectBoss.get(), statusGame.get(),username);
                        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                        stage.setScene(this.minigame());
                        stage.show();


                    }
                });
            }else {
                play = new Button("Replay");
                play.setPrefSize(143, 50);
                play.setStyle("-fx-font-weight: bold; -fx-font-size: 23; -fx-background-color: linear-gradient(to right, #fffb00, #d51111); -fx-background-radius: 15;");
                play.setEffect(new DropShadow());
                play.setOnAction(event -> {
                    statusGame.set(true);
                    selectUser.set(0);
                    selectBoss.set(0);
                    SceneMinigame sceneMinigame = new SceneMinigame();
                    sceneMinigame.setData(selectUser.get(),selectBoss.get(), statusGame.get(),username);
                    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    stage.setScene(this.minigame());
                    stage.show();

                });
            }

        gridPane.add(play, 4, 7);

        gridPane.setBackground(new Background(background));
        Scene scene = new Scene(gridPane,width,height);
        return scene;
    }

    public static int result(int selectBoss, int selectUser){
        int rs = 1 ;
        if(selectBoss == selectUser){
            rs = 3 ;
        } else if (selectBoss == 1 && selectUser == 3) {
            rs = 2 ;

        } else if (selectBoss == 2 && selectUser == 1) {
            rs = 2;

        } else if (selectBoss == 3 && selectUser == 2) {
            rs = 2 ;

        }
        return rs ;
    }
}
