package com.example.snake_game.views;

import com.example.snake_game.models.Alert;
import com.example.snake_game.models.CheckUsername;
import com.example.snake_game.models.CheckUsernamePassword;
import com.example.snake_game.utils.StringPathImage;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class SceneLogin {
    static String username = "" ;
    public static Scene login(){
        int width = 1200 ;
        int height = 780 ;
        // Create a BorderPane
        BorderPane root = new BorderPane();

        // Path to background image
        String backgroundImage = StringPathImage.in_gif(); // Replace with the actual path of the image

        // Set CSS for the BorderPane
        root.setStyle("-fx-background-image: url('" + backgroundImage + "'); " +
                "-fx-background-size: cover;");

        // Create a GridPane to hold the login form
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(70));
        gridPane.setHgap(25);
        gridPane.setVgap(25);

        // Add components to the GridPane
        Label titleLabel = new Label("Login");
        titleLabel.setFont(Font.font("Arial", FontWeight.BOLD, 50));
        Label usernameLabel = new Label("Username:");
        usernameLabel.setStyle("-fx-text-fill: white; -fx-font-size: 16px; -fx-font-weight: bold;");
        TextField usernameField = new TextField();
        Label passwordLabel = new Label("Password:");
        passwordLabel.setStyle("-fx-text-fill: white; -fx-font-size: 16px; -fx-font-weight: bold;");
        PasswordField passwordField = new PasswordField();
        Label registerLabel = new Label("Do not have an account? ");
        registerLabel.setStyle("-fx-text-fill: white; -fx-font-size: 16px; -fx-font-weight: bold;");

        Hyperlink registerLink = new Hyperlink();
        registerLink.setText("Register now.");
        registerLink.setStyle("-fx-text-fill: blue; -fx-font-size: 16px; -fx-font-weight: bold;");
        registerLink.setOnAction(event -> {
            // Open the Register window or navigate to the Register class
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(Sceneregister.register());
            stage.show();
        });
        Button loginButton = new Button("Login");
        loginButton.setStyle("-fx-background-color: linear-gradient(to right, #ff8000, #8000ff, #00ff80); -fx-text-fill: white;");
        loginButton.setPrefWidth(120); // Set the preferred width of the button
        loginButton.setOnAction(event -> {
             username = usernameField.getText();
            String password = passwordField.getText();
            if(CheckUsername.checkUsernameExist(username)){
                if(CheckUsernamePassword.checkUsernamePassword(username,password)){
                    SceneDisplay sceneDisplay = new SceneDisplay();
                    sceneDisplay.setUsername(username);
                    SceneShop sceneShop = new SceneShop();
                    sceneShop.setUsername(username);
                    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    stage.setScene(SceneDisplay.display());
                    stage.show();
                }else {
                    com.example.snake_game.models.Alert.alert("Password fail !");
                }
            }else {
                Alert.alert("Not found account !");
            }
        });

        // CSS for the title label
        titleLabel.setStyle("-fx-text-fill: linear-gradient(to right, #ff0000, #0000ff, #00ff00);");

        // Add components to the GridPane
        gridPane.add(titleLabel, 0, 0, 2, 1); // Span 2 columns for the title
        gridPane.add(usernameLabel, 0, 1);
        gridPane.add(usernameField, 1, 1);
        gridPane.add(passwordLabel, 0, 2);
        gridPane.add(passwordField, 1, 2);
        gridPane.add(registerLabel,0,3);
        gridPane.add(registerLink, 1, 3);
        gridPane.add(loginButton, 1, 4); // Change the row index of loginButton to 4

        // Center the GridPane
        gridPane.setAlignment(Pos.CENTER);

        // Set the GridPane at the center of the BorderPane
        root.setCenter(gridPane);

        // Create a Scene with the BorderPane as the root
        Scene scene = new Scene(root,width,height);

        // Set the window size


        // Center the title
        GridPane.setHalignment(titleLabel, javafx.geometry.HPos.CENTER);
        return scene;
    }
    public String getUsername(){
        return this.username ;
    }
}
