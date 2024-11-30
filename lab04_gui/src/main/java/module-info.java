module lab04.gui {
    requires javafx.fxml;
    requires javafx.controls;
    requires lab04.client;

    opens gusclientapp to javafx.fxml;
    exports gusclientapp;
    exports guiservice;
    opens guiservice to javafx.fxml;
    exports controller.regionsview;
    opens controller.regionsview to javafx.fxml;
    exports controller.countryview;
    opens controller.countryview to javafx.fxml;
    exports controller.startview;
    opens controller.startview to javafx.fxml;
    exports controller.interfacecontroller;
    opens controller.interfacecontroller to javafx.fxml;
}