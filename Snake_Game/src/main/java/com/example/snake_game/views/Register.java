package com.example.snake_game.views;

import com.example.snake_game.models.Alert;
import com.example.snake_game.models.InsertUser;
import com.example.snake_game.models.StringToHashCode;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class Register extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Create a BorderPane
        BorderPane root = new BorderPane();

        // Path to background image
        String backgroundImage = "file:D:/IdeaProjects/King_Snake/Snake_Game/src/main/java/com/example/snake_game/resources/image/in.gif"; // Replace with the actual path of the image

        // Set CSS for the BorderPane
        root.setStyle("-fx-background-image: url('" + backgroundImage + "'); " +
                "-fx-background-size: cover;");



        // Add components to the GridPane
        Label titleLabel = new Label("Register");
        titleLabel.setFont(Font.font("Arial", FontWeight.BOLD, 50));
        Label usernameLabel = new Label("Username:");

        usernameLabel.setStyle("-fx-text-fill: white; -fx-font-size: 16px; -fx-font-weight: bold;");
        TextField usernameField = new TextField();

        Label passwordLabel = new Label("Password:");
        passwordLabel.setStyle("-fx-text-fill: white; -fx-font-size: 16px; -fx-font-weight: bold;");
        PasswordField passwordField = new PasswordField();

        Label repasswordLabel = new Label("Repassword:");
        repasswordLabel.setStyle("-fx-text-fill: white; -fx-font-weight: bold; -fx-font-size: 14px;");
        PasswordField repasswordField = new PasswordField();

        Button submitButton = new Button("Register");
        submitButton.setStyle("-fx-background-color: linear-gradient(to right, #ff8000, #8000ff, #00ff80); -fx-text-fill: white;");

        submitButton.setPrefWidth(120) ;// Set the preferred width of the button

        // CSS for the title label
        titleLabel.setStyle("-fx-text-fill: linear-gradient(to right, #ff0000, #0000ff, #00ff00);");


        // Create a GridPane to hold the register form
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(70));
        gridPane.setHgap(25);
        gridPane.setVgap(25);

        // Add components to the GridPane
        gridPane.add(titleLabel, 0, 0, 2, 1); // Span 2 columns for the title

        gridPane.add(usernameLabel, 0, 1);
        gridPane.add(usernameField, 1, 1);

        gridPane.add(passwordLabel, 0, 2);
        gridPane.add(passwordField, 1, 2);

        gridPane.add(repasswordLabel, 0, 3);
        gridPane.add(repasswordField, 1, 3);

        gridPane.add(submitButton, 1, 4); // Change) the row index of registerButton to 4

        // Center the GridPane
        gridPane.setAlignment(Pos.CENTER);

        // Set the GridPane at the center of the BorderPane
        root.setCenter(gridPane);

        // Create a StackPane to hold the back button
        StackPane backButtonPane = new StackPane();

        // Thêm event cho nút "Đăng ký"
        submitButton.setOnAction(event -> {
            // Xử lý đăng ký
            String username = usernameField.getText();
            String password = passwordField.getText();
            String repassword = repasswordField.getText();
            if(password.equals(repassword)){
                password = StringToHashCode.hashString(password);
                InsertUser.insertUser(username,password);
                Register registers = new Register();
                registers.start(primaryStage);

            }else {
                Alert.alert("Password not match !");
            }
        });
// Create the back button
        Button backButton = new Button("Exit");
        backButton.setStyle("-fx-background-color: linear-gradient(#1667f1, #3d8af5, #bcbde8); -fx-text-fill: white; -fx-font-size: 14px; -fx-font-weight: bold; -fx-min-width: 100px; -fx-min-height: 30px; -fx-padding: 5px 10px;");
        backButton.setPadding(new Insets(5, 10, 5, 10));
        backButton.setOnAction(e -> {
            Login1 login1 = new Login1();
            login1.start(new Stage());
            // Đóng cửa sổ đăng ký
            primaryStage.close();
        });
// Set the position of the back button
        StackPane.setAlignment(backButton, Pos.TOP_LEFT);
        StackPane.setMargin(backButton,new Insets(15,0,0,15));

// Add the back button to the StackPane
        backButtonPane.getChildren().add(backButton);

// Add the StackPane to the top left corner of the BorderPane
        root.setTop(backButtonPane);

        // Create a Scene with the BorderPane as the root
        Scene scene = new Scene(root);

        // Set the window size
        primaryStage.setWidth(1000);
        primaryStage.setHeight(780);

        // Center the title
        GridPane.setHalignment(titleLabel, javafx.geometry.HPos.CENTER);

        // Disable window resizing
        primaryStage.setResizable(false);

        // Set the Scene to the Stage
        primaryStage.setScene(scene);

        // Set the window title
        primaryStage.setTitle("Register Form");

        // Show the Stage

        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}