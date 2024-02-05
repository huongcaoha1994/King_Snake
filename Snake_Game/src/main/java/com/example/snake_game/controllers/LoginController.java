package com.example.snake_game.controllers;

import com.mongodb.connection.Connection;
import com.mongodb.connection.ConnectionId;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.File;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    @FXML
    private Button cancelButton;

    @FXML
    private Label loginMessageLabel;

    @FXML
    private ImageView brandingImageView;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        File brandingFile = new File("/../../../../java/com/example/snake_game/resources/image/logo.jpg");
        Image brandingImage = new Image(brandingFile.toURI().toString());
        brandingImageView.setImage(brandingImage);
    }
    public void loginButtonOnAction(ActionEvent event){
        loginMessageLabel.setText("You Try to Login");
    }
    public void cancelButtonOnAction(ActionEvent event){
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.show();
    }

    public void createAccountFrom(){
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("register.fxml")));
            Stage registerStage = new Stage();
            registerStage.initStyle(StageStyle.UNDECORATED);
            registerStage.setTitle("Snake");
            registerStage.setScene(new Scene(root,800,600));
            registerStage.show();
        }catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }

}
