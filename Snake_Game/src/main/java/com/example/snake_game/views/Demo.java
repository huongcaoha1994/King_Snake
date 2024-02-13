package com.example.snake_game.views;

import com.example.snake_game.dao.MongoDBConnection;
import com.example.snake_game.models.*;
import javafx.application.Application;
import javafx.stage.Stage;

public class Demo extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        System.out.println(CheckUsernamePassword.checkUsernamePassword("nguyenthutrang","123456789"));

    }
}
