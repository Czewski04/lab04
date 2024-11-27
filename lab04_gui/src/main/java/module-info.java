module lab04.gui {
    requires javafx.fxml;
    requires javafx.controls;

    opens gusclientapp to javafx.fxml;
    exports gusclientapp;
}