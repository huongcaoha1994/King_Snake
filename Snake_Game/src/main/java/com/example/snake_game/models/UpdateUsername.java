package com.example.snake_game.models;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.UpdateResult;
import org.bson.Document;

public class UpdateUsername {
    public static void udpateUsername(String username){
        MongoDatabase database = null;
        // Thay đổi URI kết nối theo cấu hình MongoDB của bạn
        String connectionString = "mongodb+srv://kingsnake:kingsnake@cluster0.baduwey.mongodb.net/?retryWrites=true&w=majority";
        try (MongoClient mongoClient = new MongoClient(new MongoClientURI(connectionString))) {
            // Kết nối thành công

            // Chọn cơ sở dữ liệu
            database = mongoClient.getDatabase("huongcaoha");
            MongoCollection<Document> collection = database.getCollection("getUsername");
            Document query = new Document();
            Document update = new Document("$set",new Document("username",username));
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
