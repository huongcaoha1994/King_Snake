package com.example.snake_game.controllers;

import com.example.snake_game.models.Point;
//import com.example.snake_game.utils.Random;
import com.example.snake_game.views.Game1;
import com.example.snake_game.views.Main;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;

import java.util.Random;

public class UpdateMovie {
    public void updateBoss(Point boss,Point snake,Point area, int tileSize){
        if(snake.getX() < area.getX() && snake.getY() < area.getY()){
            if(boss.getY() > snake.getY()){
                boss.setY(boss.getY()-tileSize);
            } else if (boss.getY() < snake.getY()) {
                boss.setY(boss.getY()+tileSize);
            } else if (boss.getY() == snake.getY() && boss.getX() > snake.getX()) {
                boss.setX(boss.getX()-tileSize);
            } else if (boss.getY() == snake.getY() && boss.getX() < snake.getX()) {
                boss.setX(boss.getX()+tileSize);
            }
        }
        if(boss.getX() == snake.getX() && boss.getY() == snake.getY()){
            System.out.println("Game over");
            return;
        }
    }
    public void updateSnake(Scene scene,Point snake,int tileSize,Point food,int width,int height,int score){
        scene.setOnKeyPressed(keyEvent -> {
            KeyCode keyCode = keyEvent.getCode();
            switch (keyCode){
                case UP :{
                   if(snake.getY() - tileSize >= 0){
                       snake.setY(snake.getY()-tileSize);
                   }
                    break;
                }
                case DOWN:{
                    if(snake.getY() + tileSize < height){
                        snake.setY(snake.getY()+tileSize);
                    }
                    break;
                }
                case LEFT:{
                    if(snake.getX() - tileSize >= 0){
                        snake.setX(snake.getX()-tileSize);
                    }
                    break;
                }
                case RIGHT:{
                    if(snake.getX() + tileSize < width){
                        snake.setX(snake.getX()+tileSize);
                    }
                    break;
                }
            }
            if(snake.getX() == food.getX() && snake.getY() == food.getY()){

                Random random = new Random();
                food.setX(random.nextInt(width/tileSize)*tileSize);
                food.setY(random.nextInt(height/tileSize)*tileSize);
            }

        });
    }
}
