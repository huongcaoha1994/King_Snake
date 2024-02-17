package com.example.snake_game.views;

import com.example.snake_game.dao.MongoDBConnection;
import com.example.snake_game.models.*;
import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.MongoException;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import javafx.application.Application;
import javafx.stage.Stage;
import org.bson.Document;

import java.util.Calendar;
import java.util.Date;

public class Demo extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
//        // Chuỗi kết nối đến MongoDB Atlas
//        String connectionString = "mongodb+srv://kingsnake:kingsnake@cluster0.baduwey.mongodb.net/?retryWrites=true&w=majority";
//
//        // Kết nối đến cơ sở dữ liệu MongoDB Atlas
//        MongoClient mongoClient = MongoClients.create(connectionString);
//
//        // Lấy cơ sở dữ liệu từ kết nối
//        MongoDatabase database = mongoClient.getDatabase("<kingsnake>");
//
//        // Lấy bộ sưu tập (collection)
//        MongoCollection<Document> collection = database.getCollection("<users>");
//
//        // Tạo một tài liệu (document) mới
//        Document document = new Document("username", "huongcaoha")
//                .append("age", 29);
//
//        // Chèn tài liệu vào bộ sưu tập
//        collection.insertOne(document);
//
//        // Đóng kết nối
//        mongoClient.close();
       primaryStage.setScene(SceneDisplay.display());
       primaryStage.show();

    }
}
