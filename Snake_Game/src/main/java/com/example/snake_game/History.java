package com.example.snake_game;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class History {
    private final StringProperty player;
    private final StringProperty result;

    public History(String player, String result) {
        this.player = new SimpleStringProperty(player);
        this.result = new SimpleStringProperty(result);
    }

    public String getPlayer() {
        return player.get();
    }

    public StringProperty playerProperty() {
        return player;
    }

    public void setPlayer(String player) {
        this.player.set(player);
    }

    public String getResult() {
        return result.get();
    }

    public StringProperty resultProperty() {
        return result;
    }

    public void setResult(String result) {
        this.result.set(result);
    }
}