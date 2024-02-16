package com.example.snake_game.views;

import com.example.snake_game.utils.GetImage;
import com.example.snake_game.utils.MediaPlay;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.Stack;

public class GuidePlay {
    public static Scene guidePlay(Stage primaryStage ,int levelGame){
        int width = 1200 ;
        int height = 960;
        int sizeImage = 100 ;
        int fontSize = 20 ;
        Game1 game1 = new Game1();
        Game2 game2 = new Game2();
        Game3 game3 = new Game3();


        MediaPlay.playMusic("C:\\Users\\dell\\IdeaProjects\\King_Snake\\Snake_Game\\src\\main\\java\\com\\example\\snake_game\\resources\\music\\gameover.mp3");
        Image backgroundImage = GetImage.getImage("C:\\Users\\dell\\IdeaProjects\\King_Snake\\Snake_Game\\src\\main\\java\\com\\example\\snake_game\\resources\\image\\guideplay.jpeg");
        BackgroundImage background = new BackgroundImage(backgroundImage,
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT, new BackgroundSize(width, height, false, false, true, true));

        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(15));
        gridPane.setHgap(10);
        gridPane.setVgap(10);

        Text textGuide = new Text("\t \t \t \t Hướng Dẫn Chơi");
        textGuide.setFont(Font.font("Arial", 35));
        gridPane.add(textGuide,1,0);

        // Hình ảnh 1
        Image image1 = GetImage.getImage("C:\\Users\\dell\\IdeaProjects\\King_Snake\\Snake_Game\\src\\main\\java\\com\\example\\snake_game\\resources\\image\\hero.gif");
        ImageView imageView1 = new ImageView(image1);
        imageView1.setFitWidth(sizeImage);
        imageView1.setFitHeight(sizeImage);
        gridPane.add(imageView1, 0, 2);

        // Text 1
        Text text1 = new Text("Hero Area : Hero này hoạt động theo khu vực , khi rắn chạy vào khu vực của hero sẽ bị đuổi giết.");
        text1.setFont(Font.font("Arial", fontSize));
        gridPane.add(text1, 1, 2);

        // Hình ảnh 2
        Image image2 = GetImage.getImage("C:\\Users\\dell\\IdeaProjects\\King_Snake\\Snake_Game\\src\\main\\java\\com\\example\\snake_game\\resources\\image\\hero2.gif");
        ImageView imageView2 = new ImageView(image2);
        imageView2.setFitWidth(sizeImage);
        imageView2.setFitHeight(sizeImage);
        gridPane.add(imageView2, 0, 4);

        // Text 2
        Text text2 = new Text("Hero sát thủ : hero này sẽ đuổi theo rắn để giết trong suốt màn chơi .");
        text2.setFont(Font.font("Arial", fontSize));

        gridPane.add(text2, 1, 4);

        // Hình ảnh 3
        Image image3 = GetImage.getImage("C:\\Users\\dell\\IdeaProjects\\King_Snake\\Snake_Game\\src\\main\\java\\com\\example\\snake_game\\resources\\image\\snakegreen.gif");
        ImageView imageView3 = new ImageView(image3);
        imageView3.setFitWidth(sizeImage);
        imageView3.setFitHeight(sizeImage);
        gridPane.add(imageView3, 0, 6);

        // Text 3
        Text text3 = new Text("Snake : Đây là nhân vật người chơi sẽ điều khiển để chơi .");
        text3.setFont(Font.font("Arial", fontSize));
        gridPane.add(text3, 1, 6);

        // Hình ảnh 4
        Image image4 = GetImage.getImage("C:\\Users\\dell\\IdeaProjects\\King_Snake\\Snake_Game\\src\\main\\java\\com\\example\\snake_game\\resources\\image\\monsterEat.gif");
        ImageView imageView4 = new ImageView(image4);
        imageView4.setFitWidth(sizeImage);
        imageView4.setFitHeight(sizeImage);
        gridPane.add(imageView4, 0, 8);

        // Text 4
        Text text4 = new Text("Monster Eat : Quái vật này thường xuyên tìm và nhặt chìa khóa giấu đi .");
        text4.setFont(Font.font("Arial", fontSize));
        gridPane.add(text4, 1, 8);

        // Hình ảnh 5
        Image image5 = GetImage.getImage("C:\\Users\\dell\\IdeaProjects\\King_Snake\\Snake_Game\\src\\main\\java\\com\\example\\snake_game\\resources\\image\\monsterGun.jpg");
        ImageView imageView5 = new ImageView(image5);
        imageView5.setFitWidth(sizeImage);
        imageView5.setFitHeight(sizeImage);
        gridPane.add(imageView5, 0, 10);

        // Text 5
        Text text5 = new Text("Monster Gun : Quái vật này sẽ di chuyển về hướng snake và bắn súng , khi đạn trúng snake thì gameover.");
        text5.setFont(Font.font("Arial", fontSize));
        gridPane.add(text5, 1, 10);

        // Hình ảnh 6
        Image image6 = GetImage.getImage("C:\\Users\\dell\\IdeaProjects\\King_Snake\\Snake_Game\\src\\main\\java\\com\\example\\snake_game\\resources\\image\\key.gif");
        ImageView imageView6 = new ImageView(image6);
        imageView6.setFitWidth(sizeImage);
        imageView6.setFitHeight(sizeImage);
        gridPane.add(imageView6, 0, 12);

        // Text 6
        Text text6 = new Text("Key : Hãy thu thập đủ 15 chiếc chìa khóa này để qua màn chơi.");
        text6.setFont(Font.font("Arial", fontSize));
        gridPane.add(text6, 1, 12);

        // Hình ảnh 7
        Image image7 = GetImage.getImage("C:\\Users\\dell\\IdeaProjects\\King_Snake\\Snake_Game\\src\\main\\java\\com\\example\\snake_game\\resources\\image\\gatespace.jpg");
        ImageView imageView7 = new ImageView(image7);
        imageView7.setFitWidth(sizeImage);
        imageView7.setFitHeight(sizeImage);
        gridPane.add(imageView7, 0, 14);

        // TextField 7
        Text text7 = new Text("GateSpace : Chỉ xuất hiện khi bạn có đủ 15 key , đi vào nó để qua màn chơi.");
        text7.setFont(Font.font("Arial", fontSize));
        gridPane.add(text7, 1, 14);

        Button next = new Button("Đã hiểu");
        next.setOnAction(actionEvent -> {
            switch (levelGame){
                case 1 : {
                    game1.start(primaryStage);
                    break;
                }
                case 2 : {
                    game2.start(primaryStage);
                    break;
                }
                case 3 : {
                    game3.start(primaryStage);
                    break;
                }
            }
        });
        gridPane.add(next, 2, 16);

        gridPane.setBackground(new Background(background));
        Scene scene = new Scene(gridPane,width,height);
        return scene;

    }
}
