module com.example.kingsnack {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.kingsnack to javafx.fxml;
    exports com.example.kingsnack;
}