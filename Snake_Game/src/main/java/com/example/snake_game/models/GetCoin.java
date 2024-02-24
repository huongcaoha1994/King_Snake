package com.example.snake_game.models;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class GetCoin {
    public static int coin(String username){
        MongoDatabase database = null;
        // Thay đổi URI kết nối theo cấu hình MongoDB của bạn
        String connectionString = "mongodb://localhost:27017";
        int coin = 0;
        try (MongoClient mongoClient = new MongoClient(new MongoClientURI(connectionString))) {
            // Kết nối thành công

            // Chọn cơ sở dữ liệu
            database = mongoClient.getDatabase("kingsnake");
            MongoCollection<Document> collection = database.getCollection("user");
            Document query = new Document("username",(username));
            Document rs = collection.find(query).first();
            if(rs != null){
                coin = rs.getInteger("coin");
            }

        } catch (Exception e) {
            // Xử lý lỗi kết nối
            e.printStackTrace();
            System.out.println("Not found username");
        }
        return coin;
    }
}