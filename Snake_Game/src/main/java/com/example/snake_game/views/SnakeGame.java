package com.example.snake_game.views;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class SnakeGame extends Application {

    private static final int WIDTH = 400;
    private static final int HEIGHT = 400;
    private static final int UNIT_SIZE = 20;

    private Canvas canvas;
    private GraphicsContext gc;

    private List<Point> snake;
    private Point food;
    private Direction direction;
    private boolean gameOver;

    private Random random;

    @Override
    public void start(Stage primaryStage) {
        canvas = new Canvas(WIDTH, HEIGHT);
        gc = canvas.getGraphicsContext2D();

        StackPane root = new StackPane(canvas);
        Scene scene = new Scene(root, WIDTH, HEIGHT);

        scene.setOnKeyPressed(event -> handleKeyPress(event.getCode()));

        primaryStage.setScene(scene);
        primaryStage.setTitle("Snake Game");
        primaryStage.setResizable(false);

        startGame();

        primaryStage.show();
    }

    private void startGame() {
        snake = new ArrayList<>();
        snake.add(new Point(WIDTH / 2, HEIGHT / 2));
        direction = Direction.RIGHT;
        generateFood();
        gameOver = false;

        AnimationTimer timer = new AnimationTimer() {
            private long lastUpdate = 0;

            @Override
            public void handle(long now) {
                if (now - lastUpdate >= 100_000_000) {
                    lastUpdate = now;
                    if (!gameOver) {
                        updateGame();
                        drawGame();
                    }
                }
            }
        };

        timer.start();
    }

    private void updateGame() {
        Point head = snake.get(0).copy();
        switch (direction) {
            case UP:
                head.setY(head.getY() - UNIT_SIZE);
                break;
            case DOWN:
                head.setY(head.getY() + UNIT_SIZE);
                break;
            case LEFT:
                head.setX(head.getX() - UNIT_SIZE);
                break;
            case RIGHT:
                head.setX(head.getX() + UNIT_SIZE);
                break;
        }

        if (head.getX() < 0 || head.getX() >= WIDTH || head.getY() < 0 || head.getY() >= HEIGHT) {
            gameOver();
            return;
        }

        if (snake.contains(head)) {
            gameOver();
            return;
        }

        snake.add(0, head);

        if (head.equals(food)) {
            generateFood();
        } else {
            snake.remove(snake.size() - 1);
        }
    }

    private void drawGame() {
        gc.clearRect(0, 0, WIDTH, HEIGHT);

        // Vẽ food
        gc.setFill(Color.RED);
        gc.fillRect(food.getX(), food.getY(), UNIT_SIZE, UNIT_SIZE);

        // Vẽ snake
        gc.setFill(Color.GREEN);
        for (Point point : snake) {
            gc.fillRect(point.getX(), point.getY(), UNIT_SIZE, UNIT_SIZE);
        }
    }

    private void gameOver() {
        gameOver = true;
        showGameOverAlert();
    }

    private void showGameOverAlert() {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Game Over");
        alert.setHeaderText(null);
        alert.setContentText("Game Over! Your score: " + (snake.size() - 1));
        alert.setOnHidden(event -> startGame());
        alert.show();
    }

    private void generateFood() {
        random = new Random();
        int foodX = random.nextInt(WIDTH / UNIT_SIZE) * UNIT_SIZE;
        int foodY = random.nextInt(HEIGHT / UNIT_SIZE) * UNIT_SIZE;
        food = new Point(foodX, foodY);
    }

    private void handleKeyPress(KeyCode keyCode) {
        switch (keyCode) {
            case UP:
                if (direction != Direction.DOWN)
                    direction = Direction.UP;
                break;
            case DOWN:
                if (direction != Direction.UP)
                    direction = Direction.DOWN;
                break;
            case LEFT:
                if (direction != Direction.RIGHT)
                    direction = Direction.LEFT;
                break;
            case RIGHT:
                if (direction != Direction.LEFT)
                    direction = Direction.RIGHT;
                break;
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}

enum Direction {
    UP,
    DOWN,
    LEFT,
    RIGHT
}

class Point {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return
        this.x;
    }

    public int getY() {
        return this.y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Point copy() {
        return new Point(this.x, this.y);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Point point = (Point) obj;
        return x == point.x && y == point.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}