package com.example.snake_game.views;

import com.example.snake_game.controllers.UpdateMovie;
import com.example.snake_game.models.Point;
import com.example.snake_game.resources.Draws;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.*;

public class Game1 extends Application {
    private static  int TILE_SIZE = 60 ;
    private static  int WIDTH = TILE_SIZE*20;
    private static  int HEIGHT = TILE_SIZE*16 ;

    private IntegerProperty score = new SimpleIntegerProperty(0);
    static Random random = new Random();
    static Point snake = new Point(WIDTH,HEIGHT);
    static Point boss = new Point(TILE_SIZE,TILE_SIZE);
    static Point food = new Point();
    public static Point monsters ;
    public static Point gate = new Point(WIDTH/2,0);


    public void setFood(){
        food.setX(random.nextInt(WIDTH / TILE_SIZE)*TILE_SIZE);
        food.setY(random.nextInt(HEIGHT / TILE_SIZE)*TILE_SIZE);

    }


    private static void restart(){
        snake = new Point(TILE_SIZE*10,TILE_SIZE*7);
        boss = new Point(TILE_SIZE,TILE_SIZE);
            monsters = new Point(0, random.nextInt(HEIGHT/TILE_SIZE)*TILE_SIZE);
        food.setX(random.nextInt(WIDTH / TILE_SIZE)*TILE_SIZE);
        food.setY(random.nextInt(HEIGHT / TILE_SIZE)*TILE_SIZE);
         gate = new Point(WIDTH/2,0);
    }
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void  start(Stage primaryStage) {
        Game1 game1 = new Game1();
        restart();
        Canvas canvas = new Canvas(WIDTH,HEIGHT);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        Draws draws = new Draws() ;
        Pane layout = new Pane(canvas);
        Scene scene = new Scene(layout,WIDTH,HEIGHT);
        scene.setOnKeyPressed(keyEvent -> {
            UpdateMovie updateMovie = new UpdateMovie();
            updateMovie.updateSnake(gc,scene,snake,TILE_SIZE,food,WIDTH,HEIGHT,score);
            if(snake.getX() == gate.getX() && gate.getY() == food.getY() && score.get() >= 15){
                start(primaryStage);
                restart();
            }
            draws.draw(food,boss,snake,WIDTH,HEIGHT,gc,TILE_SIZE,score,monsters);


        });

        Timer timer1 = new Timer();
        timer1.schedule(new TimerTask() {
            @Override
            public void run() {
                UpdateMovie updateMovie = new UpdateMovie();
                updateMovie.updateBoss(boss,snake,new Point(TILE_SIZE*10,TILE_SIZE*10),TILE_SIZE);
                draws.draw(food,boss,snake,WIDTH,HEIGHT,gc,TILE_SIZE,score,monsters);
                Platform.runLater(() -> {
                    timer1.cancel();
                    if(boss.getX() == snake.getX() && boss.getY() == snake.getY()){
                        SceneGameover gameover = new SceneGameover();
                        gameover.start(primaryStage);
                    }
                });

            }
        },0,200);
        Timer timer2 = new Timer();
        timer2.schedule(new TimerTask() {
            @Override
            public void run() {
                UpdateMovie updateMovie = new UpdateMovie();

                    updateMovie.updateMonster(monsters,snake,TILE_SIZE);

                draws.draw(food,boss,snake,WIDTH,HEIGHT,gc,TILE_SIZE,score,monsters);
                Platform.runLater(() -> {
                    if(monsters.getX() == snake.getX() && monsters.getY() == snake.getY()){
                        timer2.cancel();
                        timer1.cancel();
                        SceneGameover gameover = new SceneGameover();
                        gameover.start(primaryStage);
                    }
                    if(snake.getX() == gate.getX() && snake.getY() == gate.getY() && score.get() >= 15){
                        timer2.cancel();
                        timer1.cancel();
                        SceneWinner demo = new SceneWinner();
                        demo.start(primaryStage);
                    }
                });
            }
        },0,310);

        primaryStage.setTitle("Game Boss 1");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();

        Canvas canvas1 = new Canvas();
    }


}
