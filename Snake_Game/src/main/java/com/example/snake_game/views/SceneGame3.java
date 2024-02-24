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

import java.util.*;

public class SceneGame3 {
    private static int tileSize = 60 ;
    private static int width = tileSize*20;
    private static int height = tileSize*13;
    private static IntegerProperty score = new SimpleIntegerProperty(14);
    private static Point snake ;
    private static Point monsterGun ;
    private static Point monsterEat ;
    private static Point monster ;
    private static Point food ;
    public static Point gate = new Point(width/2,0);
    private static List<Point> bullets = new ArrayList<>();
    static Random random = new Random();
    public void setFood(){
        Random random = new Random();
        food.setX(random.nextInt(width/tileSize)*tileSize);
        food.setY(random.nextInt(height/tileSize)*tileSize);
    }
    public static void restart(){
        snake = new Point(tileSize*10,tileSize*7);
        monsterGun = new Point((width/tileSize)*tileSize,0);
        monsterEat = new Point(random.nextInt(width/tileSize)*tileSize,(height/tileSize)*tileSize);
        food = new Point(random.nextInt(width/tileSize)*tileSize, random.nextInt(height/tileSize)*tileSize );
        monster = new Point(random.nextInt(width/tileSize)*tileSize, random.nextInt(height/tileSize)*tileSize );
        bullets.clear();
        score.set(14);
    }

    public static Scene game3(Stage primaryStage , String username){
//        MediaPlay.playMusic("C:\\Users\\dell\\IdeaProjects\\King_Snake\\Snake_Game\\src\\main\\java\\com\\example\\snake_game\\resources\\music\\nhacnen.mp3");
        int skin = Getskin.getSkin(username);
        Image skinImage = GetSnakeDisplay.getImageSnakeDisplay(skin);
        restart();
        UpdateMovie updateMovie = new UpdateMovie();
        Draws draws = new Draws();

        Canvas canvas = new Canvas(width,height);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        Pane layout = new Pane(canvas);
        Scene scene = new Scene(layout,width,height);
        scene.setOnKeyPressed(keyEvent -> {
            updateMovie.updateSnake(gc,scene,snake,tileSize,food,width,height,score);
            draws.drawGame3(gc,width,height,tileSize,snake,monsterEat,monsterGun,bullets,food,score,monster,skinImage);


        });
        Timer timerMonsterGun = new Timer();
        timerMonsterGun.schedule(new TimerTask() {
            @Override
            public void run() {
                updateMovie.updateMonsterGun(monsterGun,snake,tileSize,bullets);
                draws.drawGame3(gc,width,height,tileSize,snake,monsterEat,monsterGun,bullets,food,score,monster,skinImage);
            }
        },0,300);

        Timer timerMonsterEat = new Timer();
        timerMonsterEat.schedule(new TimerTask() {
            @Override
            public void run() {
                updateMovie.updateMonsterEat3(monsterEat,food,width,height,tileSize);
                draws.drawGame3(gc,width,height,tileSize,snake,monsterEat,monsterGun,bullets,food,score,monster,skinImage);
                Platform.runLater(() -> {
                    if(monsterEat.getX() == snake.getX() && monsterEat.getY() == snake.getY()){
                        timerMonsterEat.cancel();
                        timerMonsterGun.cancel();
                        int oldScore = GetScore.getScore(username);
                        if(score.get() > oldScore){
                            UpdateScore.updateScore(username,score.get());
                            UpdateRank.updateRank(username,score.get());
                        }
                        primaryStage.setScene(SceenGameover.SceneClose(primaryStage,3,username));
                        primaryStage.show();
                    }
                });
            }
        },0,200);

        Timer timerMonster = new Timer();
        timerMonster.schedule(new TimerTask() {
            @Override
            public void run() {

                updateMovie.updateMonster(monster,snake,tileSize);
                draws.drawGame3(gc,width,height,tileSize,snake,monsterEat,monsterGun,bullets,food,score,monster,skinImage);
                Platform.runLater(() -> {
                    if(monster.getX() == snake.getX() && monster.getY() == snake.getY()){
                        timerMonster.cancel();
                        timerMonsterEat.cancel();
                        timerMonsterGun.cancel();
                        int oldScore = GetScore.getScore(username);
                        if(score.get() > oldScore){
                            UpdateScore.updateScore(username,score.get());
                            UpdateRank.updateRank(username,score.get());
                        }
                        primaryStage.setScene(SceenGameover.SceneClose(primaryStage,3,username));
                        primaryStage.show();
                    }
                });
            }
        },0,300);


        Timer timerBullet = new Timer();
        timerBullet.schedule(new TimerTask() {
            @Override
            public void run() {
                updateMovie.updateBullet(bullets,tileSize,height);
                draws.drawBullet(gc,bullets,tileSize);
                Platform.runLater(() -> {
                    for(int i = 0 ; i < bullets.size() ; i++){
                        if(bullets.get(i).getX() == snake.getX() && bullets.get(i).getY() == snake.getY()){
                            timerBullet.cancel();
                            timerMonster.cancel();
                            timerMonsterEat.cancel();
                            timerMonsterGun.cancel();
                            int oldScore = GetScore.getScore(username);
                            if(score.get() > oldScore){
                                UpdateScore.updateScore(username,score.get());
                                UpdateRank.updateRank(username,score.get());
                            }
                            primaryStage.setScene(SceenGameover.SceneClose(primaryStage,3,username));
                            primaryStage.show();
                        }
                    }
                    if(snake.getX() == gate.getX() && snake.getY() == gate.getY() && score.get() >= 15){
                        timerBullet.cancel();
                        timerMonster.cancel();
                        timerMonsterEat.cancel();
                        timerMonsterGun.cancel();
                        int oldScore = GetScore.getScore(username);
                        if(score.get() > oldScore){
                            UpdateScore.updateScore(username,score.get());
                            UpdateRank.updateRank(username,score.get());
                        }
                        primaryStage.setScene(SceenGameWin.WinGame(primaryStage,3,username));
                        primaryStage.show();
                    }
                });
            }
        },0,100);
        return scene;
    }
}
