package com.example.snake_game.views;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Registers extends Application {

    @Override
    public void start(Stage primaryStage) {

        // Tạo các thành phần giao diện

        Text title = new Text("Register");
        title.setFont(Font.font("Arial", FontWeight.BOLD, 30));
        title.setStyle("-fx-fill: linear-gradient(#ff8000, #ff0000, #0000ff);");

        Label emailLabel = new Label("Email:");
        emailLabel.setStyle("-fx-text-fill: white; -fx-font-weight: bold; -fx-font-size: 14px;");
        TextField emailField = new TextField();

        Label nameLabel = new Label("Name:");
        nameLabel.setStyle("-fx-text-fill: white; -fx-font-weight: bold; -fx-font-size: 14px;");
        TextField nameField = new TextField();

        Label passwordLabel = new Label("PassWord:");
        passwordLabel.setStyle("-fx-text-fill: white; -fx-font-weight: bold; -fx-font-size: 14px;");
        PasswordField passwordField = new PasswordField();

        Label genderLabel = new Label("Sex:");
        genderLabel.setStyle("-fx-text-fill: white; -fx-font-weight: bold; -fx-font-size: 14px;");
        RadioButton maleRadioButton = new RadioButton("Male");
        maleRadioButton.setStyle("-fx-text-fill: white");
        RadioButton femaleRadioButton = new RadioButton("Female");
        femaleRadioButton.setStyle("-fx-text-fill: white");
        ToggleGroup genderToggleGroup = new ToggleGroup();
        maleRadioButton.setToggleGroup(genderToggleGroup);
        femaleRadioButton.setToggleGroup(genderToggleGroup);

        Label typeLabel = new Label("Account type:");
        typeLabel.setStyle("-fx-text-fill: white; -fx-text-fill: white; -fx-font-weight: bold; -fx-font-size: 14px;");
        ComboBox<String> typeComboBox = new ComboBox<>();
        typeComboBox.getItems().addAll("Individual", "Company");

        Button submitButton = new Button("Register");
        submitButton.setStyle("-fx-background-color: linear-gradient(#ff0000, #0000ff, #00ff80); -fx-text-fill: white; -fx-font-size: 14px; -fx-font-weight: bold; -fx-min-width: 120px;");

        // Tạo layout

        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10));
        gridPane.setHgap(10);
        gridPane.setVgap(10);

        gridPane.add(title, 0, 0, 2, 1);

        gridPane.add(emailLabel, 0, 1);
        gridPane.add(emailField, 1, 1, 2, 1);

        gridPane.add(nameLabel, 0, 2);
        gridPane.add(nameField, 1, 2, 2, 1);

        gridPane.add(passwordLabel, 0, 3);
        gridPane.add(passwordField, 1, 3, 2, 1);

        gridPane.add(genderLabel, 0, 4);
        gridPane.add(maleRadioButton, 1, 4);
        gridPane.add(femaleRadioButton, 2, 4);

        gridPane.add(typeLabel, 0, 5);
        gridPane.add(typeComboBox, 1, 5, 2, 1);

        HBox hBox = new HBox();
        hBox.getChildren().add(submitButton);
        gridPane.add(hBox, 1, 6, 2, 1);
        gridPane.setAlignment(Pos.CENTER);

        // Thêm event cho nút "Đăng ký"

        submitButton.setOnAction(event -> {
            // Xử lý đăng ký
            System.out.println("Registered!");
        });

        // Tạo HBox chứa nút "Button1"
        HBox button1Container = new HBox();
        button1Container.setAlignment(Pos.TOP_LEFT);
        button1Container.setPadding(new Insets(10));
        Button button1 = new Button("Login");
        button1Container.getChildren().add(button1);
        button1.setStyle("-fx-background-color: linear-gradient(#ff0000, #0000ff, #00ff80); -fx-text-fill: white; -fx-font-size: 14px; -fx-font-weight: bold; -fx-min-width: 100px; -fx-min-height: 30px;");
        button1.setOnAction(e -> {
            Login login = new Login();
            login.start(new Stage());
            // Đóng cửa sổ đăng ký
            primaryStage.close();
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


        String backgroundImage = "file:C:/Users/pc/King_Snake/Snake_Game/src/main/java/com/example/snake_game/resources/image/in.gif";
        borderPane.setStyle("-fx-background-image: url('" + backgroundImage + "'); -fx-background-size: cover;");

        // Tạo scene và hiển thị

        Scene scene = new Scene(borderPane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Register");
        primaryStage.setResizable(false);
        primaryStage.setWidth(1000);
        primaryStage.setHeight(780);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
