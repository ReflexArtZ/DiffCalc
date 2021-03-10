package de.diffcalc;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.util.Objects;

public class Main extends Application {

    //public static Debugger debugger;

    // --- coordinates for windows position ---
    private static double xOffset = 0;
    private static double yOffset = 0;

    // currently opened stage
    private static Stage openStage;


    public static Stage getOpenStage() {
        return openStage;
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        openStage = primaryStage;

        primaryStage.initStyle(StageStyle.UNDECORATED);

        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("de/diffcalc/guis/Hub.fxml")));

        primaryStage.setTitle("Diff-Calc");
        setMainScene(new Scene(root, 1000, 600));
        primaryStage.show();
    }


    public static void main(String[] args) {
        //debugger = new Debugger();
        launch(args);
       // debugger.getLogger().info("Launched DiffCalc!");
    }

    /**
     * Setting listener to the current scene in the open stage, so the stage can be dragged
     * @param scene the current scene
     */
    public static void setMainScene(Scene scene) {
        scene.getRoot().setOnMousePressed(event -> {
            xOffset = openStage.getX() - event.getScreenX();
            yOffset = openStage.getY() - event.getScreenY();
        });
        scene.getRoot().setOnMouseDragged(event -> {
            openStage.setX(event.getScreenX() + xOffset);
            openStage.setY(event.getScreenY() + yOffset);
        });
        openStage.setScene(scene);
    }


}
