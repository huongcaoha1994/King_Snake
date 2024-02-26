package com.example.snake_game.views;

import com.example.snake_game.controllers.UpdateMovie;
import com.example.snake_game.models.*;
import com.example.snake_game.resources.Draws;
import com.example.snake_game.utils.MediaPlay;
import com.example.snake_game.utils.StringPathImage;
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

public class GameRank {
    public static String username;
    public void setUsername(String username){
        this.username = username ;
    }
    private static  int TILE_SIZE = 60 ;
    private static  int WIDTH = TILE_SIZE*20;
    private static  int HEIGHT = TILE_SIZE*13 ;
    private static IntegerProperty score = new SimpleIntegerProperty(0);
    private static int speed = 300;
    static Random random = new Random();
    static Point snake = new Point(WIDTH,HEIGHT);
    static Point boss = new Point(TILE_SIZE,TILE_SIZE);
    static Point food = new Point();
    public static Point monsters ;




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

        score.set(0);
        speed = 300;
    }
    public static Scene gameRank(Stage primaryStage , String username){
        int skin = Getskin.getSkin(username);
        Image skinImage = GetSnakeDisplay.getImageSnakeDisplay(skin);
//        MediaPlay.playMusic("C:\\Users\\dell\\IdeaProjects\\King_Snake\\Snake_Game\\src\\main\\java\\com\\example\\snake_game\\resources\\music\\nhacnen.mp3");
        restart();
        Canvas canvas = new Canvas(WIDTH,HEIGHT);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        Draws draws = new Draws() ;
        Pane layout = new Pane(canvas);
        Scene scene = new Scene(layout,WIDTH,HEIGHT);
        scene.setOnKeyPressed(keyEvent -> {
            UpdateMovie updateMovie = new UpdateMovie();
            updateMovie.updateSnakeGameRank(gc,scene,snake,TILE_SIZE,food,WIDTH,HEIGHT,score);
            draws.drawGameRank(food,boss,snake,WIDTH,HEIGHT,gc,TILE_SIZE,score,monsters,skinImage);



        });

        Timer timer1 = new Timer();
        timer1.schedule(new TimerTask() {
            @Override
            public void run() {
                UpdateMovie updateMovie = new UpdateMovie();
                updateMovie.updateBoss(boss,snake,new Point(TILE_SIZE*10,TILE_SIZE*10),TILE_SIZE);
                draws.drawGameRank(food,boss,snake,WIDTH,HEIGHT,gc,TILE_SIZE,score,monsters,skinImage);
                Platform.runLater(() -> {

                    if(boss.getX() == snake.getX() && boss.getY() == snake.getY()){
                        timer1.cancel();
                        int oldScore = GetScore.getScore(username);
                        if(score.get() > oldScore){
                            UpdateScore.updateScore(username,score.get());
                            UpdateRank.updateRank(username,score.get());
                            AddCoin.updateCoin(username,score.get());
                        }
                        primaryStage.setScene(SceenGameover.SceneClose(primaryStage,4,username));
                        primaryStage.show();
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

                draws.drawGameRank(food,boss,snake,WIDTH,HEIGHT,gc,TILE_SIZE,score,monsters,skinImage);
                Platform.runLater(() -> {
                    if(monsters.getX() == snake.getX() && monsters.getY() == snake.getY()){
                        timer2.cancel();
                        timer1.cancel();
                        int oldScore = GetScore.getScore(username);
                        if(score.get() > oldScore){
                            UpdateScore.updateScore(username,score.get());
                            UpdateRank.updateRank(username,score.get());
                            AddCoin.updateCoin(username,score.get());
                        }
                        primaryStage.setScene(SceenGameover.SceneClose(primaryStage,4,username));
                        primaryStage.show();
                    }
                    if(score.get() % 5 == 0 && score.get() >= 5){
                        speed+= 50 ;
                    }
                });
            }
        },0,speed);
        return scene ;
    }
}
