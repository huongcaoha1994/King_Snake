package com.example.snake_game.views;

import com.example.snake_game.controllers.UpdateMovie;
import com.example.snake_game.models.Point;
import com.example.snake_game.resources.Draws;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class Game1 extends Application {
    private static final int WIDTH = 1200;
    private static final int HEIGHT = 800 ;
    private static final int TILE_SIZE = 20 ;
    Random random = new Random();
    static Point snake = new Point(WIDTH/2,HEIGHT/2);
    Point boss = new Point(40,40);
    static Point food = new Point();

    public static int score = 0 ;
    public static void udpateScore(){
        if(snake.getX() == food.getX() && snake.getY() == food.getY()){
            score++;
        }
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Canvas canvas = new Canvas(WIDTH,HEIGHT);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        Pane layout = new Pane(canvas);
        Scene scene = new Scene(layout,WIDTH,HEIGHT);
        scene.setOnKeyPressed(keyEvent -> {
            UpdateMovie updateMovie = new UpdateMovie();
            updateMovie.updateSnake(scene,snake,TILE_SIZE,food,WIDTH,HEIGHT,score);
            Draws draws = new Draws() ;
            draws.draw(food,boss,snake,WIDTH,HEIGHT,gc,TILE_SIZE,score);
            Game1.udpateScore();
        });
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                UpdateMovie updateMovie = new UpdateMovie();
                updateMovie.updateBoss(boss,snake,new Point(WIDTH/2-100,HEIGHT/2-100),TILE_SIZE);
                Draws draws = new Draws() ;
                draws.draw(food,boss,snake,WIDTH,HEIGHT,gc,TILE_SIZE,score);
            }
        },0,70);

        primaryStage.setTitle("Game Boss 1");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}