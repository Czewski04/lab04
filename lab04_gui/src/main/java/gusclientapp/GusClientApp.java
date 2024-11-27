package gusclientapp;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;

import javafx.application.Application;

import java.io.IOException;
import java.util.Objects;


public class GusClientApp extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/mainView.fxml")));
        primaryStage.setTitle("GUI Client");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
}