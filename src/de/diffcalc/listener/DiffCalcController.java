package de.diffcalc.listener;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import de.diffcalc.Main;
import de.diffcalc.exp4j.ast.Operation;
import de.diffcalc.exp4j.tokenizer.AbstractTreeBuilder;
import de.diffcalc.exp4j.tokenizer.TokenizerException;
import de.diffcalc.utils.Filters;
import de.diffcalc.utils.Graph;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.chart.LineChart;
import javafx.scene.control.Button;
import javafx.scene.control.TextFormatter;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.util.Duration;
import javafx.util.converter.IntegerStringConverter;
import net.objecthunter.exp4j.tokenizer.UnknownFunctionOrVariableException;
import org.controlsfx.control.Notifications;

import java.net.URL;
import java.util.ResourceBundle;


/**
 * Controller class for the DiffCalc Gui
 */
public class DiffCalcController {
    @FXML private LineChart<Double, Double> lineGraph;  // graph that displays the antiderivative and derivative function

    // location and resources will be automatically injected by the FXML loader
    @FXML private URL location; // location of the FXML File
    @FXML private ResourceBundle resources; // Resources for Strings of different languages

    private Graph graph;    // data class for the lineGraph

    @FXML private JFXTextField functionLbl;
    @FXML private JFXButton goBtn;

    @FXML private Button minimizeBtn;
    @FXML private Button closeBtn;

    @FXML private JFXTextField rangeXLbl;
    @FXML private JFXTextField rangeX1Lbl;

    /**
     * Default constructor
     */
    public DiffCalcController() {
    }

    @FXML
    void handleGo(ActionEvent event) {
        if (graph != null) graph.clear();
        if (functionLbl.getText().trim().equals("")) return;    // in case no function was entered, return

        AbstractTreeBuilder treeBuilder;
        Operation function;
        try {
             treeBuilder = new AbstractTreeBuilder(functionLbl.getText());
             function = treeBuilder.getTree();
        } catch (TokenizerException | UnknownFunctionOrVariableException e) {
            Notifications.create().title("Error!").text("Konnte den Baum der Funktion "+functionLbl.getText()+" nicht bilden!").graphic(null).hideAfter(Duration.seconds(5)).position(Pos.BOTTOM_RIGHT).show();
            return;
        }

        if (function == null) return;

        newGraph(function, "Antiderivative");

        Operation derivative = function.calcDerivative();
        newGraph(derivative, "Symbolic Derivative");

        System.out.println("Symbolic Derivative: "+derivative.toString());
    }

    // region window operations
    @FXML
    public void handleCloseMouseEntered() {
        closeBtn.setTextFill(Color.YELLOW);
    }
    @FXML
    public void handleCloseMouseExited() {
        closeBtn.setTextFill(Color.WHITE);
    }
    @FXML
    public void handleClose() {
        Main.getOpenStage().close();
    }
    @FXML
    void handleMinimize(ActionEvent event) {
        Main.getOpenStage().toBack();
    }
    @FXML
    void handleMinimizeMouseEntered(MouseEvent event) {
        minimizeBtn.setTextFill(Color.YELLOW);
    }
    @FXML
    void handleMinimizeMouseExited(MouseEvent event) {
        minimizeBtn.setTextFill(Color.WHITE);
    }
    // endregion

    /**
     * Draw a new line of a function
     * @param operation the function to draw the line
     */
    private void drawLine(Operation operation) {
        if (lineGraph.isVisible()) {
            graph.drawLine(operation);
        }
    }

    /**
     * Create new graph for a function
     * @param operation the function
     * @param info some information of the funciton
     */
    private void newGraph(Operation operation, String info) {
        graph = new Graph(lineGraph, Integer.parseInt(rangeXLbl.getText()), Integer.parseInt(rangeX1Lbl.getText()), info);
        lineGraph.setVisible(true);

        drawLine(operation);
    }

    @FXML
    private void initialize() {
        //Main.debugger.getLogger().info("Initializing DiffCalcController ...");

        // setting formatter for the rangeLbls, only letting right numbers being inputed
        rangeXLbl.setTextFormatter(new TextFormatter<>(new IntegerStringConverter(), -15, Filters.integerFilter()));  // only allowing double inputs
        rangeX1Lbl.setTextFormatter(new TextFormatter<>(new IntegerStringConverter(), 15, Filters.integerFilter()));  // only allowing double inputs
    }


}