package com.example.snake_game.views;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Display extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("display.fxml"));
        Parent root = loader.load();
        primaryStage.setScene(new Scene(root, 850 ,600));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}