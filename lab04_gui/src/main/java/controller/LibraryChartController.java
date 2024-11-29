package controller;

import app.Application;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import model.DatabaseRow;
import guiservice.ServiceAbstractClass;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class LibraryChartController extends ServiceAbstractClass implements Initializable {

    @FXML
    public BarChart<String, Double> libraryChart;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            ArrayList<XYChart.Series<String, Double>> seriesList = new ArrayList<>(prepareChartSeries());
            for(XYChart.Series<String, Double> series : seriesList) {
                libraryChart.getData().add(series);
            }
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<XYChart.Series<String, Double>> prepareChartSeries() throws IOException, InterruptedException {
        Application app = new Application();
        ArrayList<DatabaseRow> databaseRows = new ArrayList<>(app.getDatabaseRowsListLibraryData(2023));

        return prepareChartSeries(databaseRows);
    }
}
