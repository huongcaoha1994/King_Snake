package com.example.snake_game.views;

import com.example.snake_game.controllers.UpdateMovie;
import com.example.snake_game.models.*;
import com.example.snake_game.resources.Draws;
import com.example.snake_game.utils.MediaPlay;
import javafx.application.Platform;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class SceneGame2 {
    private static  int TILE_SIZE = 60 ;
    private static  int WIDTH = TILE_SIZE*20;
    private static  int HEIGHT = TILE_SIZE*13 ;
    static Random random = new Random();
    public static Point snake = new Point(TILE_SIZE*10,TILE_SIZE*7);
    public static Point monsterEat = new Point(WIDTH/2,HEIGHT/4);
    public static Point monsterLeft  = new Point(WIDTH/4,(HEIGHT/4)*3);
    public static Point monsterRight = new Point((WIDTH/4)*3,(HEIGHT/4)*3);
    public static Point food = new Point();
    private static IntegerProperty score = new SimpleIntegerProperty(0);
    public static Point gate = new Point(WIDTH/2,0);
    private static int timer1 = 190;
    private static int timer2 = 210;
    private static int timer3 = 200;

    public static void restart(){
        snake = new Point(TILE_SIZE*10,TILE_SIZE*7);
        monsterEat = new Point(WIDTH/2,TILE_SIZE*5);
        monsterLeft  = new Point(TILE_SIZE*5,TILE_SIZE*12);
        monsterRight = new Point(TILE_SIZE*15,TILE_SIZE*12);
        food.setX(random.nextInt(WIDTH / TILE_SIZE)*TILE_SIZE);
        food.setY(random.nextInt(HEIGHT / TILE_SIZE)*TILE_SIZE);
        score.set(14);
        timer1 = 190 ;
        timer2 = 210 ;
        timer3 = 200 ;
    }
    public static void setFood(){
        food.setX(random.nextInt(WIDTH / TILE_SIZE)*TILE_SIZE);
        food.setY(random.nextInt(HEIGHT / TILE_SIZE)*TILE_SIZE);
    }

    public static Scene game2(Stage primaryStage , String username){
//        MediaPlay.playMusic("C:\\Users\\dell\\IdeaProjects\\King_Snake\\Snake_Game\\src\\main\\java\\com\\example\\snake_game\\resources\\music\\nhacnen.mp3");
        int skin = Getskin.getSkin(username);
        Image skinImage = GetSnakeDisplay.getImageSnakeDisplay(skin);
        UpdateMovie updateMovie = new UpdateMovie();
        Draws draws = new Draws() ;
        restart();

        Canvas canvas = new Canvas(WIDTH,HEIGHT);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        Pane layout = new Pane(canvas);
        Scene scene = new Scene(layout,WIDTH,HEIGHT);
        scene.setOnKeyPressed(keyEvent -> {
            updateMovie.updateSnake(gc,scene,snake,TILE_SIZE,food,WIDTH,HEIGHT,score);

            draws.drawGame2(gc,snake,monsterEat,monsterLeft,monsterRight,food,TILE_SIZE,WIDTH,HEIGHT,score,skinImage);
        });
        Timer timerMonsterEAt = new Timer();
        timerMonsterEAt.schedule(new TimerTask() {
            @Override
            public void run() {
                updateMovie.updateMonsterEat(monsterEat,food,WIDTH,HEIGHT,TILE_SIZE);
                draws.drawGame2(gc,snake,monsterEat,monsterLeft,monsterRight,food,TILE_SIZE,WIDTH,HEIGHT,score,skinImage);
                Platform.runLater(() -> {
                    if(monsterEat.getX() == snake.getX() && monsterEat.getY() == snake.getY()){
                        int oldScore = GetScore.getScore(username);
                        if(score.get() > oldScore){
                            UpdateScore.updateScore(username,score.get());
                            UpdateRank.updateRank(username,score.get());
                        }
                        AddCoin.updateCoin(username,score.get());
                        timerMonsterEAt.cancel();
                        primaryStage.setScene(SceenGameover.SceneClose(primaryStage,2,username));
                        primaryStage.show();
                    }

                });
            }
        },0,timer1);

        Timer timerMonsterLeft = new Timer();
        timerMonsterLeft.schedule(new TimerTask() {
            @Override
            public void run() {
                updateMovie.updateMonsterBotLelt(monsterLeft,snake,WIDTH,HEIGHT,TILE_SIZE);
                draws.drawGame2(gc,snake,monsterEat,monsterLeft,monsterRight,food,TILE_SIZE,WIDTH,HEIGHT,score,skinImage);
                Platform.runLater(() -> {
                    if(monsterLeft.getX() == snake.getX() && monsterLeft.getY() == snake.getY()){
                        timerMonsterEAt.cancel();
                        timerMonsterLeft.cancel();
                        int oldScore = GetScore.getScore(username);
                        if(score.get() > oldScore){
                            UpdateScore.updateScore(username,score.get());
                            UpdateRank.updateRank(username,score.get());
                        }
                        AddCoin.updateCoin(username,score.get());
                        primaryStage.setScene(SceenGameover.SceneClose(primaryStage,2,username));
                        primaryStage.show();
                    }
                });
            }
        },0,timer2);

        Timer timerMonsterRight = new Timer();
        timerMonsterRight.schedule(new TimerTask() {
            @Override
            public void run() {
                updateMovie.updateMonsterBotRight(monsterRight,snake,WIDTH,HEIGHT,TILE_SIZE);
                draws.drawGame2(gc,snake,monsterEat,monsterLeft,monsterRight,food,TILE_SIZE,WIDTH,HEIGHT,score,skinImage);
                Platform.runLater(() -> {
                    if(monsterRight.getX() == snake.getX() && monsterRight.getY() == snake.getY()){
                        timerMonsterEAt.cancel();
                        timerMonsterRight.cancel();
                        timerMonsterLeft.cancel();
                        int oldScore = GetScore.getScore(username);
                        if(score.get() > oldScore){
                            UpdateScore.updateScore(username,score.get());
                            UpdateRank.updateRank(username,score.get());
                        }
                        AddCoin.updateCoin(username,score.get());
                        primaryStage.setScene(SceenGameover.SceneClose(primaryStage,2,username));
                        primaryStage.show();
                    }
                    if(snake.getX() == gate.getX() && snake.getY() == gate.getY() && score.get() >= 15){
                        timerMonsterEAt.cancel();
                        timerMonsterRight.cancel();
                        timerMonsterLeft.cancel();
                        int oldLevel = GetLevel.getLevel(username);
                        if(oldLevel < 3){
                            UpdateLevel.updateLevel(username,3);
                        }
                        int oldScore = GetScore.getScore(username);
                        if(score.get() > oldScore){
                            UpdateScore.updateScore(username,score.get());
                            UpdateRank.updateRank(username,score.get());
                        }
                        AddCoin.updateCoin(username,score.get());
                        primaryStage.setScene(SceenGameWin.WinGame(primaryStage,2,username));
                        primaryStage.show();
                    }
                });

            }
        },0,timer3);
        return scene;
    }
}
