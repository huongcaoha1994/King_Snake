package com.example.snake_game.views;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HistoryController {
    @FXML
    private Label welcomeText;

    @FXML
    public void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}