package com.example.snake_game.views;


import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.io.File;

public class Display extends Application {
    @Override
    public void start(Stage primaryStage) {
        BorderPane root = new BorderPane();
        root.setPrefSize(900, 650);

        String backgroundImage = "file:C:/Users/pc/King_Snake/Snake_Game/src/main/java/com/example/snake_game/resources/image/game_background.gif";
        root.setStyle("-fx-background-image: url('" + backgroundImage + "'); -fx-background-size: cover");
        String audioFile = "C:\\Users\\pc\\King_Snake\\Snake_Game\\src\\main\\java\\com\\example\\snake_game\\resources\\music\\TFT Set 10 - 8-bit Music.mp4";
        Media media = new Media(new File(audioFile).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        // Đặt số lần lặp lại là vô hạn
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);

        // Phát âm thanh
        mediaPlayer.play();


        // Top
        HBox topBox = new HBox();
        topBox.setPrefSize(800, 74);
        topBox.setAlignment(Pos.CENTER_LEFT);
        topBox.setSpacing(10);
        topBox.setPadding(new Insets(20, 0, 0, 20));

        ImageView userImageView = new ImageView(new Image("File:C:/Users/pc/King_Snake/Snake_Game/src/main/java/com/example/snake_game/resources/image/a.jpg"));
        userImageView.setOnMouseClicked(event -> handleUserImageClick());
        userImageView.setFitWidth(75);
        userImageView.setFitHeight(75);
        Label userLabel = new Label("User");
        userLabel.setAlignment(Pos.CENTER);
        userLabel.setContentDisplay(javafx.scene.control.ContentDisplay.CENTER);
        userLabel.setPrefSize(76, 44);
        userLabel.setStyle("-fx-font-weight: bold; -fx-font-size: 23");

        HBox userBox = new HBox(userImageView, userLabel);
        userBox.setAlignment(Pos.CENTER);
        topBox.getChildren().add(userBox);
// Tạo HBox mới cho nút Exit
        HBox hbox = new HBox();
        hbox.setAlignment(Pos.CENTER_RIGHT);
        hbox.setSpacing(10);
        hbox.setPadding(new Insets(0, 0, 0, 600));


        Button exitButton = new Button("Exit");
        exitButton.setPrefSize(75, 45);
        exitButton.setStyle("-fx-font-weight: bold; -fx-font-size: 23; -fx-background-color: linear-gradient(to right, #FF0000, #FFFF00); -fx-background-radius: 15;");
        exitButton.setOnAction(event -> handleExitButtonClick());

        HBox.setMargin(exitButton, new Insets(0, 0, 0, 0)); // Đặt khoảng cách lề phải cho nút Exit

        hbox.getChildren().add(exitButton);

        topBox.getChildren().add(hbox);

        root.setTop(topBox);


        // Left
        VBox leftBox = new VBox();
        leftBox.setPrefSize(50, 550);
        leftBox.setAlignment(Pos.CENTER_LEFT);
        leftBox.setSpacing(20);
        leftBox.setPadding(new Insets(0, 0, 0, 50));

        ImageView rankingImageView = new ImageView(new Image("file:C:\\Users\\pc\\King_Snake\\Snake_Game\\src\\main\\java\\com\\example\\snake_game\\resources\\image\\3.png"));
        rankingImageView.setOnMouseClicked(event -> handleRankingImageClick());
        rankingImageView.setFitWidth(114);
        rankingImageView.setFitHeight(112);
        Label rankingLabel = new Label("Ranking");
        rankingLabel.setAlignment(Pos.CENTER);
        rankingLabel.setPrefSize(111, 34);
        rankingLabel.setStyle("-fx-font-weight: bold; -fx-font-size: 24; -fx-text-fill: white ");

        VBox rankingBox = new VBox(rankingImageView, rankingLabel);
        rankingBox.setAlignment(Pos.BOTTOM_CENTER);
        leftBox.getChildren().add(rankingBox);

        ImageView eventImageView = new ImageView(new Image("file:C:\\Users\\pc\\King_Snake\\Snake_Game\\src\\main\\java\\com\\example\\snake_game\\resources\\image\\2.png"));
        eventImageView.setOnMouseClicked(event -> handleEventImageClick());
        eventImageView.setFitWidth(114);
        eventImageView.setFitHeight(112);
        Label eventLabel = new Label("Event");
        eventLabel.setAlignment(Pos.CENTER);
        eventLabel.setPrefSize(110, 35);
        eventLabel.setStyle("-fx-font-weight: bold; -fx-font-size: 23; -fx-text-fill: white ");

        VBox eventBox = new VBox(eventImageView, eventLabel);
        eventBox.setAlignment(Pos.CENTER);
        leftBox.getChildren().add(eventBox);

        root.setLeft(leftBox);

        // Right
        VBox rightBox = new VBox();
        rightBox.setPrefSize(250, 500);
        rightBox.setAlignment(Pos.CENTER);
        rightBox.setSpacing(35);
        rightBox.setPadding(new Insets(0, 30, 0, 0));


        Button startButton = new Button("Start");
        startButton.setPrefSize(143, 50);
        startButton.setStyle("-fx-font-weight: bold; -fx-font-size: 23; -fx-background-color: linear-gradient(to right, #aa00ff, #FFFF00); -fx-background-radius: 15;");
        startButton.setEffect(new DropShadow());
        startButton.setOnAction(event -> handleStartButtonClick());

        Button skinsButton = new Button("Skins");
        skinsButton.setPrefSize(143, 50);
        skinsButton.setStyle("-fx-font-weight: bold; -fx-font-size: 23; -fx-background-color: linear-gradient(to right, #FF0000, #00ff55); -fx-background-radius: 15;");
        skinsButton.setEffect(new DropShadow());
        skinsButton.setOnAction(event -> handleSkinsButtonClick());
        VBox.setMargin(skinsButton, new Insets(0, 50, 0, 0));

        rightBox.getChildren().addAll(startButton, skinsButton);

        root.setRight(rightBox);

        Image centerImage = new Image("File:C:\\Users\\pc\\King_Snake\\Snake_Game\\src\\main\\java\\com\\example\\snake_game\\resources\\image\\ff.gif");
        ImageView centerImageView = new ImageView(centerImage);
        centerImageView.setFitWidth(200); // Đặt chiều rộng mong muốn cho hình ảnh
        centerImageView.setFitHeight(200); // Đặt chiều cao mong muốn cho hình ảnh
        centerImageView.setTranslateX(40); // Dịch chuyển hình ảnh sang phải 10 điểm ảnh
        centerImageView.setTranslateY(-53); // Dịch chuyển hình ảnh lên trên 40 điểm ảnh

        root.setCenter(centerImageView);

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.setTitle("DisplayKingSnake");
        primaryStage.show();
    }

    private void handleUserImageClick() {
        System.out.println("User Image Clicked");
        // Thực hiện các xử lý khác tại đây
    }

    private void handleRankingImageClick() {
        System.out.println("User Image Clicked");
        // Thực hiện các xử lý khác tại đây
    }

    private void handleEventImageClick() {
        System.out.println("User Image Clicked");
        // Thực hiện các xử lý khác tại đây
    }

    private void handleStartButtonClick() {
        System.out.println("PlayScreen");
    }

    private void handleSkinsButtonClick() {
        System.out.println("Skins Button Clicked");
    }

    private void handleExitButtonClick() {
        System.exit(0); // Đóng ứng dụng
    }


    public static void main(String[] args) {
        launch(args);
    }
}
