package com.example.snake_game.views;

import com.example.snake_game.controllers.UpdateMovie;
import com.example.snake_game.models.Point;
import com.example.snake_game.resources.Draws;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*; 
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.*;

public class Game1 extends Application {
    private static  int WIDTH = 1200;
    private static  int HEIGHT = 800 ;
    private static  int TILE_SIZE = 40 ;
    int score = 0 ;
    static Random random = new Random();
    static Point snake = new Point(WIDTH/2,HEIGHT/2);
    static Point boss = new Point(40,40);
    static Point food = new Point();
    public static Point monsters ;


    private static void restart(){
        snake = new Point(WIDTH/2,HEIGHT/2);
        boss = new Point(40,40);
            monsters = new Point(random.nextInt(WIDTH/TILE_SIZE)*TILE_SIZE, random.nextInt(HEIGHT/TILE_SIZE)*TILE_SIZE);
        food.setX(random.nextInt(WIDTH / TILE_SIZE)*TILE_SIZE);
        food.setY(random.nextInt(HEIGHT / TILE_SIZE)*TILE_SIZE);
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
            updateMovie.updateSnake(scene,snake,TILE_SIZE,food,WIDTH,HEIGHT);
            if(snake.getX() == food.getX() && snake.getY() == food.getY()){
                if(snake.getX() == food.getX() && snake.getY() == food.getY()){
                    score = 2;

                }
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
                   game1.GameoverAlert(timer1,primaryStage,boss);
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
                    game1.GameoverAlert(timer2,primaryStage,monsters);
                });
            }
        },0,210);

        primaryStage.setTitle("Game Boss 1");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public void GameoverAlert(Timer timer,Stage primaryStage,Point monster){
        if(monster.getX() == snake.getX() && monster.getY() == snake.getY()){
            timer.cancel();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Game Over");
            alert.setHeaderText("Information");
            alert.setContentText("Game Over ! Are you want replay ?");
            ButtonType buttonTypeYes = new ButtonType("Yes", ButtonBar.ButtonData.YES);
            ButtonType buttonTypeNo = new ButtonType("No", ButtonBar.ButtonData.NO);

            alert.getButtonTypes().setAll(buttonTypeYes,buttonTypeNo);

            Optional<ButtonType> result = alert.showAndWait();
            if (result.isPresent() && result.get() == buttonTypeYes) {
                timer.cancel();
                start(primaryStage);
                restart();
            } else if (result.isPresent() && result.get() == buttonTypeNo) {
                primaryStage.close();
            }


        }
    }
}
