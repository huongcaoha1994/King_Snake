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
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.Optional;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class Game2 extends Application {
    private static  int TILE_SIZE = 60 ;
    private static  int WIDTH = TILE_SIZE*20;
    private static  int HEIGHT = TILE_SIZE*16 ;
    static Random random = new Random();
    public static Point snake = new Point(TILE_SIZE*10,TILE_SIZE*7);
    public static Point monsterEat = new Point(WIDTH/2,HEIGHT/4);
    public static Point monsterLeft  = new Point(WIDTH/4,(HEIGHT/4)*3);
    public static Point monsterRight = new Point((WIDTH/4)*3,(HEIGHT/4)*3);
    public static Point food = new Point();
    private IntegerProperty score = new SimpleIntegerProperty(0);
    public static void restart(){
        snake = new Point(TILE_SIZE*10,TILE_SIZE*7);
        monsterEat = new Point(WIDTH/2,TILE_SIZE*5);
        monsterLeft  = new Point(TILE_SIZE*5,TILE_SIZE*12);
        monsterRight = new Point(TILE_SIZE*15,TILE_SIZE*12);
       food.setX(random.nextInt(WIDTH / TILE_SIZE)*TILE_SIZE);
       food.setY(random.nextInt(HEIGHT / TILE_SIZE)*TILE_SIZE);

    }
    public static void setFood(){
        food.setX(random.nextInt(WIDTH / TILE_SIZE)*TILE_SIZE);
        food.setY(random.nextInt(HEIGHT / TILE_SIZE)*TILE_SIZE);
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Game2 game2 = new Game2();
        restart();
        UpdateMovie updateMovie = new UpdateMovie();
        Draws draws = new Draws() ;

        Canvas canvas = new Canvas(WIDTH,HEIGHT);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        Pane layout = new Pane(canvas);
        Scene scene = new Scene(layout,WIDTH,HEIGHT);
        scene.setOnKeyPressed(keyEvent -> {
            updateMovie.updateSnake(gc,scene,snake,TILE_SIZE,food,WIDTH,HEIGHT,score);
            if(snake.getX() == food.getX() && snake.getY() == food.getY()){

            }
            draws.drawGame2(gc,snake,monsterEat,monsterLeft,monsterRight,food,TILE_SIZE,WIDTH,HEIGHT,score);
        });
        Timer timerMonsterEAt = new Timer();
        timerMonsterEAt.schedule(new TimerTask() {
            @Override
            public void run() {
                updateMovie.updateMonsterEat(monsterEat,food,WIDTH,HEIGHT,TILE_SIZE);
                draws.drawGame2(gc,snake,monsterEat,monsterLeft,monsterRight,food,TILE_SIZE,WIDTH,HEIGHT,score);
                Platform.runLater(() -> {

                    game2.GameoverAlert(timerMonsterEAt,primaryStage,monsterEat);
                });
            }
        },0,100);

       Timer timerMonsterLeft = new Timer();
        timerMonsterLeft.schedule(new TimerTask() {
            @Override
            public void run() {
                updateMovie.updateMonsterBotLelt(monsterLeft,snake,WIDTH,HEIGHT,TILE_SIZE);
                draws.drawGame2(gc,snake,monsterEat,monsterLeft,monsterRight,food,TILE_SIZE,WIDTH,HEIGHT,score);
                Platform.runLater(() -> {

                  game2.GameoverAlert(timerMonsterLeft,primaryStage,monsterLeft);
                });
            }
        },0,150);

        Timer timerMonsterRight = new Timer();
        timerMonsterRight.schedule(new TimerTask() {
            @Override
            public void run() {
                updateMovie.updateMonsterBotRight(monsterRight,snake,WIDTH,HEIGHT,TILE_SIZE);
                draws.drawGame2(gc,snake,monsterEat,monsterLeft,monsterRight,food,TILE_SIZE,WIDTH,HEIGHT,score);
                Platform.runLater(() -> {

                   game2.GameoverAlert(timerMonsterRight,primaryStage,monsterRight);
                });

            }
        },0,200);

        primaryStage.setTitle("Game 2");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public void GameoverAlert(Timer timerMonster,Stage primaryStage,Point monster){
        if(monster.getX() == snake.getX() && monster.getY() == snake.getY()){
            timerMonster.cancel();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Game Over");
            alert.setHeaderText("Information");
            alert.setContentText("Game Over ! Are you want replay ?");
            ButtonType buttonTypeYes = new ButtonType("Yes", ButtonBar.ButtonData.YES);
            ButtonType buttonTypeNo = new ButtonType("No", ButtonBar.ButtonData.NO);

            alert.getButtonTypes().setAll(buttonTypeYes,buttonTypeNo);

            Optional<ButtonType> result = alert.showAndWait();
            if (result.isPresent() && result.get() == buttonTypeYes) {
                timerMonster.cancel();
                start(primaryStage);
                restart();
            } else if (result.isPresent() && result.get() == buttonTypeNo) {
                primaryStage.close();
            }


        }
    }
}
