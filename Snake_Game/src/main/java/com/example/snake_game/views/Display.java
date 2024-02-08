package com.example.snake_game.views;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Display extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/snake_game/display.fxml"));
        Parent root = fxmlLoader.load();

        Scene scene =new Scene(root, 800,500);
        scene.getStylesheets().add("file:C:/Users/dell/IdeaProjects/King_Snake/Snake_Game/src/main/java/com/example/snake_game/css/Style.css");

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
