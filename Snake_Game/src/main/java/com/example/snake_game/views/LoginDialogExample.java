package com.example.snake_game.views;

import com.example.snake_game.utils.GetImage;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class LoginDialogExample extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Tạo giao diện người dùng
        VBox vbox = new VBox();
        vbox.setPadding(new Insets(10));
        vbox.setSpacing(10);

        // Tạo các trường nhập liệu
        TextField usernameField = new TextField();
        PasswordField passwordField = new PasswordField();

        // Tạo nút đăng nhập
        Button loginButton = new Button("Đăng nhập");
        loginButton.setOnAction(event -> {
            String username = usernameField.getText();
            String password = passwordField.getText();

            // Kiểm tra xem username đã tồn tại trong cơ sở dữ liệu hay không
            boolean usernameExists = checkUsernameExists(username);

            // Hiển thị kết quả
            if (usernameExists) {
                showAlert("Thông báo", "Đăng nhập thành công!");
            } else {
                showAlert("Thông báo", "Username không tồn tại!");
            }
        });

        // Thêm các trường và nút vào VBox
        vbox.getChildren().addAll(
                new Label("Username:"),
                usernameField,
                new Label("Password:"),
                passwordField,
                loginButton
        );
        Image backgroundImage = GetImage.getImage("C:\\Users\\dell\\IdeaProjects\\King_Snake\\Snake_Game\\src\\main\\java\\com\\example\\snake_game\\resources\\image\\gameover.gif");
        BackgroundImage background = new BackgroundImage(backgroundImage,
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT, new BackgroundSize(1200, 960, false, false, true, true));

        // Tạo Scene và hiển thị
        Scene scene = new Scene(vbox, 300, 200);

        primaryStage.setTitle("Đăng nhập");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Phương thức kiểm tra xem username đã tồn tại trong cơ sở dữ liệu hay không (giả sử sử dụng một cơ sở dữ liệu giả)
    private boolean checkUsernameExists(String username) {
        // Thực hiện kiểm tra trong cơ sở dữ liệu thực tế
        // Trong ví dụ này, luôn trả về true để đơn giản
        return true;
    }

    // Phương thức hiển thị hộp thoại thông báo
    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }
}