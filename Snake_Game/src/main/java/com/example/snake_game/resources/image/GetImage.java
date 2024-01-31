package com.example.snake_game.resources.image;

import javafx.scene.image.Image;

import java.io.File;

public class GetImage {
    public static Image getImage(String pathAbsolute){
        String relativePath = pathAbsolute;
        File file = new File(relativePath);
        String absolutePath = file.getAbsolutePath();
        Image image = new Image("file:///" + absolutePath);
        return image;
    }
}
