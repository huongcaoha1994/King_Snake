package com.example.snake_game.dao;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoDatabase;

public class MongoDBConnection {
    public static MongoDatabase connectToMongoDB() {
        MongoDatabase database = null;
        // Thay đổi URI kết nối theo cấu hình MongoDB của bạn
        String connectionString = "mongodb://localhost:27017/?retryWrites=true&w=majority";

        try (MongoClient mongoClient = new MongoClient(new MongoClientURI(connectionString))) {
            // Kết nối thành công

            // Chọn cơ sở dữ liệu
             database = mongoClient.getDatabase("kingsnake");
//            System.out.println("connect successfully");
            // Thực hiện các thao tác với cơ sở dữ liệu ở đây
            // ...
        } catch (Exception e) {
            // Xử lý lỗi kết nối
            e.printStackTrace();
        }
        return database;
    }

}