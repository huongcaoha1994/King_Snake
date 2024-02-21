package com.example.snake_game.views;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        LoginDisplay loginDisplay = new LoginDisplay();
        primaryStage.setResizable(false);
        loginDisplay.start(primaryStage);
    }
}
