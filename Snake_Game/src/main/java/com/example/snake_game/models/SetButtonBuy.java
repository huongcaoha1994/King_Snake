package com.example.snake_game.models;

import com.example.snake_game.views.SceneInformation;
import com.example.snake_game.views.SceneLogin;
import com.example.snake_game.views.SceneShop;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.stage.Stage;

import java.util.List;

public class SetButtonBuy {
    public static Button setButton(int numberOutfit,int price){
        SceneLogin sceneLogin = new SceneLogin();
        String username = sceneLogin.getUsername();
        List<Integer> listOutfit = GetListOutfit.getListOutfit(username) ;
        int skin = Getskin.getSkin(username);

        Button buttonUsing = new Button("Using");
        buttonUsing.setPrefSize(143, 50);
        buttonUsing.setStyle("-fx-font-weight: bold; -fx-font-size: 23; -fx-background-color: linear-gradient(to right, #aa00ff, #FFFF00); -fx-background-radius: 15;");
        buttonUsing.setEffect(new DropShadow());
        buttonUsing.setOnAction(actionEvent -> {
        });

        Button buttonUse = new Button("Use");
        buttonUse.setPrefSize(143, 50);
        buttonUse.setStyle("-fx-font-weight: bold; -fx-font-size: 23; -fx-background-color: linear-gradient(to right, #aa00ff, #FFFF00); -fx-background-radius: 15;");
        buttonUse.setEffect(new DropShadow());
        buttonUse.setOnAction(actionEvent -> {
            UpdateSkin.udpateSkin(username,numberOutfit);
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setScene(SceneShop.shop());
            stage.show();
        });

        Button buttonBuy = new Button("Buy");
        buttonBuy.setPrefSize(143, 50);
        buttonBuy.setStyle("-fx-font-weight: bold; -fx-font-size: 23; -fx-background-color: linear-gradient(to right, #aa00ff, #FFFF00); -fx-background-radius: 15;");
        buttonBuy.setEffect(new DropShadow());
        buttonBuy.setOnAction(actionEvent -> {
            int coin = GetCoin.coin(username);
            int rs = coin - price ;
            if(rs >= 0 ){
                UpdateCoin.updateCoin(username,rs);
                AddOutfit.addOutfit(username,numberOutfit);
                Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                stage.setScene(SceneShop.shop());
                stage.show();
            }else {
                Alert.alert("Not enough coins");
            }
        });
        Button button = null ;
        for (Integer number : listOutfit){
            if(numberOutfit == number){
                if(number == skin){
                    button = buttonUsing;
                }else {
                    button = buttonUse;
                }
            }else {
                button = buttonBuy;
            }
        }
        return button ;
    }
}
