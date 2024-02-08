package com.example.snake_game.utils;

import com.example.snake_game.models.Point;

import java.util.Random;

public class Food {
    public void setFood(Point food,int width,int height,int tileSize){
        Random random = new Random();
        food.setX(random.nextInt(width/tileSize)*tileSize);
        food.setY(random.nextInt(height/tileSize)*tileSize);
    }
}
