package org.devteam.view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.geometry.Side;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.AnchorPane;
import org.devteam.data.DataLoader;
import org.devteam.data.ServerLoader;
import org.devteam.view.charts.CandleStickChart;
import org.devteam.view.charts.CandleStickExtraValues;
import pl.zankowski.iextrading4j.api.stocks.Chart;

import java.util.List;

public class ChartController {
    @FXML
    AnchorPane mainPane;

    DataLoader client = new ServerLoader();
    List<Chart> loadedData = null;

    public void initialize(){
        loadedData = client.getStockChart("goog");
        initCharts();
    }

    private void initCharts() {
        // x-axis:
        final CategoryAxis xAxis = new CategoryAxis();

        // y-axis:
        final NumberAxis yAxis = new NumberAxis();
        yAxis.setForceZeroInRange(false);
        yAxis.setSide(Side.RIGHT);

        // chart:
        final CandleStickChart bc = new CandleStickChart(xAxis, yAxis);
        bc.setLegendVisible(false);
        // add starting data
        XYChart.Series<String, Number> series = new XYChart.Series<String,Number>();
        int index  = 0;
        for (Chart data: loadedData) {
            index++;
            System.out.println(data.toString());
            series.getData().add(
                    new XYChart.Data<String, Number>(data.getLabel(), data.getOpen(), new CandleStickExtraValues(
                            data.getClose().doubleValue(),
                            data.getHigh().doubleValue(),
                            data.getLow().doubleValue(),
                            (data.getHigh().doubleValue()+data.getLow().doubleValue()) /2))
            );
        }
        ObservableList<XYChart.Series<String, Number>> data = bc.getData();
        if (data == null) {
            data = FXCollections.observableArrayList(series);
            bc.setData(data);
        } else {
            bc.getData().add(series);
        }
        // stretching chart
        mainPane.setTopAnchor(bc, 5.);
        mainPane.setLeftAnchor(bc, 5.);
        mainPane.setRightAnchor(bc, 5.);
        mainPane.setBottomAnchor(bc, 50.);
        mainPane.getChildren().addAll(bc);

    }
}
