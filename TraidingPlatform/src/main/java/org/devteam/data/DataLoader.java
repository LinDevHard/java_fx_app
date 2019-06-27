package org.devteam.data;

import pl.zankowski.iextrading4j.api.stocks.Chart;
import pl.zankowski.iextrading4j.api.stocks.Quote;

import java.util.List;

public interface DataLoader {
    Quote getStockQuote(String symbol);
    List<Chart> getStockChart(String symbol);
}
