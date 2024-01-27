package com.example.snake_game.views;

import com.mongodb.client.*;
import com.mongodb.MongoException;
import org.bson.Document;

public class MongoDBExample {

    public static void main(String[] args) {
        // Thay đổi chuỗi kết nối dưới đây để phù hợp với cấu hình MongoDB của bạn
        String connectionString = "mongodb://localhost:27017";

        try {
            // Kết nối tới MongoDB
            MongoClient mongoClient = MongoClients.create(connectionString);

            // Lấy database từ kết nối
            MongoDatabase database = mongoClient.getDatabase("demo_mongodb");
            MongoCollection<Document> collection = database.getCollection("new_student");

            // Lấy tất cả các tài liệu (documents) trong bộ sưu tập
            FindIterable<Document> documents = collection.find();

            // In ra các tài liệu
            for (Document document : documents) {
                System.out.println(document.toJson());
            }
            // Thực hiện các thao tác với database ở đây...

            // Đóng kết nối
            mongoClient.close();
        } catch (MongoException e) {
            e.printStackTrace();
        }
    }
}