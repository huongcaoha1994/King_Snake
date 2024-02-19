package com.example.snake_game.controllers;

import com.example.snake_game.models.CheckUsername;
import com.example.snake_game.models.InsertUser;
import com.example.snake_game.models.StringToHashCode;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.Parent;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class RegisterController implements Initializable {

    @FXML
    private ImageView shieldImageView;
    @FXML
    private TextField usernameField;
    @FXML
    private PasswordField passwordField;
   @FXML
   private PasswordField comFirmPasswordField;
    public void register(ActionEvent event){
        String username = usernameField.getText();
        String password = StringToHashCode.hashString(passwordField.getText());
        String comFirmPassword = StringToHashCode.hashString(comFirmPasswordField.getText());

        //kiểm tra nhập lại Password
        if (!password.equals(comFirmPassword)){
            showAlert("Registration Failed", "Passwords do not match.");
            return;
        }

        try {

            registerUser(username,password,comFirmPassword);
            showAlert("Registration Successful", "User registered successfully.");

            Parent loginPage = FXMLLoader.load(getClass().getResource("/com/example/snake_game/login.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(loginPage));
            stage.show();

        }catch (IOException e){
            e.printStackTrace();
            showAlert("Registration Failed", "Error registering user. Please try again.");
        }
    }


    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
    private void registerUser(String username, String password, String comFirmPassword) throws IOException {
//        try {
//            MongoDatabase database = MongoDBConnection.connectToMongoDB();
//            if (database==null){
//                throw  new IOException(" Registration failed");
//            }
//            // lấy collection User từ Mongodb
//            MongoCollection<Document> collection = database.getCollection("user");
//
//            //kiểm tra xem tài khoản đã tồn tại chưa
//            Document existingUser = collection.find(new Document("username",username)).first();
//
//            if (existingUser != null){
//                throw new IOException("Username already exists. Please choose a different username.");
//            }
//            // mã hóa mất khẩu
//            String hashedPassword =  BCrypt.hashpw(password,BCrypt.gensalt());

            // thông thông tin đăng ký vào database
//            Document newUser = new Document("username",username).append("password", password).append("comFirmPassword",comFirmPassword);
//            collection.insertOne(newUser);
//        }catch (Exception e) {
//            e.printStackTrace();
//            IOException ioException = new IOException("Registration failed. Please try again.");
//        }
        if(CheckUsername.checkUsernameExist(username)){
            throw new IOException("Username already exists. Please choose a different username.");
        }
        else {
            InsertUser.insertUser(username,password);
        }
    }
    @FXML
    private void clickLogin(ActionEvent event) throws Exception{
        Parent loginPage = FXMLLoader.load(getClass().getResource("/com/example/snake_game/login.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(loginPage));
        stage.show();
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        File shieldFile = new File("java/com/example/snake_game/resources/image/logo.jpg");
        Image shieldImage = new Image(shieldFile.toURI().toString());
        shieldImageView.setImage(shieldImage);
    }


}
