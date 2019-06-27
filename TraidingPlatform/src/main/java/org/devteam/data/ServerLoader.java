package org.devteam.data;

import pl.zankowski.iextrading4j.api.stocks.Chart;
import pl.zankowski.iextrading4j.api.stocks.ChartRange;
import pl.zankowski.iextrading4j.api.stocks.Quote;
import pl.zankowski.iextrading4j.client.IEXCloudClient;
import pl.zankowski.iextrading4j.client.rest.request.stocks.ChartRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.stocks.QuoteRequestBuilder;

import java.util.List;


public class ServerLoader implements DataLoader {
    private final IEXCloudClient client = CloudClient.getInstance();

    @Override
    public Quote getStockQuote(String symbol) {
        return client.executeRequest(new QuoteRequestBuilder()
        .withSymbol(symbol)
        .build());
    }

    @Override
    public List<Chart> getStockChart(String symbol) {
        return client.executeRequest(new ChartRequestBuilder()
        .withSymbol(symbol)
                .withChartRange(ChartRange.ONE_MONTH)
        .build());
    }
}
