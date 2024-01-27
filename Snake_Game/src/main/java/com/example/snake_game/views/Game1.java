package com.example.snake_game.views;

import com.example.snake_game.controllers.UpdateMovie;
import com.example.snake_game.models.Point;
import com.example.snake_game.resources.Draws;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.Optional;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class Game1 extends Application {
    private static final int WIDTH = 1200;
    private static final int HEIGHT = 800 ;
    private static final int TILE_SIZE = 40 ;
    Random random = new Random();
    static Point snake = new Point(WIDTH/2,HEIGHT/2);
    static Point boss = new Point(40,40);
    static Point food = new Point();
    public static boolean gameOver = false;
    public static int score = 0 ;
    public static void udpateScore(){
        if(snake.getX() == food.getX() && snake.getY() == food.getY()){
            score++;
        }
    }
    private static void restart(){
        snake = new Point(WIDTH/2,HEIGHT/2);
        boss = new Point(40,40);
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
                updateMovie.updateBoss(boss,snake,new Point(TILE_SIZE*10,TILE_SIZE*10),TILE_SIZE,gameOver);
                Draws draws = new Draws() ;
                draws.draw(food,boss,snake,WIDTH,HEIGHT,gc,TILE_SIZE,score);
                Platform.runLater(() -> {
                    if(boss.getX() == snake.getX() && boss.getY() == snake.getY()){
                        gameOver = true;
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
                            restart();
                            start(primaryStage);
                        } else if (result.isPresent() && result.get() == buttonTypeNo) {
                            primaryStage.close();
                        }


                    }
                });
            }
        },0,100);

        primaryStage.setTitle("Game Boss 1");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }
}
