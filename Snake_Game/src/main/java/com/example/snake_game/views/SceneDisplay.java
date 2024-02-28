package com.example.snake_game.views;

import com.example.snake_game.models.GetScore;
import com.example.snake_game.models.GetSnakeDisplay;
import com.example.snake_game.models.Getskin;
import com.example.snake_game.utils.StringPathImage;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


import javafx.stage.Stage;

public class SceneDisplay {
    public static String username;

    private static int oldScore = GetScore.getScore(username);
    public void setUsername(String username){
        this.username = username ;
    }
    private static void handleStartButtonClick(ActionEvent event)  {
        ScenePlaygame scenePlaygame = new ScenePlaygame();
        scenePlaygame.setUsername(username);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(ScenePlaygame.playgame(stage));
        stage.show();
    }
    public static Scene display(){
        int skin = Getskin.getSkin(username);
        BorderPane root = new BorderPane();
        root.setPrefSize(1200, 780);

        String backgroundImage = StringPathImage.background_jpg();
        root.setStyle("-fx-background-image: url('" + backgroundImage + "'); -fx-background-size: cover;");


        // Top
        HBox topBox = new HBox();
        topBox.setPrefSize(780, 74);
        topBox.setAlignment(Pos.CENTER_LEFT);
        topBox.setSpacing(10);
        topBox.setPadding(new Insets(20, 0, 0, 20));

        ImageView userImageView = new ImageView(new Image(StringPathImage.a_jpg()));
        userImageView.setOnMouseClicked(event -> handleUserImageClick(event));
        userImageView.setFitWidth(75);
        userImageView.setFitHeight(75);
        Label userLabel = new Label(username);
        userLabel.setAlignment(Pos.CENTER);
        userLabel.setContentDisplay(javafx.scene.control.ContentDisplay.CENTER);
        userLabel.setPrefSize(200, 44);
        userLabel.setStyle("-fx-font-weight: bold; -fx-font-size: 23 ; -fx-text-fill: yellow");

        HBox userBox = new HBox(userImageView, userLabel);
        userBox.setAlignment(Pos.CENTER);
        topBox.getChildren().add(userBox);
// Tạo HBox mới cho nút Exit
        HBox hbox = new HBox();
        hbox.setAlignment(Pos.CENTER_RIGHT);
        hbox.setSpacing(10);
        hbox.setPadding(new Insets(0, 0, 0, 750));

        //tạo button hươớng dẫn chơi

        HBox guidebox = new HBox();
        hbox.setAlignment(Pos.CENTER_RIGHT);
        hbox.setSpacing(10);
        hbox.setPadding(new Insets(0, 0, 0, 600));


        Button guideButton = new Button("GuidePlay");
        Tooltip tooltipGuide = new Tooltip("Hướng dẫn chơi");
        guideButton.setTooltip(tooltipGuide);
        guideButton.setPrefSize(150, 45);
        guideButton.setStyle("-fx-font-weight: bold; -fx-font-size: 23; -fx-background-color: linear-gradient(to right, #FF0000, #FFFF00); -fx-background-radius: 15;");
        guideButton.setOnAction(event -> {
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(GuidePlayGame.guidePlay(stage,5,username));
            stage.show();
        });

        HBox.setMargin(guideButton, new Insets(0, 0, 0, 0)); // Đặt khoảng cách lề phải cho nút Exit

        hbox.getChildren().add(guideButton);

        topBox.getChildren().add(guidebox);

        root.setTop(topBox);

        Button exitButton = new Button("Logout");
        Tooltip tooltipExit = new Tooltip("Click để thoát");
        exitButton.setTooltip(tooltipExit);
        exitButton.setPrefSize(120, 45);
        exitButton.setStyle("-fx-font-weight: bold; -fx-font-size: 23; -fx-background-color: linear-gradient(to right, #FF0000, #FFFF00); -fx-background-radius: 15;");
        exitButton.setOnAction(event -> {
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(SceneLogin.login());
            stage.show();
            // logout về login
        });

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

        ImageView rankingImageView = new ImageView(new Image(StringPathImage.ranking_png()));
        rankingImageView.setOnMouseClicked(event -> handleRankingImageClick(event));
        rankingImageView.setFitWidth(114);
        rankingImageView.setFitHeight(112);
        Label rankingLabel = new Label("Ranking");
        rankingLabel.setAlignment(Pos.CENTER);
        rankingLabel.setPrefSize(111, 34);
        rankingLabel.setStyle("-fx-font-weight: bold; -fx-font-size: 24; -fx-text-fill: white ");

        VBox rankingBox = new VBox(rankingImageView, rankingLabel);
        rankingBox.setAlignment(Pos.BOTTOM_CENTER);
        leftBox.getChildren().add(rankingBox);

        ImageView eventImageView = new ImageView(new Image(StringPathImage.png_2()));
        eventImageView.setOnMouseClicked(event -> handleEventImageClick(event));
        eventImageView.setFitWidth(114);
        eventImageView.setFitHeight(112);
        Label eventLabel = new Label("Shoping");
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
        Tooltip tooltipStart = new Tooltip("Click để chơi game");
        startButton.setTooltip(tooltipStart);
        startButton.setPrefSize(143, 50);
        startButton.setStyle("-fx-font-weight: bold; -fx-font-size: 23; -fx-background-color: linear-gradient(to right, #aa00ff, #FFFF00); -fx-background-radius: 15;");
        startButton.setEffect(new DropShadow());
        startButton.setOnAction(event -> handleStartButtonClick(event));

        Button rankingMatchButton = new Button("Earn Coin");
        Tooltip tooltipRank = new Tooltip("Click để kiếm coin");
        Tooltip.install(rankingMatchButton,tooltipRank);
        rankingMatchButton.setPrefSize(143, 50);
        rankingMatchButton.setStyle("-fx-font-weight: bold; -fx-font-size: 23; -fx-background-color: linear-gradient(to right, #FF0000, #00ff55); -fx-background-radius: 15;");
        rankingMatchButton.setEffect(new DropShadow());
        rankingMatchButton.setOnAction(event -> handleSkinsButtonClick(event));
        VBox.setMargin(rankingMatchButton, new Insets(0, 0, 0, 0));

        rightBox.getChildren().addAll(startButton, rankingMatchButton);

        root.setRight(rightBox);

        Image centerImage = GetSnakeDisplay.getImageSnakeDisplay(skin);
        ImageView centerImageView = new ImageView(centerImage);
        centerImageView.setFitWidth(200); // Đặt chiều rộng mong muốn cho hình ảnh
        centerImageView.setFitHeight(200); // Đặt chiều cao mong muốn cho hình ảnh
        centerImageView.setTranslateX(40); // Dịch chuyển hình ảnh sang phải 10 điểm ảnh
        centerImageView.setTranslateY(-53); // Dịch chuyển hình ảnh lên trên 40 điểm ảnh
        System.out.println(skin);
        root.setCenter(centerImageView);

        Scene scene = new Scene(root);
        return scene;
    }
    private static void handleUserImageClick(MouseEvent event) {
      SceneInformation sceneInformation = new SceneInformation();
      sceneInformation.setUsername(username);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(SceneInformation.information());
        stage.show();

        // Thực hiện các xử lý khác tại đây
    }

    private static void handleRankingImageClick(MouseEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(SceneRank.sceneRank());
        stage.show();
        // Thực hiện các xử lý khác tại đây
    }

    private static void handleEventImageClick(MouseEvent event) {
        SceneShop sceneShop = new SceneShop();
        sceneShop.setUsername(username);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(SceneShop.shop(username));
        stage.show();
        // Thực hiện các xử lý khác tại đây
    }


    private static void handleSkinsButtonClick(ActionEvent event) {
        GameRank gameRank = new GameRank();
        gameRank.setUsername(username);

        if(oldScore == 0){
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(GuidePlayGame.guidePlay(stage,4,username));
            stage.show();

        }else {
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(GameRank.gameRank(stage,username));
            stage.show();
        }

    }

    private static void handleExitButtonClick(MouseEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(SceneLogin.login());
        stage.show();
        // logout về login
    }


}
