package org.devteam.data;

import pl.zankowski.iextrading4j.api.stocks.Quote;
import pl.zankowski.iextrading4j.client.IEXCloudClient;
import pl.zankowski.iextrading4j.client.rest.request.stocks.QuoteRequestBuilder;




public class ServerLoader implements DataLoader {
    private final IEXCloudClient client = CloudClient.getInstance();

    @Override
    public Quote getStockQuote(String symbol) {
        return client.executeRequest(new QuoteRequestBuilder()
        .withSymbol(symbol)
        .build());
    }
}
