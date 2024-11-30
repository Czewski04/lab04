package controller.regionsview;

import app.ApiClientApp;
import controller.ControllerInterface;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import model.DatabaseRow;
import guiservice.GuiService;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class BookLoanRegionsChartController extends GuiService implements Initializable, ControllerInterface {
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    public Label yearLabel;
    @FXML
    public BarChart<String, Double> bookLoanChart;

    private int year=2023;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        refreshChart(year);
    }

    public void refreshChart(int year){
        try {
            bookLoanChart.getData().clear();
            yearLabel.setText(String.valueOf(year));
            ArrayList<XYChart.Series<String, Double>> seriesList = new ArrayList<>(prepareChartSeries(year));
            for(XYChart.Series<String, Double> series : seriesList) {
                bookLoanChart.getData().add(series);
            }
        } catch (IOException | InterruptedException | NullPointerException e) {
            showErrorDialog("Błąd", "Brak dostępu do danych.");
        }
    }


    public void addYear(){
        this.year+=1;
        refreshChart(year);
    }

    public void oddYear(){
        this.year-=1;
        refreshChart(year);
    }

    public ArrayList<XYChart.Series<String, Double>> prepareChartSeries(int year) throws IOException, InterruptedException {
        ApiClientApp app = new ApiClientApp();
        ArrayList<DatabaseRow> databaseRows = new ArrayList<>(app.getDatabaseRowsListBookLoanData(year));

        return prepareRegionsChartSeries(databaseRows);
    }

    public void switchToCountryChart(ActionEvent actionEvent) throws IOException {
        String fxmlPath = "/chartview/country/bookLoanCountryChartView.fxml";
        switchChart(actionEvent, root, stage,scene, fxmlPath);
    }

    public void switchToMenu(ActionEvent actionEvent) throws IOException {
        switchToMenu(actionEvent, root, stage, scene);
    }
}
