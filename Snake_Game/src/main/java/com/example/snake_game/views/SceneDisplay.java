package com.example.snake_game.views;

import com.example.snake_game.models.GetScore;
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

        ImageView userImageView = new ImageView(new Image("File:C:\\Users\\dell\\IdeaProjects\\King_Snake\\Snake_Game\\src\\main\\java\\com\\example\\snake_game\\resources\\image\\a.jpg"));
        userImageView.setOnMouseClicked(event -> handleUserImageClick(event));
        userImageView.setFitWidth(75);
        userImageView.setFitHeight(75);
        Label userLabel = new Label(username);
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
        Tooltip tooltipExit = new Tooltip("Click để thoát");
        exitButton.setTooltip(tooltipExit);
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

        ImageView rankingImageView = new ImageView(new Image(StringPathImage.a_jpg()));
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
        Label eventLabel = new Label("GuidePlay");
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

        Button rankingMatchButton = new Button("Game Rank");
        Tooltip tooltipRank = new Tooltip("Click để xem bảng xếp hạng");
        Tooltip.install(rankingMatchButton,tooltipRank);
        rankingMatchButton.setPrefSize(143, 50);
        rankingMatchButton.setStyle("-fx-font-weight: bold; -fx-font-size: 23; -fx-background-color: linear-gradient(to right, #FF0000, #00ff55); -fx-background-radius: 15;");
        rankingMatchButton.setEffect(new DropShadow());
        rankingMatchButton.setOnAction(event -> handleSkinsButtonClick(event));
        VBox.setMargin(rankingMatchButton, new Insets(0, 50, 0, 0));

        rightBox.getChildren().addAll(startButton, rankingMatchButton);

        root.setRight(rightBox);

        Image centerImage = new Image(StringPathImage.ff_gif());
        ImageView centerImageView = new ImageView(centerImage);
        centerImageView.setFitWidth(200); // Đặt chiều rộng mong muốn cho hình ảnh
        centerImageView.setFitHeight(200); // Đặt chiều cao mong muốn cho hình ảnh
        centerImageView.setTranslateX(40); // Dịch chuyển hình ảnh sang phải 10 điểm ảnh
        centerImageView.setTranslateY(-53); // Dịch chuyển hình ảnh lên trên 40 điểm ảnh

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
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        if(oldScore == 0){
            stage.setScene(GuidePlayGame.guidePlay(stage,5,username));

        }else {
            stage.setScene(GameRank.gameRank(stage,username));
        }

        stage.show();
    }

    private static void handleExitButtonClick() {
        System.exit(0); // Đóng ứng dụng
    }


}
