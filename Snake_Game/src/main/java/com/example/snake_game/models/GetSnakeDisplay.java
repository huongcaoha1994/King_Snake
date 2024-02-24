package com.example.snake_game.models;

import com.example.snake_game.utils.StringPathImage;
import javafx.scene.image.Image;

public class GetSnakeDisplay {
    public static Image getImageSnakeDisplay(int skin){
        Image image1 = new Image(StringPathImage.ff_gif());
        Image image2 = new Image(StringPathImage.image2_gif());
        Image image3 = new Image(StringPathImage.image3_gif());
        Image image4 = new Image(StringPathImage.image4_gif());
        Image image5 = new Image(StringPathImage.image5_gif());
        Image image = null;
        switch (skin){
            case 1 : {
                image = image1 ;
                break;
            }
            case 2 : {
                image = image2 ;
                break;
            }
            case 3 : {
                image = image3 ;
                break;
            }
            case 4 : {
                image = image4 ;
                break;
            }
            case 5 : {
                image = image5 ;
                break;
            }
        }
        return image;
    }
}
