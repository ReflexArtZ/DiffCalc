package de.diffcalc.listener;


import com.jfoenix.controls.JFXButton;
import de.diffcalc.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;


public class HubController {

    @FXML private JFXButton closeBtn;
    @FXML private JFXButton diffBtn;
    @FXML private JFXButton minimizeBtn;

    // location and resources will be automatically injected by the FXML loader
    @FXML private URL location;
    @FXML private ResourceBundle resources;

    /**
     * Default constructor
     */
    public HubController() {
    }

    @FXML
    void diffCalc(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("de/diffcalc/guis/DiffCalc.fxml")));
            Main.setMainScene(new Scene(root, 1200, 600));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    // region window operations
    @FXML
    void closeWindow(ActionEvent event) {
        Main.getOpenStage().close();
    }
    @FXML
    void minimizeWindow(ActionEvent event) {
        Main.getOpenStage().toBack();
    }
    // endregion

    @FXML
    private void initialize() {

    }


}
