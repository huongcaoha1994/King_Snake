package com.example.snake_game.views;

import com.example.snake_game.controllers.LoginController;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class LoginDisplay extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/snake_game/login.fxml"));
        Parent root = loader.load();

        primaryStage.setTitle("snake");
        primaryStage.setScene(new Scene(root,800,600));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);

    }

}
