package com.example.snake_game.controllers;

import com.example.snake_game.models.Point;
//import com.example.snake_game.utils.Random;
import com.example.snake_game.resources.Draws;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;

import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.Timer;

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
    public void updateSnake(Scene scene,Point snake,int tileSize,Point food,int width,int height){
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
    public void updateMonsterEat(Point monsterEat,Point food,int width,int height,int tileSize){
        Random random = new Random();
        if(food.getX() < width && food.getY() < height/2){
            if(monsterEat.getX() > food.getX()){
                monsterEat.setX(monsterEat.getX()- tileSize);
            }else  if(monsterEat.getX() < food.getX()){
                monsterEat.setX(monsterEat.getX()+ tileSize);
            } else if (monsterEat.getX() == food.getX() && monsterEat.getY() > food.getY()) {
                monsterEat.setY(monsterEat.getY()-tileSize);
            }else if (monsterEat.getX() == food.getX() && monsterEat.getY() < food.getY()) {
                monsterEat.setY(monsterEat.getY()+tileSize);
            }
        }
        if(monsterEat.getX() == food.getX() && monsterEat.getY() == food.getY()){

            food.setX(random.nextInt(width/tileSize)*tileSize);
            food.setY(random.nextInt(height/tileSize)*tileSize);
        }
    }

    public void updateMonsterBotLelt(Point monsterBotLeft,Point snake,int width , int height ,int tileSize){
        if(snake.getX() < width/2 && snake.getY() > height/2){
            if(monsterBotLeft.getX() > snake.getX()){
                monsterBotLeft.setX(monsterBotLeft.getX()-tileSize);
            }else if (monsterBotLeft.getX() < snake.getX()){
                monsterBotLeft.setX(monsterBotLeft.getX()+tileSize);
            } else if (monsterBotLeft.getX() == snake.getX() && monsterBotLeft.getY() > snake.getY()) {
                monsterBotLeft.setY(monsterBotLeft.getY()-tileSize);
            } else if (monsterBotLeft.getX() == snake.getX() && monsterBotLeft.getY() < snake.getY()) {
                monsterBotLeft.setY(monsterBotLeft.getY()+tileSize);
            }
        }
    }

    public void updateMonsterBotRight(Point monsterBotRight,Point snake,int width , int height ,int tileSize){
        if(snake.getX() > width/2 && snake.getY() > height/2){
            if(monsterBotRight.getX() > snake.getX()){
                monsterBotRight.setX(monsterBotRight.getX()-tileSize);
            }else if (monsterBotRight.getX() < snake.getX()){
                monsterBotRight.setX(monsterBotRight.getX()+tileSize);
            } else if (monsterBotRight.getX() == snake.getX() && monsterBotRight.getY() > snake.getY()) {
                monsterBotRight.setY(monsterBotRight.getY()-tileSize);
            } else if (monsterBotRight.getX() == snake.getX() && monsterBotRight.getY() < snake.getY()) {
                monsterBotRight.setY(monsterBotRight.getY()+tileSize);
            }
        }
    }
    public void updateMonsterEat3(Point monsterEat,Point food,int width,int height,int tileSize){
        Random random = new Random();
        if(food.getX() < width && food.getY() < height){
            if(monsterEat.getX() > food.getX()){
                monsterEat.setX(monsterEat.getX()- tileSize);
            }else  if(monsterEat.getX() < food.getX()){
                monsterEat.setX(monsterEat.getX()+ tileSize);
            } else if (monsterEat.getX() == food.getX() && monsterEat.getY() > food.getY()) {
                monsterEat.setY(monsterEat.getY()-tileSize);
            }else if (monsterEat.getX() == food.getX() && monsterEat.getY() < food.getY()) {
                monsterEat.setY(monsterEat.getY()+tileSize);
            }
        }
        if(monsterEat.getX() == food.getX() && monsterEat.getY() == food.getY()){

            food.setX(random.nextInt(width/tileSize)*tileSize);
            food.setY(random.nextInt(height/tileSize)*tileSize);
        }
    }

    public void updateMonsterGun(Point monsterGun , Point snake, int tileSize, List<Point> pullets){
        if(monsterGun.getX() > snake.getX() ){
            monsterGun.setX(monsterGun.getX()-tileSize);
        } else if (monsterGun.getX() < snake.getX()) {
            monsterGun.setX(monsterGun.getX()+tileSize);
        } else if (monsterGun.getX() == snake.getX()) {
            pullets.add(new Point(monsterGun.getX(), monsterGun.getY()+tileSize));
        }
    }

    public void updateBullet(List<Point> bullets ,int tileSize,int height){
        for (int i = 0 ; i < bullets.size() ; i++){
            if(bullets.get(i).getY() > height){
                bullets.remove(i);
            }else {
                bullets.get(i).setY(bullets.get(i).getY()+tileSize);
            }
        }
    }
}
