package com.example.snake_game.views;

import com.example.snake_game.utils.GetImage;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class SceneGameover2 extends Application {
    private static int width = 1200 ;
    private static int height = 960 ;
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
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
            Game2 game2 = new Game2();
            game2.start(primaryStage);
        });

        Button buttonBackMain = new Button("Main");
        buttonBackMain.setPrefWidth(100);
        buttonBackMain.setPrefHeight(40);
        buttonBackMain.setStyle("-fx-background-color: #c8ff00;");
        buttonBackMain.setOnAction(actionEvent -> {
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
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}
