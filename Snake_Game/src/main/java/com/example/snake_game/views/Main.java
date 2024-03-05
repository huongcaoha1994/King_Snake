package com.example.snake_game.views;

import com.example.snake_game.models.UpdateCoin;
import javafx.application.Application;
import javafx.scene.Node;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        primaryStage.setScene(SceneLogin.login());
        primaryStage.show();


    }
}
