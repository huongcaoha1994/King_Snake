package com.example.snake_game.views;

import javafx.application.Application;
import javafx.stage.Stage;

public class Demo extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
       primaryStage.setScene(GuidePlayGame.guidePlay(primaryStage,4,"huongcaoha95"));
        primaryStage.setResizable(false);
       primaryStage.show();
    }
}