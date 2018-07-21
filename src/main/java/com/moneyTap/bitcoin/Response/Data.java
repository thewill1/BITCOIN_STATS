package com.moneyTap.bitcoin.Response;

import java.math.BigDecimal;

public class Data {
    private long time;
    private Double close;
    private Double high;
    private Double low;
    private Double open;
    private BigDecimal volumefrom;
    private BigDecimal volumeto;

    public long getTime() {
        return time;
    }

    public void setTime(final long time) {
        this.time = time;
    }

    public Double getClose() {
        return close;
    }

    public void setClose(final Double close) {
        this.close = close;
    }

    public Double getHigh() {
        return high;
    }

    public void setHigh(final Double high) {
        this.high = high;
    }

    public Double getLow() {
        return low;
    }

    public void setLow(final Double low) {
        this.low = low;
    }

    public Double getOpen() {
        return open;
    }

    public void setOpen(final Double open) {
        this.open = open;
    }

    public BigDecimal getVolumefrom() {
        return volumefrom;
    }

    public void setVolumefrom(final BigDecimal volumefrom) {
        this.volumefrom = volumefrom;
    }

    public BigDecimal getVolumeto() {
        return volumeto;
    }

    public void setVolumeto(final BigDecimal volumeto) {
        this.volumeto = volumeto;
    }
}
