module com.example.snake_game {
    requires javafx.graphics;
    requires javafx.controls;
    requires javafx.fxml;
    requires mongo.java.driver;
    requires javafx.media;

    opens com.example.snake_game.controllers;
    opens com.example.snake_game to javafx.fxml;
    exports com.example.snake_game.controllers;
    exports com.example.snake_game.views;
//    exports com.example.snake_game;
    exports com.example.snake_game.utils;
    exports com.example.snake_game.dao;
    opens com.example.snake_game.dao;


}