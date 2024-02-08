package com.example.snake_game.views;

import com.example.snake_game.dao.MongoDBConnection;

public class MongoDBExample {
    public static void main(String[] args) {
       MongoDBConnection.connectToMongoDB();

    }
}