package com.example.kingsnack;

import entity.Food;
import entity.Snake;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class GameLayout2 extends Application {
    private static final int WIDTH = 600 ;
    private static final int HEIGHT = 600 ;
    private static final int TILE_SIZE = 20 ;
    Snake snake = new Snake(WIDTH/2,HEIGHT/2);
    Food food = new Food();
    Snake boss1 = new Snake(20,20);


    private void setFood(){
        Random random = new Random();
        food.setX(random.nextInt(WIDTH/TILE_SIZE)*TILE_SIZE);
        food.setY(random.nextInt(HEIGHT/TILE_SIZE)*TILE_SIZE);
    }
    private void draw(GraphicsContext gc){
        Image imageBoss = new Image("file:///C:\\Users\\dell\\IdeaProjects\\KingSnack\\image\\boss.png");
        Image imageSnake = new Image("file:///C:\\Users\\dell\\IdeaProjects\\KingSnack\\image\\snake.jpg");
        Image imaghheShit = new Image("file:///C:\\Users\\dell\\IdeaProjects\\KingSnack\\image\\shit.jpg");
        gc.setFill(Color.WHITE);
        gc.fillRect(0,0,WIDTH,HEIGHT);

        gc.drawImage(imageSnake,snake.getX(),snake.getY(),TILE_SIZE,TILE_SIZE);
//        gc.fillRect(snake.getX(), snake.getY(), TILE_SIZE,TILE_SIZE);

        gc.drawImage(imaghheShit, food.getX(), food.getY(),TILE_SIZE,TILE_SIZE);
//        gc.setFill(Color.GREEN);
//        gc.fillRect(food.getX(), food.getY(), TILE_SIZE,TILE_SIZE);
        gc.drawImage(imageBoss, boss1.getX(), boss1.getY(),TILE_SIZE,TILE_SIZE);
//        gc.setFill(Color.BLUE);
//        gc.fillRect(boss1.getX(), boss1.getY(), TILE_SIZE,TILE_SIZE);

    }
    private void bossHunter(){
        if(snake.getX() < WIDTH/2 && snake.getY() < HEIGHT/2){
            if(boss1.getY() > snake.getY()){
                boss1.setY(boss1.getY()-TILE_SIZE);
            } else if (boss1.getY() < snake.getY()) {
                boss1.setY(boss1.getY()+TILE_SIZE);
            } else if (boss1.getY() == snake.getY() &&  boss1.getX() > snake.getX()) {
                boss1.setX(boss1.getX()-TILE_SIZE);
            } else if (boss1.getY() == snake.getY() && boss1.getX() < snake.getX()) {
                boss1.setX(boss1.getX()+TILE_SIZE);
            }
        }



        if(boss1.getX() == snake.getX() && boss1.getY() == snake.getY()){
            System.out.println("Game over");
            return;
        }

    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Canvas canvas = new Canvas(WIDTH,HEIGHT);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        Pane pane =new Pane(canvas);
        Scene scene = new Scene(pane,WIDTH,HEIGHT);
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                KeyCode keyCode = keyEvent.getCode();
                switch (keyCode){
                    case UP -> {
                        snake.setY(snake.getY()-TILE_SIZE);
                        break;
                    }
                    case DOWN -> {
                        snake.setY(snake.getY()+TILE_SIZE);
                        break;
                    }
                    case LEFT -> {
                        snake.setX(snake.getX()-TILE_SIZE);
                        break;
                    }
                    case RIGHT -> {
                        snake.setX(snake.getX()+TILE_SIZE);
                        break;
                    }
                }
                if(snake.getX() == food.getX() && snake.getY() == food.getY()){
                    setFood();
                }
                draw(gc);
            }
        });
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                bossHunter();
                draw(gc);
            }
        },0,100);
        primaryStage.setTitle("Snake Game");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
