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

    private void loadData(String rsymbol) {
        Quote response;

        try {
            //Long-term operation, needs its flow
            response = data.getStockQuote(rsymbol);
        }catch (Exception e){
            //Todo: Rewrite this!
            e.printStackTrace();
            loadButton.setDisable(false);
            mEmptySummaryInfo.setText("Symbol not found or alternative bug");
            mEmptySummaryInfo.setVisible(true);
            return;
        }

        openLabel.setVisible(true);
        closeLabel.setVisible(true);
        lowLabel.setVisible(true);
        highLabel.setVisible(true);
        volLabel.setVisible(true);
        changeLabel.setVisible(true);
        peLabel.setVisible(true);
        mktLabel.setVisible(true);

        open.setText(response.getOpen().toString());
        open.setVisible(true);
        high.setText(response.getHigh().toString());
        high.setVisible(true);
        cmpName.setText(response.getCompanyName());
        cmpName.setVisible(true);
        symbol.setText(response.getSymbol());
        symbol.setVisible(true);
        close.setText(response.getClose().toString());
        close.setVisible(true);
        low.setText(response.getLow().toString());
        low.setVisible(true);
        vol.setText(response.getLatestVolume().toString());
        vol.setVisible(true);
        change.setText(response.getChange().toString());
        change.setVisible(true);
        mktCap.setText(response.getMarketCap().toString());
        mktCap.setVisible(true);
        peRatio.setText(response.getPeRatio().toString());
        peRatio.setVisible(true);

    }
    //Low predicate
    private boolean isValidInput() {
        return textField.getLength() != 0;
    }


}
