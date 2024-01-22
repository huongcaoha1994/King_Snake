package com.example.kingsnack;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class SnakeGame extends Application {
    private static final int TILE_SIZE = 20;
    private static final int WIDTH = 20;
    private static final int HEIGHT = 20;

    private Direction snakeDirection = Direction.RIGHT;
    private List<Coordinate> snake = new ArrayList<>();
    private Coordinate food;
    private Coordinate boss;

    @Override
    public void start(Stage primaryStage) {
        GridPane gridPane = createGridPane();
        BorderPane borderPane = new BorderPane(gridPane);
        Label gameOverLabel = createGameOverLabel();

        borderPane.setBottom(gameOverLabel);
        BorderPane.setAlignment(gameOverLabel, Pos.CENTER);

        Scene scene = new Scene(borderPane);
        scene.setOnKeyPressed(event -> handleKeyPress(event.getCode()));

        primaryStage.setTitle("Snake Game");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();

        initializeGame();
        startGameLoop(gridPane, gameOverLabel);
    }

    private GridPane createGridPane() {
        GridPane gridPane = new GridPane();
        for (int row = 0; row < HEIGHT; row++) {
            for (int col = 0; col < WIDTH; col++) {
                Rectangle tile = new Rectangle(TILE_SIZE, TILE_SIZE);
                tile.setFill(Color.WHITE);
                tile.setStroke(Color.LIGHTGRAY);
                gridPane.add(tile, col, row);
            }
        }
        return gridPane;
    }

    private Label createGameOverLabel() {
        Label gameOverLabel = new Label("Game Over");
        gameOverLabel.setStyle("-fx-font-size: 24;");
        gameOverLabel.setVisible(false);
        return gameOverLabel;
    }

    private void initializeGame() {
        snake.clear();
        snake.add(new Coordinate(WIDTH / 2, HEIGHT / 2));
//        snake.add(new Coordinate(WIDTH / 2 - 1, HEIGHT / 2));
//        snake.add(new Coordinate(WIDTH / 2 - 2, HEIGHT / 2));

        Random random = new Random();
        int foodX = random.nextInt(WIDTH);
        int foodY = random.nextInt(HEIGHT);
        food = new Coordinate(foodX, foodY);

        int bossX = random.nextInt(WIDTH);
        int bossY = random.nextInt(HEIGHT);
        boss = new Coordinate(bossX, bossY);
    }

    private void startGameLoop(GridPane gridPane, Label gameOverLabel) {
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(0.2), event -> {
            boolean canMove = moveSnake();
            if (!canMove) {

                gameOverLabel.setVisible(true);
                return;
            }

            updateGridPane(gridPane);
        }));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

    private boolean moveSnake() {
        Coordinate head = snake.get(0);
        Coordinate newHead = new Coordinate(head.getX(), head.getY());

        switch (snakeDirection) {
            case UP:
                newHead.setY(newHead.getY() - 1);
                break;
            case DOWN:
                newHead.setY(newHead.getY() + 1);
                break;
            case LEFT:
                newHead.setX(newHead.getX() - 1);
                break;
            case RIGHT:
                newHead.setX(newHead.getX() + 1);
                break;
        }

        if (isCollisionWithSnake(newHead) || isCollisionWithWall(newHead) || isCollisionWithBoss(newHead)) {
            return false;
        }

        snake.add(0, newHead);

        if (newHead.equals(food)) {
            Random random = new Random();
            int foodX = random.nextInt(WIDTH);
            int foodY = random.nextInt(HEIGHT);
            food = new Coordinate(foodX, foodY);
        } else {
            snake.remove(snake.size() - 1);
        }

        return true;
    }

    private boolean isCollisionWithSnake(Coordinate coordinate) {
        for (int i = 1; i < snake.size(); i++) {
            if (snake.get(i).equals(coordinate)) {
                return true;
            }
        }
        return false;
    }

    private boolean isCollisionWithWall(Coordinate coordinate) {
        return coordinate.getX() < 0 || coordinate.getX() >= WIDTH || coordinate.getY() < 0 || coordinate.getY() >= HEIGHT;
    }

    private boolean isCollisionWithBoss(Coordinate coordinate) {
        int bossRange = 3; // Phạm vi hoạt động của boss (số ô)
        int bossX = boss.getX();
        int bossY = boss.getY();
        int minX = bossX - bossRange;
        int maxX = bossX + bossRange;
        int minY = bossY - bossRange;
        int maxY = bossY + bossRange;

        return coordinate.getX() >= minX && coordinate.getX() <= maxX && coordinate.getY() >= minY && coordinate.getY() <= maxY;
    }

    private void updateGridPane(GridPane gridPane) {
        gridPane.getChildren().clear();

        for (Coordinate coordinate : snake) {
            Rectangle tile = new Rectangle(TILE_SIZE, TILE_SIZE);
            tile.setFill(Color.GREEN);
            tile.setStroke(Color.LIGHTGRAY);
            gridPane.add(tile, coordinate.getX(), coordinate.getY());
        }

        Rectangle foodTile = new Rectangle(TILE_SIZE, TILE_SIZE);
        foodTile.setFill(Color.RED);
        foodTile.setStroke(Color.LIGHTGRAY);
        gridPane.add(foodTile, food.getX(), food.getY());

        Rectangle bossTile = new Rectangle(TILE_SIZE, TILE_SIZE);
        bossTile.setFill(Color.BLUE);
        bossTile.setStroke(Color.LIGHTGRAY);
        gridPane.add(bossTile, boss.getX(), boss.getY());
    }

    private void handleKeyPress(KeyCode keyCode) {
        switch (keyCode) {
            case UP:
                if (snakeDirection != Direction.DOWN) {
                    snakeDirection = Direction.UP;
                }
                break;
            case DOWN:
                if (snakeDirection != Direction.UP) {
                    snakeDirection = Direction.DOWN;
                }
                break;
            case LEFT:
                if (snakeDirection != Direction.RIGHT) {
                    snakeDirection = Direction.LEFT;
                }
                break;
            case RIGHT:
                if (snakeDirection != Direction.LEFT) {
                    snakeDirection = Direction.RIGHT;
                }
                break;
        }
    }

    private enum Direction {
        UP, DOWN, LEFT, RIGHT
    }

    private static class Coordinate {
        private int x;
        private int y;

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            Coordinate that = (Coordinate) obj;
            return x == that.x && y == that.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}