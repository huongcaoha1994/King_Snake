package com.example.snake_game.views;

import com.example.snake_game.controllers.UpdateMovie;
import com.example.snake_game.models.Point;
import com.example.snake_game.resources.Draws;
import com.example.snake_game.utils.Food;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.*;

public class Game3 extends Application {
    private static int tileSize = 60 ;
    private static int width = tileSize*20;
    private static int height = tileSize*16;
    private IntegerProperty score = new SimpleIntegerProperty(14);
    private Point snake ;
    private Point monsterGun ;
    private Point monsterEat ;
    private Point monster ;
    private Point food ;
    public static Point gate = new Point(width/2,0);
    private List<Point> bullets = new ArrayList<>();
    Random random = new Random();
    public void setFood(){
        Random random = new Random();
        food.setX(random.nextInt(width/tileSize)*tileSize);
        food.setY(random.nextInt(height/tileSize)*tileSize);
    }
    public void restart(){
        snake = new Point(width/2,height/2);
        monsterGun = new Point((width/tileSize)*tileSize,0);
        monsterEat = new Point(random.nextInt(width/tileSize)*tileSize,(height/tileSize)*tileSize);
        food = new Point(random.nextInt(width/tileSize)*tileSize, random.nextInt(height/tileSize)*tileSize );
        monster = new Point(random.nextInt(width/tileSize)*tileSize, random.nextInt(height/tileSize)*tileSize );

    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        SceneGameover3 sceneGameover3 = new SceneGameover3();
        restart();
        UpdateMovie updateMovie = new UpdateMovie();
        Draws draws = new Draws();

        Canvas canvas = new Canvas(width,height);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        Pane layout = new Pane(canvas);
        Scene scene = new Scene(layout,width,height);
        scene.setOnKeyPressed(keyEvent -> {
            updateMovie.updateSnake(gc,scene,snake,tileSize,food,width,height,score);
            draws.drawGame3(gc,width,height,tileSize,snake,monsterEat,monsterGun,bullets,food,score,monster);


        });
        Timer timerMonsterGun = new Timer();
        timerMonsterGun.schedule(new TimerTask() {
            @Override
            public void run() {
                updateMovie.updateMonsterGun(monsterGun,snake,tileSize,bullets);
                draws.drawGame3(gc,width,height,tileSize,snake,monsterEat,monsterGun,bullets,food,score,monster);
            }
        },0,300);

        Timer timerMonsterEat = new Timer();
        timerMonsterEat.schedule(new TimerTask() {
            @Override
            public void run() {
                updateMovie.updateMonsterEat3(monsterEat,food,width,height,tileSize);
                draws.drawGame3(gc,width,height,tileSize,snake,monsterEat,monsterGun,bullets,food,score,monster);
                Platform.runLater(() -> {
                    if(monsterEat.getX() == snake.getX() && monsterEat.getY() == snake.getY()){
                        timerMonsterEat.cancel();
                        timerMonsterGun.cancel();
                        sceneGameover3.start(primaryStage);
                    }
                });
            }
        },0,200);

        Timer timerMonster = new Timer();
        timerMonster.schedule(new TimerTask() {
            @Override
            public void run() {

                updateMovie.updateMonster(monster,snake,tileSize);
                draws.drawGame3(gc,width,height,tileSize,snake,monsterEat,monsterGun,bullets,food,score,monster);
                Platform.runLater(() -> {
                    if(monster.getX() == snake.getX() && monster.getY() == snake.getY()){
                        timerMonster.cancel();
                        timerMonsterEat.cancel();
                        timerMonsterGun.cancel();
                        sceneGameover3.start(primaryStage);
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
                           sceneGameover3.start(primaryStage);
                       }
                   }
                    if(snake.getX() == gate.getX() && snake.getY() == gate.getY() && score.get() >= 15){
                        timerBullet.cancel();
                        timerMonster.cancel();
                        timerMonsterEat.cancel();
                        timerMonsterGun.cancel();
                        SceneWinner3 demo = new SceneWinner3();
                        demo.start(primaryStage);
                    }
                });
            }
        },0,100);

        primaryStage.setTitle("Game 3");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public void GameoverAlert(Timer timerMonsterEat ,Timer timerbullet ,Stage primaryStage,Point monster){
        if(monster.getX() == snake.getX() && monster.getY() == snake.getY()){
            timerMonsterEat.cancel();
            timerbullet.cancel();

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Game Over");
            alert.setHeaderText("Information");
            alert.setContentText("Game Over ! Are you want replay ?");
            ButtonType buttonTypeYes = new ButtonType("Yes", ButtonBar.ButtonData.YES);
            ButtonType buttonTypeNo = new ButtonType("No", ButtonBar.ButtonData.NO);

            alert.getButtonTypes().setAll(buttonTypeYes,buttonTypeNo);

            Optional<ButtonType> result = alert.showAndWait();
            if (result.isPresent() && result.get() == buttonTypeYes) {
                start(primaryStage);
                restart();
            } else if (result.isPresent() && result.get() == buttonTypeNo) {
                primaryStage.close();
            }


        }
    }
}
