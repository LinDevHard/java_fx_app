package org.devteam.data;

import pl.zankowski.iextrading4j.api.stocks.Chart;
import pl.zankowski.iextrading4j.client.IEXCloudClient;
import pl.zankowski.iextrading4j.client.rest.request.stocks.ChartRequestBuilder;
import pl.zankowski.iextrading4j.api.stocks.ChartRange;

import java.util.List;

public class DataLoader {
    private final IEXCloudClient client = CloudClient.getInstance();

    public void getChartActually(String symbol){
        final List<Chart> charts = client.executeRequest(new ChartRequestBuilder()
                .withChartRange(ChartRange.ONE_MONTH)
                .withSymbol(symbol)
                .build());
        System.out.println(charts);
    }
}
