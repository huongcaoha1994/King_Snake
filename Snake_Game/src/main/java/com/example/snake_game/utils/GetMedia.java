package com.example.snake_game.utils;

import javafx.scene.image.Image;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;

public class GetMedia {
    public static Media getMedia(String pathAbsolute){
            String relativePath = pathAbsolute;
            File file = new File(relativePath);
            String absolutePath = file.getAbsolutePath();
            Media media = new Media(new File(absolutePath).toURI().toString());
            return media;
    }
}
