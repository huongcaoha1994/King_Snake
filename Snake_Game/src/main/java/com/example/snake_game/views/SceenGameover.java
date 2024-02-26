package com.example.snake_game.views;

import com.example.snake_game.utils.GetImage;
import com.example.snake_game.utils.MediaPlay;
import com.example.snake_game.utils.StringPathImage;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class SceenGameover {
    public static Scene SceneClose(Stage primaryStage ,int gameLevel,String username){
        int width = 1200;
        int height = 780 ;

        MediaPlay.playMusic("C:\\Users\\dell\\IdeaProjects\\King_Snake\\Snake_Game\\src\\main\\java\\com\\example\\snake_game\\resources\\music\\gameover.mp3");
        Image backgroundImage = new Image(StringPathImage.gameover_gif());
        BackgroundImage background = new BackgroundImage(backgroundImage,
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT, new BackgroundSize(width, height, false, false, true, true));

        // Tạo Button
        Button buttonReplay = new Button("RePlay");
        buttonReplay.setPrefWidth(100);
        buttonReplay.setPrefHeight(40);
        buttonReplay.setStyle("-fx-background-color: #c8ff00;");
        buttonReplay.setOnAction(even -> {
            switch (gameLevel){
                case 1 : {
                    primaryStage.setScene(SceneGame1.game1(primaryStage,username));
                    primaryStage.show();
                    break;
                }
                case 2 : {
                    primaryStage.setScene(SceneGame2.game2(primaryStage,username));
                    primaryStage.show();
                    break;
                }
                case 3 : {
                    primaryStage.setScene(SceneGame3.game3(primaryStage,username));
                    primaryStage.show();
                    break;
                }
                case 4 : {
                    primaryStage.setScene(GameRank.gameRank(primaryStage,username));
                    primaryStage.show();
                    break;
                }


            }
        });

        Button buttonBackMain = new Button("Main");
        buttonBackMain.setPrefWidth(100);
        buttonBackMain.setPrefHeight(40);
        buttonBackMain.setStyle("-fx-background-color: #c8ff00;");
        buttonBackMain.setOnAction(actionEvent -> {
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setScene(SceneDisplay.display());
            stage.show();
            // chuyển scene về main tại đây
        });



        // Tạo AnchorPane
        AnchorPane pane = new AnchorPane();
        pane.setPadding(new Insets(10));
        pane.setBackground(new Background(background));

        // Đặt vị trí và kích thước cho các button
        AnchorPane.setBottomAnchor(buttonReplay, 100.0);
        AnchorPane.setLeftAnchor(buttonReplay, 350.0);


        AnchorPane.setBottomAnchor(buttonBackMain, 100.0);
        AnchorPane.setLeftAnchor(buttonBackMain, 800.0);


        // Thêm các button vào AnchorPane
        pane.getChildren().addAll(buttonReplay, buttonBackMain);

        // Tạo Scene với AnchorPane làm nội dung
        Scene scene = new Scene(pane, width, height);
        return scene ;
    }
}
