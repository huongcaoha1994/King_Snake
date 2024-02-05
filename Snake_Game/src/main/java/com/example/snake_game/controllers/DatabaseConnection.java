package com.example.snake_game.controllers;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.connection.Connection;
import com.mongodb.connection.ConnectionId;
import org.bson.Document;

import java.io.IOException;
import java.util.Properties;


public class DatabaseConnection {
    private static MongoClient mongoClient;
    private static MongoDatabase database;

    public static void connectToMongoDB() {
        try {
            // Connect to MongoDB
            mongoClient = new MongoClient("localhost", 27017);

            // Choose the database
            database = mongoClient.getDatabase("demo");

            System.out.println("Connected to MongoDB successfully!");
        } catch (Exception e) {
            System.err.println("Failed to connect to MongoDB: " + e.getMessage());
        }
    }

    public static MongoClient getMongoClient() {
        return mongoClient;
    }

    public static MongoDatabase getDatabase() {
        return database;
    }

    public static void closeConnection() {
        if (mongoClient != null) {
            mongoClient.close();
            System.out.println("MongoDB connection closed");
        }
    }
}

