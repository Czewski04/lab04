package controller;

import app.Application;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import model.DatabaseRow;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;

public class BookLoanChartController extends Application implements Initializable {

    @FXML
    public BarChart<String, Double> bookLoanChart;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            ArrayList<XYChart.Series<String, Double>> seriesList = new ArrayList<>(prepareChartSeries());
            for(XYChart.Series<String, Double> series : seriesList) {
                bookLoanChart.getData().add(series);
            }
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<XYChart.Series<String, Double>> prepareChartSeries() throws IOException, InterruptedException {
        ArrayList<DatabaseRow> databaseRows = new ArrayList<>(getDatabaseRowsListLibraryData(2023));
        ArrayList<XYChart.Series<String, Double>> seriesList = new ArrayList<>();

        HashMap<String, String[]> seriesNamesMap = new HashMap<>();
        for (DatabaseRow databaseRow : databaseRows) {
            String seriesName = databaseRow.getNamePosition3()+", "+databaseRow.getNamePosition2();
            if (!seriesNamesMap.containsKey(seriesName)) {
                seriesNamesMap.put(seriesName, new String[]{databaseRow.getNamePosition2(), databaseRow.getNamePosition3()});
            }
        }

        for(String seriesName : seriesNamesMap.keySet()) {
            seriesList.add(new XYChart.Series<>());
            seriesList.getLast().setName(seriesName);
            for(DatabaseRow databaseRow : databaseRows) {
                if(databaseRow.getNamePosition2().equals(seriesNamesMap.get(seriesName)[0]) && databaseRow.getNamePosition3().equals(seriesNamesMap.get(seriesName)[1])) {
                    seriesList.getLast().getData().add(new XYChart.Data(databaseRow.getNamePosition1(), databaseRow.getValue()));
                }
            }
        }

        return seriesList;
    }
}
