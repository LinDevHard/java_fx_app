package org.devteam.view.charts;

public class CandleStickExtraValues {
    private double close;
    private double high;
    private double low;
    private double average;

    public CandleStickExtraValues(double close, double high, double low, double average) {
        this.close = close;
        this.high = high;
        this.low = low;
        this.average = average;
        //WTF What im do...
    }


    public double getClose() {
        return close;
    }

    public double getHigh() {
        return high;
    }

    public double getLow() {
        return low;
    }

    public double getAverage() {
        return average;
    }
}
