module com.example.snake_game {
    requires javafx.graphics;
    requires javafx.controls;
    requires javafx.fxml;
    requires mongo.java.driver;

    opens com.example.snake_game.controllers;
    opens com.example.snake_game to javafx.fxml;
    exports com.example.snake_game.controllers;
    exports com.example.snake_game.views;

}