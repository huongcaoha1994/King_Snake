package com.example.snake_game.views;

import com.example.snake_game.utils.GetImage;
import com.example.snake_game.utils.StringPathImage;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

public class GuideDisplay {
    public static Scene guideDisplay(){
        int width = 1200 ;
        int height = 780;

        Image backgroundImage = new Image(StringPathImage.guideDisplay_jpg());
        BackgroundImage background = new BackgroundImage(backgroundImage,
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT, new BackgroundSize(width, height, false, false, true, true));

        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(15));
        gridPane.setHgap(10);
        gridPane.setVgap(10);

        gridPane.setBackground(new Background(background));
        Scene scene = new Scene(gridPane,width,height);
        return scene;
    }
}
