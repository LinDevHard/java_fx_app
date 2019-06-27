package org.devteam.view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.Pane;
import org.devteam.data.DataLoader;
import org.devteam.data.ServerLoader;
import org.devteam.view.charts.CandleStickChart;
import org.devteam.view.charts.CandleStickExtraValues;
import pl.zankowski.iextrading4j.api.stocks.Chart;

import java.util.List;

public class ChartController {
    @FXML
    Pane mainPane;
    DataLoader client = new ServerLoader();
    List<Chart> loadedData = null;

    public void initialize(){
        loadedData = client.getStockChart("goog");
        initCharts();
    }

    private void initCharts() {
        // x-axis:
        final NumberAxis xAxis = new NumberAxis(0, loadedData.size(), 1);
        xAxis.setLabel("Day");

        // y-axis:
        final NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("Price");
        yAxis.setForceZeroInRange(false);

        // chart:
        final CandleStickChart bc = new CandleStickChart(xAxis, yAxis);
        bc.setTitle("Custom Candle Stick Chart");

        // add starting data
        XYChart.Series<Number, Number> series = new XYChart.Series<Number, Number>();
        int index  = 0;
        for (Chart data: loadedData) {
            index++;
            System.out.println(data.toString());
            series.getData().add(
                    new XYChart.Data<Number, Number>(index, data.getOpen(), new CandleStickExtraValues(
                            data.getClose().doubleValue(),
                            data.getHigh().doubleValue(),
                            data.getLow().doubleValue(),
                            (data.getHigh().doubleValue()+data.getLow().doubleValue()) /2))
            );
        }
        ObservableList<XYChart.Series<Number, Number>> data = bc.getData();
        if (data == null) {
            data = FXCollections.observableArrayList(series);
            bc.setData(data);
        } else {
            bc.getData().add(series);
        }
        mainPane.getChildren().addAll(bc);
    }
}
