package com.example.snake_game.views;

import com.example.snake_game.models.GetLevel;
import com.example.snake_game.models.GetScore;
import com.example.snake_game.utils.GetImage;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class SceneInformation {
    public static String username ;
    public void setUsername(String username){
        this.username = username ;
    }
    public static Scene information(){
        int width = 1200;
        int height = 960;
        int fontSize = 35 ;

        Image backgroundImage = GetImage.getImage("C:\\Users\\dell\\IdeaProjects\\King_Snake\\Snake_Game\\src\\main\\java\\com\\example\\snake_game\\resources\\image\\bg_information.jpg");
        BackgroundImage background = new BackgroundImage(backgroundImage,
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT, new BackgroundSize(width, height, false, false, true, true));

        Button buttonBack = new Button("Back");
        buttonBack.setPrefWidth(100);
        buttonBack.setPrefHeight(40);
        buttonBack.setStyle("-fx-background-color: #c8ff00;");
        buttonBack.setOnAction(event -> {
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(SceneDisplay.display());
            stage.show();
        });

        // Tạo AnchorPane
        GridPane gridPane = new GridPane(width,height);
        gridPane.setPadding(new Insets(15));
        gridPane.setHgap(250);
        gridPane.setVgap(10);

        Text textTitle = new Text("\t \t    INFORMATION");
        textTitle.setFont(Font.font("Arial", FontWeight.BOLD, 50));
        textTitle.setFill(Color.RED);
        gridPane.add(textTitle,1,0);

        Text textName = new Text("Username : \t" + username);
        textName.setFont(Font.font("Arial", fontSize));
        textName.setFill(Color.RED);
        gridPane.add(textName,1,30);

        Text textScore = new Text("Score : \t" + GetScore.getScore(username));
        textScore.setFont(Font.font("Arial", fontSize));
        textScore.setFill(Color.RED);
        gridPane.add(textScore,1,32);

        Text textLevel = new Text("Level : \t" + GetLevel.getLevel(username));
        textLevel.setFont(Font.font("Arial", fontSize));
        textLevel.setFill(Color.RED);
        gridPane.add(textLevel,1,34);



        gridPane.setBackground(new Background(background));
        Scene scene = new Scene(gridPane,width,height);
        return scene ;

    }
}
