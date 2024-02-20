package com.example.snake_game.models;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class CheckUsernamePassword {
    public static boolean checkUsernamePassword(String username,String password){
        MongoDatabase database = null;
        // Thay đổi URI kết nối theo cấu hình MongoDB của bạn
        String connectionString = "mongodb://localhost:27017";
        boolean checkUsername = false ;
        try (MongoClient mongoClient = new MongoClient(new MongoClientURI(connectionString))) {
            // Kết nối thành công

            // Chọn cơ sở dữ liệu
            database = mongoClient.getDatabase("kingsnake");
            MongoCollection<Document> collection = database.getCollection("user");
            Document query = new Document("username", username);
            Document rs = collection.find(query).first();
            if(rs != null){

                String passworData = rs.getString("password");
                password = StringToHashCode.hashString(password);
                if(password.equals(passworData)){
                    checkUsername = true ;
                }else {
                    System.out.println("Password fail");
                }

            }else {
                System.out.println("Not found username");
            }

        } catch (Exception e) {
            // Xử lý lỗi kết nối
            e.printStackTrace();
        }
        return checkUsername;
    }
}
