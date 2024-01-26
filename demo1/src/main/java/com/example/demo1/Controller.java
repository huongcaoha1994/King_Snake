package com.example.demo1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

public class Controller {
    @FXML
    private TextField submit ;
    public void getAge(ActionEvent event){
        String age = submit.getText();
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Get age");
        alert.setHeaderText("age");
        alert.setContentText("Bạn năm nay " + age + " tuổi !" );
        alert.show();
    }
}
