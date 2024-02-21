package com.example.snake_game.views;

import com.example.snake_game.models.GetLevel;
import com.example.snake_game.models.GetRank;
import com.example.snake_game.models.GetScore;
import com.example.snake_game.utils.GetImage;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
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
import org.bson.Document;

public class SceneRank {
    public static Scene sceneRank(){
        int width = 1200;
        int height = 780;
        int fontSize = 35 ;

        Image backgroundImage = GetImage.getImage("C:\\Users\\dell\\IdeaProjects\\King_Snake\\Snake_Game\\src\\main\\java\\com\\example\\snake_game\\resources\\image\\rank.jpg");
        BackgroundImage background = new BackgroundImage(backgroundImage,
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT, new BackgroundSize(width, height, false, false, true, true));


        // Tạo AnchorPane
        GridPane gridPane = new GridPane(width,height);
        gridPane.setPadding(new Insets(15));
        gridPane.setHgap(70);
        gridPane.setVgap(10);

        Text textTitle = new Text("\t \t     RANK");
        textTitle.setFont(Font.font("Arial", FontWeight.BOLD, 50));
        textTitle.setFill(Color.RED);
        gridPane.add(textTitle,1,0);

        MongoDatabase database = null;
        // Thay đổi URI kết nối theo cấu hình MongoDB của bạn
        String connectionString = "mongodb://localhost:27017";

        try (com.mongodb.MongoClient mongoClient = new MongoClient(new MongoClientURI(connectionString))) {
            // Kết nối thành công

            // Chọn cơ sở dữ liệu
            database = mongoClient.getDatabase("kingsnake");
            MongoCollection<Document> collection = database.getCollection("user");
            FindIterable<Document> result = collection.find()
                    .sort(new Document("score", -1))
                    .limit(5);

            // In ra 10 tài liệu
            Text title1 = new Text("Username");
            title1.setFont(Font.font("Arial", fontSize));
            title1.setFill(Color.RED);
            gridPane.add(title1,1,5);

            Text title2 = new Text("Level");
            title2.setFont(Font.font("Arial", fontSize));
            title2.setFill(Color.RED);
            gridPane.add(title2,2,5);

            Text title3 = new Text("Score");
            title3.setFont(Font.font("Arial", fontSize));
            title3.setFill(Color.RED);
            gridPane.add(title3,3,5);

            Text title4 = new Text("Rank");
            title4.setFont(Font.font("Arial", fontSize));
            title4.setFill(Color.RED);
            gridPane.add(title4,4,5);

            int row = 10 ;
            for (Document document : result) {
              String username  =  document.getString("username");
              int level = document.getInteger("level");
              int score = document.getInteger("score");
              String rank = document.getString("rank");
                Text textName = new Text(username);
                textName.setFont(Font.font("Arial", fontSize));
                textName.setFill(Color.BLACK);
                gridPane.add(textName,1,row);

                Text textLevel = new Text(String.valueOf(level));
                textLevel.setFont(Font.font("Arial", fontSize));
                textLevel.setFill(Color.BLACK);
                gridPane.add(textLevel,2,row);

                Text textScore = new Text(String.valueOf(score));
                textScore.setFont(Font.font("Arial", fontSize));
                textScore.setFill(Color.BLACK);
                gridPane.add(textScore,3,row);

                Text textRank = new Text(rank);
                textRank.setFont(Font.font("Arial", fontSize));
                textRank.setFill(Color.BLACK);
                gridPane.add(textRank,4,row);

                row+=4;
            }
        } catch (Exception e) {
            // Xử lý lỗi kết nối
            e.printStackTrace();
        }

//        Text textName = new Text("Username : \t" + username);
//        textName.setFont(Font.font("Arial", fontSize));
//        textName.setFill(Color.RED);
//        gridPane.add(textName,1,25);


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
        gridPane.add(buttonBack,2,30);



        gridPane.setBackground(new Background(background));
        Scene scene = new Scene(gridPane,width,height);
        return scene ;

    }
}
