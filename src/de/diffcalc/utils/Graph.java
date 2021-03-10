package de.diffcalc.utils;

import de.diffcalc.exp4j.ast.Operation;
import javafx.scene.chart.XYChart;

public class Graph {
    private XYChart<Double, Double> chart;


    private double rangeNegX;
    private double rangePosX;

    private String graphInfo;

    /**
     * Custom cunstructor
     * @param lineChart
     * @param rangeNegX
     * @param rangePosX
     * @param graphInfo infos about the graph
     */
    public Graph(XYChart<Double, Double> lineChart, double rangeNegX, double rangePosX, String graphInfo) {
        this.chart = lineChart;
        this.rangeNegX = rangeNegX;
        this.rangePosX = rangePosX;

        this.graphInfo = graphInfo;
    }

    /**
     * Method to draw a line from a certain function
     */
    public void drawLine(Operation operation) {     // Using final keyword for possible performance increase, see https://en.wikipedia.org/wiki/Memoization
        final XYChart.Series<Double, Double> series = new XYChart.Series<>();
        for (double x = rangeNegX; x <= rangePosX; x = x + 0.01) {
            Double d = operation.getNumericResult(x);
            if (d.isNaN()) continue;
            drawPoint(x, d, series);
        }
        chart.getData().add(series);
    }




    /**
     * Draws a certain point in the coordinate system
     * @param x coordinate x
     * @param y coordinate y
     * @param series Series of Chart data
     */
    private void drawPoint(final double x, final double y, final XYChart.Series<Double, Double> series) {   // Using final keyword for possible performance increase, see https://en.wikipedia.org/wiki/Memoization
        XYChart.Data data = new XYChart.Data<>(x, y);
        data.setNode(new HoveredThresholdNode(graphInfo+"\n"+(double) Math.round(y * 100) / 100));
        series.getData().add(data);
    }

    public void clear() {
        chart.getData().clear();
    }

}

