package com.example.snake_game.views;

import com.example.snake_game.models.*;
import com.mongodb.client.FindIterable;
import javafx.application.Application;
import javafx.stage.Stage;
import org.bson.Document;

import java.util.List;

public class Demo extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
//       List<Integer> arr = GetListOutfit.getListOutfit("admin10");
//       for (Integer number : arr){
//           System.out.println(number);
//       }
        SceneMinigame sceneMinigame = new SceneMinigame();
        primaryStage.setScene(sceneMinigame.minigame());
        primaryStage.show();






    }
}