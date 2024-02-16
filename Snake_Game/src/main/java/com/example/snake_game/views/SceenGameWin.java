package com.example.snake_game.views;

import com.example.snake_game.utils.GetImage;
import com.example.snake_game.utils.MediaPlay;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class SceenGameWin {
    public static Scene WinGame(Stage primaryStage,int levelGame){
        int width = 1200 ;
        int height = 960 ;
        Game1 game1 = new Game1();
        Game2 game2 = new Game2();
        Game3 game3 = new Game3();
        MediaPlay.playMusic("C:\\Users\\dell\\IdeaProjects\\King_Snake\\Snake_Game\\src\\main\\java\\com\\example\\snake_game\\resources\\music\\wingame.mp3");
        Image backgroundImage = GetImage.getImage("C:\\Users\\dell\\IdeaProjects\\King_Snake\\Snake_Game\\src\\main\\java\\com\\example\\snake_game\\resources\\image\\winner1.gif");
        BackgroundImage background = new BackgroundImage(backgroundImage,
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT, new BackgroundSize(width, height, false, false, true, true));

        // Tạo Button
        Button buttonReplay = new Button("RePlay");
        buttonReplay.setPrefWidth(100);
        buttonReplay.setPrefHeight(40);
        buttonReplay.setStyle("-fx-background-color: #c8ff00;");
        buttonReplay.setOnAction(even -> {
            switch (levelGame){
                case 1 : {
                    game1.start(primaryStage);
                    break;
                }
                case 2 : {
                    game2.start(primaryStage);
                    break;
                }
                case 3 : {
                    game3.start(primaryStage);
                    break;
                }
            }
        });

        Button buttonBackMain = new Button("Main");
        buttonBackMain.setPrefWidth(100);
        buttonBackMain.setPrefHeight(40);
        buttonBackMain.setStyle("-fx-background-color: #c8ff00;");
        buttonBackMain.setOnAction(actionEvent -> {
            // chuyển scene về main tại đây
        });

        Button buttonNext = new Button("Next");
        buttonNext.setPrefWidth(100);
        buttonNext.setPrefHeight(40);
        buttonNext.setStyle("-fx-background-color: #c8ff00;");
        buttonNext.setOnAction(actionEvent -> {
            switch (levelGame){
                case 1 : {
                    game2.start(primaryStage);
                    break;
                }
                case 2 : {
                    game3.start(primaryStage);
                    break;
                }
                case 3 : {
                    System.out.println("Coming soon");
                    break;
                }
            }
        });

        // Tạo AnchorPane
        AnchorPane pane = new AnchorPane();
        pane.setPadding(new Insets(10));
        pane.setBackground(new Background(background));

        // Đặt vị trí và kích thước cho các button
        AnchorPane.setBottomAnchor(buttonReplay, 100.0);
        AnchorPane.setLeftAnchor(buttonReplay, 250.0);


        AnchorPane.setBottomAnchor(buttonBackMain, 100.0);
        AnchorPane.setLeftAnchor(buttonBackMain, width / 2 - buttonBackMain.getWidth() / 2-50);

        AnchorPane.setBottomAnchor(buttonNext, 100.0);
        AnchorPane.setRightAnchor(buttonNext, 200.0);

        // Thêm các button vào AnchorPane
        pane.getChildren().addAll(buttonReplay, buttonBackMain, buttonNext);

        // Tạo Scene với AnchorPane làm nội dung
        Scene scene = new Scene(pane, width, height);
        return  scene ;
    }
}
