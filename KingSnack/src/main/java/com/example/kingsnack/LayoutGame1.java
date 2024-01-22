package com.example.kingsnack;

import entity.Food;
import entity.Snake;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class LayoutGame1 extends Application {
    private static final int WIDTH = 600 ;
    private static final int HEIGHT = 600 ;
    private static final int TILE_SIZE = 20 ;


    private enum Direction {
        UP,DOWN,LEFT,RIGHT
    }
    private Direction direction = Direction.RIGHT;
    Snake snake = new Snake(WIDTH/2,HEIGHT/2);
    Food food = new Food();
    Snake boss1 = new Snake(20,20);


    private void setFood(){
        Random random = new Random();
        food.setX(random.nextInt(WIDTH/TILE_SIZE)*TILE_SIZE);
        food.setY(random.nextInt(HEIGHT/TILE_SIZE)*TILE_SIZE);
    }
    private void updateSnake(GraphicsContext gc){
        if(direction == Direction.UP){
            snake.setY(snake.getX()-TILE_SIZE);
        } else if (direction == Direction.DOWN) {
            snake.setY(snake.getY()+TILE_SIZE);
        } else if (direction == Direction.LEFT) {
            snake.setX(snake.getY()-TILE_SIZE);
        } else if (direction == Direction.RIGHT) {
            snake.setX(snake.getY()+TILE_SIZE);
        }

        if(snake.getX() == food.getX() && snake.getY() == food.getY()){
            setFood();
        }

        gc.setFill(Color.WHITE);
        gc.fillRect(0,0,WIDTH,HEIGHT);

        gc.setFill(Color.RED);
        gc.fillRect(snake.getX(), snake.getY(), TILE_SIZE,TILE_SIZE);

        gc.setFill(Color.GREEN);
        gc.fillRect(food.getX(), food.getY(), TILE_SIZE,TILE_SIZE);

    }
    private void draw(GraphicsContext gc){
        gc.setFill(Color.WHITE);
        gc.fillRect(0,0,WIDTH,HEIGHT);

        gc.setFill(Color.RED);
        gc.fillRect(snake.getX(), snake.getY(), TILE_SIZE,TILE_SIZE);

        gc.setFill(Color.GREEN);
        gc.fillRect(food.getX(), food.getY(), TILE_SIZE,TILE_SIZE);

        gc.setFill(Color.BLUE);
        gc.fillRect(boss1.getX(), boss1.getY(), TILE_SIZE,TILE_SIZE);



    }
    private int maxRadius = 160;

    private void updateBoss(){

            if(snake.getX() <= maxRadius){
               hunter();
            } else if (snake.getY() <= maxRadius) {
               hunter();
            }

        if (boss1.getX() == snake.getX() && boss1.getY() == snake.getY()){
            System.out.println("Game over");
            return;
        }
        if(snake.getX() == food.getX() && snake.getY() == food.getY()){
            setFood();
        }
    }
    private void hunter(){
        while (boss1.getX() >= maxRadius || boss1.getY() >= maxRadius){
            if(boss1.getX() < snake.getX()){
                boss1.setX(boss1.getX()+TILE_SIZE);
            } else if (boss1.getX() > snake.getX()) {
                boss1.setX(boss1.getX()-TILE_SIZE);
            } else if (boss1.getX() == snake.getX() && boss1.getY() > snake.getY()) {
                boss1.setY(boss1.getY()-TILE_SIZE);
            } else if (boss1.getX() == snake.getX() && boss1.getY() < snake.getY()) {
                boss1.setY(boss1.getY()+TILE_SIZE);
            }
        }
    }


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Canvas canvas = new Canvas(WIDTH,HEIGHT);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        setFood();

        Pane layout = new Pane(canvas);
        Scene scene = new Scene(layout,WIDTH,HEIGHT);
        scene.setOnKeyPressed(keyEvent -> {
            KeyCode keyCode = keyEvent.getCode();
            switch (keyCode){
                case UP -> {
                    if(snake.getY() < 0){
                        snake.setY(0);
                        break;
                    }else {
                        snake.setY(snake.getY()-TILE_SIZE);
                        break;
                    }

                }
                case DOWN -> {
                    if( snake.getY() > HEIGHT){
                        snake.setY(HEIGHT);
                        break;
                    }else {
                        snake.setY(snake.getY()+TILE_SIZE);
                        break;
                    }

                }
                case LEFT -> {
                    if(snake.getX() < 0 ){
                        snake.setX(0);
                        break;
                    }else {
                        snake.setX(snake.getX()-TILE_SIZE);
                        break;
                    }

                }
                case RIGHT -> {
                    if(snake.getX() > WIDTH ){
                        snake.setX(WIDTH);
                        break;
                    }else {
                        snake.setX(snake.getX()+TILE_SIZE);
                        break;
                    }

                }

            }
            draw(gc);
        });
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                updateBoss();
                draw(gc);
            }
        },0,100);
        primaryStage.setTitle("Snake Game");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
