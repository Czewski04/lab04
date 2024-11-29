package controller.startview;

import controller.ControllerInterface;
import javafx.event.ActionEvent;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class WelcomeViewController implements ControllerInterface {

    private Stage stage;
    private Scene scene;
    private Parent root;

    public void switchToMenuView(ActionEvent actionEvent) throws IOException {
        switchToMenu(actionEvent, root, stage, scene);
    }
}
