package com.example.snake_game.models;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class InsertUser {
    public static void insertUser(String username ,String password){
        // Kết nối tới MongoDB local
        String connectionString = "mongodb+srv://<huongcaoha1994>:<huongcaoha1994>@kingsnake.ruun7y8.mongodb.net/?retryWrites=true&w=majority";
        try (MongoClient mongoClient = MongoClients.create(connectionString)) {
            // Chọn database
            MongoDatabase database = mongoClient.getDatabase("kingsnake");

            // Chọn collection
            MongoCollection<Document> collection = database.getCollection("users");

            // Tạo document
            Document document = new Document("username", username)
                    .append("password", password)
                    .append("level", 1)
                    .append("score", 0)
                    .append("created_ad","ISODate()");


            // Chèn document vào collection
            collection.insertOne(document);
            System.out.println("Insert success");
        }catch (Exception e){
            System.out.println("Insert error");
        }
    }
}
