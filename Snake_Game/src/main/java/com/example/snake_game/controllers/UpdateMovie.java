package com.example.snake_game.controllers;

import com.example.snake_game.models.Point;
//import com.example.snake_game.utils.Random;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
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

    public void updateMonster(Point monster, Point snake, int tileSize){
        if(monster.getX() < snake.getX()){
           monster.setX(monster.getX()+tileSize);
        } else if (monster.getX() > snake.getX()) {
            monster.setX(monster.getX()-tileSize);
        } else if (monster.getX() == snake.getX() && monster.getY() < snake.getY()) {
            monster.setY(monster.getY()+tileSize);
        } else if (monster.getX() == snake.getX() && monster.getY() > snake.getY()) {
            monster.setY(monster.getY()-tileSize);
        }
    }
}
