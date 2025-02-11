package com.example.snake_game.views;

import com.example.snake_game.models.Alert;
import com.example.snake_game.models.InsertUser;
import com.example.snake_game.models.StringToHashCode;
import com.example.snake_game.utils.StringPathImage;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Sceneregister {
    public static Scene register(){
        // Tạo các thành phần giao diện
        int width = 1200 ;
        int height = 780 ;
        Text title = new Text("Register");
        title.setFont(Font.font("Arial", FontWeight.BOLD, 30));
        title.setStyle("-fx-fill: linear-gradient(#ff8000, #0000ff, #00ff80);");

        Label nameLabel = new Label("Name:");
        nameLabel.setStyle("-fx-text-fill: white; -fx-font-weight: bold; -fx-font-size: 14px;");
        TextField nameField = new TextField();

        Label passwordLabel = new Label("Password:");
        passwordLabel.setStyle("-fx-text-fill: white; -fx-font-weight: bold; -fx-font-size: 14px;");
        PasswordField passwordField = new PasswordField();

        Label repasswordLabel = new Label("Repassword:");
        repasswordLabel.setStyle("-fx-text-fill: white; -fx-font-weight: bold; -fx-font-size: 14px;");
        PasswordField repasswordField = new PasswordField();

        Button submitButton = new Button("Register");
        submitButton.setStyle("-fx-background-color: linear-gradient(#ff0000, #0000ff, #00ff80); -fx-text-fill: white; -fx-font-size: 14px; -fx-font-weight: bold; -fx-min-width: 120px;");

        // Tạo layout

        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10));
        gridPane.setHgap(10);
        gridPane.setVgap(10);

        gridPane.add(title, 0, 0, 2, 1);

        gridPane.add(nameLabel, 0, 2);
        gridPane.add(nameField, 1, 2, 2, 1);

        gridPane.add(passwordLabel, 0, 3);
        gridPane.add(passwordField, 1, 3, 2, 1);

        gridPane.add(repasswordLabel, 0, 4);
        gridPane.add(repasswordField, 1, 4, 2, 1);

        gridPane.add(submitButton, 1, 5, 2, 1);
        gridPane.setAlignment(Pos.CENTER);

        // Center the title
        GridPane.setHalignment(title, javafx.geometry.HPos.CENTER);


        // Thêm event cho nút "Đăng ký"

        submitButton.setOnAction(event -> {
            // Xử lý đăng ký
            String username = nameField.getText().replaceAll(" ","");
            String password = passwordField.getText();
            String repassword = repasswordField.getText();
            if(password.equals(repassword)){
                password = StringToHashCode.hashString(password);
                InsertUser.insertUser(username,password);
                Alert.alert("Register succesfully !");
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(SceneLogin.login());
                stage.show();

            }else {
                Alert.alert("Password not match !");
            }
        });

        // Tạo HBox chứa nút "Button1"
        HBox button1Container = new HBox();
        button1Container.setAlignment(Pos.TOP_LEFT);
        button1Container.setPadding(new Insets(10));
        Button button1 = new Button("Login");
        button1Container.getChildren().add(button1);
        button1.setStyle("-fx-background-color: linear-gradient(#ff0000, #0000ff, #00ff80); -fx-text-fill: white; -fx-font-size: 14px; -fx-font-weight: bold; -fx-min-width: 100px; -fx-min-height: 30px;");
        button1.setOnAction(event -> {
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(SceneLogin.login());
            stage.show();
        });

        // Tạo VBox chứa HBox của nút
        VBox buttonsContainer = new VBox();
        buttonsContainer.setAlignment(Pos.TOP_RIGHT);
        buttonsContainer.getChildren().addAll(button1Container);

        // Tạo BorderPane và đặt GridPane vào trung tâm
        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(gridPane);
        borderPane.setTop(buttonsContainer);
        BorderPane.setAlignment(buttonsContainer, Pos.TOP_RIGHT);
        BorderPane.setMargin(buttonsContainer, new Insets(10));


        String backgroundImage = StringPathImage.in_gif();
        borderPane.setStyle("-fx-background-image: url('" + backgroundImage + "'); -fx-background-size: cover;");

        // Tạo scene và hiển thị

        Scene scene = new Scene(borderPane,width,height);
        return scene;
    }
}
