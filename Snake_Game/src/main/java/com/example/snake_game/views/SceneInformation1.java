//package com.example.snake_game.views;
//
//import javafx.application.Application;
//import javafx.geometry.Insets;
//import javafx.geometry.Pos;
//import javafx.scene.Scene;
//import javafx.scene.control.Button;
//import javafx.scene.control.Label;
//import javafx.scene.image.Image;
//import javafx.scene.image.ImageView;
//import javafx.scene.layout.BorderPane;
//import javafx.scene.layout.GridPane;
//import javafx.scene.layout.HBox;
//import javafx.scene.layout.VBox;
//import javafx.stage.Stage;
//
//public class SceneInformation1 extends Application {
//    @Override
//    public void start(Stage primaryStage) {
//
//        BorderPane root = new BorderPane();
//        root.setPrefSize(900, 650);
//        Scene scene = null;
//
//
//        HBox topBox = new HBox();
//        topBox.setPrefSize(800, 74);
//        topBox.setAlignment(Pos.CENTER_LEFT);
//        topBox.setSpacing(10);
//        topBox.setPadding(new Insets(20, 0, 0, 20));
//
//        Label userLabel = new Label("TRANG CÁ NHÂN");
//        userLabel.setAlignment(Pos.CENTER);
//        userLabel.setContentDisplay(javafx.scene.control.ContentDisplay.CENTER);
//        userLabel.setPrefSize(200, 44);
//        userLabel.setStyle("-fx-font-weight: bold; -fx-font-size: 23; -fx-background-color: FF00CC;");
//
//        HBox userBox = new HBox(userLabel);
//        userBox.setAlignment(Pos.CENTER);
//        topBox.getChildren().add(userBox);
//
//
//        HBox hbox = new HBox();
//        hbox.setAlignment(Pos.CENTER_RIGHT);
//        hbox.setSpacing(10);
//        hbox.setPadding(new Insets(0, 0, 0, 600));
//
//        Button exitButton = new Button("Exit");
//        exitButton.setPrefSize(75, 35);
//        exitButton.setStyle("-fx-font-weight: bold; -fx-font-size: 23; -fx-background-color: #CD5C5C; -fx-background-radius: 15;");
//        exitButton.setOnAction(event -> handleExitButtonClick());
//
//        HBox.setMargin(exitButton, new Insets(0, 0, 10, 0));
//
//        hbox.getChildren().add(exitButton);
//
//        topBox.getChildren().add(hbox);
//
//        root.setTop(topBox);
//
//
//        VBox rightBox = new VBox();
//        rightBox.setPrefSize(650, 500);
//        rightBox.setAlignment(Pos.CENTER);
//        rightBox.setSpacing(35);
//        rightBox.setPadding(new Insets(0, 30, 0, 0));
//
//        HBox titleBox = new HBox();
//        titleBox.setAlignment(Pos.CENTER_LEFT);
//        titleBox.setSpacing(10);
//
//        ImageView avatarImageView = new ImageView(new Image("file:C:\\Users\\dell\\IdeaProjects\\King_Snake\\Snake_Game\\src\\main\\java\\com\\example\\snake_game\\resources\\image\\snake.png"));
//        avatarImageView.setFitWidth(150);
//        avatarImageView.setFitHeight(150);
//
//        Label titleLabel = new Label("THÔNG TIN");
//        titleLabel.setStyle("-fx-font-weight: bold; -fx-font-size: 30;");
//
//        titleBox.getChildren().addAll(avatarImageView, titleLabel);
//
//        HBox infoBox = new HBox();
//        infoBox.setSpacing(50);
//
//        VBox column0 = new VBox();
//        VBox column1 = new VBox();
//        column0.setSpacing(50);
//        column1.setSpacing(50);
//
//        GridPane infoGrid = new GridPane();
//        infoGrid.setHgap(100);
//        infoGrid.setVgap(100);
//
//        Label nameLabel = new Label("Tên:");
//        nameLabel.setStyle("-fx-font-size: 14pt; -fx-font-weight: bold; -fx-background-color:#20B2AA; -fx-background-radius: 20;");
//
//        Label levelLabel = new Label("Cấp:");
//        levelLabel.setStyle("-fx-font-size: 14pt;-fx-font-weight: bold; -fx-background-color:#20B2AA; -fx-background-radius: 20;");
//
//        Label scoreLabel = new Label("Điểm cao:");
//        scoreLabel.setStyle("-fx-font-size: 14pt;-fx-font-weight: bold; -fx-background-color:#20B2AA; -fx-background-radius: 20;");
//
//        Label timeLabel = new Label("Thời gian:");
//        timeLabel.setStyle("-fx-font-size: 14pt;-fx-font-weight: bold; -fx-background-color:#20B2AA; -fx-background-radius: 20;");
//
//        Label nameText = new Label("hiu");
//        nameText.setStyle("-fx-font-size: 14pt;");
//
//        Label levelText = new Label("2");
//        levelText.setStyle("-fx-font-size: 14pt;");
//
//        Label scoreText = new Label("15");
//        scoreText.setStyle("-fx-font-size: 14pt;");
//
//        Label timeText = new Label("50s");
//        timeText.setStyle("-fx-font-size: 14pt;");
//
//        column0.getChildren().addAll(nameLabel, levelLabel, scoreLabel, timeLabel);
//        column1.getChildren().addAll(nameText, levelText, scoreText, timeText);
//
//        infoBox.getChildren().addAll(column0, column1);
//
//        rightBox.getChildren().addAll(titleBox, infoBox);
//
//        root.setCenter(rightBox);
//
//        scene = new Scene(root);
//        primaryStage.setScene(scene);
//        primaryStage.setResizable(false);
//        primaryStage.setTitle("Scene Information");
//        primaryStage.show();
//    }
//
//    private void handleUserImageClick() {
//        System.out.println("User Image Clicked");
//    }
//
//    private void handleExitButtonClick() {
//        System.exit(0);
//    }
//    public static void main(String[] args) {
//        launch(args);
//    }
//}