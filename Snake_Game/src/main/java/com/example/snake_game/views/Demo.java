package com.example.snake_game.views;

import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoDatabase;

import javafx.application.Application;
import javafx.stage.Stage;

public class Demo extends Application {

    private static final String DATABASE_NAME = "kingsnake";
    private static final String CONNECTION_STRING = "mongodb://localhost:27017";

    @Override
    public void start(Stage primaryStage) throws Exception {
//        // Kết nối đến MongoDB Compass
//        MongoClient mongoClient = MongoClients.create(CONNECTION_STRING);
//
//        // Lấy cơ sở dữ liệu trong MongoDB
//        MongoDatabase database = mongoClient.getDatabase(DATABASE_NAME);
//
//        // Thực hiện các hoạt động trên cơ sở dữ liệu tại đây...
//        System.out.println("Connect successfully");
//        // Đóng kết nối
//        mongoClient.close();

    }

    public static void main(String[] args) {
        launch(args);
    }
}