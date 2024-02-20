package com.example.snake_game.views;

import com.example.snake_game.utils.GetImage;
import com.example.snake_game.utils.MediaPlay;
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
        int height = 960 ;

        MediaPlay.playMusic("C:\\Users\\dell\\IdeaProjects\\King_Snake\\Snake_Game\\src\\main\\java\\com\\example\\snake_game\\resources\\music\\gameover.mp3");
        Image backgroundImage = GetImage.getImage("C:\\Users\\dell\\IdeaProjects\\King_Snake\\Snake_Game\\src\\main\\java\\com\\example\\snake_game\\resources\\image\\gameover.gif");
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
                    Stage stage = (Stage) ((Node) even.getSource()).getScene().getWindow();
                    stage.setScene(SceneGame1.game1(stage,username));
                    stage.show();
                    break;
                }
                case 2 : {
                    Stage stage = (Stage) ((Node) even.getSource()).getScene().getWindow();
                    stage.setScene(SceneGame2.game2(stage,username));
                    stage.show();
                    break;
                }
                case 3 : {
                    Stage stage = (Stage) ((Node) even.getSource()).getScene().getWindow();
                    stage.setScene(SceneGame3.game3(stage,username));
                    stage.show();
                    break;
                }
                case 4 : {
                    Stage stage = (Stage) ((Node) even.getSource()).getScene().getWindow();
                    stage.setScene(GameRank.gameRank(stage,username));
                    stage.show();
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
        AnchorPane.setBottomAnchor(buttonReplay, 200.0);
        AnchorPane.setLeftAnchor(buttonReplay, 350.0);


        AnchorPane.setBottomAnchor(buttonBackMain, 200.0);
        AnchorPane.setLeftAnchor(buttonBackMain, 800.0);


        // Thêm các button vào AnchorPane
        pane.getChildren().addAll(buttonReplay, buttonBackMain);

        // Tạo Scene với AnchorPane làm nội dung
        Scene scene = new Scene(pane, width, height);
        return scene ;
    }
}
