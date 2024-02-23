package com.example.snake_game.views;

import com.example.snake_game.models.GetLevel;
import com.example.snake_game.models.GetRank;
import com.example.snake_game.models.GetScore;
import com.example.snake_game.utils.GetImage;
import com.example.snake_game.utils.StringPathImage;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class SceneInformation {
    public static String username = "huongcaoha94" ;
    public void setUsername(String username){
        this.username = username ;
    }
    public static Scene information(){
        int width = 1200;
        int height = 780;
        int fontSize = 35 ;

        Image backgroundImage = new Image(StringPathImage.bg_information_jpg());
        BackgroundImage background = new BackgroundImage(backgroundImage,
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT, new BackgroundSize(width, height, false, false, true, true));


        // Tạo AnchorPane
        GridPane gridPane = new GridPane(width,height);
        gridPane.setPadding(new Insets(15));
        gridPane.setHgap(220);
        gridPane.setVgap(10);

        Text textTitle = new Text("\t \t    INFORMATION");
        textTitle.setFont(Font.font("Arial", FontWeight.BOLD, 50));
        textTitle.setFill(Color.RED);
        gridPane.add(textTitle,1,0);

        Text textName = new Text("Username : \t" + username);
        textName.setFont(Font.font("Arial", fontSize));
        textName.setFill(Color.RED);
        gridPane.add(textName,1,25);

        Text textScore = new Text("Score : \t" + GetScore.getScore(username));
        textScore.setFont(Font.font("Arial", fontSize));
        textScore.setFill(Color.RED);
        gridPane.add(textScore,1,27);

        Text textLevel = new Text("Level : \t" + GetLevel.getLevel(username));
        textLevel.setFont(Font.font("Arial", fontSize));
        textLevel.setFill(Color.RED);
        gridPane.add(textLevel,1,29);

        Text textRank = new Text("Rank : \t" + GetRank.getRank(username));
        textRank.setFont(Font.font("Arial", fontSize));
        textRank.setFill(Color.RED);
        gridPane.add(textRank,1,31);

        Button buttonBack = new Button("Back Main");
        Tooltip tooltipStart = new Tooltip("Click để quay lại");
        buttonBack.setTooltip(tooltipStart);
        buttonBack.setPrefSize(143, 50);
        buttonBack.setStyle("-fx-font-weight: bold; -fx-font-size: 23; -fx-background-color: linear-gradient(to right, #aa00ff, #FFFF00); -fx-background-radius: 15;");
        buttonBack.setEffect(new DropShadow());
        buttonBack.setOnAction(event -> {
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(SceneDisplay.display());
            stage.show();
        });
        gridPane.add(buttonBack,1,33);



        gridPane.setBackground(new Background(background));
        Scene scene = new Scene(gridPane,width,height);
        return scene ;

    }
}
