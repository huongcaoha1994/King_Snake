package com.example.snake_game.resources;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

public class Main extends Application {

    private MediaPlayer mediaPlayer;

    @Override
    public void start(Stage primaryStage) {
        // Tạo một nút để phát âm thanh
        Button playButton = new Button("Phát âm thanh");
        playButton.setOnAction(e -> playSound());

        // Tạo layout chứa nút
        StackPane root = new StackPane(playButton);
        Scene scene = new Scene(root, 300, 200);

        primaryStage.setTitle("Phát âm thanh trong JavaFX");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void playSound() {
        String soundPath = "file:///C:\\Users\\dell\\IdeaProjects\\King_Snake\\Snake_Game\\src\\main\\java\\com\\example\\snake_game\\resources\\music\\soundTrack.mp3";
        Media sound = new Media(soundPath);

        if (mediaPlayer != null) {
            mediaPlayer.stop();
        }

        mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.play();
    }

    public static void main(String[] args) {
        launch(args);
    }
}