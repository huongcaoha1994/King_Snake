package com.example.snake_game.views;

import com.example.snake_game.utils.GetMedia;
import com.example.snake_game.utils.MediaPlay;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.File;
import java.util.Timer;
import java.util.TimerTask;

public class MusicPlayer extends Application {

    private static final String MUSIC_FILE_PATH = "C:\\Users\\dell\\IdeaProjects\\King_Snake\\Snake_Game\\src\\main\\java\\com\\example\\snake_game\\resources\\music\\lady-of-the-80x27s-128379.mp3";
    private static final String IMAGE_FILE_PATH = "C:\\Users\\dell\\IdeaProjects\\King_Snake\\Snake_Game\\src\\main\\java\\com\\example\\snake_game\\resources\\image\\logo.jpg";

    @Override
    public void start(Stage primaryStage) {
        Canvas canvas = new Canvas(400, 400);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        StackPane root = new StackPane();
        root.getChildren().add(canvas);

        Scene scene = new Scene(root, 400, 400);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Music Player");
        primaryStage.show();


        Timer backgroundMusic = new Timer();
        backgroundMusic.schedule(new TimerTask() {
            @Override
            public void run() {
//                Media media = GetMedia.getMedia("C:\\Users\\dell\\IdeaProjects\\King_Snake\\Snake_Game\\src\\main\\java\\com\\example\\snake_game\\resources\\music\\backgroundMusic.mp3");
//                MediaPlayer mediaPlayer = new MediaPlayer(media);
//                mediaPlayer.setAutoPlay(true);
//                mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
//                mediaPlayer.play();
                MediaPlay.playMusic("C:\\Users\\dell\\IdeaProjects\\King_Snake\\Snake_Game\\src\\main\\java\\com\\example\\snake_game\\resources\\music\\lady-of-the-80x27s-128379.mp3");
            }
        },0,10000);

        // Vẽ nền
        gc.setFill(Color.BLACK);
        gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());

        // Hiển thị hình ảnh
        Image image = new Image(new File(IMAGE_FILE_PATH).toURI().toString());
        gc.drawImage(image, 0, 0, canvas.getWidth(), canvas.getHeight());
    }

    private void playMusic(String filePath) {
        Media media = new Media(new File(filePath).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setAutoPlay(true);
    }

    public static void main(String[] args) {
        launch(args);
    }
}