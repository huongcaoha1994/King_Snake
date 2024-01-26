//package com.example.snakegame.controllers;
//
//import com.example.snakegame.models.Point;
////import com.example.snakegame.utils.Random;
//import com.example.snakegame.views.Game1;
//import com.example.snakegame.views.Main;
//import javafx.scene.Scene;
//import javafx.scene.input.KeyCode;
//
//public class UpdateMovie {
//    public void updateBoss(Point boss,Point snake,Point area, int tileSize){
//        if(snake.getX() < area.getX() && snake.getY() < area.getY()){
//            if(snake.getY() > area.getY()){
//                boss.setY(boss.getY()-tileSize);
//            } else if (snake.getY() < area.getY()) {
//                boss.setY(boss.getY()+tileSize);
//            } else if (boss.getY() == area.getY() && boss.getX() > area.getX()) {
//                boss.setX(boss.getX()-tileSize);
//            } else if (boss.getY() == area.getY() && boss.getX() < area.getX()) {
//                boss.setX(boss.getX()+tileSize);
//            }
//        }
//        if(boss.getX() == snake.getX() && boss.getY() == snake.getY()){
//            System.out.println("Game over");
//            return;
//        }
//    }
//    public void updateSnake(Scene scene,Point snake,int tileSize,Point food){
//        scene.setOnKeyPressed(keyEvent -> {
//            KeyCode keyCode = keyEvent.getCode();
//            switch (keyCode){
//                case UP :{
//                    snake.setY(snake.getY()-tileSize);
//                    break;
//                }
//                case DOWN:{
//                    snake.setY(snake.getY()+tileSize);
//                    break;
//                }
//                case LEFT:{
//                    snake.setX(snake.getX()-tileSize);
//                    break;
//                }
//                case RIGHT:{
//                    snake.setX(snake.getX()+tileSize);
//                    break;
//                }
//            }
//
//        });
//    }
//}
