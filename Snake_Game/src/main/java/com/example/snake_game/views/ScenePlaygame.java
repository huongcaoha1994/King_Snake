package com.example.snake_game.views;

import com.example.snake_game.models.GetLevel;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ScenePlaygame {
    public static String username ;
    public void setUsername(String username){
        this.username = username ;
    }
    StackPane rootPane = new StackPane();
    private static boolean man1Completed = true;
    private static boolean man2Completed = false;
    private static boolean man3Completed = false;
    public static Scene playgame(Stage primaryStage){

        Button playMan1Button = new Button("Chơi màn 1");
        Button playMan2Button = new Button("Chơi màn 2");
        Button playMan3Button = new Button("Chơi màn 3");

        playMan1Button.setStyle(
                "-fx-background-color: linear-gradient(to bottom, #00FFFF, #8A2BE2);" +
                        "-fx-text-fill: white; " +
                        "-fx-font-size: 16px; " +
                        "-fx-padding: 10px 20px; " +
                        "-fx-border-color: transparent; " +
                        "-fx-border-width: 2px; " +
                        "-fx-background-radius: 15; " + // Chỉnh sửa background radius
                        "-fx-effect: dropshadow(three-pass-box, #58a700, 0, 5, 0, 0);" + // Thêm shadow
                        "-fx-border-radius: 15;" + // Chỉnh sửa border radius
                        "-fx-cursor: hand;" + // Thay đổi hình ảnh con trỏ khi di chuyển qua button
                        "-fx-background-insets: 0, 0 0 1 0;" // Hiệu ứng khi hover
        );

        playMan2Button.setStyle(
                "-fx-background-color: linear-gradient(to bottom, #FF6347, #FFA500);" +
                        "-fx-text-fill: white; " +
                        "-fx-font-size: 16px; " +
                        "-fx-padding: 10px 20px; " +
                        "-fx-border-color: transparent; " +
                        "-fx-border-width: 2px; " +
                        "-fx-background-radius: 15; " + // Chỉnh sửa background radius
                        "-fx-effect: dropshadow(three-pass-box, #58a700, 0, 5, 0, 0);" + // Thêm shadow
                        "-fx-border-radius: 15;" + // Chỉnh sửa border radius
                        "-fx-cursor: hand;" + // Thay đổi hình ảnh con trỏ khi di chuyển qua button
                        "-fx-background-insets: 0, 0 0 3 0;" + // Hiệu ứng khi hover
                        "-fx-animation: pulse 1s infinite;" // Animation nhấp nháy
        );

        playMan3Button.setStyle(
                "-fx-background-color: linear-gradient(to bottom, #32CD32, #FFD700);" +
                        "-fx-text-fill: white; " +
                        "-fx-font-size: 16px; " +
                        "-fx-padding: 10px 20px; " +
                        "-fx-border-color: transparent; " +
                        "-fx-border-width: 2px; " +
                        "-fx-background-radius: 15; " + // Chỉnh sửa border radius
                        "-fx-cursor: hand;" + // Thay đổi hình ảnh con trỏ khi di chuyển qua button
                        "-fx-background-insets: 0, 0 0 1 0;" // Hiệu ứng khi hover
        );



        playMan1Button.setOnAction(event -> {
            if (man1Completed) {
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(SceneGame1.game1(stage,username));
                stage.show(); // chơi màn 1
            }
        });

        playMan2Button.setOnAction(event -> {
            if (GetLevel.getLevel(username) >= 2) {
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(SceneGame2.game2(stage,username));
                stage.show();
                // Xử lý chuyển đến màn 2
            } else {
                showIncompleteAlert("1");
            }
        });

        playMan3Button.setOnAction(event -> {
            if (GetLevel.getLevel(username) >= 3) {
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(SceneGame3.game3(stage,username));
                stage.show();
                // Xử lý chuyển đến màn 3
            } else {
                showIncompleteAlert("2");
            }
        });

        HBox topBox = new HBox(); // Tạo HBox mới cho phần top
        Button exitButton = new Button("Go Back");
        exitButton.setOnAction(event -> {
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(SceneDisplay.display());
            stage.show();
                }); // Quay lại màn hình chính
        topBox.getChildren().add(exitButton);

        exitButton.setStyle(
                "-fx-background-color: linear-gradient(to bottom, #FF6347, #FFA500);" +
                        "-fx-text-fill: white; " +
                        "-fx-font-size: 16px; " +
                        "-fx-padding: 10px 20px; " +
                        "-fx-border-color: transparent; " +
                        "-fx-border-width: 2px; " +
                        "-fx-background-radius: 15; " + // Chỉnh sửa background radius
                        "-fx-effect: dropshadow(three-pass-box, #58a700, 0, 5, 0, 0);" + // Thêm shadow
                        "-fx-border-radius: 15;" // Chỉnh sửa border radius
        );

        exitButton.setOnMouseEntered(e -> {
            exitButton.setStyle(
                    "-fx-background-color: linear-gradient(to bottom, #FF6347, #FFA500);" +
                            "-fx-text-fill: white; " +
                            "-fx-font-size: 16px; " +
                            "-fx-padding: 10px 20px; " +
                            "-fx-border-color: transparent; " +
                            "-fx-border-width: 2px; " +
                            "-fx-background-radius: 15; " + // Chỉnh sửa background radius
                            "-fx-effect: dropshadow(three-pass-box, #58a700, 0, 5, 0, 0);" + // Thêm shadow
                            "-fx-border-radius: 15;" + // Chỉnh sửa border radius
                            "-fx-cursor: hand;" + // Thay đổi hình ảnh con trỏ khi di chuyển qua button
                            "-fx-background-insets: 0, 0 0 3 0;" // Hiệu ứng khi hover
            );
        });

        exitButton.setOnMouseExited(e -> {
            exitButton.setStyle(
                    "-fx-background-color: linear-gradient(to bottom, #FF6347, #FFA500);" +
                            "-fx-text-fill: white; " +
                            "-fx-font-size: 16px; " +
                            "-fx-padding: 10px 20px; " +
                            "-fx-border-color: transparent; " +
                            "-fx-border-width: 2px; " +
                            "-fx-background-radius: 15; " + // Chỉnh sửa background radius
                            "-fx-effect: dropshadow(three-pass-box, #58a700, 0, 5, 0, 0);" + // Thêm shadow
                            "-fx-border-radius: 15;" + // Chỉnh sửa border radius
                            "-fx-cursor: hand;" + // Thay đổi hình ảnh con trỏ khi di chuyển qua button
                            "-fx-background-insets: 0, 0 0 1 0;" // Hiệu ứng khi hover
            );
        });



        VBox centerVBox1 = createVBoxWithImageAndButton("File:C:\\Users\\dell\\IdeaProjects\\King_Snake\\Snake_Game\\src\\main\\java\\com\\example\\snake_game\\resources\\image\\game1a.gif", playMan1Button);
        VBox centerVBox2 = createVBoxWithImageAndButton("File:C:\\Users\\dell\\IdeaProjects\\King_Snake\\Snake_Game\\src\\main\\java\\com\\example\\snake_game\\resources\\image\\game2a.gif", playMan2Button);
        VBox centerVBox3 = createVBoxWithImageAndButton("File:C:\\Users\\dell\\IdeaProjects\\King_Snake\\Snake_Game\\src\\main\\java\\com\\example\\snake_game\\resources\\image\\game3.gif", playMan3Button);


        HBox hBox = new HBox(centerVBox1, centerVBox2, centerVBox3); // HBox để chứa 3 màn chơi
        hBox.setAlignment(Pos.CENTER); // Canh giữa các màn chơi
        hBox.setSpacing(60); // Khoảng cách giữa các màn chơi


        BorderPane root = new BorderPane();
        root.setTop(topBox);
        root.setCenter(hBox); // Đặt HBox vào phần center của BorderPane
        Scene scene = new Scene(root, 1200, 800);
        scene.getRoot().setStyle(
                "-fx-background-color: linear-gradient(to bottom right, #00FFFF, #8A2BE2);"
        );
        return scene;
    }
    private static VBox createVBoxWithImageAndButton(String imagePath, Button button) {
        VBox vBox = new VBox();
        vBox.setAlignment(Pos.CENTER);

        ImageView imageView = new ImageView(new Image(imagePath));
        imageView.setFitHeight(300);
        imageView.setFitWidth(180);
        imageView.setStyle("-fx-background-radius: 15;"); // Bo tròn góc của ImageView

        vBox.getChildren().add(imageView);
        vBox.getChildren().add(button);
        vBox.setSpacing(10);
        vBox.setStyle("-fx-background-radius: 15;"); // Bo tròn góc của VBox

        return vBox;
    }

    private static void showIncompleteAlert(String incompleteMan) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Cảnh báo");
        alert.setHeaderText(null);
        alert.setContentText("Bạn chưa qua màn " + incompleteMan + ". "+"Hãy qua màn.");
        alert.showAndWait();
    }
}
