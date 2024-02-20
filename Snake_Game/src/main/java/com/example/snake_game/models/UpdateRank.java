package com.example.snake_game.models;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.UpdateResult;
import org.bson.Document;

public class UpdateRank {
    public static void updateRank(String username ,int score){
        MongoDatabase database = null;
        // Thay đổi URI kết nối theo cấu hình MongoDB của bạn
        String connectionString = "mongodb+srv://kingsnake:kingsnake@cluster0.baduwey.mongodb.net/?retryWrites=true&w=majority";
        try (MongoClient mongoClient = new MongoClient(new MongoClientURI(connectionString))) {
            // Kết nối thành công

            // Chọn cơ sở dữ liệu
            database = mongoClient.getDatabase("huongcaoha");
            MongoCollection<Document> collection = database.getCollection("users");
            Document query = new Document("username",(username));
            Document update = new Document();
            if(score >= 10 && score < 15){
                 update = new Document("$set",new Document("rank","Bronze"));
            } else if (score >= 15 && score < 20) {
                 update = new Document("$set",new Document("rank","Silver"));
            } else if (score >= 20) {
                 update = new Document("$set",new Document("rank","Gold"));
            }else {
                return;
            }

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
