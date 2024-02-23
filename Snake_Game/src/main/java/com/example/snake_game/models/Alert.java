package com.example.snake_game.models;

public class Alert {
    public static void alert(String text){
        javafx.scene.control.Alert alert = new javafx.scene.control.Alert(javafx.scene.control.Alert.AlertType.WARNING);
        alert.setTitle("Cảnh báo");
        alert.setHeaderText(null);
        alert.setContentText(text);
        alert.showAndWait();
    }
}
