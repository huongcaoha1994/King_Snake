package com.example.snake_game.models;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;


public class InsertUser {
    public static void insertUser(String username ,String password){
        // Kết nối tới MongoDB local
        String connectionString = "mongodb://localhost:27017";
        try (MongoClient mongoClient = MongoClients.create(connectionString)) {
            // Chọn database
            MongoDatabase database = mongoClient.getDatabase("kingsnake");

            // Chọn collection
            MongoCollection<Document> collection = database.getCollection("user");
            Calendar calendar = Calendar.getInstance();
            Date currentDate = calendar.getTime();
            // Tạo document
            Document document = new Document("username", username)
                    .append("password", password)
                    .append("level", 1)
                    .append("score", 0)
                    .append("rank","Iron")
                    .append("coin",0)
                    .append("skin",1)
                    .append("outfit", Arrays.asList(1))
                    .append("created_at", currentDate);


            // Chèn document vào collection
            collection.insertOne(document);
            System.out.println("Insert success");
        }catch (Exception e){
            System.out.println("Insert error");
        }
    }
}
