package org.devteam.view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.devteam.data.DataLoader;
import org.devteam.data.ServerLoader;
import pl.zankowski.iextrading4j.api.stocks.Quote;


public class SummaryController {
    @FXML
    public Label openLabel;
    @FXML
    public Label closeLabel;
    @FXML
    public Label lowLabel;
    @FXML
    public Label highLabel;
    @FXML
    public Label mktLabel;
    @FXML
    public Label peLabel;
    @FXML
    public Label changeLabel;
    @FXML
    public Label volLabel;
    @FXML
    TextField textField;
    @FXML
    Button loadButton;
    @FXML
    Label open;
    @FXML
    Label high;
    @FXML
    Label low;
    @FXML
    Label close;
    @FXML
    Label vol;
    @FXML
    Label change;
    @FXML
    Label cmpName;
    @FXML
    Label mktCap;
    @FXML
    Label peRatio;
    @FXML
    Label symbol;
    @FXML
    Label mEmptySummaryInfo;

    //TODO: Bad architecture solution, REWRITE!!! maybe use the factory method?
    private DataLoader data = new ServerLoader();

    public void  initialize(){
        initListeners();
    }

    private void initListeners() {
        loadButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(isValidInput()){
                    mEmptySummaryInfo.setVisible(false);
                    String symbol = textField.getText();
                    loadButton.setDisable(true);
                    loadData(symbol);
                    loadButton.setDisable(false);
                    textField.clear();
                }
            }
        });
    }

    private void loadData(String symbol) {
        Quote response;

        try {
            //Long-term operation, needs its flow
            response = data.getStockQuote(symbol);
        }catch (Exception e){
            //Todo: Rewrite this!
            e.printStackTrace();
            loadButton.setDisable(false);
            setVisibleAll(false);
            mEmptySummaryInfo.setText("Symbol not found or alternative bug");
            mEmptySummaryInfo.setVisible(true);
            return;
        }
        setVisibleAll(true);

        open.setText(response.getOpen().toString());
        high.setText(response.getHigh().toString());
        cmpName.setText(response.getCompanyName());
        this.symbol.setText(response.getSymbol());
        close.setText(response.getClose().toString());
        low.setText(response.getLow().toString());
        vol.setText(response.getLatestVolume().toString());
        change.setText(response.getChange().toString());
        mktCap.setText(response.getMarketCap().toString());
        peRatio.setText(response.getPeRatio().toString());


    }
    //Low predicate
    private boolean isValidInput() {
        return textField.getLength() != 0;
    }

    private void setVisibleAll(boolean isVisible){
        openLabel.setVisible(isVisible);
        closeLabel.setVisible(isVisible);
        lowLabel.setVisible(isVisible);
        highLabel.setVisible(isVisible);
        volLabel.setVisible(isVisible);
        changeLabel.setVisible(isVisible);
        peLabel.setVisible(isVisible);
        mktLabel.setVisible(isVisible);
        open.setVisible(isVisible);
        low.setVisible(isVisible);
        close.setVisible(isVisible);
        high.setVisible(isVisible);
        peRatio.setVisible(isVisible);
        mktCap.setVisible(isVisible);
        change.setVisible(isVisible);
        vol.setVisible(isVisible);
        this.symbol.setVisible(isVisible);
        cmpName.setVisible(isVisible);

    }

}
