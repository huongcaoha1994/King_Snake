package com.example.snake_game.controllers;

import com.example.snake_game.models.CheckUsernamePassword;
import com.example.snake_game.views.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
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
    private TextField usernameTextField ;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button cancelButton;

    @FXML
    private Label loginMessageLabel;

    @FXML
    private ImageView brandingImageView;

    private  String username = "" ;
    private String password = "" ;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        File brandingFile = new File("/../../../../java/com/example/snake_game/resources/image/logo.jpg");
        Image brandingImage = new Image(brandingFile.toURI().toString());
        brandingImageView.setImage(brandingImage);
    }
    public void loginButtonOnAction(ActionEvent event) throws Exception {
        username = usernameTextField.getText().trim();
        password = passwordField.getText().trim();
//        loginMessageLabel.setText("You Try to Login");
        if (CheckUsernamePassword.checkUsernamePassword(username,password)){
            SceneDisplay sceneDisplay = new SceneDisplay();
            sceneDisplay.setUsername(username);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(SceneDisplay.display());
            stage.show();

        }
        else{
            showAlert("Login Error","Acount or Password fail !");
            return;
        }
    }
    public void register(ActionEvent event) throws Exception {
        Parent registerPage = FXMLLoader.load(getClass().getResource("/com/example/snake_game/Register.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(registerPage));
        stage.show();

    }
    public void cancelButtonOnAction(ActionEvent event){
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.show();
    }
    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
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
