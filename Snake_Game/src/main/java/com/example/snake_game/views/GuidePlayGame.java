package com.example.snake_game.views;

import com.example.snake_game.utils.GetImage;
import com.example.snake_game.utils.StringPathImage;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class GuidePlayGame {
    public static Scene guidePlay(Stage primaryStage ,int levelGame,String username){
        int width = 1200 ;
        int height = 780;
        int sizeImage = 60 ;
        int fontSize = 20 ;



        Image backgroundImage = new Image(StringPathImage.guidePlay_gif());
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
        Image image1 = new Image(StringPathImage.hero_gif());
        ImageView imageView1 = new ImageView(image1);
        imageView1.setFitWidth(sizeImage);
        imageView1.setFitHeight(sizeImage);
        gridPane.add(imageView1, 0, 2);

        // Text 1
        Text text1 = new Text("Hero Area : Hero này hoạt động theo khu vực , khi rắn chạy vào khu vực của hero sẽ bị đuổi giết.");
        text1.setFont(Font.font("Arial", fontSize));
        gridPane.add(text1, 1, 2);

        // Hình ảnh 2
        Image image2 = new Image(StringPathImage.hero2_gif());
        ImageView imageView2 = new ImageView(image2);
        imageView2.setFitWidth(sizeImage);
        imageView2.setFitHeight(sizeImage);
        gridPane.add(imageView2, 0, 4);

        // Text 2
        Text text2 = new Text("Hero sát thủ : hero này sẽ đuổi theo rắn để giết trong suốt màn chơi .");
        text2.setFont(Font.font("Arial", fontSize));

        gridPane.add(text2, 1, 4);

        // Hình ảnh 3
        Image image3 = new Image(StringPathImage.snakegreen_gif());
        ImageView imageView3 = new ImageView(image3);
        imageView3.setFitWidth(sizeImage);
        imageView3.setFitHeight(sizeImage);
        gridPane.add(imageView3, 0, 6);

        // Text 3
        Text text3 = new Text("Snake : Đây là nhân vật người chơi sẽ điều khiển để chơi .");
        text3.setFont(Font.font("Arial", fontSize));
        gridPane.add(text3, 1, 6);

        Image image4 = new Image(StringPathImage.monsterEat_gif());
        ImageView imageView4 = new ImageView(image4);
        imageView4.setFitWidth(sizeImage);
        imageView4.setFitHeight(sizeImage);
        gridPane.add(imageView4, 0, 8);

        // Text
        Text text4 = new Text("Monster Eat : Quái vật này sẽ đi cướp chi khóa và giấu đi chỗ khác .");
        text4.setFont(Font.font("Arial", fontSize));
        gridPane.add(text4, 1, 8);


        // Hình ảnh 4
        Image image5 = new Image(StringPathImage.monsterGun_gif());
        ImageView imageView5 = new ImageView(image5);
        imageView5.setFitWidth(sizeImage);
        imageView5.setFitHeight(sizeImage);
        gridPane.add(imageView5, 0, 10);

        // Text 4
        Text text5 = new Text("Monster Gun : Quái vật này sẽ di chuyển về hướng snake và bắn súng , khi đạn trúng snake thì gameover.");
        text5.setFont(Font.font("Arial", fontSize));
        gridPane.add(text5, 1, 10);

        // Hình ảnh 5
        Image image6 = new Image(StringPathImage.key_gif());
        ImageView imageView6 = new ImageView(image6);
        imageView6.setFitWidth(sizeImage);
        imageView6.setFitHeight(sizeImage);
        gridPane.add(imageView6, 0, 12);

        // Text 5
        Text text6 = new Text("Key : Hãy thu thập đủ 15 chiếc chìa khóa này để qua màn chơi.");
        text6.setFont(Font.font("Arial", fontSize));
        gridPane.add(text6, 1, 12);

        // Hình ảnh 6
        Image image7 = new Image(StringPathImage.gatespace_jpg());
        ImageView imageView7 = new ImageView(image7);
        imageView7.setFitWidth(sizeImage);
        imageView7.setFitHeight(sizeImage);
        gridPane.add(imageView7, 0, 14);

        // TextField 6
        Text text7 = new Text("GateSpace : Chỉ xuất hiện khi bạn có đủ 15 key , đi vào nó để qua màn chơi.");
        text7.setFont(Font.font("Arial", fontSize));
        gridPane.add(text7, 1, 14);

        // Hình ảnh 8
        Image image8 = new Image(StringPathImage.anh4phim_png());
        ImageView imageView8 = new ImageView(image8);
        imageView8.setFitWidth(sizeImage);
        imageView8.setFitHeight(sizeImage);
        gridPane.add(imageView8, 0, 16);

        // TextField 8
        Text text8 = new Text ("scroll key : Điều khiển rắn bằng 4 phím lên , xuống , trái , phải .");
        text8.setFont(Font.font("Arial", fontSize));
        gridPane.add(text8, 1, 16);

        Text task = new Text("=> Nhiệm vụ của bạn là phải thu thập đủ 15 chìa khóa rồi đi qua cánh cổng không gian để qua màn chơi");
        task.setFont(Font.font("Arial", fontSize));
        gridPane.add(task, 1, 18);

        Button next = new Button("Đã hiểu");
        next.setPrefSize(143, 50);
        next.setStyle("-fx-font-weight: bold; -fx-font-size: 23; -fx-background-color: linear-gradient(to right, #aa00ff, #FFFF00); -fx-background-radius: 15;");
        next.setEffect(new DropShadow());
        next.setOnAction(actionEvent -> {
            switch (levelGame){
                case 1 : {
                    primaryStage.setScene(SceneGame1.game1(primaryStage,username));
                    primaryStage.show();
                    break;
                }
                case 2 : {
                    primaryStage.setScene(SceneGame2.game2(primaryStage,username));
                    primaryStage.show();
                    break;
                }
                case 3 : {
                    primaryStage.setScene(SceneGame3.game3(primaryStage, username));
                    primaryStage.show();
                    break;
                }
                case 4 : {
                    primaryStage.setScene(GameRank.gameRank(primaryStage, username));
                    primaryStage.show();
                    break;
                }
                case 5 : {
                    primaryStage.setScene(SceneDisplay.display());
                    primaryStage.show();
                    break;
                }

            }
        });
        gridPane.add(next, 2, 18);

        gridPane.setBackground(new Background(background));
        Scene scene = new Scene(gridPane,width,height);
        return scene;

    }
}
