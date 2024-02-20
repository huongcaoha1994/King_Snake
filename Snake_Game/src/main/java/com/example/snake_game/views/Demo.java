package com.example.snake_game.views;

import com.example.snake_game.models.CheckUsernamePassword;
import com.example.snake_game.models.StringToHashCode;
import com.example.snake_game.models.UpdateScore;
import com.example.snake_game.models.UpdateUsername;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.UpdateResult;
import javafx.application.Application;
import javafx.stage.Stage;
import org.bson.Document;

import java.util.Calendar;
import java.util.Date;

public class Demo extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
//       primaryStage.setScene(SceneInformation.information());
//        primaryStage.setScene(GameRank.gameRank(primaryStage,"admin"));
//       primaryStage.show();
        UpdateScore.updateScore("thutrang1992",0);
    }
}
