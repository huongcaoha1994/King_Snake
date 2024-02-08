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

public class RankingController {
    @FXML
    private TableView<User> tableView;

    @FXML
    private TableColumn<User, String> nameColumn;

    @FXML
    private TableColumn<User, String> rankColumn;

    public void initialize() {
        // Connect to MongoDB
        MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
        MongoDatabase database = mongoClient.getDatabase("kingsnake");
        MongoCollection<Document> collection = database.getCollection("user");

        // Configure table columns
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        rankColumn.setCellValueFactory(new PropertyValueFactory<>("rank"));
        // Query MongoDB and populate the table view
        FindIterable<Document> documents = collection.find();
        for (Document document : documents) {
            String name = document.getString("name");
            String rank = document.getString("rank");
            User user = new User();
            user.setName(name);
            user.setRank(rank);
            tableView.getItems().add(user);
        }
    }
}