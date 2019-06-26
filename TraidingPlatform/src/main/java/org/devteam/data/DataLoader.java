package org.devteam.data;

import pl.zankowski.iextrading4j.api.stocks.Quote;

public interface DataLoader {
    Quote getStockQuote(String symbol);
}
