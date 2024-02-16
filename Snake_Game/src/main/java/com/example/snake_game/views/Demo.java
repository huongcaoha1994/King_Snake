package com.example.snake_game.views;

import com.example.snake_game.dao.MongoDBConnection;
import com.example.snake_game.models.*;
import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.MongoException;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import javafx.application.Application;
import javafx.stage.Stage;
import org.bson.Document;

public class Demo extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        // Chuỗi kết nối đến MongoDB Atlas
        String connectionString = "mongodb+srv://<huongcaoha1994>:<huongcaoha1994>@kingsnake.ruun7y8.mongodb.net/?retryWrites=true&w=majority";

        // Kết nối đến cơ sở dữ liệu MongoDB Atlas
        MongoClient mongoClient = MongoClients.create(connectionString);

        // Lấy cơ sở dữ liệu từ kết nối
        MongoDatabase database = mongoClient.getDatabase("<kingsnake>");

        // Truy vấn và thao tác với cơ sở dữ liệu
        // ...
        System.out.println("Connect Successfully");
        // Đóng kết nối
        mongoClient.close();
    }
}
