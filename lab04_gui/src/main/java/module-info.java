module lab04.gui {
    requires javafx.fxml;
    requires javafx.controls;
    requires lab04.client;

    opens gusclientapp to javafx.fxml;
    exports gusclientapp;
    exports controller;
    opens controller to javafx.fxml;
}