package com.example.snake_game.models;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.UpdateResult;
import org.bson.Document;

public class UpdateSkin {
    public static void udpateSkin(String username,int skin){
        MongoDatabase database = null;
        // Thay đổi URI kết nối theo cấu hình MongoDB của bạn
        String connectionString = "mongodb://localhost:27017";
        try (MongoClient mongoClient = new MongoClient(new MongoClientURI(connectionString))) {
            // Kết nối thành công

            // Chọn cơ sở dữ liệu
            database = mongoClient.getDatabase("kingsnake");
            MongoCollection<Document> collection = database.getCollection("user");
            Document query = new Document("username",(username));
            Document update = new Document("$set",new Document("skin",skin));
            UpdateResult rs = collection.updateOne(query,update);
            if(rs.getModifiedCount() > 0){
                System.out.println("Update succesfully ");
            }else {
                System.out.println("Update Error");
            }


        } catch (Exception e) {
            // Xử lý lỗi kết nối
            e.printStackTrace();
        }
    }
}
