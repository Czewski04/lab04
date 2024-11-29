package controller.startview;

import controller.ControllerInterface;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class MenuViewController implements ControllerInterface {

    private Stage stage;
    private Scene scene;
    private Parent root;

    public void switchToLibraryChartView(ActionEvent actionEvent) throws IOException {
        String fxmlPath = "/chartview/regions/libraryRegionsChartView.fxml";
        switchChart(actionEvent, root, stage, scene, fxmlPath);
    }

    public void switchToBookLoanChartView(ActionEvent actionEvent) throws IOException {
        String fxmlPath = "/chartview/regions/bookLoanRegionsChartView.fxml";
        switchChart(actionEvent, root, stage, scene, fxmlPath);
    }

    public void switchToPlacesForReadersChartView(ActionEvent actionEvent) throws IOException {
        String fxmlPath = "/chartview/regions/placesForReadersRegionsChartView.fxml";
        switchChart(actionEvent, root, stage, scene, fxmlPath);
    }

    public void switchToReadersChartView(ActionEvent actionEvent) throws IOException {
        String fxmlPath = "/chartview/regions/readersRegionsChartView.fxml";
        switchChart(actionEvent, root, stage, scene, fxmlPath);
    }
}
