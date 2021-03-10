package de.diffcalc.utils;

import javafx.scene.control.TextFormatter;

import java.util.function.UnaryOperator;

public class Filters {
    /**
     * Custom formatter only passing integer values
     * @return unary operator
     */
    public static UnaryOperator<TextFormatter.Change> integerFilter() {
        return change -> {
            String newText = change.getControlNewText();
            if (newText.matches("[-]?[0-9]*")) {
                return change;
            }
            return null;
        };
    }
}
