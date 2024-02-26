package com.example.snake_game.views;

import com.example.snake_game.models.GetCoin;
import com.example.snake_game.models.SetButtonBuy;
import com.example.snake_game.utils.GetImage;
import com.example.snake_game.utils.StringPathImage;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class SceneShop {
    public static String username ;
    public void setUsername(String username){
        this.username = username ;
    }
    public static Scene shop(String username){
        int width = 1200 ;
        int height = 780;
        int sizeImage = 225 ;
        int fontSize = 20 ;
        int coinNumber = GetCoin.coin(username);
        String numberCoin = "Coin : "+ coinNumber ;
        Image backgroundImage = new Image(StringPathImage.shop_gif());
        BackgroundImage background = new BackgroundImage(backgroundImage,
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT, new BackgroundSize(width, height, false, false, true, true));

        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(15));
        gridPane.setHgap(10);
        gridPane.setVgap(10);


        Button shop = new Button("Shop");
        shop.setPrefSize(150, 100);
        shop.setStyle("-fx-font-weight: bold; -fx-font-size: 40; -fx-background-color: transparent; -fx-text-fill: #c8ff00;");
        shop.setEffect(new DropShadow());
        gridPane.add(shop, 2, 0);

        Button coin = new Button(numberCoin);
        coin.setPrefSize(150, 100);
        coin.setStyle("-fx-font-weight: bold; -fx-font-size: 20; -fx-background-color: transparent; -fx-text-fill: #c8ff00;");
        coin.setEffect(new DropShadow());
        gridPane.add(coin, 0, 1);


        // Hình ảnh 1
        Image image1 = new Image(StringPathImage.ff_gif());
        ImageView imageView1 = new ImageView(image1);
        imageView1.setFitWidth(sizeImage);
        imageView1.setFitHeight(sizeImage);
        gridPane.add(imageView1, 0, 3);

        // Hình ảnh 2
        Image image2 = new Image(StringPathImage.image2_gif());
        ImageView imageView2 = new ImageView(image2);
        imageView2.setFitWidth(sizeImage);
        imageView2.setFitHeight(sizeImage);
        gridPane.add(imageView2, 1, 3);

        // Hình ảnh 3
        Image image3 = new Image(StringPathImage.image3_gif());
        ImageView imageView3 = new ImageView(image3);
        imageView3.setFitWidth(sizeImage);
        imageView3.setFitHeight(sizeImage);
        gridPane.add(imageView3, 2, 3);

        // Hình ảnh 4
        Image image4 = new Image(StringPathImage.image4_gif());
        ImageView imageView4 = new ImageView(image4);
        imageView4.setFitWidth(sizeImage);
        imageView4.setFitHeight(sizeImage);
        gridPane.add(imageView4, 3, 3);

        // Hình ảnh 5
        Image image5 = new Image(StringPathImage.image5_gif());
        ImageView imageView5 = new ImageView(image5);
        imageView5.setFitWidth(sizeImage);
        imageView5.setFitHeight(sizeImage);
        gridPane.add(imageView5, 4, 3);

        Button name1 = new Button("Snake Classic");
        name1.setPrefSize(150, 100);
        name1.setStyle("-fx-font-weight: bold; -fx-font-size: 20; -fx-background-color: transparent; -fx-text-fill: #00a6ff;");
        name1.setEffect(new DropShadow());
        gridPane.add(name1, 0, 4);

        Button name2 = new Button("Unicorn Red");
        name2.setPrefSize(150, 100);
        name2.setStyle("-fx-font-weight: bold; -fx-font-size: 20; -fx-background-color: transparent; -fx-text-fill: #00a6ff;");
        name2.setEffect(new DropShadow());
        gridPane.add(name2, 1, 4);

        Button name3 = new Button("Turtle Green");
        name3.setPrefSize(150, 100);
        name3.setStyle("-fx-font-weight: bold; -fx-font-size: 20; -fx-background-color: transparent; -fx-text-fill: #00a6ff;");
        name3.setEffect(new DropShadow());
        gridPane.add(name3, 2, 4);

        Button name4 = new Button("Unicorn King");
        name4.setPrefSize(150, 100);
        name4.setStyle("-fx-font-weight: bold; -fx-font-size: 20; -fx-background-color: transparent; -fx-text-fill: #00a6ff;");
        name4.setEffect(new DropShadow());
        gridPane.add(name4, 3, 4);

        Button name5 = new Button("Unicorn Special");
        name5.setPrefSize(150, 100);
        name5.setStyle("-fx-font-weight: bold; -fx-font-size: 20; -fx-background-color: transparent; -fx-text-fill: #00a6ff;");
        name5.setEffect(new DropShadow());
        gridPane.add(name5, 4, 4);

        Button price1 = new Button("1000 coin");
        price1.setPrefSize(150, 100);
        price1.setStyle("-fx-font-weight: bold; -fx-font-size: 20; -fx-background-color: transparent; -fx-text-fill: #c8ff00;");
        price1.setEffect(new DropShadow());
        gridPane.add(price1, 0, 5);

        Button price2 = new Button("1500 coin");
        price2.setPrefSize(150, 100);
        price2.setStyle("-fx-font-weight: bold; -fx-font-size: 20; -fx-background-color: transparent; -fx-text-fill: #c8ff00;");
        price2.setEffect(new DropShadow());
        gridPane.add(price2, 1, 5);

        Button price3 = new Button("2000 coin");
        price3.setPrefSize(150, 100);
        price3.setStyle("-fx-font-weight: bold; -fx-font-size: 20; -fx-background-color: transparent; -fx-text-fill: #c8ff00;");
        price3.setEffect(new DropShadow());
        gridPane.add(price3, 2, 5);

        Button price4 = new Button("2500 coin");
        price4.setPrefSize(150, 100);
        price4.setStyle("-fx-font-weight: bold; -fx-font-size: 20; -fx-background-color: transparent; -fx-text-fill: #c8ff00;");
        price4.setEffect(new DropShadow());
        gridPane.add(price4, 3, 5);

        Button price5 = new Button("3000 coin");
        price5.setPrefSize(150, 100);
        price5.setStyle("-fx-font-weight: bold; -fx-font-size: 20; -fx-background-color: transparent; -fx-text-fill: #c8ff00;");
        price5.setEffect(new DropShadow());
        gridPane.add(price5, 4, 5);


        Button button1 = SetButtonBuy.setButton(1,1000,username);
        gridPane.add(button1, 0, 6);

        Button button2 = SetButtonBuy.setButton(2,1500,username);
        gridPane.add(button2, 1, 6);

        Button button3 = SetButtonBuy.setButton(3,2000,username);
        gridPane.add(button3, 2, 6);

        Button button4 = SetButtonBuy.setButton(4,2500,username);
        gridPane.add(button4, 3, 6);

        Button button5 = SetButtonBuy.setButton(5,3000,username);
        gridPane.add(button5, 4, 6);

        Button next = new Button("Back");
        next.setPrefSize(143, 50);
        next.setStyle("-fx-font-weight: bold; -fx-font-size: 23; -fx-background-color: linear-gradient(to right, #fffb00, #d51111); -fx-background-radius: 15;");
        next.setEffect(new DropShadow());
        next.setOnAction(actionEvent -> {
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setScene(SceneDisplay.display());
            stage.show();
        });
        gridPane.add(next, 3, 10);

        gridPane.setBackground(new Background(background));
        Scene scene = new Scene(gridPane,width,height);
        return scene;

    }
}
