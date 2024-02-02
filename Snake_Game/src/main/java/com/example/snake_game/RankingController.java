package com.example.snake_game;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import org.bson.Document;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class RankingController {
    @FXML
    private TableView<Ranking> tableView;

    @FXML
    private TableColumn<Ranking, String> nameColumn;

    @FXML
    private TableColumn<Ranking, String> rankColumn;

    public void initialize() {
        // Connect to MongoDB
        MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
        MongoDatabase database = mongoClient.getDatabase("projectdemo");
        MongoCollection<Document> collection = database.getCollection("thi");

        // Query MongoDB and populate the table view
        FindIterable<Document> documents = collection.find();
        for (Document document : documents) {
            String name = document.getString("name");
            String rank = document.getString("rank");
            tableView.getItems().add(new Ranking(name, rank));
        }

        // Configure table columns
        nameColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        rankColumn.setCellValueFactory(cellData -> cellData.getValue().rankProperty());
    }
}