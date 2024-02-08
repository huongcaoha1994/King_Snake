package com.example.snake_game.views;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SceneInformation extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/snake_game/info.fxml"));
        Parent root = fxmlLoader.load();

        Scene scene =new Scene(root, 800,500);
        scene.getStylesheets().add("file:C:\\Users\\pc\\King_Snake\\Snake_Game\\src\\main\\java\\com\\example\\snake_game\\css\\information.css");

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
