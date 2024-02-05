package com.example.snake_game.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class DisplayController {

    @FXML
    private BorderPane mainPane;

    @FXML
    private HBox topHBox;

    @FXML
    private HBox leftVBox;

    @FXML
    private VBox rightVBox;

    @FXML
    private ImageView UserImage;

    @FXML
    private ImageView SettingImage;

    @FXML
    private ImageView RankingImage;

    @FXML
    private ImageView EventImage;

    @FXML
    private Button StartButton;

    @FXML
    private Button SkinsButton;

    @FXML
    private void handleUserImageClick(ActionEvent event) {
        // Xử lý sự kiện khi hình ảnh User được nhấp vào
    }

    @FXML
    private void handleSettingImageClick(ActionEvent event) {
        // Xử lý sự kiện khi hình ảnh Setting được nhấp vào
    }

    @FXML
    private void handleRankingImageClick(ActionEvent event) {
        // Xử lý sự kiện khi hình ảnh Ranking được nhấp vào
    }

    @FXML
    private void handleEventImageClick(ActionEvent event) {
        // Xử lý sự kiện khi hình ảnh Event được nhấp vào
    }

    @FXML
    private void handleStartButtonClick(ActionEvent event) {
        // Xử lý sự kiện khi nút Start được nhấp vào
    }

    @FXML
    private void handleSkinsButtonClick(ActionEvent event) {
        // Xử lý sự kiện khi nút Skins được nhấp vào
    }
}
