package com.example.snake_game.utils;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class WinGame extends Application {
    Image winGame = GetImage.getImage("C:\\Users\\dell\\IdeaProjects\\King_Snake\\Snake_Game\\src\\main\\java\\com\\example\\snake_game\\resources\\image\\Winer.gif");
    private static int width = 1200;
    private static int height = 60*16;
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Canvas canvas = new Canvas(width,height);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.drawImage(winGame,0,0,width,height);

        Font font = new Font("Arial", 60); // Đặt kích thước chữ
        gc.setFill(Color.YELLOW);
        gc.setFont(font);
        gc.fillText("Win Game", width / 2-100, height/2);

        Pane layout = new Pane(canvas);
        Scene scene = new Scene(layout,width,height);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Winner");
        primaryStage.show();
    }
}
