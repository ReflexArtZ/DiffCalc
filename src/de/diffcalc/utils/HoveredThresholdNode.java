package de.diffcalc.utils;

import javafx.scene.Cursor;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;

/**
 * Custom Node for hover tooltip
 */
class HoveredThresholdNode extends StackPane {

    /**
     * Custom constructor displaying informations of a graph-point
     * @param s string to display in the label
     */
    public HoveredThresholdNode(String s) {
        setPrefSize(2, 2);

        final Label label = createLabel(s);

        setOnMouseEntered(mouseEvent -> {
            getChildren().setAll(label);
            setCursor(Cursor.NONE);
            toFront();
        }); // listener on mouse entered -> display the label
        setOnMouseExited(mouseEvent -> getChildren().clear());
    }

    /**
     * Create threshold-label displaying informations of the current graph-point
     * @param s string to display
     * @return the generated label
     */
    private Label createLabel(String s) {
        final Label label = new Label(s + "");
        label.getStyleClass().addAll("default-color0", "chart-line-symbol", "chart-series-line");
        label.setStyle("-fx-font-size: 15");

        label.setMinSize(Label.USE_PREF_SIZE, Label.USE_PREF_SIZE);
        return label;
    }
}