package guiservice;

import javafx.scene.chart.XYChart;
import model.DatabaseRow;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public abstract class AbstractService {
    public static ArrayList<XYChart.Series<String, Double>> prepareCountryChartSeries(ArrayList<DatabaseRow> databaseRows) throws IOException, InterruptedException {
        ArrayList<XYChart.Series<String, Double>> seriesList = new ArrayList<>();
        HashMap<String, String[]> seriesNamesMap = new HashMap<>(createSeriesMap(databaseRows));


        for(String seriesName : seriesNamesMap.keySet()) {
            seriesList.add(new XYChart.Series<>());
            seriesList.getLast().setName(seriesName);
            for(DatabaseRow databaseRow : databaseRows) {
                if(databaseRow.getNamePosition2().equals(seriesNamesMap.get(seriesName)[0]) && databaseRow.getNamePosition3().equals(seriesNamesMap.get(seriesName)[1])&&databaseRow.getNamePosition1().equals("POLSKA")) {
                    seriesList.getLast().getData().add(new XYChart.Data(databaseRow.getNamePosition1(), databaseRow.getValue()));
                }
            }
        }

        return seriesList;
    }

    public static ArrayList<XYChart.Series<String, Double>> prepareRegionsChartSeries(ArrayList<DatabaseRow> databaseRows) throws IOException, InterruptedException {
        ArrayList<XYChart.Series<String, Double>> seriesList = new ArrayList<>();
        HashMap<String, String[]> seriesNamesMap = new HashMap<>(createSeriesMap(databaseRows));

        for(String seriesName : seriesNamesMap.keySet()) {
            seriesList.add(new XYChart.Series<>());
            seriesList.getLast().setName(seriesName);
            for(DatabaseRow databaseRow : databaseRows) {
                if(databaseRow.getNamePosition2().equals(seriesNamesMap.get(seriesName)[0]) && databaseRow.getNamePosition3().equals(seriesNamesMap.get(seriesName)[1]) && !databaseRow.getNamePosition1().equals("POLSKA")) {
                    seriesList.getLast().getData().add(new XYChart.Data(databaseRow.getNamePosition1(), databaseRow.getValue()));
                }
            }
        }

        return seriesList;
    }

    private static HashMap<String, String[]> createSeriesMap(ArrayList<DatabaseRow> databaseRows) {
        HashMap<String, String[]> seriesNamesMap = new HashMap<>();
        for (DatabaseRow databaseRow : databaseRows) {
            String seriesName="";
            if(databaseRow.getNamePosition3().isEmpty())
                seriesName = databaseRow.getNamePosition2();
            else
                seriesName = databaseRow.getNamePosition3()+", "+databaseRow.getNamePosition2();
            if (!seriesNamesMap.containsKey(seriesName)) {
                seriesNamesMap.put(seriesName, new String[]{databaseRow.getNamePosition2(), databaseRow.getNamePosition3()});
            }
        }

        return seriesNamesMap;
    }


}
