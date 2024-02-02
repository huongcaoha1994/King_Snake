package com.example.snake_game;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Ranking {
    private final StringProperty name;
    private final StringProperty rank;

    public Ranking(String name, String rank) {
        this.name = new SimpleStringProperty(name);
        this.rank = new SimpleStringProperty(rank);
    }

    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty() {
        return name ;
    }

    public void setName(String player) {
        this.name.set(player);
    }

    public String getRank() {
        return rank.get();
    }

    public StringProperty rankProperty() {
        return rank;
    }

    public void setRank(String result) {
        this.rank.set(result);
    }
}