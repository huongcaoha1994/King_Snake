package com.example.snake_game.views;

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
        System.out.println(username);
        int width = 1200 ;
        int height = 780;
        int sizeImage = 225 ;
        int fontSize = 20 ;

        Image backgroundImage = GetImage.getImage("C:\\Users\\dell\\IdeaProjects\\King_Snake\\Snake_Game\\src\\main\\java\\com\\example\\snake_game\\resources\\image\\shop.gif");
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
        gridPane.add(shop, 0, 0);


        // Hình ảnh 1
        Image image1 = new Image(StringPathImage.snakegreen_gif());
        ImageView imageView1 = new ImageView(image1);
        imageView1.setFitWidth(sizeImage);
        imageView1.setFitHeight(sizeImage);
        gridPane.add(imageView1, 0, 10);

        // Hình ảnh 1
        Image image2 = new Image(StringPathImage.snakegreen_gif());
        ImageView imageView2 = new ImageView(image2);
        imageView2.setFitWidth(sizeImage);
        imageView2.setFitHeight(sizeImage);
        gridPane.add(imageView2, 1, 10);

        // Hình ảnh 1
        Image image3 = new Image(StringPathImage.snakegreen_gif());
        ImageView imageView3 = new ImageView(image3);
        imageView3.setFitWidth(sizeImage);
        imageView3.setFitHeight(sizeImage);
        gridPane.add(imageView3, 2, 10);

        // Hình ảnh 1
        Image image4 = new Image(StringPathImage.snakegreen_gif());
        ImageView imageView4 = new ImageView(image4);
        imageView4.setFitWidth(sizeImage);
        imageView4.setFitHeight(sizeImage);
        gridPane.add(imageView4, 3, 10);

        // Hình ảnh 1
        Image image5 = new Image(StringPathImage.snakegreen_gif());
        ImageView imageView5 = new ImageView(image5);
        imageView5.setFitWidth(sizeImage);
        imageView5.setFitHeight(sizeImage);
        gridPane.add(imageView5, 4, 10);

        Button price1 = new Button("1000 coin");
        price1.setPrefSize(150, 100);
        price1.setStyle("-fx-font-weight: bold; -fx-font-size: 20; -fx-background-color: transparent; -fx-text-fill: #c8ff00;");
        price1.setEffect(new DropShadow());
        gridPane.add(price1, 0, 11);

        Button price2 = new Button("1500 coin");
        price2.setPrefSize(150, 100);
        price2.setStyle("-fx-font-weight: bold; -fx-font-size: 20; -fx-background-color: transparent; -fx-text-fill: #c8ff00;");
        price2.setEffect(new DropShadow());
        gridPane.add(price2, 1, 11);

        Button price3 = new Button("2000 coin");
        price3.setPrefSize(150, 100);
        price3.setStyle("-fx-font-weight: bold; -fx-font-size: 20; -fx-background-color: transparent; -fx-text-fill: #c8ff00;");
        price3.setEffect(new DropShadow());
        gridPane.add(price3, 2, 11);

        Button price4 = new Button("2500 coin");
        price4.setPrefSize(150, 100);
        price4.setStyle("-fx-font-weight: bold; -fx-font-size: 20; -fx-background-color: transparent; -fx-text-fill: #c8ff00;");
        price4.setEffect(new DropShadow());
        gridPane.add(price4, 3, 11);

        Button price5 = new Button("3000 coin");
        price5.setPrefSize(150, 100);
        price5.setStyle("-fx-font-weight: bold; -fx-font-size: 20; -fx-background-color: transparent; -fx-text-fill: #c8ff00;");
        price5.setEffect(new DropShadow());
        gridPane.add(price5, 4, 11);


        Button button1 = SetButtonBuy.setButton(1,1000,username);
        gridPane.add(button1, 0, 12);

        Button button2 = SetButtonBuy.setButton(2,1500,username);
        gridPane.add(button2, 1, 12);

        Button button3 = SetButtonBuy.setButton(3,2000,username);
        gridPane.add(button3, 2, 12);

        Button button4 = SetButtonBuy.setButton(4,2500,username);
        gridPane.add(button4, 3, 12);

        Button button5 = SetButtonBuy.setButton(5,3000,username);
        gridPane.add(button5, 4, 12);

        Button next = new Button("Back");
        next.setPrefSize(143, 50);
        next.setStyle("-fx-font-weight: bold; -fx-font-size: 23; -fx-background-color: linear-gradient(to right, #fffb00, #d51111); -fx-background-radius: 15;");
        next.setEffect(new DropShadow());
        next.setOnAction(actionEvent -> {
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setScene(SceneDisplay.display());
            stage.show();
        });
        gridPane.add(next, 3, 30);

        gridPane.setBackground(new Background(background));
        Scene scene = new Scene(gridPane,width,height);
        return scene;

    }
}
