package com.example.snake_game;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.bson.Document;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import java.time.LocalDateTime;
import java.time.ZoneId;

public class HistoryController {
    @FXML
    private TableView<User> tableView;

    @FXML
    private TableColumn<User, String> nameColumn;

    @FXML
    private TableColumn<User, Integer> pointColumn;
    @FXML
    private TableColumn<User, LocalDateTime> timeColumn;

    public void initialize() {
        // Connect to MongoDB
        MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
        MongoDatabase database = mongoClient.getDatabase("kingsnake");
        MongoCollection<Document> collection = database.getCollection("user");

        // Configure table columns
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        pointColumn.setCellValueFactory(new PropertyValueFactory<>("point"));
        timeColumn.setCellValueFactory(new PropertyValueFactory<>("time"));

        // Query MongoDB and populate the table view
        FindIterable<Document> documents = collection.find();
        for (Document document : documents) {
            String name = document.getString("name");
            int point = document.getInteger("point");
            LocalDateTime time = document.getDate("time").toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
            User user = new User();
            user.setName(name);
            user.setPoint(point);
            user.setTime(time);
            tableView.getItems().add(user);
        }
    }
}