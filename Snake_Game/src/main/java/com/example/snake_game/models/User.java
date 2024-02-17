package com.example.snake_game.models;


import javafx.beans.property.*;

import java.time.LocalDateTime;
import java.util.Date;

public class User {
    private StringProperty name;
    private StringProperty password;
    private IntegerProperty point;
    private StringProperty level;
    private StringProperty rank;
    private ObjectProperty<LocalDateTime> time;
    private IntegerProperty price;

    public User(StringProperty name, StringProperty password, IntegerProperty point, StringProperty level, StringProperty rank, ObjectProperty<LocalDateTime> time, IntegerProperty price) {
        this.name = name;
        this.password = password;
        this.point = point;
        this.level = level;
        this.rank = rank;
        this.time = time;
        this.price = price;
    }

    public User() {
        this.name = new SimpleStringProperty();
        this.password = new SimpleStringProperty();
        this.point = new SimpleIntegerProperty();
        this.level = new SimpleStringProperty();
        this.rank = new SimpleStringProperty();
        this.time = new SimpleObjectProperty<>();
        this.price = new SimpleIntegerProperty();
    }
    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getPassword() {
        return password.get();
    }

    public StringProperty passwordProperty() {
        return password;
    }

    public void setPassword(String password) {
        this.password.set(password);
    }

    public int getPoint() {
        return point.get();
    }

    public IntegerProperty pointProperty() {
        return point;
    }

    public void setPoint(int point) {
        this.point.set(point);
    }

    public String getLevel() {
        return level.get();
    }

    public StringProperty levelProperty() {
        return level;
    }

    public void setLevel(String level) {
        this.level.set(level);
    }

    public String getRank() {
        return rank.get();
    }

    public StringProperty rankProperty() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank.set(rank);
    }

    public LocalDateTime getTime() {
        return time.get();
    }

    public ObjectProperty<LocalDateTime> timeProperty() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time.set(time);
    }

    public int getPrice() {
        return price.get();
    }

    public IntegerProperty priceProperty() {
        return price;
    }

    public void setPrice(int price) {
        this.price.set(price);
    }
}
