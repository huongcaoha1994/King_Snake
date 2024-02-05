package com.example.snake_game.utils;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;

public class MediaPlay {

    public static void playMusic(String pathAbsolute) {
        String relativePath = pathAbsolute;
        File file = new File(relativePath);
        String absolutePath = file.getAbsolutePath();
        Media media = new Media(new File(absolutePath).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setAutoPlay(true);

    }
}
