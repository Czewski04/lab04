package controller;

import app.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;
import model.DatabaseRow;
import guiservice.ServiceAbstractClass;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Objects;
import java.util.ResourceBundle;

public class BookLoanChartController extends ServiceAbstractClass implements Initializable {

    private Stage stage;
    private Scene scene;
    private Parent root;

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
            ArrayList<XYChart.Series<String, Double>> seriesList = new ArrayList<>(prepareChartSeries(year));
            for(XYChart.Series<String, Double> series : seriesList) {
                bookLoanChart.getData().add(series);
            }
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
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
        Application app = new Application();
        ArrayList<DatabaseRow> databaseRows = new ArrayList<>(app.getDatabaseRowsListBookLoanData(year));

        return prepareChartSeries(databaseRows);
    }

    public void switchToCountryChart(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Objects.requireNonNull(getClass().getResource("/bookLoanChartView.fxml")));
        root = fxmlLoader.load();

        stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
