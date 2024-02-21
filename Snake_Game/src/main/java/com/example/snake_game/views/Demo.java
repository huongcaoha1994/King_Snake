package com.example.snake_game.views;

import com.example.snake_game.models.GetTop10User;
import com.mongodb.client.FindIterable;
import javafx.application.Application;
import javafx.stage.Stage;
import org.bson.Document;

public class Demo extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
       primaryStage.setScene(SceneRank.sceneRank());
        primaryStage.setResizable(false);
       primaryStage.show();


    }
}