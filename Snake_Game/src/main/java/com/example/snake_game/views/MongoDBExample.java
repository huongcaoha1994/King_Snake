package com.example.snake_game.views;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class MongoDBExample {
    public static void main(String[] args) {
        // Thiết lập kết nối tới MongoDB
        MongoClientURI uri = new MongoClientURI("mongodb://localhost:27017");
        try (MongoClient mongoClient = new MongoClient(uri)) {
            // Kết nối tới database
            MongoDatabase database = mongoClient.getDatabase("projectdemo");

            // Lấy collection
            MongoCollection<Document> collection = database.getCollection("thi");

            // Lấy tất cả các documents từ collection
            FindIterable<Document> documents = collection.find();
            MongoCursor<Document> cursor = documents.iterator();
            while (cursor.hasNext()) {
                Document document = cursor.next();
                System.out.println(document.toJson());
            }
        }
    }
}