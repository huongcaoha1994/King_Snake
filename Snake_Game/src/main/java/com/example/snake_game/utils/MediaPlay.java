package com.example.snake_game.utils;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;

public class MediaPlay {

    public static void playMusic(String pathAbsolute) {

        Media media = new Media(new File(pathAbsolute).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setAutoPlay(true);
        mediaPlayer.play();
    }
}
